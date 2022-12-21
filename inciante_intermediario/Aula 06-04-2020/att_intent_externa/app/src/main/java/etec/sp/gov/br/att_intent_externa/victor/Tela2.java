package etec.sp.gov.br.att_intent_externa.victor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    TextView nome1, senha1;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        nome1 = findViewById(R.id.txttela2);
        senha1 = findViewById(R.id.txtela2);

        voltar = findViewById(R.id.btsair);

        Intent telaAtual = getIntent();
        Bundle loginRecebido = telaAtual.getExtras();


        nome1.setText(loginRecebido.getString("userCadastrado"));
        senha1.setText(loginRecebido.getString("senhaCadastrada"));

        String name, pass;

        name = nome1.getText().toString();
        pass = senha1.getText().toString();

        
        if(name == "victor" && pass == "etec123"){
            Toast.makeText(Tela2.this, "Bem vindo, " + name, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(Tela2.this, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show();
        }

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mensagem = new AlertDialog.Builder((Tela2.this));
                mensagem.setTitle("Aviso");
                mensagem.setMessage("Use o botão acima para voltar");
                mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Tela2.this, "Clicou em sim!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Tela2.this, "Clicou em não!", Toast.LENGTH_SHORT).show();
                    }
                });
                mensagem.setCancelable(false);
                mensagem.show();

            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Tela2.this, "Clique no botão sair!", Toast.LENGTH_SHORT).show();
    }
}