import java.util.Scanner;

public class QuanLySach {
    public static void main(String[] args) {
        // BAI 1: Nhập mã sách, tên sách, tác giả, năm xuất bản, đơn giá, số lượng và
        // hiển thị lại
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
        // BÀI 2: Tính thành tiền = đơn giá × số lượng.
        double thanhTien = donGia * soLuong;
        // BÀI 3: Phí vận chuyển = 5% giá trị sách.
        double phiVanChuyen = thanhTien * 0.05;
        // BÀI 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
        double tongTienNhap = thanhTien + phiVanChuyen;
        // HIỂN THỊ KẾT QUẢ
        System.out.println("\n========== THONG TIN NHAP KHO ==========");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.printf("Don gia: %.0f VND\n", donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("----------------------------------------");
        System.out.printf("Bai 2 - Thanh tien: %.0f VND\n", thanhTien);
        System.out.printf("Bai 3 - Phi van chuyen (5%%): %.0f VND\n", phiVanChuyen);
        System.out.printf("Bai 4 - Tong tien nhap: %.0f VND\n", tongTienNhap);
        System.out.println("========================================");

        scanner.close();
    }
}
