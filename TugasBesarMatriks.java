import java.util.Scanner;

public class TugasBesarMatriks {
    static void tambahMatrix(int matriks[][]) {

    }
    static void kurangMatriks(int matriks[][]) {

    }
    static void kaliMatriks(int matriks1[][], int matriks2[][]) {

    }
    static void inversMatriks() {

    }
    static void transposeMatriks(int matriks[][]) {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println("=== Operasi Matriks ===");
            System.out.println("1. +");
            System.out.println("2. -");
            System.out.println("3. *");
            System.out.println("4. Invers");
            System.out.println("5. Transpose");
            System.out.println("6. Exit");
            System.out.print("Menu: ");
            menu = sc.nextInt();
            int baris = 0, kolom = 0, baris1, baris2, kolom1, kolom2;
            if (menu > 0 && menu < 3) {
                System.out.print("Masukkan jumlah baris matriks: ");
                baris = sc.nextInt();
                System.out.print("Masukkan jumlah kolom matriks: ");
                kolom = sc.nextInt();
                int matriks[][] = new int[baris][kolom];
                switch (menu) {
                    case 1:
                    tambahMatrix(matriks);
                        break;
                    case 2:
                    kurangMatriks(matriks);
                        break;
                    case 5:
                    transposeMatriks(matriks);
                        break;
                }
            } else if (menu == 3) {
                System.out.print("Masukkan jumlah baris matriks 1: ");
                baris1 = sc.nextInt();
                System.out.print("Masukkan jumlah kolom matriks 1: ");
                kolom1 = sc.nextInt();
                int matriks1[][] = new int[baris1][kolom1];
                System.out.print("Masukkan jumlah baris matriks 2: ");
                baris2 = sc.nextInt();
                if (baris2 != kolom1) {
                    System.out.println("Baris matriks 2 harus sama dengan kolom matriks 1!");
                    continue;
                } else {
                System.out.print("Masukkan jumlah kolom matriks 2: ");
                kolom2 = sc.nextInt();
                int matriks2[][] = new int[baris2][kolom2];
                kaliMatriks(matriks1, matriks2);
                }
            } else {
                switch (menu) {
                    case 4:
                    inversMatriks();
                        break;
                    case 6:
                        System.out.println("Terima Kasih!");
                        break;
                    default:
                        System.out.println("Input Invalid");
                        break;
                }
            }
        } while (menu != 6);
        sc.close();
    }
}