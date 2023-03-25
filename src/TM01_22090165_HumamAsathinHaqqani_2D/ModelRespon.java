package TM01_22090165_HumamAsathinHaqqani_2D;

public class ModelRespon {
    private String namaObat;
    private String stok;
    private int harga;

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public ModelRespon() {
        this.namaObat = namaObat;
        this.stok = stok;
        this.harga = harga;
    }
}
