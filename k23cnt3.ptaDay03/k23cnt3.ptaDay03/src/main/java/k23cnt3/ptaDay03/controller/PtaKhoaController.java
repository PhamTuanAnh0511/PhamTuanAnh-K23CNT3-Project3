package k23cnt3.ptaDay03.controller;

import k23cnt3.ptaDay03.Service.PtaKhoaService;
import k23cnt3.ptaDay03.entity.PtaKhoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("khoa")
public class PtaKhoaController {
    private final PtaKhoaService khoaService;

    public PtaKhoaController(PtaKhoaService khoaService) {
        this.khoaService = khoaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PtaKhoa>> getAll() {
        return ResponseEntity.ok(khoaService.getAll());
    }

    @GetMapping("/{makh}")
    public ResponseEntity<PtaKhoa> getByMakh(@PathVariable String makh) {
        PtaKhoa k = khoaService.getByMakh(makh);
        return k != null ? ResponseEntity.ok(k) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<PtaKhoa> add(@RequestBody PtaKhoa k) {
        return ResponseEntity.ok(khoaService.add(k));
    }

    @PutMapping("/update/{makh}")
    public ResponseEntity<PtaKhoa> update(@PathVariable String makh, @RequestBody PtaKhoa k) {
        PtaKhoa updated = khoaService.update(makh, k);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{makh}")
    public ResponseEntity<Void> delete(@PathVariable String makh) {
        boolean deleted = khoaService.delete(makh);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
