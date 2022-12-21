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

public class Tela9 extends AppCompatActivity {

    TextView nomeTela9;
    RadioGroup grpNove;
    Button btnRespostaNove;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela9);

        Intent telaNove = getIntent();
        Bundle nomeNove = telaNove.getExtras();

        nomeTela9 = findViewById(R.id.nomeTelaNove);
        nomeTela9.setText(nomeNove.getString("transfTela9"));

        String nomeTelaNove = nomeTela9.getText().toString();

        grpNove = findViewById(R.id.grpNove);

        btnRespostaNove = findViewById(R.id.btnRespostaNove);

        String pontoP8 = nomeNove.getString("questaoOito");
        pontos = Integer.parseInt(pontoP8);

        btnRespostaNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CÓDIGO DO RADIO -->C É A CERTA

                int opNove = grpNove.getCheckedRadioButtonId();

                Intent nove = new Intent(Tela9.this, Tela10.class);

                String valorQuestao9;

                if(opNove==R.id.alternativaCNOVE){
                    pontos +=1;
                    valorQuestao9 = String.valueOf(pontos);
                    nove.putExtra("questaoNove", valorQuestao9);
                }
                else{
                    pontos +=0;
                    valorQuestao9 = String.valueOf(pontos);
                    nove.putExtra("questaoNove", valorQuestao9);
                }

                nove.putExtra("transfTela10", nomeTelaNove);
                Log.e("teste", "w" + pontos);
                startActivity(nove);

            }
        });

    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela9.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}