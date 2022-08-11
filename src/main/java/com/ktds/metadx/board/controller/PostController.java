package com.ktds.metadx.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.ktds.metadx.board.dto.PostDTO;

import com.ktds.metadx.board.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequestMapping("/board")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;
    
    @GetMapping("/register")
    public void getInsertDataPage(){
    }
    @ResponseBody
    @PostMapping("/register")
    public RedirectView insertData(PostDTO postDTO){

        log.info("--------------register---------------");
        log.info(postDTO);

        MultipartFile[] files = postDTO.getFiles();
                
        if(files != null && files.length > 0){

            byte[] buffer = new byte[1024*8];

            for (MultipartFile multipartFile : files) {
                
                String fileName = multipartFile.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();

                log.info(uuid+"_" + fileName);

                String ext = fileName.substring(fileName.lastIndexOf(".") +1);

                String savedFileName = fileName.substring(0, fileName.lastIndexOf("."));

                savedFileName = uuid+"_"+savedFileName;

                String fname = savedFileName.substring(savedFileName.lastIndexOf("_")+1);
                String fkey = postDTO.getFkey();
                String fuuid = savedFileName.substring(0, savedFileName.lastIndexOf("_"));
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

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new RedirectView("/board/register");     
    }
}
