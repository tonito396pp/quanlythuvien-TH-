package BTT7;

// Yêu cầu 3(BTT7)
public class Test {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(">>> YEU CAU 3: TAO DOI TUONG TU LOP SACH <<<");
        System.out.println("==================================================");

        Sach s1 = new Sach("B01", "Lap trinh Java co ban", "Nguyen Van A", 2023, 10);
        System.out.println("1. Thong tin sach s1 :");
        s1.hienThiThongTin();
        Sach s2 = new Sach("B02", "Cau truc du lieu va Giai thuat", "Tran Thi B", 2022, 5);
        System.out.println("2. Thong tin sach s2 :");
        s2.hienThiThongTin();
    }
}
