package etec.com.br.victor.quizzdoscria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    TextView nomeTela1;
    RadioGroup grpUm;
    Button btnRespostaUm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        Intent telaUm = getIntent();
        Bundle nomeUm = telaUm.getExtras();

        nomeTela1 = findViewById(R.id.nomeTelaUm);
        nomeTela1.setText(nomeUm.getString("transfTela1"));

        String nomeTelaUm = nomeTela1.getText().toString();

        grpUm = findViewById(R.id.grpUm);

        btnRespostaUm = findViewById(R.id.btnRespostaUm);

        btnRespostaUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //codigo do radio --> C É A CERTA

                int pontos=0;
                String valorQuestao1;

                Intent um = new Intent(Tela1.this, Tela2.class);

                if(grpUm.getCheckedRadioButtonId() == R.id.alternativaCUM){
                    pontos += 1;
                    valorQuestao1 = String.valueOf(pontos);
                    um.putExtra("questaoUm",valorQuestao1);
                }
                else{
                    pontos += 0;
                    valorQuestao1 = String.valueOf(pontos);
                    um.putExtra("questaoUm", valorQuestao1);
                }

                um.putExtra("transfTela2", nomeTelaUm);
                Log.e("teste", "w" + pontos);
                startActivity(um);

            }
        });
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(Tela1.this, "Não tem como parar o quiz dos cria", Toast.LENGTH_SHORT).show();

    }

}