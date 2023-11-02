package ProgramTipeDataBoolean;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Pajak {
    private static final double TAX_RATE = 0.1; // Persentase pajak 10%
    private static final String CURRENCY_FORMAT = "###,###,###.00";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulangi;

        do {
            System.out.println("=== Kalkulator Pajak ===");

            // Meminta pengguna untuk memasukkan pendapatan tahunan dan batas pendapatan untuk pajak
            double pendapatanTahunan = getInputDouble("Masukkan Pendapatan Tahunan\t\t: Rp.");
            double batasPendapatan = getInputDouble("Masukkan Batas Pendapatan untuk Pajak\t: Rp.");
            double pajakTahunan = calculateTax(pendapatanTahunan, batasPendapatan);

            System.out.println("=======================================");

            // Menampilkan pendapatan tahunan, batas pendapatan, dan hasil perhitungan pajak
            System.out.printf("Pendapatan Tahunan\t\t: %s%n", formatCurrency(pendapatanTahunan));
            System.out.printf("Batas Pendapatan untuk Pajak\t: %s%n", formatCurrency(batasPendapatan));
            System.out.println("=======================================");

            // Menampilkan menu pilihan jenis pajak
            System.out.println("Pilih Jenis Pajak:");
            System.out.println("1. Pajak Mobil");
            System.out.println("2. Pajak Motor");
            System.out.print("Masukkan nomor jenis pajak yang ingin dihitung: ");
            int jenisPajak = input.nextInt();

            if (jenisPajak == 1) {
                System.out.println("Anda memilih Pajak Mobil.");
            } else if (jenisPajak == 2) {
                System.out.println("Anda memilih Pajak Motor.");
            } else {
                System.out.println("Jenis pajak tidak valid.");
            }

            // Menampilkan jumlah pajak sesuai dengan jenis pajak yang dipilih
            System.out.printf("Anda harus membayar pajak sebesar: %s%n", formatCurrency(pajakTahunan));

            ulangi = getYesNoInput("Hitung pajak anda lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
        System.out.println("Terima kasih telah menggunakan kalkulator pajak!");
    }

    // Fungsi untuk meminta input angka desimal dari pengguna
    private static double getInputDouble(String message) {
        double value = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(message);
                value = input.nextDouble();
                if (value < 0) {
                    System.out.println("Input tidak valid. Harus lebih dari atau sama dengan nol.");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Masukkan angka desimal yang benar.");
                input.nextLine(); // Membersihkan input yang tidak valid.
            }
        }
    }

    // Fungsi untuk menghitung jumlah pajak berdasarkan pendapatan dan batas pendapatan yang diberikan
    private static double calculateTax(double pendapatanTahunan, double batasPendapatan) {
        double pajak = 0;
        if (pendapatanTahunan > batasPendapatan) {
            pajak = pendapatanTahunan * TAX_RATE;
        }
        return pajak;
    }

    // Fungsi untuk memformat angka menjadi format mata uang
    private static String formatCurrency(double amount) {
        NumberFormat currencyFormatter = NumberFormat.getNumberInstance(Locale.US);
        return currencyFormatter.format(amount);
    }

    // Fungsi untuk meminta input 'Y' atau 'N' dari pengguna
    private static char getYesNoInput(String message) {
        char response;
        Scanner input = new Scanner(System.in);

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
