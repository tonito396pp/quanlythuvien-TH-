import java.util.Scanner;

//kết hợp tuần 4 sửa dữ liệu
public class QuanLySach {
    public static void main(String[] args) {
        // BAI 1(BTT3): Nhập thông tin sách và hiển thị lại
        Scanner scanner = new Scanner(System.in);

        System.out.println("NHAP THONG TIN SACH");

        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhap don gia: ");
        double donGia = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        // BÀI 4(BTT4): Dùng switch chọn loại sách
        System.out
                .println("Chon loai sach: 1. Sach giao khoa | 2. Sach tham khao | 3. Sach chuyen nganh | 4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        int loaiSach = Integer.parseInt(scanner.nextLine());
        String tenLoaiSach;
        switch (loaiSach) {
            case 1:
                tenLoaiSach = "Sach giao khoa";
                break;
            case 2:
                tenLoaiSach = "Sach tham khao";
                break;
            case 3:
                tenLoaiSach = "Sach chuyen nganh";
                break;
            case 4:
                tenLoaiSach = "Sach khac";
                break;
            default:
                tenLoaiSach = "Khong xac dinh";
                break;
        }

        // BÀI 2(BTT3): Tính thành tiền = đơn giá × số lượng.
        double thanhTien = donGia * soLuong;
        // BÀI 3(BTT3): Phí vận chuyển = 5% giá trị sách.
        double phiVanChuyen = thanhTien * 0.05;
        // BÀI 4(BTT3): Tổng tiền nhập = Thành tiền + Phí vận chuyển
        double tongTienNhap = thanhTien + phiVanChuyen;

        // BÀI 1(BTT4): Kiểm tra giá > 0, số lượng >= 0, năm xuất bản hợp lệ
        boolean hopLe = (donGia > 0) && (soLuong >= 0) && (namXuatBan > 0 && namXuatBan <= 2026);

        // BÀI 2(BTT4): Phân loại giá: thấp, trung bình, cao, đặc biệt
        String phanLoaiGia;
        if (donGia < 50000)
            phanLoaiGia = "Sach gia thap";
        else if (donGia <= 100000)
            phanLoaiGia = "Sach gia trung binh";
        else if (donGia <= 200000)
            phanLoaiGia = "Sach gia cao";
        else
            phanLoaiGia = "Sach gia dac biet";

        // BÀI 3(BTT4): Phân loại tồn kho: hết, sắp hết, còn ít, còn nhiều
        String phanLoaiTonKho;
        if (soLuong == 0)
            phanLoaiTonKho = "Het sach";
        else if (soLuong <= 5)
            phanLoaiTonKho = "Sap het";
        else if (soLuong <= 20)
            phanLoaiTonKho = "Con it";
        else
            phanLoaiTonKho = "Con nhieu";
        // HIỂN THỊ KẾT QUẢ TỔNG HỢP (BTT3 & BTT4)
        System.out.println("\n========== THONG TIN NHAP KHO ==========");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Loai sach: " + tenLoaiSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.printf("Don gia: %.0f VND\n", donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("----------------------------------------");
        System.out.printf("Bai 2(BTT3) - Thanh tien: %.0f VND\n", thanhTien);
        System.out.printf("Bai 3(BTT3) - Phi van chuyen (5%%): %.0f VND\n", phiVanChuyen);
        System.out.printf("Bai 4(BTT3) - Tong tien nhap: %.0f VND\n", tongTienNhap);
        System.out.println("----------------------------------------");
        System.out.println("Bai 1(BTT4) - Du lieu: " + (hopLe ? "Hop le" : "Khong hop le"));
        System.out.println("Bai 2(BTT4) - Phan loai gia: " + phanLoaiGia);
        System.out.println("Bai 3(BTT4) - Ton kho: " + phanLoaiTonKho);
        System.out.println("========================================");

        scanner.close();
    }
}
