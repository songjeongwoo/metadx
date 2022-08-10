package com.ktds.metadx.common.controller;

import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;
import java.awt.image.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@Controller
@Log4j2
public class CaptchaController {

    @ResponseBody
    @GetMapping(value ="/makeCaptcha", produces = "image/gif")
    public byte[] makeImage(HttpServletRequest request) throws Exception{

        String captchaNum = ((int)(Math.random() * 1000000))+"";
        int x = 300;
        int y = 200;

        HttpSession session = request.getSession();
        session.removeAttribute("captchaNum");
        session.setAttribute("captchaNum", captchaNum);

        BufferedImage image = new BufferedImage(300,  200, BufferedImage.TYPE_INT_RGB);
        //붓
        Graphics g = image.getGraphics();
        
        g.setColor(Color.GRAY);
        
        g.fillRect(0, 0, x, y);
        
        //font
        String[] fontList = {"고딕", "휴먼편지체", "Bodoni MT Poster Compressed", "Showcard Gothic", "Jokerman",
                            "HY얕은샘물M", "Algerian", "Edwardian Script ITC", "궁서", "돋움"};
        
        for (int i = 0; i < captchaNum.length(); i++) {
            g.setFont(new Font(fontList[(int)(Math.random() * 10)], Font.PLAIN, 40));
            
            g.setColor(Color.BLACK);
            g.drawString(
                Character.toString(captchaNum.charAt(i)),
                (int)(x / 8) + (i * (int)(x / 10))+(int)((Math.random() * 10000) % 10),
                ((int)(y / 3) + (int)Math.pow(-1, i)) + (int)((Math.random()*10000)%10) * (int)(y / 40));
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ImageIO.write(image, "gif", bos);
        return bos.toByteArray();
    }

    @GetMapping("/captcha")
    public String captcha(HttpServletRequest request) {
        
        /* 게시물 업/다운로드 코드에 추가될 코드 */
        HttpSession session = request.getSession();
        session.removeAttribute("failCnt");
        session.setAttribute("failCnt", 0);

        return "captcha.html";
    }

    @PostMapping("/captcha")
    public Model captchaNumCheck(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String captchaNum = (String)session.getAttribute("captchaNum");
        String captchaNumCheck = request.getParameter("captchaNum");
        
        if(captchaNum.equals(captchaNumCheck)) {
            model.addAttribute("result", "success");
        } else {
            model.addAttribute("result", "fail");
            
            int failCnt = (Integer)session.getAttribute("failCnt");
            session.setAttribute("failCnt", ++failCnt);

            if(failCnt == 3) {
                log.info("member 메소드(계정잠금) 호출");
            }
        }

        return model;

    }
}
