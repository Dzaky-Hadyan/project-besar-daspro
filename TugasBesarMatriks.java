import java.util.Scanner;

public class TugasBesarMatriks {
    static Scanner sc = new Scanner(System.in);
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
                    hasil[i][j] += matriks1[i][k] * matriks2[k][j];
                }
            }
        }
        /* 12       123
         * 34   x   456
         * 56
         * 
         */
        System.out.println("Hasil perkalian matriks: ");
        for (int i = 0; i < baris1; i++) {
            for (int j = 0; j < kolom2; j++) {
                System.out.print(hasil[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void inversMatriks(float matriks[][]) {
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                System.out.printf("Baris ke-%d Kolom ke-%d: ", i + 1, j + 1);
                matriks[i][j] = sc.nextFloat();
            }
        }
        float[][] cofactorMatrix = new float[matriks.length][matriks.length];
        // Adjoin
        switch (matriks.length) {
            case 3:
            // Minor-Kofaktor
            cofactorMatrix[0][0] = (matriks[1][1] * matriks[2][2]) - (matriks[1][2] * matriks[2][1]);
            cofactorMatrix[0][1] = -1 * ((matriks[1][0] * matriks[2][2]) - (matriks[1][2] * matriks[2][0]));
            cofactorMatrix[0][2] = (matriks[1][0] * matriks[2][1]) - (matriks[1][1] * matriks[2][0]);
            cofactorMatrix[1][0] = -1 * ((matriks[0][1] * matriks[2][2]) - (matriks[0][2] * matriks[2][1]));
            cofactorMatrix[1][1] = (matriks[0][0] * matriks[2][2]) - (matriks[0][2] * matriks[2][0]);
            cofactorMatrix[1][2] = -1 * ((matriks[0][0] * matriks[2][1]) - (matriks[0][1] * matriks[2][0]));
            cofactorMatrix[2][0] = (matriks[0][1] * matriks[1][2]) - (matriks[0][2] * matriks[1][1]);
            cofactorMatrix[2][1] = -1 * ((matriks[0][0] * matriks[1][2]) - (matriks[0][2] * matriks[1][0]));
            cofactorMatrix[2][2] = (matriks[0][0] * matriks[1][1]) - (matriks[0][1] * matriks[1][0]);
            // Transpose
            System.out.println("Adjoint: ");
            for (int k = 0; k < cofactorMatrix.length; k++) {
                System.out.print("| ");
                for (int l = 0; l < cofactorMatrix[k].length; l++) {
                    System.out.printf("%f ", cofactorMatrix[l][k]);
                }
                System.out.print("|");
                System.out.println();
            }
            // Determinan
            float determinanMatrix = 0;
            int j = 2;
            for (int i = 0; i < 3; i++) {
                if (i == 1) {
                    determinanMatrix -= matriks[0][i] * ((matriks[1][j - 2] * matriks[2][j]) - (matriks[1][j] * matriks[2][j - 2]));
                    j--;
                } else {
                    determinanMatrix += matriks[0][i] * ((matriks[1][j - 1] * matriks[2][j]) - (matriks[1][j] * matriks[2][j - 1]));
                    if (i == 2) {
                        j--;
                    }
                }
            }
            System.out.printf("Determinan: %f\n", determinanMatrix);
            if (determinanMatrix == 0) {
                System.out.println("Matriks dengan determinan 0 tidak memiliki invers");
                break;
            }
            System.out.println("Hasil Inverse Matriks:");
            for (int k = 0; k < cofactorMatrix.length; k++) {
                System.out.print("| ");
                for (int l = 0; l < cofactorMatrix[k].length; l++) {
                    System.out.printf("%f ", cofactorMatrix[l][k] / determinanMatrix);
                }
                System.out.print("|");
                System.out.println();
            }
            case 2:
            for (int i = 1; i >= 0; i--) {
                for (int k = 1; k >= 0; k--) {
                    if ((i == 1 && k == 0) || (i == 0 && k == 1)) {
                        cofactorMatrix[k][i] = -1 * matriks[k][i];
                    } else {
                        cofactorMatrix[k][i] = matriks[k][i];
                    }
                }
            }
            float inversMatriks[][] = new float[cofactorMatrix.length][cofactorMatrix.length];
            for (int i = 1; i >= 0; i--) {
                for (int k = 1; k >= 0; k--) {
                    inversMatriks[k][i] = ((1f / ((matriks[0][0] * matriks[1][1]) - (matriks[0][1] * matriks[1][0])))
                            * cofactorMatrix[k][i]);
                }
            }
            if (((matriks[0][0] * matriks[1][1]) - (matriks[0][1] * matriks[1][0])) == 0) {
                System.out.println("Matriks dengan determinan 0 tidak memiliki invers");
                break;
            }
            System.out.println("Hasil Inverse Matriks: ");
            for (int i = 1; i >= 0; i--) {
                System.out.print("| ");
                for (int k = 1; k >= 0; k--) {
                    System.out.printf("%.2f ", inversMatriks[k][i]);
                }
                System.out.print("|");
                System.out.println();
            }
            break;
        }
    }

    static void transposeMatriks(int matriks[][]) {
        int baris = matriks.length;
        int kolom = matriks[0].length;

        System.out.println("Sebelum di transpose");
        for (int j = 0; j < baris; j++) {
            for (int i = 0; i < kolom; i++) {
                System.out.print(matriks[j][i] + " ");
            }
            System.out.println();
        }

        System.out.println("Hasil Transpose Matriks:");
        for (int j = 0; j < kolom; j++) {
            for (int i = 0; i < baris; i++) {
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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

                int matriks1[][] = new int[baris][kolom];
                int matriks2[][] = new int[baris][kolom];

                System.out.println("Masukkan elemen matriks 1: ");
                for (int i = 0; i < baris; i++) {
                    System.out.println("Baris ke-" + (i + 1) + ":");
                    for (int j = 0; j < kolom; j++) {
                        matriks1[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Masukkan elemen matriks 2: ");
                for (int i = 0; i < baris; i++) {
                    System.out.println("Baris ke-" + (i + 1) + ":");
                    for (int j = 0; j < kolom; j++) {
                        matriks2[i][j] = sc.nextInt();
                    }
                }

                switch (menu) {
                    case 1:
                        tambahMatrix(matriks1, matriks2);
                        break;
                    case 2:
                        kurangMatriks(matriks1, matriks2);
                        break;
                }
            } else if (menu == 3) {
                System.out.print("Masukkan jumlah baris matriks 1: ");
                baris1 = sc.nextInt();
                System.out.print("Masukkan jumlah kolom matriks 1: ");
                kolom1 = sc.nextInt();
                System.out.print("Masukkan jumlah baris matriks 2: ");
                baris2 = sc.nextInt();
                if (baris2 != kolom1) {
                    System.out.println("Baris matriks 2 dan kolom matriks 1 harus sama!");
                    continue;
                } else {
                    System.out.print("Masukkan jumlah kolom matriks 2: ");
                    kolom2 = sc.nextInt();
                    
                int matriks1[][] = new int[baris1][kolom1];
                int matriks2[][] = new int[baris2][kolom2];

                System.out.println("Masukkan elemen matriks 1: ");
                for (int i = 0; i < baris1; i++) {
                    System.out.println("Baris ke-" + (i + 1) + ":");
                    for (int j = 0; j < kolom1; j++) {
                        matriks1[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Masukkan elemen matriks 2: ");
                for (int i = 0; i < baris2; i++) {
                    System.out.println("Baris ke-" + (i + 1) + ":");
                    for (int j = 0; j < kolom2; j++) {
                        matriks2[i][j] = sc.nextInt();
                    }
                }
                kaliMatriks(matriks1, matriks2);
            }
            } else if (menu == 5) {
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
                        float[][] matriks = new float[menuInvers][menuInvers];
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