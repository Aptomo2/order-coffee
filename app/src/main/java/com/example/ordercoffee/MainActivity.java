package com.example.ordercoffee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Slide ViewFlipper
    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pesanEmail = findViewById(R.id.btn_pesan_email);
        pesanEmail.setOnClickListener(this);
        Button pesanPhone = findViewById(R.id.btn_pesan_phone);
        pesanPhone.setOnClickListener(this);

        Toolbar bar = findViewById(R.id.bar);
        setSupportActionBar(bar);

        //ViewFlipper
        int[] images = {R.drawable.menu, R.drawable.latte,
                R.drawable.capu, R.drawable.coffee};
        v_flipper = findViewById(R.id.v_flipper);
        for (int image : images) {
            flipperImages(image);
        }
    }

    //Method Flipper
    private void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000); //3 scn
        v_flipper.setAutoStart(true);
        //animationn
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_pesan_email) {
            Intent moveIntent = new Intent(MainActivity.this, SubAct.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_pesan_phone) {
            String phoneNumber = "083824414700";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        }
    }
}

