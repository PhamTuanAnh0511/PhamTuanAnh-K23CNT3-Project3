package service;

import dto.PtaStudentDTO;
import entity.PtaStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PtaStudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PtaStudentService {

    private final PtaStudentRepository studentRepository;

    @Autowired
    public PtaStudentService(PtaStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<PtaStudent> findAll() {
        return studentRepository.findAll();
    }

    public Optional<PtaStudentDTO> findById(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    PtaStudentDTO dto = new PtaStudentDTO();
                    dto.setId(student.getId());
                    dto.setName(student.getName());
                    dto.setEmail(student.getEmail());
                    dto.setAge(student.getAge());
                    return dto;
                });
    }

    public Boolean save(PtaStudentDTO studentDTO) {
        PtaStudent student = new PtaStudent();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        try {
            studentRepository.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PtaStudent updateStudentById(Long id, PtaStudentDTO updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setAge(updatedStudent.getAge());
                    return studentRepository.save(student);
                })
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid student ID: " + id));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}