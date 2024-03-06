package com.example.ordercoffee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SubHasil extends AppCompatActivity {

    private Button kirimPesanan;
    private CheckBox setujuPesan;
    TextView namaPemesan ;
    TextView alamatPemesan ;
    TextView totalLatte ;
    TextView totalCapu;
    TextView Granule;
    TextView Cream;
    TextView Sugar;
    TextView Milk;
    TextView totalPembayaran;
    String namaEmail = "";
    String alamatEmail = "";
    String hargaLatteEmail = "";
    String hargaCapuEmail = "";
    String hargaGranuleEmail = "";
    String hargaCreamEmail = "";
    String hargaSugarEmail = "";
    String hargaMilkEmail = "";
    String totalPembayaranEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_hasil);

        Toolbar bar = (Toolbar) findViewById(R.id.bar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        namaPemesan = (TextView)findViewById(R.id.txt_nama_pemesan);
        alamatPemesan = (TextView)findViewById(R.id.txt_alamat_pemesan);
        totalLatte = (TextView)findViewById(R.id.txt_Latte);
        totalCapu=(TextView)findViewById(R.id.txt_Capu);
        Granule = (TextView)findViewById(R.id.txt_Granule);
        Cream = (TextView)findViewById(R.id.txt_Cream);
        Sugar = (TextView)findViewById(R.id.txt_Sugar);
        Milk = (TextView)findViewById(R.id.txt_Milk);
        namaPemesan.setText(intent.getExtras().getString("nama"));
        alamatPemesan.setText(intent.getExtras().getString("alamat"));
        totalLatte.setText(intent.getExtras().getString("Latte"));
        totalCapu.setText(intent.getExtras().getString("Cappucino"));
        Granule.setText(intent.getExtras().getString("Granule"));
        Cream.setText(intent.getExtras().getString("Cream"));
        Sugar.setText(intent.getExtras().getString("Sugar"));
        Milk.setText(intent.getExtras().getString("Milk"));
        boolean trueGranule = getIntent().getExtras().getBoolean("Granule");
        boolean trueCream = getIntent().getExtras().getBoolean("Cream");
        boolean trueSugar = getIntent().getExtras().getBoolean("Sugar");
        boolean trueMilk = getIntent().getExtras().getBoolean("Milk");
        if(trueGranule){
            Granule.setText("3000");
        }else {
            Granule.setText("0");
        }
        if(trueCream){
            Cream.setText("3000");
        }else {
            Cream.setText("0");
        }
        if(trueSugar){
            Sugar.setText("2000");
        }else {
            Sugar.setText("0");
        }
        if(trueMilk){
            Milk.setText("4000");
        }else {
            Milk.setText("0");
        }
        String stringLatte = totalLatte.getText().toString();
        int intLatte = Integer.parseInt(stringLatte);
        String stringCapu = totalCapu.getText().toString();
        int intCapu = Integer.parseInt(stringCapu);
        String stringGranule = Granule.getText().toString();
        int intGranule = Integer.parseInt(stringGranule);
        String stringCream = Cream.getText().toString();
        int intCream = Integer.parseInt(stringCream);
        String stringSugar = Sugar.getText().toString();
        int intSugar = Integer.parseInt(stringSugar);
        String stringMilk = Milk.getText().toString();
        int intMilk = Integer.parseInt(stringMilk);
        int total = intLatte + intCapu + intGranule + intCream +
                intSugar + intMilk;
        totalPembayaran = (TextView)findViewById(R.id.txt_total_pembayaran);
        totalPembayaran.setText(total+"");
        kirimPesanan = (Button)findViewById(R.id.btn_kirimPesanan);
    }
    public String getNamaEmail(){
        TextView namaEmail = (TextView)findViewById(R.id.txt_nama_pemesan);
        return namaEmail.getText().toString();
    }
    public String getAlamatEmail(){
        TextView alamatEmail = (TextView)findViewById(R.id.txt_alamat_pemesan);
        return alamatEmail.getText().toString();
    }
    public String getHargaLatteEmail(){
        TextView hargaLatteEmail = (TextView)findViewById(R.id.txt_Latte);
        return String.valueOf(hargaLatteEmail);
    }
    public String getHargaCapuEmail(){
        TextView hargaCapuEmail = (TextView)findViewById(R.id.txt_Cream);
        return String.valueOf(hargaCapuEmail);
    }
    public String getHargaGranuleEmail(){
        TextView hargaGranuleEmail = (TextView)findViewById(R.id.txt_Granule);
        return String.valueOf(hargaGranuleEmail);
    }
    public String getHargaCreamEmail(){
        TextView hargaCreamEmail = (TextView)findViewById(R.id.txt_Cream);
        return String.valueOf(hargaCreamEmail);
    }
    public String getHargaSugarEmail(){
        TextView hargaSugarEmail = (TextView)findViewById(R.id.txt_Sugar);
        return String.valueOf(hargaSugarEmail);
    }
    public String getHargaMilkEmail(){
        TextView hargaMilkEmail = (TextView)findViewById(R.id.txt_Milk);
        return String.valueOf(hargaMilkEmail);
    }
    public String getTotalPembayaranEmail(){
        TextView totalPembayaranEmail = (TextView)findViewById(R.id.txt_total_pembayaran);
        return String.valueOf(totalPembayaranEmail);
    }
    public void onClick(View v) {
        setujuPesan = (CheckBox)findViewById(R.id.cb_setuju_pesan);
        namaEmail = namaPemesan.getText().toString();
        alamatEmail = alamatPemesan.getText().toString();
        hargaLatteEmail = totalLatte.getText().toString();
        hargaCapuEmail = totalCapu.getText().toString();
        hargaGranuleEmail = Granule.getText().toString();
        hargaCreamEmail = Cream.getText().toString();
        hargaSugarEmail = Sugar.getText().toString();
        hargaMilkEmail = Milk.getText().toString();
        totalPembayaranEmail = totalPembayaran.getText().toString();
        String pesanan = String.format("Nama Pemesan : %s" +
                        "\nAlamat Pemesan : %s" +
                        "\nLatte Art : %s" +
                        "\nCappucino : %s" +
                        "\nChoco Granule : %s" +
                        "\nCream : %s" +
                        "\nSugar : %s" +
                        "\nMilk : %s" +
                        "\n\nTotal Pembayaran : %s" +
                        "\n",
                namaEmail,
                alamatEmail,
                hargaLatteEmail,
                hargaCapuEmail,
                hargaGranuleEmail,
                hargaCreamEmail,
                hargaSugarEmail,
                hargaMilkEmail,
                totalPembayaranEmail);

        if(setujuPesan.isChecked()){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:apsky.ap09@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Order Coffee dari : " + namaEmail);
            intent.putExtra(Intent.EXTRA_TEXT, pesanan);
            startActivity(Intent.createChooser(intent, "Send Email"));
        }else{
            Toast.makeText(this, "Silahkan chekclist \"Pesanan sudah benar\" untuk " +
                    "melanjutkan pengiriman email", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}