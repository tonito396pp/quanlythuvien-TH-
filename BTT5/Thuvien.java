package BTT5;

import java.util.Scanner;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private double donGia;
    private int soLuong;

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap ma sach: ");
        this.maSach = scanner.nextLine();

        System.out.print("Nhap ten sach: ");
        this.tenSach = scanner.nextLine();

        System.out.print("Nhap tac gia: ");
        this.tacGia = scanner.nextLine();

        System.out.print("Nhap don gia: ");
        while (!scanner.hasNextDouble()) {
            System.out.println(">> Chi duoc nhap so!");
            System.out.print("Nhap lai don gia: ");
            scanner.nextLine();
        }
        this.donGia = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap so luong: ");
        while (!scanner.hasNextInt()) {
            System.out.println(">> Chi duoc nhap so!");
            System.out.print("Nhap lai so luong: ");
            scanner.nextLine();
        }
        this.soLuong = scanner.nextInt();
        scanner.nextLine();
    }

    public double tinhGiaTri() {
        return this.donGia * this.soLuong;
    }

    public String layThongTin() {
        return "Ma: " + maSach + " | Ten: " + tenSach + " | Tac gia: " + tacGia
                + " | Gia: " + (long) donGia + " | SL: " + soLuong + " | Tong: " + (long) tinhGiaTri();
    }
}

public class Thuvien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        String dsSach = "";
        int luaChon;

        // BÀI 3(BTT5): Menu lặp đến khi chọn Thoát
        do {
            System.out.println("\n========== QUAN LY THU VIEN ==========");
            System.out.println("1. Nhap n sach (Bai 1(BTT5))");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tong so luong va gia tri (Bai 2(BTT5))");
            System.out.println("4. Tim sach theo ma (Bai 4(BTT5))");
            System.out.println("0. Thoat (Bai 3(BTT5))");
            System.out.println("======================================");
            System.out.print("Chon chuc nang (0-4): ");

            while (!scanner.hasNextInt()) {
                System.out.println(">> Chi duoc nhap so!");
                System.out.print("Chon lai chuc nang (0-4): ");
                scanner.nextLine();
            }
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    // BÀI 1(BTT5): Nhập n sách bằng vòng lặp
                    while (true) {
                        System.out.print("\nNhap so luong sach (n > 0): ");
                        while (!scanner.hasNextInt()) {
                            System.out.println(">> Chi duoc nhap so!");
                            System.out.print("Nhap lai so luong (n > 0): ");
                            scanner.nextLine();
                        }
                        n = scanner.nextInt();
                        scanner.nextLine();

                        if (n > 0) {
                            break;
                        }
                        System.out.println(">> So luong phai lon hon 0!");
                    }

                    tongSoLuong = 0;
                    tongGiaTri = 0;
                    dsSach = "";

                    for (int i = 1; i <= n; i++) {
                        System.out.println("\nNhap sach thu " + i + ":");
                        Sach sach = new Sach();
                        sach.nhapThongTin(scanner);

                        tongSoLuong += sach.getSoLuong();
                        tongGiaTri += sach.tinhGiaTri();

                        dsSach += i + ". " + sach.layThongTin() + "\n";
                    }
                    System.out.println("=> Da nhap xong " + n + " cuon sach!");
                    break;

                case 2:
                    if (dsSach.isEmpty()) {
                        System.out.println(">> Chua co sach nao!");
                    } else {
                        System.out.println("\n--- DANH SACH SACH (" + n + " cuon) ---");
                        System.out.print(dsSach);
                    }
                    break;

                case 3:
                    // BÀI 2(BTT5): Hiển thị tổng số lượng và tổng giá trị đã tính
                    if (dsSach.isEmpty()) {
                        System.out.println(">> Chua co sach de thong ke!");
                    } else {
                        System.out.println("\n--- THONG KE (BAI 2) ---");
                        System.out.println("- Tong so luong sach: " + tongSoLuong + " cuon");
                        System.out.println("- Tong gia tri sach : " + (long) tongGiaTri + " VND");
                    }
                    break;

                case 4:
                    // BÀI 4(BTT5): Tìm sách theo mã
                    if (dsSach.isEmpty()) {
                        System.out.println(">> Chua co sach de tim kiem!");
                    } else {
                        System.out.print("\nNhap ma sach can tim: ");
                        String maCanTim = scanner.nextLine().trim();
                        boolean timThay = false;

                        Scanner docDanhSach = new Scanner(dsSach);
                        while (docDanhSach.hasNextLine()) {
                            String dong = docDanhSach.nextLine();
                            if (dong.toLowerCase().contains("ma: " + maCanTim.toLowerCase() + " |")) {
                                System.out.println("=> Tim thay sach: " + dong);
                                timThay = true;
                                break;
                            }
                        }

                        if (!timThay) {
                            System.out.println(">> Khong tim thay ma: " + maCanTim);
                        }
                    }
                    break;

                case 0:
                    System.out.println(">> Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }

        } while (luaChon != 0);

        scanner.close();
    }
}
