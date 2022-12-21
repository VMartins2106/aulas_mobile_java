package etec.com.br.victor.quizzdoscria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tela11 extends AppCompatActivity {

    TextView nomeTela11, pontuacao;
    Button reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela11);

        pontuacao = findViewById(R.id.placar);

        Intent telaOnze = getIntent();
        Bundle nomeOnze = telaOnze.getExtras();

        nomeTela11 = findViewById(R.id.nomeTelaOnze);
        nomeTela11.setText(nomeOnze.getString("transfTela11"));

        pontuacao.setText(nomeOnze.getString("questaoDez"));

        reiniciar = findViewById(R.id.btnReiniciar);

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent voltar = new Intent(Tela11.this, MainActivity.class);
                startActivity(voltar);
                finish();

            }
        });

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(Tela11.this, "Clique no botão de reiniciar", Toast.LENGTH_SHORT).show();

    }

}