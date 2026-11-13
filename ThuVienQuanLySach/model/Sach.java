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
        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        this.namXuatBan = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don gia: ");
        this.donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(sc.nextLine());

        System.out.println("--- Chon loai sach ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Vui long nhap lua chon (1-4): ");
        this.loaiSach = Integer.parseInt(sc.nextLine());
    }

    public void hienThiThongTin() {
        System.out.println("\n----- THONG TIN SACH -----");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Loai sach: " + layTenLoaiSach());
    }

    // Tuần 3 - Bài 2: Tính thành tiền = đơn giá * số lượng
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }

    // Tuần 3 - Bài 3: Phí vận chuyển = 5% giá trị sách
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    // Tuần 3 - Bài 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
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
            return "Sach gia thap";
        } else if (this.donGia <= 100000) {
            return "Sach gia trung binh";
        } else if (this.donGia <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }

    // Tuần 4 - Bài 3: Phân loại tồn kho
    public String phanLoaiTonKho() {
        if (this.soLuong == 0) {
            return "Het sach";
        } else if (this.soLuong <= 5) {
            return "Sap het";
        } else if (this.soLuong <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    // Tuần 4 - Bài 4: Xử lý bằng switch chọn loại sách
    // Tuần 4 - Bài 4: Xử lý bằng rule switch chọn loại sách
    public String layTenLoaiSach() {
        return switch (this.loaiSach) {
            case 1 -> "Sach giao khoa";
            case 2 -> "Sach tham khao";
            case 3 -> "Sach chuyen nganh";
            case 4 -> "Sach khac";
            default -> "Loai sach khong hop le";
        };
    }

    public String getMaSach() {
        return this.maSach;
    }

    public int getSoLuong() {
        return this.soLuong;
    }
}