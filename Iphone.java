package tugas.mainapp;

public class Iphone extends Smartphone {
    private String icloudStatus; //ENCAPSULATION

    public Iphone(String model, Integer harga, int stok, String icloudStatus) {
        super(model, Brand.IPHONE, harga, stok);
        this.icloudStatus = icloudStatus;
    }

    public String getIcloudStatus() { return icloudStatus; }
    public void setIcloudStatus(String icloudStatus) { this.icloudStatus = icloudStatus; }

    @Override
    public void tampilkanSpesifikasi() {
        System.out.println("Tipe: " + getBrand() + " | Model: " + getModel() + " | iCloud: " + icloudStatus);
    }

    @Override
    public void cekStatus() {
        System.out.println("Cek Stok iPhone " + getModel() + ": " + (getStok() > 5 ? "Aman" : "Terbatas"));
    }

    @Override
    public String getDetailInfo() {
        return "IPHONE;" + getModel() + ";" + getHarga() + ";" + getStok() + ";" + icloudStatus;
    }
}