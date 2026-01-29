package tugas.mainapp;
public class Android extends Smartphone {
    
    private String osVersion; //ENCAPSULATION

    public Android(String model, Integer harga, int stok, String osVersion) {
        super(model, Brand  .ANDROID, harga, stok);
        this.osVersion = osVersion;
    }

    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }

    @Override
    public void tampilkanSpesifikasi() {
        System.out.println("Tipe: " + getBrand() + " | Model: " + getModel() + " | OS: " + osVersion);
    }

    @Override
    public void cekStatus() {
        System.out.println("Cek Stok Android " + getModel() + ": " + (getStok() > 0 ? "Ready" : "Out of Stock"));
    }

    @Override
    public String getDetailInfo() {
        return "ANDROID;" + getModel() + ";" + getHarga() + ";" + getStok() + ";" + osVersion;
    }
}