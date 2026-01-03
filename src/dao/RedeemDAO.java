/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HYPE AMD
 */
public class RedeemDAO {

    public ResultSet getAllRedeem() {
        try {
            Connection conn = Koneksi.getConnection();
            String sql
                    = "SELECT r.id_redeem, u.nama AS nama_user, r.reward_text, r.poin_dipakai, r.tanggal_redeem, r.status "
                    + "FROM redeem r "
                    + "JOIN `user` u ON r.id_user = u.id_user "
                    + "ORDER BY r.tanggal_redeem DESC";

            Statement st = conn.createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getRedeemByUser(int idUser) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql
                    = "SELECT id_redeem, reward_text, poin_dipakai, tanggal_redeem, status "
                    + "FROM redeem "
                    + "WHERE id_user = ? "
                    + "ORDER BY tanggal_redeem DESC";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);

            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean tukarPoin(int idUser, String reward, int poin) {
        try {
            Connection conn = Koneksi.getConnection();

            String sqlRedeem = "INSERT INTO redeem (id_user, reward_text, poin_dipakai, tanggal_redeem, status) "
                    + "VALUES (?, ?, ?, NOW(), 'diproses')";
            PreparedStatement ps1 = conn.prepareStatement(sqlRedeem);
            ps1.setInt(1, idUser);
            ps1.setString(2, reward);
            ps1.setInt(3, poin);
            ps1.executeUpdate();

            String sqlUpdate = "UPDATE user SET poin = poin - ? WHERE id_user = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdate);
            ps2.setInt(1, poin);
            ps2.setInt(2, idUser);
            ps2.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStatusRedeem(int idRedeem, String status) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "UPDATE redeem SET status = ? WHERE id_redeem = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, idRedeem);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRedeem(int idRedeem) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "DELETE FROM redeem WHERE id_redeem = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idRedeem);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRedeemUser(int idRedeem, String reward, int poin) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE redeem SET reward_text=?, poin_dipakai=? "
                    + "WHERE id_redeem=? AND status='diproses'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reward);
            ps.setInt(2, poin);
            ps.setInt(3, idRedeem);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
