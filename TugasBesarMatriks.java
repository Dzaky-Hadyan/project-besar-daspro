import java.util.Scanner;

public class TugasBesarMatriks {
    static void tambahMatrix(int matriks1[][], int matriks2[][]) {
        int baris = matriks1.length;
        int kolom = matriks1[0].length;
        int[][] hasil = new int[baris][kolom];

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil[i][j] = matriks1[i][j] + matriks2[i][j];
            }
        }
        System.out.println("Hasil pertambahan matriks: ");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(hasil[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void kurangMatriks(int matriks1[][], int matriks2[][]) {
        int baris = matriks1.length;
        int kolom = matriks1[0].length;
        int[][] hasil = new int[baris][kolom];

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil[i][j] = matriks1[i][j] - matriks2[i][j];
            }
        }
        System.out.println("Hasil pengurangan matriks: ");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(hasil[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void kaliMatriks(int matriks1[][], int matriks2[][]) {
        int baris1 = matriks1.length;
        int kolom1 = matriks1[0].length;
        int baris2 = matriks2.length;
        int kolom2 = matriks2[0].length;
        int[][] hasil = new int[baris1][kolom2];

        for (int i = 0; i < baris1; i++) {
            for (int j = 0; j < kolom2; j++) {
                for (int k = 0; k < kolom1; k++) {
                    hasil[i][j] += matriks1[i][j] * matriks2[i][j];
                    }
                }
            }

        System.out.println("Hasil perkalian matriks: ");
        for (int i = 0; i < hasil.length; i++) {
            for (int j = 0; j < hasil[i].length; j++) {
                System.out.print(hasil[i][j] + " ");
            }
            System.out.println();
        }
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

                int matriks1[][] = new int[baris][kolom];
                int matriks2[][] = new int[baris][kolom];

                System.out.println("Masukkan elemen matriks 1:");
                for (int i = 0; i < baris; i++) {
                    System.out.println("Baris ke-" + (i+1) + ":");
                    for (int j = 0; j < kolom; j++) {
                        matriks1[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Masukkan elemen matriks 2:");
                for (int i = 0; i < baris; i++) {
                    System.out.println("Baris ke-" + (i+1) + ":");
                    for (int j = 0; j < kolom; j++) {
                        matriks2[i][j] = sc.nextInt();
                    }
                }
                int matriks[][] = new int[baris][kolom];

                switch (menu) {
                    case 1:
                    tambahMatrix(matriks1, matriks2);
                        break;
                    case 2:
                    kurangMatriks(matriks1, matriks2);
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
                System.out.println("Masukkan elemen matriks 1: ");
                for (int i = 0; i < baris1; i++) {
                    System.out.println("Baris ke-" + (i+1) + ":");
                    for (int j = 0; j < kolom1; j++) {
                        matriks1[i][j] = sc.nextInt();
                    }
                }

                System.out.print("Masukkan jumlah baris matriks 2: ");
                baris2 = sc.nextInt();
                if (baris2 != kolom1) {
                    System.out.println("Baris matriks 2 harus sama dengan kolom matriks 1!");
                    continue;
                } else {
                System.out.print("Masukkan jumlah kolom matriks 2: ");
                kolom2 = sc.nextInt();
                int matriks2[][] = new int[baris2][kolom2];

                System.out.println("Masukkan elemen matriks 2: ");
                    for (int i = 0; i < baris2; i++) {
                        System.out.println("Baris ke-" + (i+1) + ":");
                        for (int j = 0; j < kolom2; j++) {
                            matriks2[i][j] = sc.nextInt();
                        }
                    }
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