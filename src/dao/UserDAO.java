/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Koneksi;
import helper.HashPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;

/**
 *
 * @author HYPE AMD
 */
public class UserDAO {

    public User login(String username, String password) {
        User user = null;

        try {
            Connection conn = Koneksi.getConnection();
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, HashPassword.hash(password));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setAlamat(rs.getString("alamat"));
                user.setNo_hp(rs.getString("no_hp"));
                user.setPoin(rs.getInt("poin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean usernameExist(String username) {
        try {
            Connection conn = Koneksi.getConnection();
            String query = "SELECT id_user FROM user WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean register(User user) {
        try {
            Connection conn = Koneksi.getConnection();
            String query = "INSERT INTO user (nama,username,password,role,poin)"
                    + "VALUES(?,?,?,'user',0)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, HashPassword.hash(user.getPassword()));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getAllUsers() {
        try {
            Connection conn = Koneksi.getConnection();
            String query = "SELECT id_user, nama, username, alamat, no_hp, poin FROM user WHERE role = "
                    + "'user'";

            Statement st = conn.createStatement();
            return st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteUser(int id) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "DELETE FROM user WHERE id_user = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    Petugas
    public boolean insertPetugas(User user) {
        try {
            Connection conn = Koneksi.getConnection();
            String query = "INSERT INTO user (nama,username,password,role,alamat,no_hp)"
                    + "VALUES(?,?,?,'petugas',?,?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, HashPassword.hash(user.getPassword()));
            ps.setString(4, user.getAlamat());
            ps.setString(5, user.getNo_hp());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getAllPetugas() {
        try {
            Connection conn = Koneksi.getConnection();
            String query = "SELECT id_user, nama, username, alamat, no_hp FROM user WHERE role = "
                    + "'petugas'";

            Statement st = conn.createStatement();
            return st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updatePetugas(int id, String nama, String username, String alamat, String nohp) {
        try {
            Connection conn = Koneksi.getConnection();
            String query = "UPDATE user SET nama = ?, username = ?, alamat = ?, no_hp = ? "
                   + "WHERE id_user = ? AND role = 'petugas'";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nama);
            ps.setString(2, username);
            ps.setString(3, alamat);
            ps.setString(4, nohp);
            ps.setInt(5, id);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
