package com.ktds.metadx.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.metadx.admin.dto.AdminCountDTO;
import com.ktds.metadx.admin.dto.AdminDTO;
import com.ktds.metadx.admin.dto.AdminLockDTO;
import com.ktds.metadx.admin.service.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/admin/*")
@RequiredArgsConstructor
@Log4j2
public class AdminController {

    private final AdminService service;

    @GetMapping("/statisticsList")
    public List<AdminDTO> statisticsList() {
        return service.getList();
    }

    @GetMapping("/getCountDownloads")
    public List<AdminCountDTO> getCount() {
        return service.getCountDownloads();
    }

    @GetMapping("/getLockList")
    public List<AdminLockDTO> memberLockList() {
        return service.getLockList();
    }

    @GetMapping("/getCountLocks")
    public List<AdminCountDTO> getCountLocks() {
        return service.getCountLocks();
    }

    @GetMapping("/getLockAccount")
    public List<AdminLockDTO> getLockAccount() {
        return service.getLockAccount();
    }

    @PostMapping("/changeLockAccount")
    public void changeLockAccount(@RequestParam(value = "email", required = false) String email) {
        log.info("가져온 값 : " + email);
        boolean result = service.changeLockAccount(email);
        log.info(result);
    }
    
    // use thymeleaf template html
    // @GetMapping("/statistics")
    // public void statistics(Model model) {
    //     log.info("Statistics Page Loading...");
    //     model.addAttribute("statisticsList", service.getList());
    //     model.addAttribute("getCountDownloads", service.getCountDownloads());
    // }

    // @GetMapping("/memberlock")
    // public void memberlock(Model model) {
    //     log.info("Lock Page Loading...");
    //     model.addAttribute("memberLockList", service.getLockList());
    // }
}
