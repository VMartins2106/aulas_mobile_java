package etec.com.br.victor.quizzdoscria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.Temporal;

public class Tela8 extends AppCompatActivity {

    public int counter=30;
    TextView nomeTela8, tempo, pergunta;
    RadioGroup grpOito;
    Button btnRespostaOito, comecar;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela8);

        MediaPlayer biel = MediaPlayer.create(this, R.raw.risada_biel);

        pergunta = findViewById(R.id.perguntaOito);
        tempo = findViewById(R.id.timer);

        comecar = findViewById(R.id.btnComecar);

        Intent telaOito = getIntent();
        Bundle nomeOito = telaOito.getExtras();

        nomeTela8 = findViewById(R.id.nomeTelaOito);
        nomeTela8.setText(nomeOito.getString("transfTela8"));

        String nomeTelaOito = nomeTela8.getText().toString();

        grpOito = findViewById(R.id.grpOito);

        btnRespostaOito = findViewById(R.id.btnRespostaOito);

        String pontoP7 = nomeOito.getString("questaoSete");
        pontos = Integer.parseInt(pontoP7);

        btnRespostaOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int opOito = grpOito.getCheckedRadioButtonId();

                //CÓDIGO DO RADIO --> D É A CERTA

                Intent oito = new Intent(Tela8.this, Tela9.class);

                String valorQuestao8;

                if (opOito == R.id.alternativaDOITO) {
                    pontos += 1;
                    valorQuestao8 = String.valueOf(pontos);
                    oito.putExtra("questaoOito", valorQuestao8);
                } else {
                    pontos += 0;
                    valorQuestao8 = String.valueOf(pontos);
                    oito.putExtra("questaoOito", valorQuestao8);
                }

                oito.putExtra("transfTela9", nomeTelaOito);
                Log.e("teste", "w" + pontos);

                startActivity(oito);

            }
        });

        comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pergunta.setText("DE QUEM É ESSA RISADA ?");

                biel.start();

                new CountDownTimer(30000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        tempo.setText(String.valueOf(counter));
                        counter--;
                    }

                    @Override
                    public void onFinish() {
                        tempo.setText(0);
                        Toast.makeText(Tela8.this, "NÃO DEU PAE", Toast.LENGTH_SHORT).show();
                    }
                }.start();

            }
        });

    }
    @Override
    public void onBackPressed () {

        Toast.makeText(Tela8.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}