import java.util.Scanner;
public class hmmm2222222 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Harga paket haji
    double hargaReguler = 40000000;
    double hargaPlus = 70000000;
    double hargaVIP = 120000000;

    // Harga tambahan opsional
    double asuransi = 5000000;
    double hotel = 10000000;
    double katering = 7000000;

    // Pilih paket haji
    System.out.println("Pilih paket haji:");
    System.out.println("1. Reguler (Rp 40.000.000)");
    System.out.println("2. Plus (Rp 70.000.000)");
    System.out.println("3. VIP (Rp 120.000.000)");
    System.out.print("Masukkan pilihan Anda (1-3): ");
    int pilihanPaket = scanner.nextInt();

    double hargaPaket = 0;
    if (pilihanPaket == 1) {
        hargaPaket = hargaReguler;
    } else if (pilihanPaket == 2) {
        hargaPaket = hargaPlus;
    } else if (pilihanPaket == 3) {
        hargaPaket = hargaVIP;
    } else {
        System.out.println("Pilihan tidak valid!");
        return; // Keluar jika input tidak valid
    }

    // Pilih tambahan opsional
    System.out.println("\nTambahan opsional yang tersedia:");
    System.out.println("1. Asuransi kesehatan (Rp 5.000.000)");
    System.out.println("2. Hotel dekat Masjidil Haram (Rp 10.000.000)");
    System.out.println("3. Upgrade layanan katering (Rp 7.000.000)");
    System.out.print("Masukkan pilihan tambahan (misalnya 1,2): ");
    scanner.nextLine(); // Tangkap newline dari input sebelumnya
    String tambahan = scanner.nextLine();

    double biayaTambahan = 0;
    if (tambahan.contains("1")) biayaTambahan += asuransi;
    if (tambahan.contains("2")) biayaTambahan += hotel;
    if (tambahan.contains("3")) biayaTambahan += katering;

    // Input usia, uang muka, tahun keberangkatan, dll.
    System.out.print("\nMasukkan usia calon jamaah: ");
    int usia = scanner.nextInt();

    System.out.print("Masukkan uang muka yang telah dibayarkan (Rp): ");
    double uangMuka = scanner.nextDouble();

    System.out.print("Masukkan jumlah tahun hingga keberangkatan: ");
    int tahun = scanner.nextInt();

    System.out.print("Masukkan simpanan awal (Rp): ");
    double simpananAwal = scanner.nextDouble();

    System.out.print("Masukkan tabungan per bulan (Rp): ");
    double tabunganBulanan = scanner.nextDouble();

    // Hitung total biaya
    double totalBiaya = hargaPaket + biayaTambahan;
    double totalBiayaInflasi = totalBiaya * Math.pow(1.05, tahun);

    // Hitung diskon berdasarkan usia
    double diskon = 0;
    if (usia >= 60) {
        diskon = totalBiayaInflasi * 0.10; // Diskon 10% jika usia >= 60
    }

    // Tambahkan diskon untuk uang muka > Rp10.000.000
    if (uangMuka > 10000000) {
        diskon += 2000000; // Diskon tambahan Rp2.000.000
    }

    // Hitung biaya akhir setelah diskon
    double biayaAkhir = totalBiayaInflasi - diskon;

    // Hitung waktu menabung
    double sisaBiaya = biayaAkhir - uangMuka;
    int bulan = 0;
    double saldo = simpananAwal;
    while (saldo < sisaBiaya) {
        saldo += tabunganBulanan;
        bulan++;
    }

    int tahunMenabung = bulan / 12;
    int bulanSisa = bulan % 12;

    // Tampilkan hasil
    System.out.println("\n### Simulasi Biaya Haji ###");
    System.out.printf("Biaya paket: Rp %,.0f%n", hargaPaket);
    System.out.printf("Biaya tambahan: Rp %,.0f%n", biayaTambahan);
    System.out.printf("Total biaya awal: Rp %,.0f%n", totalBiaya);
    System.out.printf("Total biaya setelah inflasi (dalam %d tahun): Rp %,.0f%n", tahun, totalBiayaInflasi);
    System.out.printf("Diskon: Rp %,.0f%n", diskon);
    System.out.printf("Biaya akhir setelah diskon: Rp %,.0f%n", biayaAkhir);

    System.out.println("\n### Simulasi Menabung ###");
    System.out.printf("Simpanan awal: Rp %,.0f%n", simpananAwal);
    System.out.printf("Tabungan bulanan: Rp %,.0f%n", tabunganBulanan);
    System.out.printf("Uang muka: Rp %,.0f%n", uangMuka);
    System.out.printf("Waktu menabung: %d tahun %d bulan%n", tahunMenabung, bulanSisa);

    scanner.close();
}
}
