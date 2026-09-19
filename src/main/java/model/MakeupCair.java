package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gedascc
 */
public class MakeupCair extends ProdukMakeup {
    private String aplikator;
    
    public MakeupCair(String nama, String merek, int bulanBuka, int tahunBuka, int masaPaoBulan, String aplikator) {
        super(nama, merek, bulanBuka, tahunBuka, masaPaoBulan);
        this.aplikator = aplikator;
    }
    
    @Override
    public void infoProduk() {
        super.infoProduk();
        System.out.println("Bentuk/Tipe : Cair (Liquid)");
        System.out.println("Aplikator   : " + aplikator);
    }
}
