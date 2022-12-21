package etec.com.br.victor.quizzdoscria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Tela3 extends AppCompatActivity {

    TextView nomeTela3;
    RadioGroup grpTres;
    Button btnRespostaTres;
    int pontos;
    ImageView botons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        botons = findViewById(R.id.playBotoni);
        MediaPlayer botoni = MediaPlayer.create(this, R.raw.botoni);

        Intent telaTres = getIntent();
        Bundle nomeTres = telaTres.getExtras();

        nomeTela3 = findViewById(R.id.nomeTelaTres);
        nomeTela3.setText(nomeTres.getString("transfTela3"));

        String nomeTelaTres = nomeTela3.getText().toString();

        grpTres = findViewById(R.id.grpTres);

        btnRespostaTres = findViewById(R.id.btnRespostaTres);

        String pontoP2 = nomeTres.getString("questaoDois");
        pontos = Integer.parseInt(pontoP2);

        botons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(botoni.isPlaying()) {
                    botoni.pause();
                    botons.setImageResource(R.drawable.ic_play);
                }
                else{
                    botons.setImageResource(R.drawable.ic_pause);
                    botoni.start();
                }
            }
        });

        btnRespostaTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int opTres = grpTres.getCheckedRadioButtonId();

                Intent tres = new Intent(Tela3.this, Tela4.class);

                String valorQuestao3;

                if(opTres==R.id.alternativaATRES){
                    pontos +=1;
                    valorQuestao3 = String.valueOf(pontos);
                    tres.putExtra("questaoTres", valorQuestao3);
                }
                else{
                    pontos +=0;
                    valorQuestao3 = String.valueOf(pontos);
                    tres.putExtra("questaoTres", valorQuestao3);
                }

                tres.putExtra("transfTela4", nomeTelaTres);
                Log.e("teste", "w" + pontos);
                startActivity(tres);

            }
        });
    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela3.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}