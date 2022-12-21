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

public class Tela10 extends AppCompatActivity {

    TextView nomeTela10;
    RadioGroup grpDez;
    Button btnRespostaDez;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela10);

        Intent telaDez = getIntent();
        Bundle nomeDez = telaDez.getExtras();

        nomeTela10 = findViewById(R.id.nomeTelaDez);
        nomeTela10.setText(nomeDez.getString("transfTela10"));

        String nomeTelaDez = nomeTela10.getText().toString();

        grpDez = findViewById(R.id.grpDez);

        btnRespostaDez = findViewById(R.id.btnRespostaDez);

        String pontoP9 = nomeDez.getString("questaoNove");
        pontos = Integer.parseInt(pontoP9);

        btnRespostaDez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CÓDIGO DO RADIO --> A É A CERTA

                int opDez = grpDez.getCheckedRadioButtonId();

                Intent dez = new Intent(Tela10.this, Tela11.class);

                String valorQuestao10;

                if(opDez==R.id.alternativaADEZ){
                    pontos +=1;
                    valorQuestao10 = String.valueOf(pontos);
                    dez.putExtra("questaoDez", valorQuestao10);
                }
                else{
                    pontos +=0;
                    valorQuestao10 = String.valueOf(pontos);
                    dez.putExtra("questaoDez", valorQuestao10);
                }

                dez.putExtra("transfTela11", nomeTelaDez);
                Log.e("teste", "w" + pontos);
                startActivity(dez);

            }
        });

    }
    @Override
    public void onBackPressed() {

        Toast.makeText(Tela10.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }
}