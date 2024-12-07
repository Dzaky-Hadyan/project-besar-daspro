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
        if (matriks.length == 3) {
            int[][] cofactorMatrix = new int[3][3];
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
        }
    }
    static void transposeMatriks(int matriks[][]) {
        int baris = matriks.length;
        int kolom = matriks[0].length;
    
        System.out.println("Hasil Transpose Matriks:");
        for (int j = 0; j < kolom; j++) {
            for (int i = 0; i < baris; i++) {
                System.out.print(matriks[i][j] + " "); 
            }
            System.out.println();
        }
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
            if (menu == 1 || menu == 2) {
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
            }  else if (menu == 5) {
                // Input matriks untuk transpose
                System.out.print("Masukkan jumlah baris matriks: ");
                baris = sc.nextInt();
                System.out.print("Masukkan jumlah kolom matriks: ");
                kolom = sc.nextInt();
                
                int matriks[][] = new int[baris][kolom];
                
                // Input elemen matriks
                System.out.println("Masukkan elemen matriks:");
                for (int i = 0; i < baris; i++) {
                    for (int j = 0; j < kolom; j++) {
                        System.out.printf("Baris %d Kolom %d: ", i + 1, j + 1);
                        matriks[i][j] = sc.nextInt();
                    }
                }
                
                transposeMatriks(matriks); // Panggil fungsi transpose
            } 
            else {
                switch (menu) {
                    case 4:
                    System.out.println("1. 2x2\n2. 3x3");
                    int menuInvers = sc.nextInt();
                    int[][] matriks = new int[menuInvers][menuInvers];
                    switch (menuInvers) {
                        case 1:
                        menuInvers = 2;
                            break;
                        case 2:
                        menuInvers = 3;
                        default:
                        System.out.println("Input invalid");
                            break;
                    }
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