import java.util.Scanner;
import model.Sach;

public class MainTuan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach[] danhSachSach = null;
        int n = 0;
        int luaChon;

        // Bài 3: Menu lặp đến khi chọn Thoát
        do {
            System.out.println("\n========== MENU QUẢN LÝ SÁCH (TUẦN 5) ==========");
            System.out.println("1. Nhập danh sách n cuốn sách");
            System.out.println("2. Hiển thị danh sách và phân loại (kèm Tuần 3 & 4)");
            System.out.println("3. Tính tổng số lượng và tổng giá trị sách");
            System.out.println("4. Tìm sách theo mã");
            System.out.println("0. Thoát chương trình");
            System.out.println("================================================");
            System.out.print("Vui lòng chọn chức năng (0-4): ");
            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    // Bài 1: Nhập n sách bằng vòng lặp
                    System.out.print("\nNhập số lượng cuốn sách (n): ");
                    n = Integer.parseInt(sc.nextLine());
                    danhSachSach = new Sach[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("\n>> Nhập thông tin cuốn sách thứ " + (i + 1) + ":");
                        danhSachSach[i] = new Sach();
                        danhSachSach[i].nhapThongTin(sc);
                    }
                    System.out.println("=> Đã nhập xong " + n + " cuốn sách!");
                    break;

                case 2:
                    if (danhSachSach == null || n == 0) {
                        System.out.println("Danh sách trống! Hãy chọn 1 để nhập sách trước.");
                    } else {
                        for (int i = 0; i < n; i++) {
                            danhSachSach[i].hienThiThongTin();
                            System.out.println("Thành tiền: " + danhSachSach[i].tinhThanhTien());
                            System.out.println("Phí vận chuyển (5%): " + danhSachSach[i].tinhPhiVanChuyen());
                            System.out.println("Tổng tiền nhập kho: " + danhSachSach[i].tinhTongTienNhap());
                            System.out.println("Hợp lệ: " + (danhSachSach[i].kiemTraHopLe() ? "Hợp lệ" : "Không hợp lệ"));
                            System.out.println("Mức giá: " + danhSachSach[i].phanLoaiGia());
                            System.out.println("Tình trạng kho: " + danhSachSach[i].phanLoaiTonKho());
                        }
                    }
                    break;

                case 3:
                    // Bài 2: Tính tổng số lượng và tổng giá trị sách
                    if (danhSachSach == null || n == 0) {
                        System.out.println("Chưa có dữ liệu sách để tính toán!");
                    } else {
                        int tongSoLuong = 0;
                        double tongGiaTri = 0;

                        for (int i = 0; i < n; i++) {
                            tongSoLuong += danhSachSach[i].getSoLuong();
                            tongGiaTri += danhSachSach[i].tinhTongTienNhap();
                        }

                        System.out.println("\n--- KẾT QUẢ THỐNG KÊ ---");
                        System.out.println("Tổng số lượng sách: " + tongSoLuong);
                        System.out.printf("Tổng giá trị nhập kho: %,.2f VND\n", tongGiaTri);
                    }
                    break;

                case 4:
                    // Bài 4: Tìm sách theo mã
                    if (danhSachSach == null || n == 0) {
                        System.out.println("Chưa có dữ liệu sách để tìm kiếm!");
                    } else {
                        System.out.print("\nNhập mã sách cần tìm: ");
                        String maCanTim = sc.nextLine();
                        boolean timThay = false;

                        for (int i = 0; i < n; i++) {
                            if (danhSachSach[i].getMaSach().equalsIgnoreCase(maCanTim)) {
                                System.out.println("=> ĐÃ TÌM THẤY SÁCH:");
                                danhSachSach[i].hienThiThongTin();
                                timThay = true;
                                break;
                            }
                        }

                        if (!timThay) {
                            System.out.println("=> Không tìm thấy sách có mã: " + maCanTim);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 0-4!");
                    break;
            }
        } while (luaChon != 0);

        sc.close();
    }
}