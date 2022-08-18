package com.ktds.metadx.board.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ktds.metadx.board.dto.FileDTO;

import com.ktds.metadx.board.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService service;

    @GetMapping("/filelist")
    public List<FileDTO> getFileList(@RequestParam(value = "bno",required = false) Long bno) {
        return service.getFileList(bno);
    }

    @PostMapping("/register")
    public void insertData(FileDTO fileDTO){
        MultipartFile[] files = fileDTO.getFiles();
                
        if(files != null && files.length > 0){

            byte[] buffer = new byte[1024*1000];

            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                String ext = fileName.substring(fileName.lastIndexOf(".") +1);
                String savedFileName = fileName.substring(0, fileName.lastIndexOf("."));
                String fname = savedFileName;
                savedFileName = uuid+"_"+savedFileName;

                String fkey = fileDTO.getFkey();
                String fuuid = uuid;
                String fileDataType = ext;

                // *.exe, *.txt 업로드 불가
                if(fileDataType.equals("exe") || fileDataType.equals("txt")){
                    continue;
                }

                savedFileName += ".dat";

                service.insertData(fname, fkey, fuuid, fileDataType, fileDTO.getBno());

                byte[] pwd = fileDTO.getFkey().getBytes();
                // 패스워드를 100byte까지 입력 가능
                byte[] tempArr = new byte[100]; 

                //pwd를 tempArr에 저장
                System.arraycopy(pwd, 0, tempArr, 0, pwd.length);

                try (
                    FileOutputStream fos = new FileOutputStream("C:\\upload\\" + savedFileName );
                    InputStream in = multipartFile.getInputStream();
                ) {
                    fos.write(tempArr);

                    while(true){
                        int count = in.read(buffer);

                        if(count == -1) {
                            break;
                        }

                        fos.write(buffer,0, count);
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @PostMapping(value = "/fileDownload" )
    public ResponseEntity<byte[]> fileDownload(@RequestBody FileDTO fileDTO,
                                    @RequestParam(value = "bno",required = false) String bno,
                                    @RequestParam(value = "fno",required = false) String fno,
                                    @RequestParam(value = "userKey",required = false) String userKey)throws Exception{

        // 다운로드 성공/실패 시 db에 로그 남기기
        log.info("+++++++++++++++++++++++++++++++");
        log.info(bno);
        log.info(fno);
        log.info("+++++++++++++++++++++++++++++++");

        String fuuid = fileDTO.getFuuid();
        String realFkey = service.getFileFkey(fuuid);

        // 비번 불일치 시
        if(!userKey.equals(realFkey)){
            return null;
        }

        // 비번 일치 시
        String inputFilePath = "C:\\upload\\" + fileDTO.getFuuid() + "_" + fileDTO.getFname()+ ".dat";
        byte[] buffer = new byte[1024*1000];

        InputStream fin = new FileInputStream(inputFilePath);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // 패스워드 100byte 배열 선언
        byte[] pwBuffer = new byte[100];

        // 100byte만큼 read해줌
        fin.read(pwBuffer);

        while(true){
            int count = fin.read(buffer);

            if(count == -1){
                break;
            }

            bos.write(buffer, 0, count);
        }

        bos.close();

        byte[] data  = bos.toByteArray();
        String fileName = URLEncoder.encode(fileDTO.getFname(), "UTF-8");
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","application/octet-stream");
        responseHeaders.add("Content-disposition", "attachment; filename=" + fileName + "." + fileDTO.getFdatatype());
        responseHeaders.add("fileName", fileName + "." + fileDTO.getFdatatype());

        return ResponseEntity.ok().headers(responseHeaders).body(data);
    }
}
