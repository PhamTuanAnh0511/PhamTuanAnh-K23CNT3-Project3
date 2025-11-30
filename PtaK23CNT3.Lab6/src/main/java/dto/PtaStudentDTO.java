package dto;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PtaStudentDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
}