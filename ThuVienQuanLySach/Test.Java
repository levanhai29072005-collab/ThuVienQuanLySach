import java.util.ArrayList;
import java.util.Scanner;
import model.Sach;

public class Test {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Sach> danhSachSach = new ArrayList<>();

            // 1. Tạo đối tượng bằng Constructor đầy đủ tham số (Yêu cầu 4 - Tuần 8)
            System.out.println("=== 1. KHOI TAO BANG CONSTRUCTOR DAY DU THAM SO ===");
            Sach s1 = new Sach("S001", "Lap trinh huong doi tuong Java", "Tran Van B", 2025, 20);
            danhSachSach.add(s1);
            s1.hienThiThongTin();

            // 2. Kiểm thử tính đóng gói qua Setter có kiểm tra điều kiện (Yêu cầu 2 & 3 - Tuần 8)
            System.out.println("\n=== 2. KIEM THU SETTER VA RANG BUOC DU LIEU ===");
            Sach s2 = new Sach();
            s2.setMaSach("S002");
            s2.setTieuDe("Cau truc du lieu va giai thuat");
            s2.setTacGia("Le Thi C");
            s2.setNamXuatBan(2030); // Cố tình nhập sai năm (> năm hiện tại) để test kiểm tra
            s2.setSoLuong(-5);      // Cố tình nhập số lượng âm để test kiểm tra
            danhSachSach.add(s2);
            s2.hienThiThongTin();

            // Cập nhật lại đúng giá trị qua Setter
            System.out.println("\n-> Cap nhat lai thong tin hop le cho S002 qua Setter:");
            s2.setNamXuatBan(2023);
            s2.setSoLuong(10);
            System.out.println("Ten sach (qua Getter): " + s2.getTieuDe() + " | So luong moi: " + s2.getSoLuong());

            // 3. Nhập thêm danh sách sách từ bàn phím vào ArrayList
            System.out.print("\nNhap so luong sach muon them vao danh sach: ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.println("\nNhap thong tin sach thu " + (i + 1) + ":");
                Sach sMoi = new Sach();
                sMoi.nhapThongTinCoBan(sc);
                danhSachSach.add(sMoi);
            }

            System.out.println("\n=== DANH SACH TOAN BO SACH HIEN CO ===");
            for (Sach s : danhSachSach) {
                s.hienThiThongTin();
            }
        }
    }
}