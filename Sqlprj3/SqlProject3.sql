CREATE DATABASE prj3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE prj3;
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(500),
    price DOUBLE,
    description TEXT,
    category_id INT,
    CONSTRAINT fk_product_category 
        FOREIGN KEY (category_id) REFERENCES category(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

INSERT INTO category (name) VALUES
('Nhẫn'),
('Mặt dây chuyền'),
('Vòng tay'),
('Khuyên tai');

INSERT INTO product (name, image, price, description, category_id)
VALUES
('Nam Quốc Sơn Hà Ring Helios Black Silver', 'nhan1.jpg', 1985000, 'Nhẫn Nam Quốc Sơn Hà được nung nấu từ niềm tự hào bất diệt ấy. Đại diện cho tình yêu Tổ Quốc bền vững của gần trăm triệu đồng bào, chế tác khao khát được là vật bảo chứng cho lòng yêu nước, để mỗi người đeo đều có thể cảm nhận được sức mạnh của lịch sử và niềm tự hào về quê hương mình.', 1),
('Shinku Helios Black Silver', 'nhan2.jpg', 2350000, 'Cái tên Shinku nghĩa là “bầu trời sâu thẳm” — nơi không có tiếng ồn, không có ánh sáng, chỉ còn lại khoảng lặng tuyệt đối. Nhưng chính trong khoảng lặng ấy, con người mới nghe thấy tiếng của chính mình.', 1),
('Exaltus Helios Black Silver', 'nhan3.jpg', 2450000, 'Exaltus khắc họa khoảnh khắc cá chép vượt vũ môn, hóa thân thành rồng – hình ảnh biểu trưng cho sự thăng hoa của đức tin, khi niềm tin không còn là điều được giữ trong tâm trí, mà đã trở thành sức mạnh.', 1),
('Nam Quốc Sơn Hà Pendant Helios Black Silver', 'matdaychuyen1.jpg', 2400000, 'Mặt dây Nam Quốc Sơn Hà là cách Helios gửi đến bạn một biểu tượng của tự hào – để bạn yêu nước theo cách riêng, dù đi đến đâu cũng có Tổ Quốc bên mình.', 2),
('Orientate Helios Silver', 'matdaychuyen2.jpg', 1185000, 'Mặt dây chuyền đúng như cái tên của nó - định hướng, được truyền cảm hứng từ biểu tượng ngọn hải đăng, sừng sững giữa biển cả như một cột mốc quan trọng, với sứ mệnh dẫn dắt - chỉ lối cho những con tàu ra khơi. ', 2),
('Shogun Helios Black Silver', 'matdaychuyen3.jpg', 1850000, 'Mặt dây Shogun - với chiếc mũ Kabuto có sừng đặc trưng, được tạo ra để tái hiện huyền thoại này. Chi tiết những hộp sọ được ẩn giấu đại diện cho những sinh mệnh từng chiến đấu dưới lá cờ của Shogun. Shogun, hơn cả lãnh tướng đứng đầu, họ là người gánh vác của cả đoàn quân, chịu trách nhiệm cho vạn con người, cho thành bại của mỗi chiến dịch.', 2),
('Ruyi Cuff Helios Black Silver', 'vongtay1.jpg', 3850000, 'Ruyi Cuff được tạo ra để đồng hành cùng những người đàn ông trên quá trình trưởng thành và nhắc rằng họ đủ mạnh mẽ để tiếp tục tiến về phía trước.', 3),
('Matira Chrysaber Helios Black Silver', 'vongtay2.jpg', 4250000, 'Matira là thanh kiếm mang theo sự bình tĩnh của người hiểu rõ giới hạn của mình, không cần phô trương. Hình ảnh hoa cúc kết hợp cùng lưỡi kiếm sắc bén là biểu tượng cho sự bền bỉ, không gục ngã giữa thử thách.', 3),
('River Lotus Bracelet Helios Silver', 'vongtay3.jpg', 5350000, 'Thay vì đính đá hay làm trơn, Helios đã chạm khắc tỉ mỉ hoa văn Lotus độc bản lên từng mắt xích nhỏ.Toát lên một vẻ rất ngông, rất chiến khi đeo lên tay.', 3),
('Minh Đăng Helios Black Silver', 'khuyentai1.jpg', 395000, 'Đeo Minh Đăng là giữ bên mình một lời khẳng định rằng, trong hành trình trưởng thành, người đàn ông cũng chính là ngọn đèn cho gia đình: mạnh mẽ để xua đi bóng tối, bền bỉ để gìn giữ sự bình yên, và sáng rõ để soi lối cho những người đồng hành.', 4),
('Hoả Luân Helios Silver', 'khuyentai2.jpg', 395000, 'Hoả Luân hiện diện với những tính cách đặc trưng của người đàn ông ngông cuồng, khó đoán và có chút gì đó bướng bỉnh.', 4),
('Storyteller Earring Helios Silver', 'khuyentai3.jpg', 560000 , 'Không chỉ là tên gọi của khuyên tai này, Storyteller ở đây chính là anh em, người sẽ kể câu chuyện của bản thân, hoàn thiện nó với các lựa chọn charm tùy theo sở thích.', 4);
-- đơn hàng --

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(150) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    note VARCHAR(500),
    total_amount DOUBLE NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at DATETIME NOT NULL
);

ALTER TABLE orders 
ADD COLUMN user_id BIGINT NULL,
ADD CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES users(id);


CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_orderitems_order
        FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
    -- FK product_id :
    -- , CONSTRAINT fk_orderitems_product
    --     FOREIGN KEY (product_id) REFERENCES product(id)
);

-- users --

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    role VARCHAR(20) NOT NULL
);


INSERT INTO users(full_name,email,password,phone,role)
VALUES
('Admin Test','admin@test.com','123','0984551682','ADMIN'),
('Shipper Test','ship@test.com','123','034624622','SHIPPER');

CREATE TABLE pta_product_comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    content TEXT NOT NULL,
    star INT NOT NULL CHECK (star BETWEEN 1 AND 5),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,

    CONSTRAINT fk_comment_product
        FOREIGN KEY (product_id)
        REFERENCES product(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_comment_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;


SELECT id, status FROM orders;