import java.util.Scanner;
import model.Sach;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach sach = new Sach();

        System.out.println("=== NHẬP THÔNG TIN SÁCH ===");
        sach.nhapThongTin(sc);
        sach.hienThiThongTin();
        System.out.println("Thành tiền: " + sach.tinhThanhTien());
        sc.close();
        System.out.println("Phí vận chuyển (5%): " + sach.tinhPhiVanChuyen());
        System.out.println("Tổng tiền nhập kho: " + sach.tinhTongTienNhap());
    }
}