package model;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;  
    private int soLuong;
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
        System.out.println("So luo  ng: " + soLuong);
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
}