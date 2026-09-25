/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartlibrary;

/**
 *
 * @author R3-KD020
 */
public class BukuCetak extends Koleksi {
    private int jumlahHalaman;
    
    public BukuCetak(String judul, String pengarang, int tahunTerbit, int jumlahHalaman){
        super(judul, pengarang, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        
    }
    
    @Override
    public void tampilkanInfo(){
        System.out.printf("[Buku Cetak] Judul: %15s | Pengarang: %10s | Tahun: %d | Ukuran: %d MB%n",
                this.judul, this.pengarang, this.tahunTerbit, this.jumlahHalaman);
    }
    @Override
    public void cariPinjam(){
        System.out.println("--> Info Pinjam: Buku cetak wajib diambil fisik bukunya di meja administrasi perpustakaan");
    }
    
}
