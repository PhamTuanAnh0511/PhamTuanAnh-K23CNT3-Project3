package com.phukienthoitrang.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Cấu hình mã hóa mật khẩu (Bắt buộc)
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt là thuật toán mã hóa được khuyến nghị
        return new BCryptPasswordEncoder();
    }

    // 2. Cấu hình chuỗi lọc bảo mật (Security Filter Chain)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF nếu cần (cẩn thận khi dùng thực tế)
                .authorizeHttpRequests(authorize -> authorize
                        // Đường dẫn quản trị chỉ cho phép người dùng có vai trò ADMIN
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // Các trang công khai (Trang chủ, sản phẩm, CSS/JS/Images)
                        .requestMatchers("/", "/products/**", "/register", "/css/**", "/js/**", "/images/**").permitAll()

                        // Mọi request khác đều yêu cầu xác thực
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom Login Page (bạn sẽ tạo trang này)
                        .defaultSuccessUrl("/") // Redirect sau khi đăng nhập thành công
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/") // Redirect sau khi đăng xuất
                        .permitAll()
                );

        return http.build();
    }
}