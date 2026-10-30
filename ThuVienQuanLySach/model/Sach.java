package model;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;  
    private int soLuong;
    private int loaiSach;
    public Sach() {}
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        System.out.print("Nhap ten sachh: ");
        this.tenSach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        this.namXuatBan = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập đon gia: ");
        this.donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(sc.nextLine());
    }

    public void hienThiThongTin() {
        System.out.println("----- THÔNG TIN SÁCH -----");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Đon gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Loại sách: " + layTenLoaiSach());
        System.out.println("--- Chọn loại sách ---");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Vui lòng nhập lựa chọn (1-4): ");

        this.loaiSach = Integer.parseInt(sc.nextLine());
        
    }
    // Bài 2: Tính thành tiền = đơn giá * số lượng
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }
    // Bài 3: Phí vận chuyển = 5% giá trị sách
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }
    // Bài 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
    public double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }
    // Tuần 4 - Bài 1: Kiểm tra tính hợp lệ của dữ liệu
    public boolean kiemTraHopLe() {
        boolean giaHopLe = this.donGia > 0;
        boolean soLuongHopLe = this.soLuong >= 0;
        boolean namHopLe = this.namXuatBan > 0 && this.namXuatBan <= 2026;

        return giaHopLe && soLuongHopLe && namHopLe;
    }
    // Tuần 4 - Bài 2: Phân loại giá sách
    public String phanLoaiGia() {
        if (this.donGia < 50000) {
            return "Sách giá thấp";
        } else if (this.donGia <= 100000) {
            return "Sách giá trung bình";
        } else if (this.donGia <= 200000) {
            return "Sách giá cao";
        } else {
            return "Sách giá đặc biệt";
        }
    }
    // Tuần 4 - Bài 3: Phân loại tồn kho
    public String phanLoaiTonKho() {
        if (this.soLuong == 0) {
            return "Hết sách";
        } else if (this.soLuong <= 5) {
            return "Sắp hết";
        } else if (this.soLuong <= 20) {
            return "Còn ít";
        } else {
            return "Còn nhiều";
        }
    }
// Tuần 4 - Bài 4: Xử lý bằng switch chọn loại sách
public String layTenLoaiSach() {
    switch (this.loaiSach) {
        case 1:
            return "Sách giáo khoa";
        case 2:
            return "Sách tham khảo";
        case 3:
            return "Sách chuyên ngành";
        case 4:
            return "Sách khác";
        default:
            return "Loại sách không hợp lệ";
    }
}

}