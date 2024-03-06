package com.example.ordercoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SubAct extends AppCompatActivity implements View.OnClickListener{
    private EditText namaPemesan;
    private EditText alamatPemesan;
    private TextView totalLatte;
    private TextView totalCapu;
    private CheckBox granule;
    private CheckBox Krim;
    private CheckBox gula;
    private CheckBox milk;
    private Button selesaiPesan;

    int Latte = 0;
    int satuanLatte = 30000;
    int hargaLatte = 0;
    int Capucino = 0;
    int satuanCapu = 25000;
    int hargaCapu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Toolbar bar = (Toolbar) findViewById(R.id.bar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findAllViewsId();
        selesaiPesan.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void findAllViewsId() {
        namaPemesan = (EditText) findViewById(R.id.et_nama_pemesan);
        totalLatte = (TextView)findViewById(R.id.txt_harga_latte);
        granule = (CheckBox)findViewById(R.id.cb_choco);
        Krim = (CheckBox)findViewById(R.id.cb_cream);
        selesaiPesan=(Button)findViewById(R.id.btn_selesaiPesan);
        alamatPemesan = (EditText)findViewById(R.id.et_alamat_pemesan);
        totalCapu = (TextView)findViewById(R.id.txt_harga_capu);
        gula = (CheckBox)findViewById(R.id.cb_sugar);
        milk = (CheckBox)findViewById(R.id.cb_milk);
    }
    @Override
    public void onClick(View view){
        Intent intent = new Intent(SubAct.this, SubHasil.class);
        intent.putExtra("nama", namaPemesan.getText().toString());
        intent.putExtra("Latte", totalLatte.getText().toString());
        intent.putExtra("Granule", granule.isChecked());
        intent.putExtra("Cream", Krim.isChecked());
        intent.putExtra("alamat",alamatPemesan.getText().toString());
        intent.putExtra("Cappucino", totalCapu.getText().toString());
        intent.putExtra("Sugar", gula.isChecked());
        intent.putExtra("Milk", milk.isChecked());
        startActivity(intent);
    }
    public void incrementLatte(View view){
        Latte = Latte + 1 ;
        hargaLatte = Latte * satuanLatte;
        displayLatte(Latte);
        displayHargaLatte(hargaLatte);
    }
    public void decrementLatte(View view){
        if(Latte < 1){
            Toast.makeText(this, "Maaf, Anda tidak bisa memesan kurang dari 0",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Latte = Latte - 1;
        hargaLatte = Latte * satuanLatte;
        displayLatte(Latte);
        displayHargaLatte(hargaLatte);
    }
    private void displayLatte(int number){
        TextView txtLatte = (TextView)findViewById(R.id.txt_jumlah_kopi);
        txtLatte.setText(""+number);
    }
    private void displayHargaLatte(int number){
        TextView txtHargaLatte =
                (TextView)findViewById(R.id.txt_harga_latte);
        txtHargaLatte.setText(""+number);
    }
    public void incrementCapu(View view){
        Capucino = Capucino + 1 ;
        hargaCapu = Capucino * satuanCapu;
        displayCapu(Capucino);
        displayHargaCapu(hargaCapu);
    }
    public void decrementCapu(View view){
        if(Capucino < 1){
            Toast.makeText(this, "Maaf, Anda tidak bisa memesan kurang dari 0",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Capucino = Capucino - 1;
        hargaCapu = Capucino * satuanCapu;
        displayCapu(Capucino);
        displayHargaCapu(hargaCapu);
    }
    private void displayCapu(int number){
        TextView txtCapu = (TextView)findViewById(R.id.txt_jumlah_capu);
        txtCapu.setText(""+number);
    }
    private void displayHargaCapu(int number){
        TextView txtHargaCapu =
                (TextView)findViewById(R.id.txt_harga_capu);
        txtHargaCapu.setText(""+number);
    }
}
