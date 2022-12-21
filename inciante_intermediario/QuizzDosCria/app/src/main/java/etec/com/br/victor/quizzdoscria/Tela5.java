package etec.com.br.victor.quizzdoscria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Tela5 extends AppCompatActivity {

    TextView nomeTela5;
    RadioGroup grpCinco;
    Button btnRespostaCinco;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela5);

        Intent telaCinco = getIntent();
        Bundle nomeCinco = telaCinco.getExtras();

        nomeTela5 = findViewById(R.id.nomeTelaCinco);
        nomeTela5.setText(nomeCinco.getString("transfTela5"));

        String nomeTelaCinco = nomeTela5.getText().toString();

        grpCinco = findViewById(R.id.grpCinco);

        btnRespostaCinco = findViewById(R.id.btnRespostaCinco);

        String pontoP4 = nomeCinco.getString("questaoQuatro");
        pontos = Integer.parseInt(pontoP4);

        btnRespostaCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CÓDIGO DO RADIO --> A É A CERTA

                int opCinco = grpCinco.getCheckedRadioButtonId();

                Intent cinco = new Intent(Tela5.this, Tela6.class);

                String valorQuestao5;

                if(opCinco==R.id.alternativaACINCO){
                    pontos +=1;
                    valorQuestao5 = String.valueOf(pontos);
                    cinco.putExtra("questaoCinco", valorQuestao5);
                }
                else{
                    pontos +=0;
                    valorQuestao5 = String.valueOf(pontos);
                    cinco.putExtra("questaoCinco", valorQuestao5);
                }

                cinco.putExtra("transfTela6", nomeTelaCinco);
                Log.e("teste", "w" + pontos);
                startActivity(cinco);

            }
        });

    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela5.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}