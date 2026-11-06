import java.util.ArrayList;
import java.util.Scanner;
import model.Sach;

public class MainTuan5_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luaChonChinh;

        // Dữ liệu dùng riêng cho Tuần 5 (Mảng cố định)
        Sach[] danhSachTuan5 = null;
        int nTuan5 = 0;

        // Dữ liệu dùng riêng cho Tuần 6 (ArrayList động)
        ArrayList<Sach> dsArrayListTuan6 = new ArrayList<>();

        do {
            System.out.println("\n========== MENU TỔNG HỢP QUẢN LÝ SÁCH (TUẦN 5 & 6) ==========");
            System.out.println("1. Chạy chương trình TUẦN 5 (Mảng tĩnh n cuốn sách & Thống kê/Tìm kiếm)");
            System.out.println("2. Chạy chương trình TUẦN 6 (ArrayList động với 8 chức năng)");
            System.out.println("0. Thoát chương trình");
            System.out.println("=============================================================");
            System.out.print("Vui lòng chọn phần tuần thực hành muốn chạy (0-2): ");
            luaChonChinh = Integer.parseInt(sc.nextLine());

            switch (luaChonChinh) {
                case 1:
                    // --- MENU TUẦN 5 ---
                    int luaChonTuan5;
                    do {
                        System.out.println("\n--- MENU THỰC HÀNH TUẦN 5 ---");
                        System.out.println("1. Nhập danh sách n cuốn sách (Mảng)");
                        System.out.println("2. Hiển thị danh sách sách");
                        System.out.println("3. Tính tổng số lượng và tổng giá trị sách");
                        System.out.println("4. Tìm sách theo mã");
                        System.out.println("0. Quay lại menu chính");
                        System.out.print("Chọn chức năng Tuần 5 (0-4): ");
                        luaChonTuan5 = Integer.parseInt(sc.nextLine());

                        switch (luaChonTuan5) {
                            case 1:
                                System.out.print("Nhập số lượng sách n: ");
                                nTuan5 = Integer.parseInt(sc.nextLine());
                                danhSachTuan5 = new Sach[nTuan5];
                                for (int i = 0; i < nTuan5; i++) {
                                    System.out.println("Nhập sách thứ " + (i + 1) + ":");
                                    danhSachTuan5[i] = new Sach();
                                    danhSachTuan5[i].nhapThongTin(sc);
                                }
                                System.out.println("=> Đã nhập xong mảng " + nTuan5 + " cuốn sách!");
                                break;
                            case 2:
                                if (danhSachTuan5 == null) {
                                    System.out.println("Chưa có dữ liệu mảng sách!");
                                } else {
                                    for (Sach s : danhSachTuan5) {
                                        s.hienThiThongTin();
                                    }
                                }
                                break;
                            case 3:
                                if (danhSachTuan5 == null) {
                                    System.out.println("Chưa có dữ liệu!");
                                } else {
                                    int tongSL = 0;
                                    double tongGT = 0;
                                    for (Sach s : danhSachTuan5) {
                                        tongSL += s.getSoLuong();
                                        tongGT += s.tinhTongTienNhap();
                                    }
                                    System.out.println("Tổng số lượng: " + tongSL);
                                    System.out.printf("Tổng giá trị: %,.2f VND\n", tongGT);
                                }
                                break;
                            case 4:
                                if (danhSachTuan5 == null) {
                                    System.out.println("Chưa có dữ liệu!");
                                } else {
                                    System.out.print("Nhập mã sách cần tìm: ");
                                    String ma = sc.nextLine();
                                    boolean found = false;
                                    for (Sach s : danhSachTuan5) {
                                        if (s.getMaSach().equalsIgnoreCase(ma)) {
                                            s.hienThiThongTin();
                                            found = true;
                                            break;
                                        }
                                    }
                                    if (!found) System.out.println("Không tìm thấy!");
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (luaChonTuan5 != 0);
                    break;

                case 2:
                    // --- MENU TUẦN 6 (8 Chức năng theo yêu cầu) ---
                    int luaChonTuan6;
                    do {
                        System.out.println("\n--- MENU THỰC HÀNH TUẦN 6 (ARRAYLIST & 8 CHỨC NĂNG) ---");
                        System.out.println("1. Thêm sách");
                        System.out.println("2. Hiển thị sách");
                        System.out.println("3. Tìm sách");
                        System.out.println("4. Xóa sách");
                        System.out.println("5. Sửa sách");
                        System.out.println("6. Tính tổng số lượng");
                        System.out.println("7. Tính tổng giá trị");
                        System.out.println("8. Quay lại menu chính");
                        System.out.print("Chọn chức năng Tuần 6 (1-8): ");
                        luaChonTuan6 = Integer.parseInt(sc.nextLine());

                        switch (luaChonTuan6) {
                            case 1:
                                Sach sMoi = new Sach();
                                sMoi.nhapThongTin(sc);
                                dsArrayListTuan6.add(sMoi);
                                System.out.println("=> Đã thêm vào ArrayList thành công!");
                                break;
                            case 2:
                                if (dsArrayListTuan6.isEmpty()) {
                                    System.out.println("Danh sách trống!");
                                } else {
                                    for (int i = 0; i < dsArrayListTuan6.size(); i++) {
                                        System.out.println("\n[Sách thứ " + (i + 1) + "]");
                                        dsArrayListTuan6.get(i).hienThiThongTin();
                                    }
                                }
                                break;
                            case 3:
                                System.out.print("Nhập mã sách cần tìm: ");
                                String maTim = sc.nextLine();
                                boolean hasFound = false;
                                for (Sach s : dsArrayListTuan6) {
                                    if (s.getMaSach().equalsIgnoreCase(maTim)) {
                                        s.hienThiThongTin();
                                        hasFound = true;
                                        break;
                                    }
                                }
                                if (!hasFound) System.out.println("Không tìm thấy!");
                                break;
                            case 4:
                                System.out.print("Nhập mã sách cần xóa: ");
                                String maXoa = sc.nextLine();
                                boolean hasDeleted = false;
                                for (int i = 0; i < dsArrayListTuan6.size(); i++) {
                                    if (dsArrayListTuan6.get(i).getMaSach().equalsIgnoreCase(maXoa)) {
                                        dsArrayListTuan6.remove(i);
                                        System.out.println("=> Đã xóa thành công!");
                                        hasDeleted = true;
                                        break;
                                    }
                                }
                                if (!hasDeleted) System.out.println("Không tìm thấy mã để xóa!");
                                break;
                            case 5:
                                System.out.print("Nhập mã sách cần sửa: ");
                                String maSua = sc.nextLine();
                                boolean hasUpdated = false;
                                for (int i = 0; i < dsArrayListTuan6.size(); i++) {
                                    if (dsArrayListTuan6.get(i).getMaSach().equalsIgnoreCase(maSua)) {
                                        System.out.println("Nhập thông tin mới:");
                                        Sach sMoiCapNhat = new Sach();
                                        sMoiCapNhat.nhapThongTin(sc);
                                        dsArrayListTuan6.set(i, sMoiCapNhat);
                                        System.out.println("=> Đã cập nhật thành công!");
                                        hasUpdated = true;
                                        break;
                                    }
                                }
                                if (!hasUpdated) System.out.println("Không tìm thấy mã để sửa!");
                                break;
                            case 6:
                                int tongSL6 = 0;
                                for (Sach s : dsArrayListTuan6) {
                                    tongSL6 += s.getSoLuong();
                                }
                                System.out.println("=> Tổng số lượng sách: " + tongSL6);
                                break;
                            case 7:
                                double tongGT6 = 0;
                                for (Sach s : dsArrayListTuan6) {
                                    tongGT6 += s.tinhTongTienNhap();
                                }
                                System.out.printf("=> Tổng giá trị nhập kho: %,.2f VND\n", tongGT6);
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (luaChonTuan6 != 8);
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChonChinh != 0);

        sc.close();
    }
}