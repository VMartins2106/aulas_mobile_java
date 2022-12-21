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

public class Tela2 extends AppCompatActivity {

    TextView nomeTela2;
    RadioGroup grpDois;
    Button btnRespostaDois;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //INTENT
        Intent telaDois = getIntent();
        Bundle nomeDois = telaDois.getExtras();

        //RECUPERANDO E TRANSFERINDO NOME
        nomeTela2 = findViewById(R.id.nomeTelaDois);
        nomeTela2.setText(nomeDois.getString("transfTela2"));

        String nomeTelaDois = nomeTela2.getText().toString();

        //DECLARANDO RADIO GROUP
        grpDois = findViewById(R.id.grpDois);


        //BOTAO CONFIRMAR
        btnRespostaDois = findViewById(R.id.btnRespostaDois);

        //RECUPERANDO E ARMAZENANDO QUESTAO ANTERIOR
        String pontoP1 = nomeDois.getString("questaoUm");
        pontos = Integer.parseInt(pontoP1);

        btnRespostaDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int opDois = grpDois.getCheckedRadioButtonId();

                Intent dois = new Intent(Tela2.this, Tela3.class);

                //CÓDIGO DO RADIO --> C É A CERTA

                String valorQuestao2;

                if(opDois==R.id.alternativaCDOIS){
                    pontos +=1;
                    valorQuestao2 = String.valueOf(pontos);
                    dois.putExtra("questaoDois", valorQuestao2);
                }
                else{
                    pontos +=0;
                    valorQuestao2 = String.valueOf(pontos);
                    dois.putExtra("questaoDois", valorQuestao2);
                }

                dois.putExtra("transfTela3", nomeTelaDois);
                Log.e("teste", "w" + pontos);
                startActivity(dois);

            }
        });

    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela2.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}