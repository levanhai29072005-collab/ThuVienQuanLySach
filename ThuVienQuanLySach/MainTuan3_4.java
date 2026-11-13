import java.util.Scanner;
import model.Sach;

public class MainTuan3_4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Sach sach = new Sach();

            System.out.println("=== NHAP THONG TIN SACH ===");
            sach.nhapThongTin(sc);
            sach.hienThiThongTin();
            System.out.println("Thanh tien: " + sach.tinhThanhTien());
            System.out.println("Phi van chuyen (5%): " + sach.tinhPhiVanChuyen());
            System.out.println("Tong tien nhap kho: " + sach.tinhTongTienNhap());

            System.out.println("\n=== TUAN 4 - BAI 1: KIEM TRA HOP LE ===");
            if (sach.kiemTraHopLe()) {
                System.out.println("Thong tin sach hop le!");
            } else {
                System.out.println("Thong tin sach KHONG hop le (kiem tra lai gia, so luong hoac nam XB)!");
            }

            System.out.println("\n=== TUAN 4 - BAI 2: PHAN LOAI GIA ===");
            System.out.println("Muc gia: " + sach.phanLoaiGia());

            System.out.println("\n=== TUAN 4 - BAI 3: PHAN LOAI TON KHO ===");
            System.out.println("Tinh trang kho: " + sach.phanLoaiTonKho());

            System.out.println("\n=== THE LOAI SACH (BAI 4) ===");
            System.out.println("Loai sach da chon: " + sach.layTenLoaiSach());
        }
    }
}