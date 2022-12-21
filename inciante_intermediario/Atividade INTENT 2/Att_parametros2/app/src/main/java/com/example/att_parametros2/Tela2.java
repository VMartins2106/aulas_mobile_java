package com.example.att_parametros2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    Button calcular, voltar;
    EditText h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        calcular = findViewById(R.id.btnCalc);
        voltar = findViewById(R.id.btnVoltar);
        h = findViewById(R.id.altura);

        Intent telaAtual = getIntent();
        Bundle valoresRecebidos = telaAtual.getExtras();

        String sexo;
        sexo = valoresRecebidos.getString("genero");

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float altura, peso;
                
                if(sexo.equals("masculino")){

                    altura = Float.parseFloat(h.getText().toString());
                    peso = (altura * 72.7f) - 58f;
                    Toast.makeText(Tela2.this, "O peso ideal é: " +peso, Toast.LENGTH_SHORT).show();
                }

                else if(sexo.equals("feminino")){

                    altura = Float.parseFloat(h.getText().toString());
                    peso = (altura * 62.1f) - 44.7f;
                    Toast.makeText(Tela2.this, "O peso ideal é: " +peso, Toast.LENGTH_SHORT).show();
                }


            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mensagem = new AlertDialog.Builder((Tela2.this));
                mensagem.setTitle("Aviso");
                mensagem.setMessage("Deseja mesmo sair ?");
                mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Tela2.this, "Ok", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Tela2.this, "Você escolheu ficar!", Toast.LENGTH_SHORT).show();
                    }
                });
                mensagem.setCancelable(false);
                mensagem.show();
            }
        });

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(Tela2.this, "Clique no botão de sair!", Toast.LENGTH_SHORT).show();
    }
}