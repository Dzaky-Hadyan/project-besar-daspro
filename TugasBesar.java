import java.util.Scanner;

public class TugasBesar {

    static int MAX_MAHASISWA = 100;
    static String[] nimMahasiswa = new String[MAX_MAHASISWA];
    static String[] namaMahasiswa = new String[MAX_MAHASISWA];
    static String[][] kodeMatkul = new String[MAX_MAHASISWA][10];
    static String[][] namaMatkul = new String[MAX_MAHASISWA][10];
    static int[][] sksMatkul = new int[MAX_MAHASISWA][10];
    static int[] totalSks = new int[MAX_MAHASISWA];
    static int[] jumlahMatkulPerMahasiswa = new int[MAX_MAHASISWA];
    static int jumlahMahasiswa = 0, jumlahMahasiswaSKSKurangdari20 = 0;

    static void tambahData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();

        nimMahasiswa[jumlahMahasiswa] = nim;
        namaMahasiswa[jumlahMahasiswa] = nama;

        int jumlahMatkul = 0;
        while (true) {
            System.out.print("Kode Mata Kuliah: ");
            String kode = sc.nextLine();
            System.out.print("Nama Mata Kuliah: ");
            String namaMk = sc.nextLine();
            System.out.print("Jumlah SKS (1-3): ");
            int sks = sc.nextInt();
            sc.nextLine();
            if (sks > 3) {
                System.out.println("Jumlah SKS tidak valid! SKS harus antara 1 dan 3.");
                continue;
            } else {
            kodeMatkul[jumlahMahasiswa][jumlahMatkul] = kode;
            namaMatkul[jumlahMahasiswa][jumlahMatkul] = namaMk;
            sksMatkul[jumlahMahasiswa][jumlahMatkul] = sks;
            totalSks[jumlahMahasiswa] += sks;

            System.out.println("Data mata kuliah berhasil ditambahkan.");
            System.out.print("Tambah mata kuliah lain? (y/t): ");
            String lanjut = sc.nextLine();
            if (lanjut.equalsIgnoreCase("t")) break;

            jumlahMatkul++;
            }
        }
        jumlahMatkulPerMahasiswa[jumlahMahasiswa] = jumlahMatkul + 1;
        jumlahMahasiswa++;
    }

    static void tampilData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.nextLine();

        System.out.println("Daftar KRS: ");
        System.out.printf("%-15s %-25s %-20s %-20s %-25s%n", "NIM", "Nama", "Kode MK", "Nama Mata Kuliah", "SKS");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (nimMahasiswa[i].equals(nim)) {
                for (int j = 0; j < jumlahMatkulPerMahasiswa[i]; j++) {
                    System.out.printf("%-15s %-25s %-20s %-20s %-25s%n", nimMahasiswa[i], namaMahasiswa[i], kodeMatkul[i][j], namaMatkul[i][j], sksMatkul[i][j]);
                }
                if (totalSks[i] < 20) {
                    jumlahMahasiswaSKSKurangdari20++;
                }
                System.out.printf("Total SKS: %d\n", totalSks[i]);
            }
        }
    }
    static void analisisData() {
        boolean[] sudahDihitung = new boolean[jumlahMahasiswa];
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (!sudahDihitung[i]) {
                int totalSKSperMahasiswa = 0;
                String nim = nimMahasiswa[i];
                for (int j = 0; j < jumlahMahasiswa; j++) {
                    if (nimMahasiswa[j].equals(nim)) {
                        totalSKSperMahasiswa += totalSks[j];
                        sudahDihitung[j] = true;
                    }
                }
                if (totalSKSperMahasiswa < 20) {
                    jumlahMahasiswaSKSKurangdari20++;
                }
            }
        }
        /* emu 5, nene 3, rui 2
         * 
         * 
         */
        System.out.println("--- Analisis Data KRS ---");
        System.out.printf("Jumlah mahasiswa yang mengambil SKS kurang dari 20: %d\n", jumlahMahasiswaSKSKurangdari20);
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
            sc.nextLine();
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
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (menu != 4);
        sc.close();
    }
}