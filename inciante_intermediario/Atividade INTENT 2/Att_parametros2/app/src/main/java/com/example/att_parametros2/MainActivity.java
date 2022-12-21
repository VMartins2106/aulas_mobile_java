package com.example.att_parametros2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMasc, btnFem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btnFem = findViewById(R.id.btnF);
    btnMasc = findViewById(R.id.btnM);

    btnMasc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent tela2 = new Intent(MainActivity.this, Tela2.class);
            tela2.putExtra("genero", "masculino");
            startActivity(tela2);

        }
    });

    btnFem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent tela2 = new Intent(MainActivity.this, Tela2.class);
            tela2.putExtra("genero", "feminino");
            startActivity(tela2);

        }
    });

    }
}