import java.util.ArrayList;
import java.util.Scanner;
import model.Sach;

public class Test {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Yêu cầu 3: Tạo đối tượng đơn lẻ từ lớp Sach
            System.out.println("=== YEU CAU 3: TAO DOI TUONG SACH DON LE ===");
            Sach sach1 = new Sach("S001", "Lap trinh Java co ban", "Nguyen Van A", 2024, 15);
            sach1.hienThiThongTin();

            // Yêu cầu 4: Tạo và quản lý danh sách Sach bằng ArrayList
            System.out.println("\n=== YEU CAU 4: QUAN LY DANH SACH SACH BANG ARRAYLIST ===");
            ArrayList<Sach> danhSachSach = new ArrayList<>();
            danhSachSach.add(sach1);

            System.out.print("\nNhap so luong sach muon them vao ArrayList: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\nNhap thong tin sach thu " + (i + 1) + ":");
                Sach s = new Sach();
                s.nhapThongTinCoBan(sc);
                danhSachSach.add(s);
            }

            System.out.println("\n=== DANH SACH TOAN BO SACH TRONG THU VIEN ===");
            for (Sach s : danhSachSach) {
                s.hienThiThongTin();
            }
        }
    }
}