package tugas.mainapp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//FILE HANDLING
class FileMeneger {

  public static void simpanData(ArrayList<Smartphone> list) {
    try {
        FileWriter fw = new FileWriter("stok_hp.csv");

        for (Smartphone hp : list) {
            fw.write(hp.getStok() + "\n");
        }

        fw.close();
        System.out.println("Data berhasil disimpan ke file");

    } catch (IOException e) {
        System.out.println("Gagal menyimpan data");
    }
}

public static void bacaData() {
    try {
        BufferedReader br = new BufferedReader(
                new FileReader("stok_hp.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    } catch (IOException e) {
        System.out.println("File belum ada");
        }
    }
}