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

public class Tela4 extends AppCompatActivity {

    TextView nomeTela4;
    RadioGroup grpQuatro;
    Button btnRespostaQuatro;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);

        Intent telaQuatro = getIntent();
        Bundle nomeQuatro = telaQuatro.getExtras();

        nomeTela4 = findViewById(R.id.nomeTelaQuatro);
        nomeTela4.setText(nomeQuatro.getString("transfTela4"));

        String nomeTelaQuatro = nomeTela4.getText().toString();

        grpQuatro = findViewById(R.id.grpQuatro);

        btnRespostaQuatro = findViewById(R.id.btnRespostaQuatro);

        String pontoP3 = nomeQuatro.getString("questaoTres");
        pontos = Integer.parseInt(pontoP3);

        btnRespostaQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int opQuatro = grpQuatro.getCheckedRadioButtonId();

                Intent quatro = new Intent(Tela4.this, Tela5.class);

                String valorQuestao4;

                if(opQuatro==R.id.alternativaDQUATRO){
                    pontos +=1;
                    valorQuestao4 = String.valueOf(pontos);
                    quatro.putExtra("questaoQuatro", valorQuestao4);
                }
                else{
                    pontos +=0;
                    valorQuestao4 = String.valueOf(pontos);
                    quatro.putExtra("questaoQuatro", valorQuestao4);
                }

                quatro.putExtra("transfTela5", nomeTelaQuatro);
                Log.e("teste", "w" + pontos);
                startActivity(quatro);

            }
        });

    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela4.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}