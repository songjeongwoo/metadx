package com.ktds.metadx.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktds.metadx.admin.service.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/admin/*")
@RequiredArgsConstructor
@Log4j2
public class StatisticsController {

    private final AdminService service;

    @GetMapping("/statistics")
    public void statistics(Model model) {
        log.info("통계 페이지 불러오는 중..");
        model.addAttribute("statisticsList", service.getList());
    }
}
