public class siswa {
    private String nama;
    private Double nilai;
    private String grade;
    private String status;

    public siswa(String nama) {
        this.nama = nama;
    }
    //SETTER & GETTER NAMA
    public String getNama() {
      return nama;
    }
    public void setNama(String  nama) {
      this.nama = nama;
    }
    //SETTER & GETTER NILAI
    public Double getNilai() {
      return nilai;
    }
    public void setNilai(Double nilai) {
      this.nilai = nilai;
    }
    //SETTER & GETTER GRADE
    public String getGrade() {
      return grade;
    }
    public void setGrade(String grade) {
      this.grade = grade;
    }

    //SETTER & GETTER STATUS
    public String getStatus() {
      return status;
    }
    public void setStatus(String status) {
      this.status = status;
    }

    public String tentukanGrade() {
        if (nilai >= 90) {
            return "A";
        } else if (nilai >= 80) {
            return "B";
        } else if (nilai >= 70) {
            return "C";
        } else if (nilai >= 60) {
            return "D";
        } else {
            return "E";
        }
    }

    public void prosesNilai() {
      this.grade = tentukanGrade();
      this.status = tentukanStatus();
    }
    
    public String tentukanStatus() {
        if (nilai >= 85) {
            return "Lulus";
        } else {
            return "Gagal";
        }
    }

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
      return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    } 
}