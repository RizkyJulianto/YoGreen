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
public class PickupRequestDAO {

    public ResultSet getAllPickup() {
        try {
            Connection conn = Koneksi.getConnection();
            String sql
                    = "SELECT pr.id_request, u.nama AS nama_user, pr.jenis_sampah, pr.alamat_pickup, pr.status, p.nama AS nama_petugas "
                    + "FROM pickup_request pr "
                    + "JOIN `user` u ON pr.id_user = u.id_user "
                    + "LEFT JOIN `user` p ON pr.id_petugas = p.id_user "
                    + "ORDER BY pr.tanggal_request DESC";

            Statement st = conn.createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getPickupRequestByUser(int idUser) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql
                    = "SELECT pr.id_request, u.nama AS nama_user, pr.jenis_sampah,pr.estimasi_berat, pr.alamat_pickup, pr.status, p.nama AS nama_petugas "
                    + "FROM pickup_request pr "
                    + "JOIN `user` u ON pr.id_user = u.id_user "
                    + "LEFT JOIN `user` p ON pr.id_petugas = p.id_user "
                    + "WHERE pr.id_user = ? "
                    + "ORDER BY pr.tanggal_request DESC";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);

            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertPickupRequest(int idUser, String jenisSampah,
            double estimasiBerat, String alamat) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "INSERT INTO pickup_request "
                    + "(id_user, jenis_sampah, estimasi_berat, alamat_pickup, status) "
                    + "VALUES (?, ?, ?, ?, 'menunggu')";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ps.setString(2, jenisSampah);
            ps.setDouble(3, estimasiBerat);
            ps.setString(4, alamat);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean tugaskanPickup(int idRequest, int idPetugas) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "UPDATE pickup_request "
                    + "SET id_petugas = ?, "
                    + "tanggal_penugasan = NOW() "
                    + "WHERE id_request = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPetugas);
            ps.setInt(2, idRequest);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deletePickup(int idRequest) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "DELETE FROM pickup_request WHERE id_request = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idRequest);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStatusPickup(int idRequest, String status) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "UPDATE pickup_request SET status = ? WHERE id_request = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, idRequest);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getPickupByPetugas(int idPetugas) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql
                    = "SELECT pr.id_request, u.id_user, u.nama, u.poin, "
                    + "pr.jenis_sampah, pr.alamat_pickup, pr.status "
                    + "FROM pickup_request pr "
                    + "JOIN user u ON pr.id_user = u.id_user "
                    + "WHERE pr.id_petugas = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPetugas);
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean prosesPickup(int idRequest, int idUser, double beratFinal, String status) {
        try {
            Connection conn = Koneksi.getConnection();
            conn.setAutoCommit(false);

            int poinTambahan = (int) (beratFinal * 10);

            String sqlPickup
                    = "UPDATE pickup_request SET berat_final=?, status=? WHERE id_request=?";
            PreparedStatement ps1 = conn.prepareStatement(sqlPickup);
            ps1.setDouble(1, beratFinal);
            ps1.setString(2, status);
            ps1.setInt(3, idRequest);
            ps1.executeUpdate();

            String sqlUser
                    = "UPDATE user SET poin = poin + ? WHERE id_user=?";
            PreparedStatement ps2 = conn.prepareStatement(sqlUser);
            ps2.setInt(1, poinTambahan);
            ps2.setInt(2, idUser);
            ps2.executeUpdate();

            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePickupRequest( int idRequest,String jenisSampah,double estimasiBerat,String alamat) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE pickup_request SET "
                    + "jenis_sampah = ?, "
                    + "estimasi_berat = ?, "
                    + "alamat_pickup = ? "
                    + "WHERE id_request = ? AND status = 'menunggu'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jenisSampah);
            ps.setDouble(2, estimasiBerat);
            ps.setString(3, alamat);
            ps.setInt(4, idRequest);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
