package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gedascc
 */
public class ProdukMakeup {
    private String nama;
    private String merek;
    private int bulanBuka;
    private int tahunBuka;
    private int masaPaoBulan;
    
    public ProdukMakeup(String nama, String merek, int bulanBuka, int tahunBuka, int masaPaoBulan) {
        this.nama = nama;
        this.merek = merek;
        this.bulanBuka = bulanBuka;
        this.tahunBuka = tahunBuka;
        this.masaPaoBulan = masaPaoBulan;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getMerek() {
        return merek;
    }
    
    public boolean isExpired(int bulanSekarang, int tahunSekarang) {
        int totalBulanPakai = (tahunSekarang - tahunBuka) * 12 + (bulanSekarang - bulanBuka);
        return totalBulanPakai > masaPaoBulan;
    }
    
    public void infoProduk() {
        System.out.println("Nama Produk : " + nama);
        System.out.println("Merek       : " + merek);
        System.out.println("Tgl Dibuka  : Bulan " + bulanBuka + "/" + tahunBuka);
        System.out.println("Masa PAO    : " + masaPaoBulan + " Bulan");
    }
}
