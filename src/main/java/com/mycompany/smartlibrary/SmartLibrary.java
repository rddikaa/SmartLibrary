package com.mycompany.smartlibrary;

import java.util.Scanner;

public class SmartLibrary {

    public static void cariKoleksi(String judul, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari buku dengan Judul: " + judul);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getJudul().equalsIgnoreCase(judul)) { 
                System.out.print("- Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Koleksi tidak ditemukan.");
    }

    // ts

    public static void cariKoleksi(int tahunTerbit, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari buku dengan Tahun Terbit: " + tahunTerbit);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getTahunTerbit() == tahunTerbit) { 
                System.out.print("- Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Koleksi tidak ditemukan.");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Koleksi[] daftarKoleksi = new Koleksi[10];
            
            int jumlahKoleksi = 0;
            boolean isRunning = true;
            
            System.out.println("========================================");
            System.out.println("    SELAMAT DATANG DI SMART LIBRARY!    ");
            System.out.println("========================================");            
            
            while(isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Koleksi");
                System.out.println("2. Lihat Daftar Koleksi");
                System.out.println("3. Cari Koleksi (Fitur Overloading)");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu: 1-4: ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch(pilihan) {
                    case 1 -> {
                        if (jumlahKoleksi < daftarKoleksi.length) {
                            System.out.println("\n-- Pilih Jenis Koleksi --");
                            System.out.println("1. Koleksi Cetak Fisik");
                            System.out.println("2. E-Book Digital");
                            System.out.print("Pilihan (1/2): ");
                            
                            int jenis = scanner.nextInt();
                            scanner.nextLine();
                            
                            System.out.print("Masukkan Judul: ");
                            String judulBaru = scanner.nextLine();
                            
                            System.out.print("Masukkan Pengarang: ");
                            String pengarangBaru = scanner.nextLine();
                            
                            System.out.print("Masukkan Tahun Terbit: ");
                            int tahunBaru = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (jenis == 1) {
                                System.out.print("Masukkan Jumlah Halaman: ");
                                int halaman = scanner.nextInt();
                                scanner.nextLine();
                                daftarKoleksi[jumlahKoleksi] = new BukuCetak(judulBaru, pengarangBaru, tahunBaru, halaman);
                            } else if (jenis == 2) {
                                System.out.print("Masukkan Ukuran File (MB): ");
                                int ukuran = scanner.nextInt();
                                scanner.nextLine();
                                daftarKoleksi[jumlahKoleksi] = new EBook(judulBaru, pengarangBaru, tahunBaru, ukuran);
                            }
                            
                            jumlahKoleksi++;
                            System.out.println("Sukses! Koleksi berhasil ditambahkan.");
                        } else {
                            System.out.println("Maaf, kapasitas perpustakaan penuh!");
                        }
                        scanner.nextLine();
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi di Perpustakaan ---");
                        if (jumlahKoleksi == 0) {
                            System.out.println("Belum ada koleksi yang tersimpan");
                        } else {
                            for (int i = 0; i < jumlahKoleksi; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarKoleksi[i].tampilkanInfo();
                                daftarKoleksi[i].cariPinjam();
                                System.out.println();
                            }
                            
                            System.out.println("* Total Item Perpustakaan: " + Koleksi.totalKoleksiBerhasilDibuat);
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Koleksi --");
                        System.out.println("1. Cari berdasarkan Judul Teks (String)");
                        System.out.println("2. Cari berdasarkan Tahun (Integer)");
                        System.out.print("Pilih (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (modeCari == 1) {
                            System.out.print("Masukkan Judul: ");
                            String kataKunci = scanner.nextLine();
                            cariKoleksi(kataKunci, daftarKoleksi, jumlahKoleksi);
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan Tahun: ");
                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();
                            cariKoleksi(angkaKunci, daftarKoleksi, jumlahKoleksi);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("Terima kasih telah menggunakan Smart Library!");
                        isRunning = false;
                    }
                    default -> {
                        System.out.println("Pilihan tidak valid. Silahkan masukkan angka 1-4.");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}