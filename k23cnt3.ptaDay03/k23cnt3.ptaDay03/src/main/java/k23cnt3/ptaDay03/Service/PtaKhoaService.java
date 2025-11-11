package k23cnt3.ptaDay03.Service;

import k23cnt3.ptaDay03.entity.PtaKhoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PtaKhoaService {
    private List<PtaKhoa> khoaList = new ArrayList<>();
    public PtaKhoaService() {
        khoaList.add(new PtaKhoa("KH01", "Công nghệ thông tin"));
        khoaList.add(new PtaKhoa("KH02", "Kinh tế"));
        khoaList.add(new PtaKhoa("KH03", "Điện tử viễn thông"));
        khoaList.add(new PtaKhoa("KH04", "Xây dựng"));
        khoaList.add(new PtaKhoa        ("KH05", "Quản trị kinh doanh"));
    }

    public List<PtaKhoa> getAll() {
        return khoaList;
    }

    public PtaKhoa getByMakh(String makh) {
        return khoaList.stream().filter(k -> k.getMakh().equals(makh)).findFirst().orElse(null);
    }

    public PtaKhoa add(PtaKhoa k) {
        khoaList.add(k);
        return k; // trả về đối tượng vừa thêm
    }

    public PtaKhoa update(String makh, PtaKhoa k) {
        PtaKhoa existing = getByMakh(makh);
        if(existing != null) {
            existing.setTenkh(k.getTenkh());
            return existing; // trả về đối tượng vừa cập nhật
        }
        return null; // nếu không tìm thấy
    }

    public boolean delete(String makh) {
        return khoaList.removeIf(k -> k.getMakh().equals(makh)); // trả về true nếu xóa thành công
    }
}