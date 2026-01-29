package tugas.mainapp;
public abstract class Smartphone implements Stock {
    // Atribut Private 
    private String model;
    private Brand brand; 
    private Integer harga;
    private int stok;

    // Constructor Berparameter 
    public Smartphone(String model, Brand brand, Integer harga, int stok) {
        this.model = model;
        this.brand = brand;
        this.harga = harga;
        this.stok = stok;
    }

    // Encapsulation: Getter dan Setter
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    public Integer getHarga() { return harga; }
    public void setHarga(Integer harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public abstract void tampilkanSpesifikasi();
}