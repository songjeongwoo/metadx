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
        log.info("Statistics Page Loading...");
        model.addAttribute("statisticsList", service.getList());
    }

    @GetMapping("/memberlock")
    public void memberlock(Model model) {
        log.info("Lock Page Loading...");
        model.addAttribute("memberLockList", service.getLockList());
    }
}
