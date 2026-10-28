import java.util.Scanner;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private int loaiSach;

    // BÀI 1(BTT3):nhập thông tin sách
    void nhapThongTin(Scanner scanner) {
        System.out.println("NHAP THONG TIN SACH");

        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();

        System.out.print("Nhap ten sach: ");
        tenSach = scanner.nextLine();

        System.out.print("Nhap tac gia: ");
        tacGia = scanner.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(scanner.nextLine());

        // BÀI 4(BTT4): Dùng switch chọn loại sách
        System.out
                .println("Chon loai sach: 1. Sach giao khoa | 2. Sach tham khao | 3. Sach chuyen nganh | 4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        loaiSach = Integer.parseInt(scanner.nextLine());
        scanner.close();
    }

    // BÀI 4(BTT4): Lấy tên loại sách theo lựa chọn
    String layTenLoaiSach() {
        switch (loaiSach) {
            case 1:
                return "Sach giao khoa";
            case 2:
                return "Sach tham khao";
            case 3:
                return "Sach chuyen nganh";
            case 4:
                return "Sach khac";
            default:
                return "Khong xac dinh";
        }
    }

    // BÀI 2(BTT3): Tính thành tiền = đơn giá × số lượng
    double tinhThanhTien() {
        return donGia * soLuong;
    }

    // BÀI 3(BTT3): Phí vận chuyển = 5% giá trị sách (thành tiền)
    double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    // BÀI 4(BTT3): Tổng tiền nhập = Thành tiền + Phí vận chuyển
    double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    // BÀI 1(BTT4): Kiểm tra giá > 0, số lượng >= 0, năm xuất bản hợp lệ
    boolean kiemTraHopLe() {
        return (donGia > 0) && (soLuong >= 0) && (namXuatBan > 0 && namXuatBan <= 2026);
    }

    // BÀI 2(BTT4): Phân loại giá: thấp, trung bình, cao, đặc biệt
    String phanLoaiGia() {
        if (donGia < 50000) {
            return "Sach gia thap";
        } else if (donGia <= 100000) {
            return "Sach gia trung binh";
        } else if (donGia <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }

    // BÀI 3(BTT4): Phân loại tồn kho: hết, sắp hết, còn ít, còn nhiều
    String phanLoaiTonKho() {
        if (soLuong == 0) {
            return "Het sach";
        } else if (soLuong <= 5) {
            return "Sap het";
        } else if (soLuong <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    // HIỂN THỊ KẾT QUẢ TỔNG HỢP (BTT3 & BTT4)
    void xuatThongTin() {
        System.out.println("\n========== THONG TIN NHAP KHO ==========");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Loai sach: " + layTenLoaiSach());
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.printf("Don gia: %.0f VND\n", donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("----------------------------------------");
        System.out.printf("Bai 2(BTT3) - Thanh tien: %.0f VND\n", tinhThanhTien());
        System.out.printf("Bai 3(BTT3) - Phi van chuyen (5%%): %.0f VND\n", tinhPhiVanChuyen());
        System.out.printf("Bai 4(BTT3) - Tong tien nhap: %.0f VND\n", tinhTongTienNhap());
        System.out.println("----------------------------------------");
        System.out.println("Bai 1(BTT4) - Du lieu: Hop le");
        System.out.println("Bai 2(BTT4) - Phan loai gia: " + phanLoaiGia());
        System.out.println("Bai 3(BTT4) - Ton kho: " + phanLoaiTonKho());
        System.out.println("========================================");
    }
}

public class QuanLySach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Sach sach = new Sach();

        sach.nhapThongTin(scanner);

        // BÀI 1(BTT4): Kiểm tra tính hợp lệ ở main - chỉ khi hợp lệ mới in ra kết quả
        if (sach.kiemTraHopLe()) {
            sach.xuatThongTin();
        } else {
            System.out.println("\ndữ liệu không hợp lệ");
        }

        scanner.close();
    }
}
