  

package backend;

import java.util.ArrayList;
import java.sql.*;
import backend.*;

/**
 *
 * @author PC
 */
public class Mahasiswa  {
    private int nim;
    private String nama;
    private String jenisKelamin;
    private String tanggal;
    private String keterangan;
    private String jurusan;
    private MataKuliah matkul = new MataKuliah();
    private IPK ipk = new IPK();

    public MataKuliah getMatkul() {
        return matkul;
    }

    public void setMatkul(MataKuliah matkul) {
        this.matkul = matkul;
    }
    
    public void setNim(int nim) {
        this.nim = nim;
    }

    public int getNim() {
        return nim;
    }
    
       
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }   
    

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }
    

    
    public Mahasiswa() {
    }

    public Mahasiswa(int Nim,String nama, String jenisKelamin, String tanggal, String keterangan, String jurusan) {
        this.nim = Nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.jurusan = jurusan;
    }

    
    
    
    public Mahasiswa getById(int nim) {
        Mahasiswa m = new Mahasiswa();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM mahasiswa " + " WHERE nim = '" + nim + "'");

        try {
            while (rs.next()) {
                m = new Mahasiswa();
                m.setNim(rs.getInt("nim"));
                m.setNama(rs.getString("nama"));
                m.setJenisKelamin("jeniskelamin");
                m.setTanggal(rs.getString("tanggal"));
                m.setKeterangan(rs.getString("keterangan"));
                m.setJurusan(rs.getString("jurusan"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public ArrayList<Mahasiswa> getAll() {
        ArrayList<Mahasiswa> ListMahasiswa = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM mahasiswa");

        try {
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa();
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
    
    public void save(){
        if(getById(nim).getNim() == 0){
            String SQL = "Insert into mahasiswa (nama,jeniskelamin,tanggal,keterangan,jurusan) values(" 
                    + " '" +this.nama + "', "
                    + " '" +this.jenisKelamin + "' " 
                    + " '" +this.tanggal + "', "
                    + " '" +this.keterangan + "', "
                    + " '"+this.jurusan+"' "
                    + " )";
                    this.nim = DBHelper.insertQueryGetId(SQL);
                    System.out.println(this.nama+this.jenisKelamin+this.tanggal+this.keterangan+this.jurusan+"nim"+this.nim);
        }else{
            String SQL = "Update mahasiswa set"
                   + " nama = '" +this.nama +"', "
                   + " jeniskelamin = '" +this.jenisKelamin + "' " 
                   + " alamat = '" +this.tanggal +"', "
                   + " keterangan = '" +this.keterangan + "', "
                   + " jurusan= '"+this.jurusan+"' "
                   +"Where nim = '"+this.nim+"'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM mahasiswa WHERE nim = '"+this.nim+"'";
        DBHelper.executeQuery(SQL);
    }
}
