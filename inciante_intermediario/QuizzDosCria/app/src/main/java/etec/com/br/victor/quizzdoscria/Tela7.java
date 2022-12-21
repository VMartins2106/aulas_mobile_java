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

public class Tela7 extends AppCompatActivity {

    TextView nomeTela7;
    RadioGroup grpSete;
    Button btnRespostaSete;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela7);

        Intent telaSete = getIntent();
        Bundle nomeSete = telaSete.getExtras();

        nomeTela7 = findViewById(R.id.nomeTelaSete);
        nomeTela7.setText(nomeSete.getString("transfTela7"));

        String nomeTelaSete = nomeTela7.getText().toString();

        grpSete = findViewById(R.id.grpSete);

        btnRespostaSete = findViewById(R.id.btnRespostaSete);

        String pontoP6 = nomeSete.getString("questaoSeis");
        pontos = Integer.parseInt(pontoP6);

        btnRespostaSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CÓDIGO DO RADIO --> B É A CERTA

                int opSete = grpSete.getCheckedRadioButtonId();

                Intent sete = new Intent(Tela7.this, Tela8.class);

                String valorQuestao7;

                if(opSete==R.id.alternativaBSETE){
                    pontos +=1;
                    valorQuestao7 = String.valueOf(pontos);
                    sete.putExtra("questaoSete", valorQuestao7);
                }
                else{
                    pontos +=0;
                    valorQuestao7 = String.valueOf(pontos);
                    sete.putExtra("questaoSete", valorQuestao7);
                }

                sete.putExtra("transfTela8", nomeTelaSete);
                Log.e("teste", "w" + pontos);
                startActivity(sete);

            }
        });

    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela7.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}