package BTT7;
// Yêu cầu 3 (BTT7)
public class Test {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(">>> YEU CAU 3: TAO DOI TUONG TU LOP SACH <<<");
        System.out.println("==================================================");

        Sach s1 = new Sach("B01", "Lap trinh Java co ban", "Nguyen Van A", 2023, 10);
        System.out.println("1. Thong tin sach s1 (tao bang constructor day du):");
        s1.hienThiThongTin();

        Sach s2 = new Sach("B02", "Cau truc du lieu va Giai thuat", "Tran Thi B", 2022, 5);
        System.out.println("2. Thong tin sach s2 (tao bang constructor day du):");
        s2.hienThiThongTin();

        System.out.println("--- KIEM THU TINH NANG BTT8 ---");

        System.out.println("\n* Test Getter & Setter:");
        s2.setTieuDe("Cau truc du lieu & Giai thuat (Tai ban)");
        s2.setNamXuatBan(2024);
        s2.setSoLuong(20);
        System.out.println("+ Tieu de moi cua s2 lay qua getter: " + s2.getTieuDe());
        System.out.println("+ Nam xuat ban moi: " + s2.getNamXuatBan());
        System.out.println("+ So luong moi: " + s2.getSoLuong());
    }
}
