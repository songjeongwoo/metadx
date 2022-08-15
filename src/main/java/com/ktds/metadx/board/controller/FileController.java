package com.ktds.metadx.board.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.ktds.metadx.board.dto.FileDTO;

import com.ktds.metadx.board.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
@RequestMapping("/board")
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

    // @ResponseBody
    @PostMapping("/register")
    public void insertData(FileDTO postDTO){
        MultipartFile[] files = postDTO.getFiles();
                
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

                String fkey = postDTO.getFkey();
                String fuuid = uuid;
                String fileDataType = ext;

                savedFileName += ".dat";

                log.info(service.insertData(fname, fkey, fuuid, fileDataType));

                byte[] pwd = postDTO.getFkey().getBytes();
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
    public void fileDownload(FileDTO postDTO, @RequestParam(value = "user_key",required = false) String userkey)throws Exception{

        if(!userkey.equals(postDTO.getFkey())){
            log.info("비번 불일치!!");
            return;
        }
        String outputFolderPath = "C:\\fileDownload\\";

        String inputFilePath = "C:\\upload\\" + postDTO.getFuuid() + "_" + postDTO.getFname()+ ".dat";
        String outputFilePath = postDTO.getFname()+ "." + postDTO.getFdatatype();
        byte[] buffer = new byte[1024*1000];

        log.info("비번 일치!!");

        File Folder = new File(outputFolderPath);

        // 해당 디렉토리가 없을경우 디렉토리를 생성
        if (!Folder.exists()) {
            try{
                Folder.mkdir(); //폴더 생성
                } 
                catch(Exception e){
                e.getStackTrace();
            }        
        }

        InputStream fin = new FileInputStream(inputFilePath);
        FileOutputStream fos = new FileOutputStream(outputFolderPath + outputFilePath);

        // 패스워드 100byte 배열 선언
        byte[] pwBuffer = new byte[100];

        // 100byte만큼 read해줌
        fin.read(pwBuffer);

        while(true){

            int count = fin.read(buffer);

            if(count == -1){break;}

            fos.write(buffer, 0, count);

        }
        fos.close();
    }
}
