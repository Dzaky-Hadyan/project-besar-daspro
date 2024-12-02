import java.util.Scanner;

public class TugasBesar {
    static String tambahData() {

    }
    static String tampilData() {

    }
    static String analisisData() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    analisisData();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
            }
        } while (menu != 4);
    }
}