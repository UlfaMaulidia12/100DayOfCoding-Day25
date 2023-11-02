package ProgramUnderscore;

import java.util.Scanner;

public class CalculatorProgram {
    public static void main(String[] args) {
        char ulangi;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("=== Calculator Program ===");

            // Meminta pengguna untuk memasukkan dua angka
            double angka1 = getInput(input, "Masukkan angka pertama\t: ");
            double angka2 = getInput(input, "Masukkan angka kedua\t: ");

            System.out.println("Pilihan operasi matematika:");
            System.out.println("1. Penjumlahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.print("Pilih operasi (1/2/3/4)\t: ");
            int pilihan = getOperationChoice(input);

            if (pilihan == 1) {
                double hasil = angka1 + angka2;
                System.out.println("Hasil penjumlahan\t: " + hasil);
            } else if (pilihan == 2) {
                double hasil = angka1 - angka2;
                System.out.println("Hasil pengurangan\t: " + hasil);
            } else if (pilihan == 3) {
                double hasil = angka1 * angka2;
                System.out.println("Hasil perkalian\t\t: " + hasil);
            } else if (pilihan == 4) {
                if (angka2 == 0) {
                    System.out.println("Tidak bisa membagi dengan nol.");
                } else {
                    double hasil = angka1 / angka2;
                    System.out.println("Hasil pembagian\t\t: " + hasil);
                }
            } else {
                System.out.println("Operasi tidak valid. Silakan pilih 1, 2, 3, atau 4.");
            }

            ulangi = getYesNoInput(input, "Ingin melakukan perhitungan lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
        System.out.println("Terima kasih!");
    }

    // Fungsi untuk meminta input angka dari pengguna
    private static double getInput(Scanner input, String message) {
        double angka = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(message);
                angka = input.nextDouble();
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
                input.nextLine(); // Bersihkan buffer input
            }
        }

        return angka;
    }

    // Fungsi untuk meminta pengguna memilih operasi matematika
    private static int getOperationChoice(Scanner input) {
        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            choice = input.nextInt();
            if (choice >= 1 && choice <= 4) {
                validChoice = true;
            } else {
                System.out.println("Pilihan operasi tidak valid. Silakan pilih 1, 2, 3, atau 4.");
            }
        }

        return choice;
    }

    // Fungsi untuk meminta input 'Y' atau 'N' dari pengguna
    private static char getYesNoInput(Scanner input, String message) {
        char response;

        while (true) {
            System.out.print(message);
            response = input.next().charAt(0);
            if (response == 'Y' || response == 'y' || response == 'N' || response == 'n') {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Masukkan 'Y' atau 'N'.");
            }
        }

        return response;
    }
}
