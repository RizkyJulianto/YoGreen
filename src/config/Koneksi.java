/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HYPE AMD
 */
public class Koneksi {
      private static Connection conn;

    public static Connection getConnection() {

        if (conn == null) {
            try {

                String url = "jdbc:mysql://localhost:3306/yogreen";
                String user = "root";
                String password = "";

                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi berhasil");
            } catch (Exception e) {
                System.out.println("Koneksi gagal " + e.getMessage());
            }
        }
        
        return conn;
    }
}
