package BTT7;

import java.util.ArrayList;
import java.util.Scanner;

//Yêu cầu 1
class Sach {
    public String maSach;
    public String tieuDe;
    public String tacGia;
    public int namXuatBan;
    public int soLuong;

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    // Yêu cầu 2
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("---------------------------------");
    }
}

// Yêu cầu 4(BTT7)
public class CTQLsach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("YEU CAU 4: QUAN LY DANH SACH SACH");

        ArrayList<Sach> dsSach = new ArrayList<>();

        dsSach.add(new Sach("B01", "Lap trinh Java co ban", "Nguyen Van A", 2023, 10));
        dsSach.add(new Sach("B02", "Cau truc du lieu va Giai thuat", "Tran Thi B", 2022, 5));
        dsSach.add(new Sach("B03", "Co so du lieu SQL", "Le Van C", 2021, 8));

        int luaChon;
        do {
            System.out.println("\n---------- MENU QUAN LY SACH ----------");
            System.out.println("1. Hien thi toan bo danh sach sach");
            System.out.println("2. Them sach moi vao danh sach");
            System.out.println("3. Tim kiem sach theo ma sach");
            System.out.println("4. Tinh tong so luong sach trong thu vien");
            System.out.println("0. Thoat chuong trinh");
            System.out.print(">> Vui long chon chuc nang (0-4): ");

            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- DANH SACH CAC CUON SACH TRONG THU VIEN ---");
                    if (dsSach.isEmpty()) {
                        System.out.println("Danh sach sach hien dang trong!");
                    } else {
                        for (Sach s : dsSach) {
                            s.hienThiThongTin();
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- NHAP THONG TIN CUON SACH MOI ---");
                    System.out.print("Nhap ma sach: ");
                    String ma = sc.nextLine();
                    System.out.print("Nhap tieu de: ");
                    String tieuDe = sc.nextLine();
                    System.out.print("Nhap tac gia: ");
                    String tacGia = sc.nextLine();
                    System.out.print("Nhap nam xuat ban: ");
                    int namXB = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap so luong: ");
                    int soLuong = Integer.parseInt(sc.nextLine());

                    Sach sachMoi = new Sach(ma, tieuDe, tacGia, namXB, soLuong);
                    dsSach.add(sachMoi);
                    System.out.println("=> Da them sach moi vao danh sach thanh cong!");
                    break;

                case 3:
                    System.out.print("\nNhap ma sach can tim: ");
                    String maTim = sc.nextLine().trim();
                    boolean timThay = false;
                    for (Sach s : dsSach) {
                        if (s.maSach.equalsIgnoreCase(maTim)) {
                            System.out.println("=> Da tim thay sach:");
                            s.hienThiThongTin();
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("=> Khong tim thay sach co ma: " + maTim);
                    }
                    break;

                case 4:
                    int tongSoLuong = 0;
                    for (Sach s : dsSach) {
                        tongSoLuong += s.soLuong;
                    }
                    System.out.println("=> Tong so luong sach hien co trong thu vien: " + tongSoLuong);
                    break;

                case 0:
                    System.out.println("ket thuc chuong trinh");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long chon tu 0 den 4!");
            }
        } while (luaChon != 0);

        sc.close();
    }
}
