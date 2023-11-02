package ProgramTipeDataKarakter;

import java.util.Scanner;

public class Pajak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulangi;
        int percobaan = 0;

        do {
            System.out.println("=== Program Jenis Kelamin ===");

            // Meminta pengguna untuk memasukkan jenis kelamin ('L' untuk Laki-laki atau 'P' untuk Perempuan)
            char jenisKelamin = getGenderInput(input, "Masukkan Jenis Kelamin Anda (L/P)\t: ");

            if (jenisKelamin == 'L') {
                System.out.println("Anda adalah seorang Laki-laki.");
                
            System.out.println("=============================");
                int usia = getAgeInput(input, "Masukkan Usia Anda\t\t: ");
                System.out.println("Usia Anda adalah: " + usia + " tahun.");
            } else if (jenisKelamin == 'P') {
                System.out.println("Anda adalah seorang Perempuan.");
                int usia = getAgeInput(input, "Masukkan Usia Anda\t\t: ");
                System.out.println("Usia Anda adalah\t\t\t " + usia + " tahun.");
            } else {
                System.out.println("Jenis kelamin tidak valid. Silakan masukkan 'L' atau 'P'.");
            }

            ulangi = getYesNoInput(input, "Ingin memasukkan jenis kelamin lagi? (Y/N): ");

            percobaan++;
            if (percobaan >= 3) {
                System.out.println("Anda telah mencoba sebanyak 3 kali. Keluar dari program.");
                break;
            }
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
        System.out.println("Terima kasih telah menggunakan program Jenis Kelamin!");
    }

    // Fungsi untuk meminta input jenis kelamin ('L' atau 'P') dari pengguna
    private static char getGenderInput(Scanner input, String message) {
        char jenisKelamin;
        while (true) {
            System.out.print(message);
            jenisKelamin = input.next().charAt(0);
            if (isValidGender(jenisKelamin)) {
                return jenisKelamin;
            } else {
                System.out.println("Jenis kelamin tidak valid. Silakan masukkan 'L' atau 'P'.");
            }
        }
    }

    // Fungsi untuk memeriksa apakah jenis kelamin yang dimasukkan valid ('L' atau 'P')
    private static boolean isValidGender(char jenisKelamin) {
        return jenisKelamin == 'L' || jenisKelamin == 'P';
    }

    // Fungsi untuk meminta input usia dari pengguna
    private static int getAgeInput(Scanner input, String message) {
        int usia;
        while (true) {
            System.out.print(message);
            if (input.hasNextInt()) {
                usia = input.nextInt();
                if (usia >= 0) {
                    return usia;
                } else {
                    System.out.println("Usia harus lebih besar dari atau sama dengan nol.");
                }
            } else {
                System.out.println("Input tidak valid. Masukkan usia dalam bentuk angka.");
                input.next(); // Membersihkan input yang tidak valid.
            }
        }
    }

    // Fungsi untuk meminta input 'Y' atau 'N' dari pengguna
    private static char getYesNoInput(Scanner input, String message) {
        char response;
        while (true) {
            System.out.print(message);
            response = input.next().charAt(0);
            if (response == 'Y' || response == 'y' || response == 'N' || response == 'n') {
                return response;
            } else {
                System.out.println("Pilihan tidak valid. Masukkan 'Y' atau 'N'.");
            }
        }
    }
}
