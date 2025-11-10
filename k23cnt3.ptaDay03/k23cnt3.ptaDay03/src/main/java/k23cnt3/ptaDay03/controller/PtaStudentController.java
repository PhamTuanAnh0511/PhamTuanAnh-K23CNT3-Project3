package k23cnt3.ptaDay03.controller;

import k23cnt3.ptaDay03.entity.PtaStudent;
import k23cnt3.ptaDay03.Service.PtatServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class PtaStudentController {
    @Autowired
    private PtatServiceStudent studentService;

    @GetMapping("/student-list")
    public List<PtaStudent> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public PtaStudent getAllStudents(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return studentService.getStudent(param);
    }

    @PostMapping("/student-add")
    public PtaStudent addStudent(@RequestBody PtaStudent student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/student/{id}")
    public PtaStudent updateStudent(@PathVariable String id,
                                    @RequestBody PtaStudent student) {
        Long param = Long.parseLong(id);
        return studentService.updateStudent(param,
                student);
    }

    @DeleteMapping("/student/{id}")
    public boolean deleteStudent(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return studentService.deleteStudent(param);
    }
}