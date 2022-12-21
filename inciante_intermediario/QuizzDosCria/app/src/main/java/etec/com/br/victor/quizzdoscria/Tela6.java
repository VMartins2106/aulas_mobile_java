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

public class Tela6 extends AppCompatActivity {

    TextView nomeTela6;
    RadioGroup grpSeis;
    Button btnRespostaSeis;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela6);

        Intent telaSeis = getIntent();
        Bundle nomeSeis = telaSeis.getExtras();

        nomeTela6 = findViewById(R.id.nomeTelaSeis);
        nomeTela6.setText(nomeSeis.getString("transfTela6"));

        String nomeTelaSeis = nomeTela6.getText().toString();

        grpSeis = findViewById(R.id.grpSeis);

        btnRespostaSeis = findViewById(R.id.btnRespostaSeis);

        String pontoP5 = nomeSeis.getString("questaoCinco");
        pontos = Integer.parseInt(pontoP5);

        btnRespostaSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CÓDIGO DO RADIO --> B É A CERTA

                int opSeis = grpSeis.getCheckedRadioButtonId();

                Intent seis = new Intent(Tela6.this, Tela7.class);

                String valorQuestao6;

                if(opSeis==R.id.alternativaBSEIS){
                    pontos +=1;
                    valorQuestao6 = String.valueOf(pontos);
                    seis.putExtra("questaoSeis", valorQuestao6);
                }
                else{
                    pontos +=0;
                    valorQuestao6 = String.valueOf(pontos);
                    seis.putExtra("questaoSeis", valorQuestao6);
                }

                seis.putExtra("transfTela7", nomeTelaSeis);
                Log.e("teste", "w" + pontos);
                startActivity(seis);

            }
        });

    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela6.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}