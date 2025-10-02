package com.example.demo.controller;

import com.example.demo.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    // Bài 1: hiển thị bean Staff
    @RequestMapping("/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "demo/staff-detail";
    }

    // Bài 2/4/5: tạo danh sách dùng chung
    private List<Staff> sampleList() {
        return List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
        );
    }

    // Bài 2: list dạng dòng
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", sampleList());
        return "demo/staff-list";
    }

    // Bài 4: bảng trạng thái th:each
    @RequestMapping("/list-status")
    public String listStatus(Model model) {
        model.addAttribute("list", sampleList());
        return "demo/list-status";
    }

    // Bài 5: select box + radio group
    @RequestMapping("/list-controls")
    public String listControls(Model model) {
        model.addAttribute("list", sampleList());
        return "demo/list-controls";
    }
}
