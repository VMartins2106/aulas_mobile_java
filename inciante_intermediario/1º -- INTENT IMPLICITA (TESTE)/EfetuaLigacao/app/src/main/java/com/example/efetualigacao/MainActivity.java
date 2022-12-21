package com.example.efetualigacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ligar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ligar = findViewById(R.id.btnLigar);

        ligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri numero = Uri.parse("tel:11997143811") ;
                Intent callNat = new Intent(Intent.ACTION_CALL, numero);

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;

                }
                startActivity(callNat);
            }
        });

    }
}