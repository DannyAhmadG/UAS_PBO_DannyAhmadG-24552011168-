package tugas.mainapp;
import java.util.Scanner;
import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        Store toko = new Store();
        toko.muatDariFile(); // Memuat data lama saat aplikasi dibuka
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n--- Handphone STORE ---");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Cek Status Data");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1 -> { // TAMBAH DATA
                    System.out.print("Tipe (1.Android / 2.iPhone): ");
                    int tipe = Integer.parseInt(sc.nextLine());
                    System.out.print("Model: "); String model = sc.nextLine();
                    System.out.print("Harga: "); Integer harga = Integer.valueOf(sc.nextLine());
                    System.out.print("Stok: "); int stok = Integer.parseInt(sc.nextLine());

                    if (tipe == 1) {
                        System.out.print("Versi OSVersion: "); String osVersion = sc.nextLine();
                        toko.tambahHP(new Android(model, harga, stok, osVersion));
                    } else {
                        System.out.print("Status iCloud: "); String icloud = sc.nextLine();
                        toko.tambahHP(new Iphone(model, harga, stok, icloud));
                    }
                }
                case 2 -> { // TAMPILKAN DATA
                    System.out.println("\n--- DAFTAR STOK BARANG ---");
                    for (Smartphone hp : toko.getDaftarHP()) {
                        hp.tampilkanSpesifikasi();
                    }
                }
                case 3 -> { // CARI DATA
                    System.out.print("Masukkan Model yang dicari: ");
                    String cari = sc.nextLine();
                    boolean found = false;
                    for (Smartphone hp : toko.getDaftarHP()) {
                        if (hp.getModel().equalsIgnoreCase(cari)) {
                            hp.tampilkanSpesifikasi();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Data tidak ditemukan.");
                }
                case 4 -> { // UBAH DATA
                    System.out.print("Masukkan Model yang akan diubah harganya: ");
                    String modelUbah = sc.nextLine();
                    for (Smartphone hp : toko.getDaftarHP()) {
                        if (hp.getModel().equalsIgnoreCase(modelUbah)) {
                            System.out.print("Masukkan Harga Baru: ");
                            hp.setHarga(Integer.valueOf(sc.nextLine()));
                            System.out.println("Harga berhasil diperbarui!");
                        }
                    }
                }
                case 5 -> { // CEK STATUS DATA (Polymorphism)
                    System.out.println("\n--- STATUS KETERSEDIAAN ---");
                    for (Smartphone hp : toko.getDaftarHP()) {
                        System.out.print(hp.getModel() + " -> ");
                        hp.cekStatus(); // Memanggil method interface
                    }
                }
                case 6 -> { // KELUAR
                    toko.simpanKeFile(); // Menyimpan ke CSV sebelum tutup
                    System.out.println("Data berhasil disimpan. Sampai jumpa!");
                }
            }
        } while (pilihan != 6);
    }
}