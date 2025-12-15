package com.phukienthoitrang.ecommerce.config;

import com.phukienthoitrang.ecommerce.model.Role;
import com.phukienthoitrang.ecommerce.model.User;
import com.phukienthoitrang.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Dependency Injection
    public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Kiểm tra xem User ADMIN đã tồn tại chưa
        if (userRepository.findByUsername("admin").isEmpty()) {

            // 1. Tạo User ADMIN
            User adminUser = new User();
            adminUser.setUsername("admin");
            // Mật khẩu sẽ là '123456' sau khi mã hóa
            adminUser.setPassword(passwordEncoder.encode("123456"));
            adminUser.setEmail("admin@ecommerce.com");
            adminUser.setFullName("Quản trị viên Hệ thống");

            // 2. Gán quyền ADMIN
            adminUser.setRoles(Set.of(Role.ADMIN, Role.CUSTOMER));

            // 3. Lưu vào Database
            userRepository.save(adminUser);
            System.out.println(">>> User ADMIN đã được tạo thành công.");
        }

        // TODO: Bạn có thể thêm dữ liệu Category và Product mẫu ở đây.
        // Ví dụ:
        // if (categoryRepository.count() == 0) {
        //     categoryRepository.save(new Category("Vòng cổ", "Mô tả..."));
        // }
    }
}