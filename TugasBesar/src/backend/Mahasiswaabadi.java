package backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Mahasiswaabadi extends Mahasiswa{

    public Mahasiswaabadi() {
    }

    public Mahasiswaabadi(int nim, String nama, String jenisKelamin, String tanggal, String keterangan, String jurusan) {
        super(nim, nama, jenisKelamin, tanggal, keterangan, jurusan);
    }
    public void Berjalan(){
        System.out.println("Berjalannya lihai");
    }
    
}
