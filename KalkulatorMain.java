import java.util.*;
public class KalkulatorMain {

    public static void inputData(Scanner input, int jumlahSiswa, ArrayList<siswa> daftarSiswa) {
      double tugas, uts, uas;
      for (int i = 1; i <= jumlahSiswa; i++) {
        System.out.println("\n===== SISWA " + i + " =====");
        System.out.print("Nama Siswa : ");
        String nama = input.next();

        do {
          System.out.print("Nilai Tugas : ");
          tugas = input.nextDouble();
          System.out.print("Nilai UTS : ");
          uts = input.nextDouble();
          System.out.print("Nilai UAS : ");
          uas = input.nextDouble();
          if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            System.out.println("Nilai harus berada antara 0-100.");
            System.out.println("Tolong masukkan ulang nilai yang benar!");
          }
        } while (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100);
          siswa siswa = new siswa(nama);
          double nilaiAkhir = siswa.hitungNilaiAkhir(tugas, uts, uas);
          siswa.setNilai(nilaiAkhir);
          siswa.prosesNilai();
          daftarSiswa.add(siswa);
        }
      }      

    public static siswa cariSiswa(ArrayList<siswa> daftarSiswa, String nama) {
      for (int i = 0; i < daftarSiswa.size(); i++) {
        siswa siswa = daftarSiswa.get(i);
        if (siswa.getNama().equalsIgnoreCase(nama)) {
          return siswa;
        }
      }
      return null;
    }

    public static void tampilkanDataSiswa(ArrayList<siswa> daftarSiswa) {
    System.out.println("\n===============");
        for (int i = 0; i < daftarSiswa.size(); i++) {
          siswa siswa = daftarSiswa.get(i);
          System.out.println(siswa.getNama() + " | " + siswa.getNilai() + " | " + siswa.getGrade() + " | " + siswa.getStatus());
        }
    }

    public static double hitungRataRata(ArrayList<siswa> daftarSiswa) {
      double totalNilai = 0;
      for (int i = 0; i < daftarSiswa.size(); i++) {
          siswa siswa = daftarSiswa.get(i);
          totalNilai += siswa.getNilai();
        }
      return totalNilai / daftarSiswa.size();
    }

    public static int cariIndexTertinggi(ArrayList<siswa> daftarSiswa) {
      int indexTertinggi = 0;
      for(int i = 0; i < daftarSiswa.size(); i++) {
        if (daftarSiswa.get(i).getNilai() > daftarSiswa.get(indexTertinggi).getNilai()) {
          indexTertinggi = i;
        }
      }
      return indexTertinggi;
    }

    public static int cariIndexTerendah(ArrayList<siswa> daftarSiswa) {
      int indexTerendah = 0;
      for(int i = 0; i < daftarSiswa.size(); i++) {
        if (daftarSiswa.get(i).getNilai() < daftarSiswa.get(indexTerendah).getNilai()) {
          indexTerendah = i;
        }
      }
      return indexTerendah;
    }

    public static int cariJumlahLulus(ArrayList<siswa> daftarSiswa) {
      int jumlahLulus = 0;
      for(int i = 0; i < daftarSiswa.size(); i++) {
        if (daftarSiswa.get(i).getStatus().equals("Lulus")) {
            jumlahLulus++;
          }
      } 
      return jumlahLulus;
    }

    public static int cariJumlahGagal(ArrayList<siswa> daftarSiswa) {
      int jumlahGagal = 0;
      for(int i = 0; i < daftarSiswa.size(); i++) {
        if (daftarSiswa.get(i).getStatus().equals("Gagal")) {
            jumlahGagal++;
          }
      } 
      return jumlahGagal;
    }

    public static int[] hitungDistribusiGrade(ArrayList<siswa> daftarSiswa) {
      int nilaiA = 0;
      int nilaiB = 0;
      int nilaiC = 0;
      int nilaiD = 0;
      int nilaiE = 0;
      for (int i = 0; i < daftarSiswa.size(); i++) {
        if (daftarSiswa.get(i).getGrade().equals("A")) {
          nilaiA++;
        } else if (daftarSiswa.get(i).getGrade().equals("B")) {
          nilaiB++;
        } else if (daftarSiswa.get(i).getGrade().equals("C")) {
          nilaiC++;
        } else if (daftarSiswa.get(i).getGrade().equals("D")) {
          nilaiD++;
       } else {
          nilaiE++;
        }          
      }
      return new int[]{nilaiA, nilaiB, nilaiC, nilaiD, nilaiE};
    }

    public static void editDataSiswa(ArrayList <siswa> daftarSiswa, Scanner input) {
      System.out.print("Masukkan nama siswa yang ingin diedit: ");
      String cariNama = input.next();
      siswa hasil = cariSiswa(daftarSiswa, cariNama);

      if (hasil == null) {
        System.out.println("Siswa tidak ditemukan");
      } else {
        System.out.println("== DATA SISWA == ");
        System.out.println("Nama: " + hasil.getNama());
        System.out.println("Nilai: " + hasil.getNilai());
        System.out.println("Grade: " + hasil.getGrade());
        System.out.println("Status: " + hasil.getStatus());
        double tugas, uts, uas;
        
        do {
          System.out.print("Nilai Tugas Baru : ");
          tugas = input.nextDouble();
          System.out.print("Nilai UTS Baru : ");
          uts = input.nextDouble();
          System.out.print("Nilai UAS Baru : ");
          uas = input.nextDouble();

          if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            System.out.println("Nilai harus berada antara 0-100.");
            System.out.println("Tolong masukkan ulang nilai yang benar!");
          }
        } while (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100);
        double nilaiBaru = hasil.hitungNilaiAkhir(tugas, uts, uas);
        hasil.setNilai(nilaiBaru);
        hasil.prosesNilai();
        System.out.println("Data siswa berhasil diperbarui!");
      }
    }

    public static void main(String[] args) { //KODE UTAMA MAINNYA WOI JANGAN LUPA
        Scanner input = new Scanner(System.in);
        int jumlahSiswa, pilihan;
        ArrayList<siswa> daftarSiswa = new ArrayList<>();
        do {
          System.out.println("\n=== STUDENT GRADE CALCULATOR v.3 ====");
          System.out.println("1. Tambah Siswa");
          System.out.println("2. Tampilkan Semua Siswa");
          System.out.println("3. Cari Siswa");
          System.out.println("4. Statistik");
          System.out.println("5. Edit Data Siswa");
          System.out.println("6. Keluar");
          System.out.println("=============");
          System.out.print("Pilih menu : ");
          pilihan = input.nextInt();
          switch (pilihan) {
            case 1:
              do {
                System.out.print("Jumlah Siswa : ");
                jumlahSiswa = input.nextInt();

                if (jumlahSiswa < 1) {
                System.out.println("Jumlah Siswa harus minimal 1!");
                }
              } while (jumlahSiswa < 1);
              inputData(input, jumlahSiswa, daftarSiswa);
              break;

            case 2:
              if(daftarSiswa.isEmpty()) {
                System.out.println("Belum ada data siswa");
              } else {
                tampilkanDataSiswa(daftarSiswa);
              }
              break;

            case 3:
              if (daftarSiswa.isEmpty()) {
                System.out.println("Belum ada data siswa");
              } else {
                  System.out.print("Cari nama siswa : ");
                  String namaCari = input.next();
                  siswa hasil = cariSiswa(daftarSiswa, namaCari);
                  if (hasil != null) {
                    System.out.println("=== Siswa Ditemukan");
                    System.out.println("Nama : " + hasil.getNama());
                    System.out.println("Nilai : " + hasil.getNilai());
                    System.out.println("Grade : " + hasil.getGrade());
                    System.out.println("Status : " + hasil.getStatus());        
                  } else {
                  System.out.println("Siswa tidak ditemukan");
                }
              }
              break;

            case 4:
              if (daftarSiswa.isEmpty()) {

                System.out.println("Belum ada data siswa");
              } else {
                double rataRata = hitungRataRata(daftarSiswa);
                int indexTertinggi = cariIndexTertinggi(daftarSiswa);
                int indexTerendah = cariIndexTerendah(daftarSiswa);
                int jumlahLulus = cariJumlahLulus(daftarSiswa);
                int jumlahGagal = cariJumlahGagal(daftarSiswa);
                int[] distribusiGrade = hitungDistribusiGrade(daftarSiswa);

                System.out.println("\n=== Statistik Nilai Siswa ===");
                System.out.println("Rata-rata Nilai : " + rataRata);
                System.out.println("Nilai Tertinggi : " + daftarSiswa.get(indexTertinggi).getNama() + " | " + daftarSiswa.get(indexTertinggi).getNilai());
                System.out.println("Nilai Terendah : " + daftarSiswa.get(indexTerendah).getNama() + " | " + daftarSiswa.get(indexTerendah).getNilai());
                System.out.println("Jumlah Lulus : " + jumlahLulus);
                System.out.println("Jumlah Gagal : " + jumlahGagal);
                System.out.println("Distribusi Grade : ");
                System.out.println("A : " + distribusiGrade[0]);
                System.out.println("B : " + distribusiGrade[1]);
                System.out.println("C : " + distribusiGrade[2]);
                System.out.println("D : " + distribusiGrade[3]);
                System.out.println("E : " + distribusiGrade[4]);
              }
              break;
            
            case 5:
              if (daftarSiswa.isEmpty()) {
                System.out.println("Belum ada data siswa");
              } else {
                editDataSiswa(daftarSiswa, input);
              }
              break;

            case 6:
              System.out.println("Terima Kasih telah menggunakan SGC");
              break;

            default:
              System.out.print("Tidak valid");
          }        
        } while (pilihan != 6);
        input.close();
    }
}