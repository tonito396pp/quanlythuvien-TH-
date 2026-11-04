package BTT5;

import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private double donGia;
    private int soLuong;

    public Sach() {
    }

    public String getMaSach() {
        return maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Nhập thông tin sách
    public void nhapThongTin(Scanner scanner) {
        do {
            System.out.print("Nhap ma sach: ");
            this.maSach = scanner.nextLine().trim();
            if (this.maSach.isEmpty())
                System.out.println(">> Ma sach khong duoc de trong");
        } while (this.maSach.isEmpty());

        do {
            System.out.print("Nhap ten sach: ");
            this.tenSach = scanner.nextLine().trim();
            if (this.tenSach.isEmpty())
                System.out.println(">> Ten sach khong duoc de trong");
        } while (this.tenSach.isEmpty());

        System.out.print("Nhap tac gia: ");
        this.tacGia = scanner.nextLine().trim();

        this.donGia = Thuvien.nhapSoThuc(scanner, "Nhap don gia: ", 0);
        this.soLuong = Thuvien.nhapSo(scanner, "Nhap so luong: ", 0);
    }

    // Tính giá trị sách = đơn giá * số lượng
    public double tinhGiaTri() {
        return this.donGia * this.soLuong;
    }

    // Xuất thông tin sách
    public void xuatThongTin() {
        System.out.printf("Ma: %s | Ten: %s | Tac gia: %s | Gia: %,d VND | SL: %d | Tong: %,d VND\n",
                maSach, tenSach, tacGia, (long) donGia, soLuong, (long) tinhGiaTri());
    }
}

public class Thuvien {

    public static int nhapSo(Scanner sc, String thongBao, int min) {
        while (true) {
            System.out.print(thongBao);
            while (!sc.hasNextInt()) {
                System.out.print(">> Chi duoc nhap so, nhap lai: ");
                sc.nextLine();
            }
            int val = sc.nextInt();
            sc.nextLine();
            if (val >= min)
                return val;
            System.out.println(">> Gia tri phai lon hon hoac bang " + min);
        }
    }

    public static double nhapSoThuc(Scanner sc, String thongBao, double min) {
        while (true) {
            System.out.print(thongBao);
            while (!sc.hasNextDouble()) {
                System.out.print(">> Chi duoc nhap so, nhap lai: ");
                sc.nextLine();
            }
            double val = sc.nextDouble();
            sc.nextLine();
            if (val >= min)
                return val;
            System.out.println(">> Gia tri phai lon hon hoac bang " + (long) min);
        }
    }

    public static ArrayList<Integer> timViTriTrung(ArrayList<Sach> ds, String ma) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaSach().equalsIgnoreCase(ma)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void inDanhSachTrung(ArrayList<Sach> ds, ArrayList<Integer> viTri) {
        for (int i = 0; i < viTri.size(); i++) {
            System.out.print((i + 1) + ". [Vi tri #" + (viTri.get(i) + 1) + "] ");
            ds.get(viTri.get(i)).xuatThongTin();
        }
    }

    // BÀI 1(BTT6): Tạo mảng int[] soLuong (5 cuốn sách), tính tổng, tìm max
    public static void bai1_MangSoLuong(Scanner scanner) {
        int[] soLuong = new int[5];
        int tong = 0, max = 0;
        System.out.println("\n========== BAI 1(BTT6): MANG INT[] SO LUONG ==========");
        for (int i = 0; i < 5; i++) {
            soLuong[i] = nhapSo(scanner, "Nhap so luong cuon thu " + (i + 1) + ": ", 0);
            tong += soLuong[i];
            if (i == 0 || soLuong[i] > max)
                max = soLuong[i];
        }
        System.out.println("--- Ket qua ---");
        for (int i = 0; i < 5; i++)
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i] + " cuon");
        System.out.println("Tong so luong: " + tong + " cuon | Lon nhat: " + max + " cuon");
    }

    // BÀI 2(BTT6): Sử dụng ArrayList<String> để lưu mã sách (thêm, hiển thị, tìm,
    // xóa)
    public static void bai2_ArrayListMaSach(Scanner scanner) {
        ArrayList<String> ds = new ArrayList<>();
        int chon;
        do {
            System.out.println("\n========== BAI 2(BTT6): QUAN LY MA SACH ==========");
            System.out.println("1. Them ma | 2. Hien thi | 3. Tim ma | 4. Xoa ma | 0. Quay lai");
            chon = nhapSo(scanner, "Chon chuc nang (0-4): ", 0);
            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    String ma = scanner.nextLine().trim();
                    if (!ma.isEmpty()) {
                        ds.add(ma);
                        System.out.println("=> Da them ma: " + ma);
                    } else
                        System.out.println(">> Ma khong duoc de trong");
                    break;
                case 2:
                    if (ds.isEmpty())
                        System.out.println(">> Danh sach ma dang trong");
                    else
                        for (int i = 0; i < ds.size(); i++)
                            System.out.println((i + 1) + ". " + ds.get(i));
                    break;
                case 3:
                    System.out.print("Nhap ma can tim: ");
                    String tim = scanner.nextLine().trim();
                    int idx = ds.indexOf(tim);
                    System.out.println(
                            idx >= 0 ? "=> Tim thay tai vi tri: " + (idx + 1) : ">> Khong tim thay ma: " + tim);
                    break;
                case 4:
                    System.out.print("Nhap ma can xoa: ");
                    String xoa = scanner.nextLine().trim();
                    System.out.println(ds.remove(xoa) ? "=> Da xoa ma: " + xoa : ">> Khong tim thay ma de xoa");
                    break;
                case 0:
                    System.out.println(">> Quay lai Menu chinh");
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
    }

    // BÀI 3(BTT6): Xây dựng ArrayList<String> danhSachSach (thêm, hiển thị, tìm,
    // xóa, sửa)
    public static void bai3_ArrayListDanhSachSach(Scanner scanner) {
        ArrayList<String> ds = new ArrayList<>();
        int chon;
        do {
            System.out.println("\n========== BAI 3(BTT6): DANH SACH SACH ==========");
            System.out.println("1. Them | 2. Hien thi | 3. Tim | 4. Xoa | 5. Sua | 0. Quay lai");
            chon = nhapSo(scanner, "Chon chuc nang (0-5): ", 0);
            switch (chon) {
                case 1:
                    System.out.print("Nhap thong tin sach: ");
                    String info = scanner.nextLine().trim();
                    if (!info.isEmpty()) {
                        ds.add(info);
                        System.out.println("=> Da them sach thanh cong");
                    } else
                        System.out.println(">> Thong tin khong duoc de trong");
                    break;
                case 2:
                    if (ds.isEmpty())
                        System.out.println(">> Danh sach dang trong");
                    else
                        for (int i = 0; i < ds.size(); i++)
                            System.out.println((i + 1) + ". " + ds.get(i));
                    break;
                case 3:
                    System.out.print("Nhap tu khoa: ");
                    String kw = scanner.nextLine().trim().toLowerCase();
                    boolean thay = false;
                    for (int i = 0; i < ds.size(); i++) {
                        if (ds.get(i).toLowerCase().contains(kw)) {
                            System.out.println((i + 1) + ". " + ds.get(i));
                            thay = true;
                        }
                    }
                    if (!thay)
                        System.out.println(">> Khong tim thay");
                    break;
                case 4:
                    if (ds.isEmpty()) {
                        System.out.println(">> Danh sach dang trong");
                        break;
                    }
                    int sttXoa = nhapSo(scanner, "Nhap STT can xoa (1-" + ds.size() + "): ", 1);
                    if (sttXoa <= ds.size())
                        System.out.println("=> Da xoa: " + ds.remove(sttXoa - 1));
                    else
                        System.out.println(">> STT khong hop le");
                    break;
                case 5:
                    if (ds.isEmpty()) {
                        System.out.println(">> Danh sach dang trong");
                        break;
                    }
                    int sttSua = nhapSo(scanner, "Nhap STT can sua (1-" + ds.size() + "): ", 1);
                    if (sttSua <= ds.size()) {
                        System.out.print("Nhap thong tin moi: ");
                        ds.set(sttSua - 1, scanner.nextLine().trim());
                        System.out.println("=> Da cap nhat");
                    } else
                        System.out.println(">> STT khong hop le");
                    break;
                case 0:
                    System.out.println(">> Quay lai Menu chinh");
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
    }

    // BÀI 4(BTT6): Xây dựng menu hoàn chỉnh 8 chức năng
    public static void bai4_QuanLyThuVien(Scanner scanner, ArrayList<Sach> dsSach) {
        int chon;
        do {
            System.out.println("\n========== MENU (BAI 4) ==========");
            System.out.println("1. Them sach         | 2. Hien thi sach");
            System.out.println("3. Tim sach          | 4. Xoa sach");
            System.out.println("5. Sua sach          | 6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri | 8. Quay lai Menu chinh");
            System.out.println("===================================================");
            chon = nhapSo(scanner, "Nhap lua chon (1-8): ", 1);

            switch (chon) {
                // BÀI 4(BTT6) - 1. Thêm sách
                case 1:
                    System.out.println("\n--- Nhap sach moi ---");
                    Sach sachMoi = new Sach();
                    sachMoi.nhapThongTin(scanner);
                    ArrayList<Integer> trungThem = timViTriTrung(dsSach, sachMoi.getMaSach());
                    if (!trungThem.isEmpty()) {
                        System.out.println(">> Canh bao: Ma \"" + sachMoi.getMaSach() + "\" da ton tai trong kho:");
                        inDanhSachTrung(dsSach, trungThem);
                    }
                    dsSach.add(sachMoi);
                    System.out.println("=> Da them sach thanh cong");
                    break;

                // BÀI 4(BTT6) - 2. Hiển thị sách
                case 2:
                    if (dsSach.isEmpty())
                        System.out.println(">> Danh sach sach dang trong");
                    else {
                        System.out.println("\n--- DANH SACH SACH (" + dsSach.size() + " cuon) ---");
                        for (int i = 0; i < dsSach.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            dsSach.get(i).xuatThongTin();
                        }
                    }
                    break;

                // BÀI 4(BTT6) - 3. Tìm sách (hiển thị tất cả sách trùng mã)
                case 3:
                    if (dsSach.isEmpty()) {
                        System.out.println(">> Danh sach dang trong");
                        break;
                    }
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = scanner.nextLine().trim();
                    ArrayList<Integer> trungTim = timViTriTrung(dsSach, maTim);
                    if (trungTim.isEmpty())
                        System.out.println(">> Khong tim thay cuon sach nao co ma: " + maTim);
                    else {
                        System.out.println("=> Tim thay " + trungTim.size() + " cuon trung ma \"" + maTim + "\":");
                        inDanhSachTrung(dsSach, trungTim);
                    }
                    break;

                // BÀI 4(BTT6) - 4. Xóa sách
                case 4:
                    if (dsSach.isEmpty()) {
                        System.out.println(">> Danh sach dang trong");
                        break;
                    }
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = scanner.nextLine().trim();
                    ArrayList<Integer> trungXoa = timViTriTrung(dsSach, maXoa);
                    if (trungXoa.isEmpty()) {
                        System.out.println(">> Khong tim thay sach co ma: " + maXoa);
                    } else {
                        System.out.println("Tim thay " + trungXoa.size() + " cuon co ma \"" + maXoa + "\":");
                        inDanhSachTrung(dsSach, trungXoa);
                        if (trungXoa.size() == 1) {
                            dsSach.remove((int) trungXoa.get(0));
                            System.out.println("=> Da xoa sach co ma: " + maXoa);
                        } else {
                            System.out.println("1. Xoa TAT CA | 2. Chi xoa 1 cuon theo STT");
                            int opt = nhapSo(scanner, "Chon (1 hoac 2): ", 1);
                            if (opt == 1) {
                                for (int i = dsSach.size() - 1; i >= 0; i--) {
                                    if (dsSach.get(i).getMaSach().equalsIgnoreCase(maXoa))
                                        dsSach.remove(i);
                                }
                                System.out.println("=> Da xoa tat ca " + trungXoa.size() + " cuon co ma: " + maXoa);
                            } else if (opt == 2) {
                                int stt = nhapSo(scanner, "Nhap STT muon xoa (1-" + trungXoa.size() + "): ", 1);
                                if (stt <= trungXoa.size()) {
                                    dsSach.remove((int) trungXoa.get(stt - 1));
                                    System.out.println("=> Da xoa cuon sach da chon");
                                } else
                                    System.out.println(">> STT khong hop le");
                            }
                        }
                    }
                    break;

                // BÀI 4(BTT6) - 5. Sửa sách
                case 5:
                    if (dsSach.isEmpty()) {
                        System.out.println(">> Danh sach dang trong");
                        break;
                    }
                    System.out.print("Nhap ma sach can sua: ");
                    String maSua = scanner.nextLine().trim();
                    ArrayList<Integer> trungSua = timViTriTrung(dsSach, maSua);
                    if (trungSua.isEmpty()) {
                        System.out.println(">> Khong tim thay sach co ma: " + maSua);
                    } else {
                        System.out.println("Tim thay " + trungSua.size() + " cuon co ma \"" + maSua + "\":");
                        inDanhSachTrung(dsSach, trungSua);
                        int idxSua = trungSua.get(0);
                        if (trungSua.size() > 1) {
                            int stt = nhapSo(scanner, "Nhap STT cuon muon sua (1-" + trungSua.size() + "): ", 1);
                            if (stt > trungSua.size()) {
                                System.out.println(">> STT khong hop le");
                                break;
                            }
                            idxSua = trungSua.get(stt - 1);
                        }
                        System.out.println("--- Nhap thong tin moi ---");
                        dsSach.get(idxSua).nhapThongTin(scanner);
                        System.out.println("=> Da cap nhat thong tin sach");
                    }
                    break;

                // BÀI 4(BTT6) - 6. Tính tổng số lượng
                case 6:
                    if (dsSach.isEmpty())
                        System.out.println(">> Danh sach dang trong");
                    else {
                        int tongSL = 0;
                        for (Sach s : dsSach)
                            tongSL += s.getSoLuong();
                        System.out.println("=> Tong so luong sach: " + tongSL + " cuon");
                    }
                    break;

                // BÀI 4(BTT6) - 7. Tính tổng giá trị
                case 7:
                    if (dsSach.isEmpty())
                        System.out.println(">> Danh sach dang trong");
                    else {
                        double tongGT = 0;
                        for (Sach s : dsSach)
                            tongGT += s.tinhGiaTri();
                        System.out.printf("=> Tong gia tri sach: %,d VND\n", (long) tongGT);
                    }
                    break;

                // BÀI 4(BTT6) - 8. Thoát về Menu chính
                case 8:
                    System.out.println(">> Quay lai Menu chinh");
                    break;

                default:
                    System.out.println(">> Lua chon khong hop le");
                    break;
            }
        } while (chon != 8);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sach> dsSach = new ArrayList<>();
        int menuTong;

        do {
            System.out.println("\n================ BAI THUC HANG TUẦN 6 ================");
            System.out.println("1. Bai 1: Mang int[] so luong sach (tinh tong, tim max)");
            System.out.println("2. Bai 2: ArrayList<String> luu ma sach (them, xem, tim, xoa)");
            System.out.println("3. Bai 3: ArrayList<String> danh sach sach (them, xem, sua, xoa)");
            System.out.println("4. Bai 4: He thong Quan Ly Thu Vien hoan chinh (8 chuc nang)");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("======================================================");
            menuTong = nhapSo(scanner, "Nhap lua chon cua ban (0-4): ", 0);

            switch (menuTong) {
                case 1:
                    bai1_MangSoLuong(scanner);
                    break;
                case 2:
                    bai2_ArrayListMaSach(scanner);
                    break;
                case 3:
                    bai3_ArrayListDanhSachSach(scanner);
                    break;
                case 4:
                    bai4_QuanLyThuVien(scanner, dsSach);
                    break;
                case 0:
                    System.out.println(">> Ket thuc chuong trinh");
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le, chon tu 0 den 4");
                    break;
            }

        } while (menuTong != 0);

        scanner.close();
    }
}
