/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HYPE AMD
 */
public class PickupRequest {
    private int idRequest;
    private int idUser;
    private String jenisSampah;
    private double estimasiBerat;
    private String alamatPickup;
    private String status;
    private Integer idPetugas; // boleh null
    private String tanggalRequest;
    private String tanggalPenugasan;
    private Double beratFinal;
    private int poin;
    private String catatan;

    public PickupRequest() {
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(String jenisSampah) {
        this.jenisSampah = jenisSampah;
    }

    public double getEstimasiBerat() {
        return estimasiBerat;
    }

    public void setEstimasiBerat(double estimasiBerat) {
        this.estimasiBerat = estimasiBerat;
    }

    public String getAlamatPickup() {
        return alamatPickup;
    }

    public void setAlamatPickup(String alamatPickup) {
        this.alamatPickup = alamatPickup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(Integer idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getTanggalRequest() {
        return tanggalRequest;
    }

    public void setTanggalRequest(String tanggalRequest) {
        this.tanggalRequest = tanggalRequest;
    }

    public String getTanggalPenugasan() {
        return tanggalPenugasan;
    }

    public void setTanggalPenugasan(String tanggalPenugasan) {
        this.tanggalPenugasan = tanggalPenugasan;
    }

    public Double getBeratFinal() {
        return beratFinal;
    }

    public void setBeratFinal(Double beratFinal) {
        this.beratFinal = beratFinal;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    
}
