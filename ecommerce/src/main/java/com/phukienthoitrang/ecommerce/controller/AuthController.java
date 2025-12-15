package com.phukienthoitrang.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Chỉ cần mapping đến trang login.html
    @GetMapping("/login")
    public String login() {
        return "login"; // Trả về view login.html
    }

    // TODO: Bổ sung chức năng Đăng ký (/register) và lưu User vào DB (cần mã hóa mật khẩu)
}