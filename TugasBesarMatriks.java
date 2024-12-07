import java.util.Scanner;

public class TugasBesarMatriks {
    static void tambahMatrix(int matriks[][]) {

    }
    static void kurangMatriks(int matriks[][]) {

    }
    static void kaliMatriks(int matriks1[][], int matriks2[][]) {

    }
    static void inversMatriks(int matriks[][]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                System.out.printf("Baris ke-%d Kolom ke-%d: ", i, j);
                matriks[i][j] = sc.nextInt();
            }
        }
        int[][] cofactorMatrix = new int[matriks.length][matriks.length];
        if (matriks.length == 3) {
            cofactorMatrix[0][0] = (matriks[1][1] * matriks[2][2]) - (matriks[1][2] * matriks[2][1]);
            cofactorMatrix[0][1] = -1 * ((matriks[1][0] * matriks[2][2]) - (matriks[1][2] * matriks[2][0]));
            cofactorMatrix[0][2] = (matriks[1][0] * matriks[2][1]) - (matriks[1][1] * matriks[2][0]);
            cofactorMatrix[1][0] = -1 * ((matriks[0][1] * matriks[2][2]) - (matriks[0][2] * matriks[2][1]));
            cofactorMatrix[1][1] = (matriks[0][0] * matriks[2][2]) - (matriks[0][2] * matriks[2][0]);
            cofactorMatrix[1][2] = -1 * ((matriks[0][0] * matriks[2][1]) - (matriks[0][1] * matriks[2][0]));
            cofactorMatrix[2][0] = (matriks[0][1] * matriks[1][2]) - (matriks[0][2] * matriks[1][1]);
            cofactorMatrix[2][1] = -1 * ((matriks[0][0] * matriks[1][2]) - (matriks[0][2] * matriks[1][0]));
            cofactorMatrix[2][2] = (matriks[0][0] * matriks[1][1]) - (matriks[0][1] * matriks[1][0]);
            for (int k = 0; k < cofactorMatrix.length; k++) {
                System.out.print("| ");
                for (int l = 0; l < cofactorMatrix[k].length; l++) {
                    System.out.printf("%d ", cofactorMatrix[l][k]);
                }
                System.out.print("|");
                System.out.println();
            }
        }  else {
            for (int i = 1; i >= 0; i--) {
                for (int j = 1; j >= 0; j--) {
                    if ((i == 1 && j == 0) || (i == 0 && j == 1)) {
                        cofactorMatrix[j][i] = -1 * matriks[j][i];
                    } else {
                        cofactorMatrix[j][i] = matriks[j][i];
                    }
                }
            }
            for (int i = 1; i >= 0; i--) {
                System.out.print("| ");
                for (int j = 1; j >= 0; j--) {
                    System.out.printf("%d ", cofactorMatrix[j][i]);
                }
                System.out.print("|");
                System.out.println();
            }
        }
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
            if (menu == 1 || menu == 2 || menu == 5) {
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
                    System.out.println("Baris matriks 2 dan kolom matriks 1 harus sama!");
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
                    System.out.print("1. 2x2\n2. 3x3\nmenu: ");
                    int menuInvers = sc.nextInt();
                    switch (menuInvers) {
                        case 1:
                        menuInvers = 2;
                            break;
                        case 2:
                        menuInvers = 3;
                            break;
                        default:
                        System.out.println("Input invalid");
                            continue;
                    }
                    int[][] matriks = new int[menuInvers][menuInvers];
                    inversMatriks(matriks);
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