/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARKINGSYSTEMUNSIKA;

/**
 *
 * @author salsa
 */
public class Kendaraan {
    private String noPolisi;
    private String noTiket;
    private String jenisKendaraan;
    private String jamMasuk;
    private String jamKeluar;

    // Constructor
    public Kendaraan(String noPolisi, String noTiket, String jenisKendaraan, String jamMasuk) {
        this.noPolisi = noPolisi;
        this.noTiket = noTiket;
        this.jenisKendaraan = jenisKendaraan;
        this.jamMasuk = jamMasuk;
    }

    // Getter dan Setter
    public String getNoPolisi() {
        return noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    public String getNoTiket() {
        return noTiket;
    }

    public void setNoTiket(String noTiket) {
        this.noTiket = noTiket;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public String getJamKeluar() {
        return jamKeluar;
    }

    public void setJamKeluar(String jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    @Override
    public String toString() {
        return "Kendaraan{" +
                "noPolisi='" + noPolisi + '\'' +
                ", noTiket='" + noTiket + '\'' +
                ", jenisKendaraan='" + jenisKendaraan + '\'' +
                ", jamMasuk='" + jamMasuk + '\'' +
                ", jamKeluar='" + jamKeluar + '\'' +
                '}';
    }
}
