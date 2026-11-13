import java.util.ArrayList;
import java.util.Scanner;
import model.Sach;

public class MainTuan5_6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int luaChonChinh;

            Sach[] danhSachTuan5 = null;
            int nTuan5;
            ArrayList<Sach> dsArrayListTuan6 = new ArrayList<>();

            do {
                System.out.println("\n========== MENU TONG HOP QUAN LY SACH (TUAN 5 & 6) ==========");
                System.out.println("1. Chay chuong trinh TUAN 5 (Mang tinh n cuon sach & Thong ke/Tim kiem)");
                System.out.println("2. Chay chuong trinh TUAN 6 (ArrayList dong voi 8 chuc nang)");
                System.out.println("0. Thoat chuong trinh");
                System.out.println("=============================================================");
                System.out.print("Vui long chon phan tuan thuc hanh muon chay (0-2): ");
                luaChonChinh = Integer.parseInt(sc.nextLine());

                switch (luaChonChinh) {
                    case 1 -> {
                        int luaChonTuan5;
                        do {
                            System.out.println("\n--- MENU THUC HANH TUAN 5 ---");
                            System.out.println("1. Nhap danh sach n cuon sach (Mang)");
                            System.out.println("2. Hien thi danh sach sach");
                            System.out.println("3. Tinh tong so luong va tong gia tri sach");
                            System.out.println("4. Tim sach theo ma");
                            System.out.println("0. Quay lai menu chinh");
                            System.out.print("Chon chuc nang Tuan 5 (0-4): ");
                            luaChonTuan5 = Integer.parseInt(sc.nextLine());

                            switch (luaChonTuan5) {
                                case 1 -> {
                                    System.out.print("Nhap so luong sach n: ");
                                    nTuan5 = Integer.parseInt(sc.nextLine());
                                    danhSachTuan5 = new Sach[nTuan5];
                                    for (int i = 0; i < nTuan5; i++) {
                                        System.out.println("Nhap sach thu " + (i + 1) + ":");
                                        danhSachTuan5[i] = new Sach();
                                        danhSachTuan5[i].nhapThongTin(sc);
                                    }
                                    System.out.println("=> Da nhap xong mang " + nTuan5 + " cuon sach!");
                                }
                                case 2 -> {
                                    if (danhSachTuan5 == null) {
                                        System.out.println("Chua co du lieu mang sach!");
                                    } else {
                                        for (Sach s : danhSachTuan5) {
                                            s.hienThiThongTin();
                                        }
                                    }
                                }
                                case 3 -> {
                                    if (danhSachTuan5 == null) {
                                        System.out.println("Chua co du lieu!");
                                    } else {
                                        int tongSL = 0;
                                        double tongGT = 0;
                                        for (Sach s : danhSachTuan5) {
                                            tongSL += s.getSoLuong();
                                            tongGT += s.tinhTongTienNhap();
                                        }
                                        System.out.println("Tong so luong: " + tongSL);
                                        System.out.printf("Tong gia tri: %,.2f VND\n", tongGT);
                                    }
                                }
                                case 4 -> {
                                    if (danhSachTuan5 == null) {
                                        System.out.println("Chua co du lieu!");
                                    } else {
                                        System.out.print("Nhap ma sach can tim: ");
                                        String ma = sc.nextLine();
                                        boolean found = false;
                                        for (Sach s : danhSachTuan5) {
                                            if (s.getMaSach().equalsIgnoreCase(ma)) {
                                                s.hienThiThongTin();
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (!found) System.out.println("Khong tim thay!");
                                    }
                                }
                                case 0 -> {}
                                default -> System.out.println("Lua chon khong hop le!");
                            }
                        } while (luaChonTuan5 != 0);
                    }

                    case 2 -> {
                        int luaChonTuan6;
                        do {
                            System.out.println("\n--- MENU THUC HANH TUAN 6 (ARRAYLIST & 8 CHUC NANG) ---");
                            System.out.println("1. Them sach");
                            System.out.println("2. Hien thi sach");
                            System.out.println("3. Tim sach");
                            System.out.println("4. Xoa sach");
                            System.out.println("5. Sua sach");
                            System.out.println("6. Tinh tong so luong");
                            System.out.println("7. Tinh tong gia tri");
                            System.out.println("8. Quay lai menu chinh");
                            System.out.print("Chon chuc nang Tuan 6 (1-8): ");
                            luaChonTuan6 = Integer.parseInt(sc.nextLine());

                            switch (luaChonTuan6) {
                                case 1 -> {
                                    Sach sMoi = new Sach();
                                    sMoi.nhapThongTin(sc);
                                    dsArrayListTuan6.add(sMoi);
                                    System.out.println("=> Da them vao ArrayList thanh cong!");
                                }
                                case 2 -> {
                                    if (dsArrayListTuan6.isEmpty()) {
                                        System.out.println("Danh sach trong!");
                                    } else {
                                        for (int i = 0; i < dsArrayListTuan6.size(); i++) {
                                            System.out.println("\n[Sach thu " + (i + 1) + "]");
                                            dsArrayListTuan6.get(i).hienThiThongTin();
                                        }
                                    }
                                }
                                case 3 -> {
                                    System.out.print("Nhap ma sach can tim: ");
                                    String maTim = sc.nextLine();
                                    boolean hasFound = false;
                                    for (Sach s : dsArrayListTuan6) {
                                        if (s.getMaSach().equalsIgnoreCase(maTim)) {
                                            s.hienThiThongTin();
                                            hasFound = true;
                                            break;
                                        }
                                    }
                                    if (!hasFound) System.out.println("Khong tim thay!");
                                }
                                case 4 -> {
                                    System.out.print("Nhap ma sach can xoa: ");
                                    String maXoa = sc.nextLine();
                                    boolean hasDeleted = false;
                                    for (int i = 0; i < dsArrayListTuan6.size(); i++) {
                                        if (dsArrayListTuan6.get(i).getMaSach().equalsIgnoreCase(maXoa)) {
                                            dsArrayListTuan6.remove(i);
                                            System.out.println("=> Da xoa thanh cong!");
                                            hasDeleted = true;
                                            break;
                                        }
                                    }
                                    if (!hasDeleted) System.out.println("Khong tim thay ma de xoa!");
                                }
                                case 5 -> {
                                    System.out.print("Nhap ma sach can sua: ");
                                    String maSua = sc.nextLine();
                                    boolean hasUpdated = false;
                                    for (int i = 0; i < dsArrayListTuan6.size(); i++) {
                                        if (dsArrayListTuan6.get(i).getMaSach().equalsIgnoreCase(maSua)) {
                                            System.out.println("Nhap thong tin moi:");
                                            Sach sMoiCapNhat = new Sach();
                                            sMoiCapNhat.nhapThongTin(sc);
                                            dsArrayListTuan6.set(i, sMoiCapNhat);
                                            System.out.println("=> Da cap nhat thanh cong!");
                                            hasUpdated = true;
                                            break;
                                        }
                                    }
                                    if (!hasUpdated) System.out.println("Khong tim thay ma de sua!");
                                }
                                case 6 -> {
                                    int tongSL6 = 0;
                                    for (Sach s : dsArrayListTuan6) {
                                        tongSL6 += s.getSoLuong();
                                    }
                                    System.out.println("=> Tong so luong sach: " + tongSL6);
                                }
                                case 7 -> {
                                    double tongGT6 = 0;
                                    for (Sach s : dsArrayListTuan6) {
                                        tongGT6 += s.tinhTongTienNhap();
                                    }
                                    System.out.printf("=> Tong gia tri nhap kho: %,.2f VND\n", tongGT6);
                                }
                                case 8 -> {}
                                default -> System.out.println("Lua chon khong hop le!");
                            }
                        } while (luaChonTuan6 != 8);
                    }

                    case 0 -> System.out.println("Da thoat chuong trinh. Tam biet!");
                    default -> System.out.println("Lua chon khong hop le!");
                }
            } while (luaChonChinh != 0);
        }
    }
}