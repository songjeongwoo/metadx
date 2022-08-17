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

    @GetMapping("/register")
    public void getInsertDataPage(){
    }

    @PostMapping("/register")
    public void insertData(FileDTO fileDTO){
        MultipartFile[] files = fileDTO.getFiles();
                
        if(files != null && files.length > 0){

            byte[] buffer = new byte[1024*1000];

            for (MultipartFile multipartFile : files) {
                
                String fileName = multipartFile.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();

                log.info(uuid+"_" + fileName);

                String ext = fileName.substring(fileName.lastIndexOf(".") +1);

                String savedFileName = fileName.substring(0, fileName.lastIndexOf("."));
                String fname = savedFileName;

                savedFileName = uuid+"_"+savedFileName;

                String fkey = fileDTO.getFkey();
                String fuuid = uuid;
                String fileDataType = ext;

                if(fileDataType.equals("exe") || fileDataType.equals("txt")){
                    log.info("지원하지 않는 확장자입니다.");
                    continue;
                }

                savedFileName += ".dat";

                log.info(service.insertData(fname, fkey, fuuid, fileDataType, fileDTO.getBno()));

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

                        if(count == -1) { break;}

                        fos.write(buffer,0, count);

                        fos.close();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }


    @GetMapping("/fileDownload")
    public void getfleDownload(){
    }

    @PostMapping("/fileDownload")
    public ResponseEntity<byte[]> fileDownload(FileDTO fileDTO, @RequestParam(value = "user_key",required = false) String userkey,
                                            @RequestParam(value = "fuuid",required = false) String fuuid)throws Exception{

        String realFkey = service.getFileFkey(fuuid);

        if(!userkey.equals(realFkey)){
            log.info("비번 불일치!!");
            return null;
        }

        String inputFilePath = "C:\\upload\\" + fileDTO.getFuuid() + "_" + fileDTO.getFname()+ ".dat";
        byte[] buffer = new byte[1024*1000];

        log.info("비번 일치!!");

        InputStream fin = new FileInputStream(inputFilePath);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // 패스워드 100byte 배열 선언
        byte[] pwBuffer = new byte[100];

        // 100byte만큼 read해줌
        fin.read(pwBuffer);

        while(true){

            int count = fin.read(buffer);

            if(count == -1){break;}

            bos.write(buffer, 0, count);

        }
        bos.close();
        byte[] data  = bos.toByteArray();

        String fileName = URLEncoder.encode(fileDTO.getFname(), "UTF-8");
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","application/octet-stream");
        responseHeaders.add("Content-disposition", "attachment; filename=" + fileName + "." + fileDTO.getFdatatype());

        
        return ResponseEntity.ok().headers(responseHeaders).body(data);
    }
}
