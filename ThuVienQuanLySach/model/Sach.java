package model;

import java.time.Year;
import java.util.Scanner;

public class Sach {
    // Yêu cầu 1 (Tuần 8): Tất cả thuộc tính khai báo private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private int loaiSach;

    public Sach() {}

    // Yêu cầu 4 (Tuần 8): Constructor có tham số đầy đủ để khởi tạo đối tượng Sach
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan); // Gọi setter để tận dụng kiểm tra hợp lệ
        setSoLuong(soLuong);       // Gọi setter để tận dụng kiểm tra hợp lệ
    }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, double donGia, int soLuong, int loaiSach) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        this.donGia = donGia;
        setSoLuong(soLuong);
        this.loaiSach = loaiSach;
    }

    // Yêu cầu 2 & 3 (Tuần 8): Đầy đủ Public Getters và Setters có kiểm tra ràng buộc
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    // Yêu cầu 3 (Tuần 8): Kiểm tra năm xuất bản hợp lệ
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Canh bao: Nam xuat ban khong hop le (phai > 0 va <= " + currentYear + "). Mac dinh gan = " + currentYear);
            this.namXuatBan = currentYear;
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Yêu cầu 3 (Tuần 8): Kiểm tra số lượng không âm
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Canh bao: So luong khong duoc am! Mac dinh gan = 0");
            this.soLuong = 0;
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        }
    }

    public int getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(int loaiSach) {
        this.loaiSach = loaiSach;
    }

    // --- Các phương thức nhập / hiển thị ---
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        setMaSach(sc.nextLine());
        System.out.print("Nhap tieu de (ten sach): ");
        setTieuDe(sc.nextLine());
        System.out.print("Nhap tac gia: ");
        setTacGia(sc.nextLine());
        System.out.print("Nhap nam xuat ban: ");
        setNamXuatBan(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap don gia: ");
        setDonGia(Double.parseDouble(sc.nextLine()));
        System.out.print("Nhap so luong: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));

        System.out.println("--- Chon loai sach ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Vui long nhap lua chon (1-4): ");
        setLoaiSach(Integer.parseInt(sc.nextLine()));
    }

    public void nhapThongTinCoBan(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        setMaSach(sc.nextLine());
        System.out.print("Nhap tieu de sach: ");
        setTieuDe(sc.nextLine());
        System.out.print("Nhap tac gia: ");
        setTacGia(sc.nextLine());
        System.out.print("Nhap nam xuat ban: ");
        setNamXuatBan(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap so luong: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));
    }

    public void hienThiThongTin() {
        System.out.println("\n----- THONG TIN SACH -----");
        System.out.println("Ma sach: " + getMaSach());
        System.out.println("Tieu de: " + getTieuDe());
        System.out.println("Tac gia: " + getTacGia());
        System.out.println("Nam xuat ban: " + getNamXuatBan());
        System.out.println("So luong: " + getSoLuong());
        if (donGia > 0) {
            System.out.println("Don gia: " + getDonGia());
            System.out.println("Loai sach: " + layTenLoaiSach());
        }
    }

    // --- Các phương thức tính toán Tuần 3 & 4 ---
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
        int currentYear = Year.now().getValue();
        return this.donGia > 0 && this.soLuong >= 0 && this.namXuatBan > 0 && this.namXuatBan <= currentYear;
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
}