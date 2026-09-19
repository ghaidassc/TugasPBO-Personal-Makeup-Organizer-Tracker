package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import model.ProdukMakeup;
import model.MakeupCair;
import model.MakeupPadat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gedascc
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ProdukMakeup> koleksi = new ArrayList<>();
        
        koleksi.add(new MakeupCair("Fit Me Matte Foundation", "Maybelline", 1, 2025, 12, "Pump"));
        
        koleksi.add(new MakeupPadat("Colorfit Velvet Powder", "Wardah", 5, 2025, 24, "Matte Powder"));
        
        koleksi.add(new MakeupCair("Lash Sensational Mascara", "Maybelline", 1, 2024, 6, "Silicone Wand"));
        
        boolean jalan = true;
        
        while (jalan) {
            System.out.println("\n==========================================");
            System.out.println("   PERSONAL MAKEUP ORGANIZER & TRACKER    ");
            System.out.println("==========================================");
            System.out.println("1. Tambah Produk Makeup Baru");
            System.out.println("2. Lihat Semua Koleksi Meja Rias");
            System.out.println("3. Cek Produk Kedaluwarsa");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            int menu = input.nextInt();
            input.nextLine();
            
            switch (menu) {
                case 1:
                    System.out.println("\n--- Pilih Jenis Produk ---");
                    System.out.println("1. Makeup Cair (Foundation, Mascara, Lip Tint)");
                    System.out.println("2. Makeup Padat (Compact Powder, Eyeshadow)");
                    System.out.print("Pilihan (1/2): ");
                    int tipe = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama Produk         : ");
                    String nama = input.nextLine();
                    System.out.print("Merek               : ");
                    String merek = input.nextLine();
                    System.out.print("Bulan Pertama Buka (1-12) : ");
                    int bln = input.nextInt();
                    System.out.print("Tahun Pertama Buka        : ");
                    int thn = input.nextInt();
                    System.out.print("Masa PAO (dalam Bulan)    : ");
                    int pao = input.nextInt();
                    input.nextLine();
                    
                    if (tipe == 1) {
                        System.out.print("Jenis Aplikator (Pump/Doe-foot/Pipet): ");
                        String aplikator = input.nextLine();
                        koleksi.add(new MakeupCair(nama, merek, bln, thn, pao, aplikator));
                    } else {
                        System.out.print("Tekstur (Matte/Shimmer/Baked): ");
                        String tekstur = input.nextLine();
                        koleksi.add(new MakeupPadat(nama, merek, bln, thn, pao, tekstur));
                    }
                    System.out.println("-> Produk berhasil ditambahkan!");
                    break;
                    
                    case 2:
                    System.out.println("\n--- DAFTAR KOLEKSI MAKEUP ---");
                    if (koleksi.isEmpty()) {
                        System.out.println("Belum ada produk di meja rias.");
                    } else {
                        for (int i = 0; i < koleksi.size(); i++) {
                            System.out.println("\n[Produk #" + (i + 1) + "]");
                            koleksi.get(i).infoProduk();
                        }
                    }
                    break;
                    
                    case 3:
                    System.out.println("\n--- CEK KEDALUWARSA PRODUK ---");
                    if (koleksi.isEmpty()) {
                        System.out.println("Koleksi masih kosong.");
                        break;
                    }
                    System.out.print("Masukkan Bulan Saat Ini (1-12): ");
                    int blnNow = input.nextInt();
                    System.out.print("Masukkan Tahun Saat Ini       : ");
                    int thnNow = input.nextInt();

                    System.out.println("\nStatus Produk:");
                    int kedaluwarsa = 0;
                    for (ProdukMakeup p : koleksi) {
                        if (p.isExpired(blnNow, thnNow)) {
                            System.out.println("[BUANG] " + p.getNama() + " (" + p.getMerek() + ") sudah lewat masa PAO!");
                            kedaluwarsa++;
                        } else {
                            System.out.println("[AMAN] " + p.getNama() + " (" + p.getMerek() + ") masih layak pakai.");
                        }
                    }
                    if (kedaluwarsa == 0) {
                        System.out.println("Semua koleksi masih aman digunakan.");
                    }
                    break;
                    
                    case 4:
                    jalan = false;
                    System.out.println("Program selesai. Sampai jumpa!");
                    break;
                    
                    default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        input.close();
    }
}
