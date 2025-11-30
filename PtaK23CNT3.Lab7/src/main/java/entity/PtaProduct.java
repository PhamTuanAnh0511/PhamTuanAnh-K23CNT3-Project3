package entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PtaProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String imageUrl;
    Integer quantity;
    Double price;
    String content;
    Boolean status;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)   // đúng với DDL đã tạo
    PtaCategory category;
}