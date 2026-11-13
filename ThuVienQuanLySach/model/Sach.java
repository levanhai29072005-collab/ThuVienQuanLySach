package model;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tieuDe; // Bổ sung theo yêu cầu Tuần 7 (tương đương tên sách)
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private int loaiSach;

    public Sach() {}

    // Constructor dùng cho Tuần 7 (5 thuộc tính cơ bản)
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        System.out.print("Nhap tieu de (ten sach): ");
        this.tieuDe = sc.nextLine();
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

    // Phương thức nhập nhanh 5 thuộc tính cơ bản cho Tuần 7 & 8
    public void nhapThongTinCoBan(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        System.out.print("Nhap tieu de sach: ");
        this.tieuDe = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        this.namXuatBan = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(sc.nextLine());
    }

    public void hienThiThongTin() {
        System.out.println("\n----- THONG TIN SACH -----");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        if (donGia > 0) {
            System.out.println("Don gia: " + donGia);
            System.out.println("Loai sach: " + layTenLoaiSach());
        }
    }

    // --- Các phương thức từ Tuần 3 & 4 (giữ nguyên để tương thích) ---
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }

    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    public double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    public boolean kiemTraHopLe() {
        return this.donGia > 0 && this.soLuong >= 0 && this.namXuatBan > 0 && this.namXuatBan <= 2026;
    }

    public String phanLoaiGia() {
        if (this.donGia < 50000) return "Sach gia thap";
        if (this.donGia <= 100000) return "Sach gia trung binh";
        if (this.donGia <= 200000) return "Sach gia cao";
        return "Sach gia dac biet";
    }

    public String phanLoaiTonKho() {
        if (this.soLuong == 0) return "Het sach";
        if (this.soLuong <= 5) return "Sap het";
        if (this.soLuong <= 20) return "Con it";
        return "Con nhieu";
    }

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