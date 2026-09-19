package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gedascc
 */
public class MakeupPadat extends ProdukMakeup {
    private String tekstur;
    
    public MakeupPadat(String nama, String merek, int bulanBuka, int tahunBuka, int masaPaoBulan, String tekstur) {
        super(nama, merek, bulanBuka, tahunBuka, masaPaoBulan);
        this.tekstur = tekstur;
    }
    
    @Override
    public void infoProduk() {
        super.infoProduk();
        System.out.println("Bentuk/Tipe : Padat (Powder)");
        System.out.println("Tekstur     : " + tekstur);
    }
}
