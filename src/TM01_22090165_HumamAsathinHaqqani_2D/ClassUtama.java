package TM01_22090165_HumamAsathinHaqqani_2D;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ClassUtama extends JFrame{
    private JButton tombol;
    private JTextArea hasilData;

    public ClassUtama(){
        komponen();
    }

    private void komponen(){
        setTitle("TM01_Data Obat");
        setSize(450,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tombol = new JButton("Submit");
        hasilData = new JTextArea(32,40);
        hasilData.setEditable(false);

        tombol.addActionListener(e -> {
            try {
                KoneksiKeURL koneksiSaya = new KoneksiKeURL();
                URL myAddress = koneksiSaya.buildURL
                        ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
                String response = koneksiSaya.getResponseFromHttpUrl(myAddress);

                assert response != null;
                JSONArray responJSON = new JSONArray(response);
                ArrayList<ModelRespon> modelRespon = new ArrayList<>();
                for (int i=0;i<responJSON.length();i++) {
                    ModelRespon resData = new ModelRespon();
                    JSONObject myObject = responJSON.getJSONObject(i);
                    resData.setNamaObat(myObject.getString("i_name"));
                    resData.setStok(myObject.getString("i_qty"));
                    resData.setHarga(myObject.getInt("i_sell"));
                    modelRespon.add(resData);
                }

                StringBuilder hasil = new StringBuilder();
                hasil.append("Berikut Hasil Sortir Data Barang \n");
                hasil.append("Berawalan Huruf S & Harganya Maksimal 7000 \n");
                hasil.append("--------------------------------------------------------------\n");

                for (int dex=0;dex< modelRespon.size();dex++){
                    if (modelRespon.get(dex).getNamaObat().startsWith("S") && modelRespon.get(dex).getHarga()<=7000){
                        hasil.append("Nama Barang = "+modelRespon.get(dex).getNamaObat()+" | Harga = "+modelRespon.get(dex).getHarga()+"\n");
                        hasil.append("\n");
                    }
                }
                hasilData.setText(hasil.toString());
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        });

        JLabel label = new JLabel("Tekan Tombol untuk Menampilkan Hasil Sortir >>>");
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(tombol);
        panel.add(hasilData);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        ClassUtama start = new ClassUtama();
        start.setVisible(true);
    }
}