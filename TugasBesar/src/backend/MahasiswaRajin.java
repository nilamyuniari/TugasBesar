/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class MahasiswaRajin extends Mahasiswa{
    protected String Jalankaki;

    public String getJalankaki() {
        return Jalankaki;
    }

    public void setJalankaki(String Jalankaki) {
        this.Jalankaki = Jalankaki;
    }
    

    public MahasiswaRajin() {
    }

    public MahasiswaRajin(String Jalankaki, int nim, String nama, String jenisKelamin, String tanggal, String keterangan, String jurusan) {
        super(nim, nama, jenisKelamin, tanggal, keterangan, jurusan);
        this.Jalankaki = Jalankaki;
    }
    

   
    
    public void Berjalan(){
        System.out.println("berjalannya tegak");
    }
    
    public ArrayList<Mahasiswa> search(String keyword) {
        ArrayList<Mahasiswa> ListMahasiswa= new ArrayList();

        String sql = "Select * from mahasiswa where " + " nama like '%" + keyword + "%' " + " or keterangan like '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Mahasiswa m  = new Mahasiswa();
                m.setNim(rs.getInt("nim"));
                m.setNama(rs.getString("nama"));
                m.setJenisKelamin("jeniskelamin");
                m.setTanggal(rs.getString("tanggal"));
                m.setKeterangan(rs.getString("keterangan"));
                m.setJurusan(rs.getString("jurusan"));
                

                ListMahasiswa.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListMahasiswa;
    }
}
