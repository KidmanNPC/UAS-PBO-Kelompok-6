/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARKINGSYSTEMUNSIKA;

/**
 *
 * @author salsa
 */

public class ParkingData {
    // Data kendaraan
    private String npm;
    private String nama;
    private String noPolisi;
    private String noTiket;
    private String jenisKendaraan;
    private String jamMasuk;
    private String jamKeluar;


    // Constructor untuk data kendaraan
    public ParkingData(String npm, String nama, String noPolisi, String noTiket, String jenisKendaraan, String jamMasuk) {
        this.npm = npm;
        this.nama = nama;
        this.noPolisi = noPolisi;
        this.noTiket = noTiket;
        this.jenisKendaraan = jenisKendaraan;
        this.jamMasuk = jamMasuk;
    }

    // Getter dan Setter untuk atribut data kendaraan
    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

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

    // toString untuk debugging
    @Override
    public String toString() {
        return "ParkingData{" +
                "npm='" + npm + '\'' +
                ", nama='" + nama + '\'' +
                ", noPolisi='" + noPolisi + '\'' +
                ", noTiket='" + noTiket + '\'' +
                ", jenisKendaraan='" + jenisKendaraan + '\'' +
                ", jamMasuk='" + jamMasuk + '\'' +
                ", jamKeluar='" + jamKeluar + '\'' +
                '}';
    }
}


