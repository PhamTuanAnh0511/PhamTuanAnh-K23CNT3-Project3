package k23cnt3.ptaDay03.Service;
import k23cnt3.ptaDay03.entity.PtaStudent;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class PtatServiceStudent {
    List<PtaStudent> students
            = new ArrayList<PtaStudent>();
    public PtatServiceStudent() {
        students.addAll(Arrays.asList(
                new PtaStudent(1L,"Devmaster 1",20,"Non","Số 25VNP","0978611889","chungtrinhj@gmail.com"),


        new PtaStudent(2L,"Devmaster2",25,"Non","Số 25VNP","0978611889","contact@devmaster.edu.vn"),


        new PtaStudent(3L,"Devmaster3",22,"Non","Số 25VNP","0978611889","chungtrinhj@gmail.com")


        ));
    }
    // Lấy toàn bộ danh sách sinh viên
    public List<PtaStudent> getStudents() {
        return students;
    }
    // Lấy sinh viên theo id
    public PtaStudent getStudent(Long id) {
        return students.stream()
                .filter(student -> student
                        .getId().equals(id))
                .findFirst().orElse(null);
    }
    // Thêm mới một sinh viên
    public PtaStudent addStudent(PtaStudent student) {
        students.add(student);
        return student;
    }
    // Cập nhật thông tin sinh viên
    public PtaStudent updateStudent(Long id, PtaStudent student)
    {
        PtaStudent check = getStudent(id);
        if (check == null) {
            return null;
        }
        students.forEach(item -> {
            if (item.getId()==id) {
                item.setName(student.getName());
                item.setAddress(student.getAddress());
                item.setEmail(student.getEmail());
                item.setPhone(student.getPhone());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
            }
        });
        return student;
    }
    // Xóa thông tin sinh viên
    public boolean deleteStudent(Long id) {
        PtaStudent check = getStudent(id);
        return students.remove(check);
    }
}
