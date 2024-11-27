/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARKINGSYSTEMUNSIKA;

/**
 *
 * @author salsa
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class LoadData {
    public static void loadDataToTable(javax.swing.JTable table) {
        Connection conn = DBConnection.getConnection();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Bersihkan tabel sebelum menambahkan data

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM parkir"; 
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Ambil data dari setiap kolom tabel
                String col1 = rs.getString("NPM"); // Kolom "NPM"
                String col2 = rs.getString("Nama"); // Kolom "Nama"
                String col3 = rs.getString("No_Polisi"); // Kolom "No_Polisi"
                String col4 = rs.getString("No_Tiket"); // Kolom "No_Tiket"
                String col5 = rs.getString("jenis_kendaraan"); // Kolom "jenis_kendaraan"
                String col6 = rs.getString("jam_masuk"); // Kolom "jam_masuk"
                String col7 = rs.getString("jam_keluar"); // Kolom "jam_masuk"
                String col8 = rs.getString("durasi"); // Kolom "jam_masuk"
                String col9 = rs.getString("total_biaya"); // Kolom "jam_masuk"
                
                // Tambahkan data ke tabel
                model.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9});
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Gagal memuat data dari database!");
        }
    }
}
