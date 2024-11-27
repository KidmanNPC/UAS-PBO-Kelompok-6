/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARKINGSYSTEMUNSIKA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Pastikan driver sesuai database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_parkir", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
