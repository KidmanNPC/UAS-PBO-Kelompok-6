/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARKINGSYSTEMUNSIKA;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author salsa
 */


public class ParkingDAO {
    private final Connection conn;
    
    public ParkingDAO() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_parkir";
        String user = "root";
        String password = "";
        this.conn = DriverManager.getConnection(url, user, password);
    }
    
    public static void simpanData(String npm, String nama, String noPolisi, String noTiket, String jenisKendaraan, String jamMasuk)
        throws SQLException {
    String query = "INSERT INTO parkir (npm, nama, no_polisi, no_tiket, jenis_kendaraan, jam_masuk) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, npm);
        stmt.setString(2, nama);
        stmt.setString(3, noPolisi);
        stmt.setString(4, noTiket);
        stmt.setString(5, jenisKendaraan);
        stmt.setString(6, jamMasuk);
        stmt.executeUpdate();
        
    }
}

    public ParkingData getParkingDataByTicket(String noTiket) throws SQLException {
        String query = "SELECT * FROM parkir WHERE no_tiket = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, noTiket);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ParkingData(
                        rs.getString("npm"),
                        rs.getString("nama"),
                        rs.getString("no_polisi"),
                        rs.getString("no_tiket"),
                        rs.getString("jenis_kendaraan"),
                        rs.getString("jam_masuk")
                );
            }
        }
        return null;
    }

    public CalculationResult calculateParking(String jamMasuk, String jamKeluar, String jenisKendaraan) {
    try {
        // Format waktu
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Konversi jamMasuk dan jamKeluar ke LocalDateTime
        LocalDateTime masuk = LocalDateTime.parse(jamMasuk, formatter);
        LocalDateTime keluar = LocalDateTime.parse(jamKeluar, formatter);

        // Hitung durasi dalam jam
        long durationMinutes = Duration.between(masuk, keluar).toMinutes();
        long durationHours = (durationMinutes + 59) / 60; // Pembulatan ke atas untuk jam

        // Hitung biaya berdasarkan jenis kendaraan
        int costPerHour = 0;
        if ("motor".equalsIgnoreCase(jenisKendaraan)) {
            costPerHour = 2000;
        } else if ("mobil".equalsIgnoreCase(jenisKendaraan)) {
            costPerHour = 4000;
        }

        int totalCost = (int) (durationHours * costPerHour);

        // Kembalikan hasil perhitungan
        return new CalculationResult(durationHours, totalCost);
    } catch (Exception e) {
        System.err.println("Error saat menghitung biaya parkir: " + e.getMessage());
        return new CalculationResult(0, 0);
    }
}
    
    public void updateParkingData(String noTiket, String jamKeluar, long durationHours, int totalCost) throws SQLException {
    // Query untuk memperbarui data parkir berdasarkan no_tiket
    String query = "UPDATE parkir SET jam_keluar = ?, durasi = ?, total_biaya = ? WHERE no_tiket = ?";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set parameter query
        stmt.setString(1, jamKeluar);             // Waktu keluar
        stmt.setLong(2, durationHours);           // Durasi parkir dalam jam
        stmt.setInt(3, totalCost);                // Total biaya parkir
        stmt.setString(4, noTiket);               // Nomor tiket (sebagai kondisi)

        // Eksekusi query
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Data parkir berhasil diperbarui untuk tiket: " + noTiket);

         // Ambil jenis kendaraan untuk memperbarui statistik
            String jenisKendaraanQuery = "SELECT jenis_kendaraan FROM parkir WHERE no_tiket = ?";
            try (PreparedStatement stmtJenis = conn.prepareStatement(jenisKendaraanQuery)) {
                stmtJenis.setString(1, noTiket);
                ResultSet rs = stmtJenis.executeQuery();
                if (rs.next()) {
                    String jenisKendaraan = rs.getString("jenis_kendaraan");

                }
            }
        } else {
            System.err.println("Gagal memperbarui data parkir. Tiket tidak ditemukan: " + noTiket);
        }
    } catch (SQLException e) {
        System.err.println("Error saat memperbarui data parkir: " + e.getMessage());
        throw e;
    }
}

    
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error saat menutup koneksi: " + e.getMessage());
        }
    }
}


