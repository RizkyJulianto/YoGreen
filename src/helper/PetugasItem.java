/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author HYPE AMD
 */
public class PetugasItem {
    private int id;
    private String nama;

    public PetugasItem(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nama;
    }

    
}
