/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARKINGSYSTEMUNSIKA;

/**
 *
 * @author salsa
 */
public class Mobil extends Kendaraan {
    private static final int HARGA_PER_JAM = 4000;

    // Constructor
    public Mobil(String noPolisi, String noTiket, String jamMasuk) {
        super(noPolisi, noTiket, "Mobil", jamMasuk); 
    }

    // Metode untuk menghitung biaya parkir
    public int hitungBiayaParkir(int durasiJam) {
        return HARGA_PER_JAM * durasiJam;
    }

    @Override
    public String toString() {
        return super.toString() + ", Harga Parkir per Jam=" + HARGA_PER_JAM;
    }
}
