package tugas.mainapp;
import java.util.*;
import java.io.*;

public class Store {
    private List<Smartphone> daftarHP = new ArrayList<>();
    private final String fileName = "database_stok.txt";

    public void tambahHP(Smartphone hp) {
        daftarHP.add(hp);
        System.out.println("Data berhasil ditambahkan!");
    }

    public List<Smartphone> getDaftarHP() { return daftarHP; }

    public void simpanKeFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Smartphone hp : daftarHP) {
                writer.println(hp.getDetailInfo());
            }
        } catch (IOException e) {
            System.out.println("Error simpan file: " + e.getMessage());
        }
    }

    public void muatDariFile() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals("ANDROID")) {
                    daftarHP.add(new Android(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]));
                } else {
                    daftarHP.add(new Iphone(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File database belum ada, memulai database baru.");
      
                }
            }
        }   