package etec.com.br.victor.att_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tela3 extends AppCompatActivity {

    Button btnC, btnV;
    EditText valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        btnC = findViewById(R.id.btnCalcularM);
        btnV = findViewById(R.id.btnVoltaM);
        valor = findViewById(R.id.valor2);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float h, peso=0F;

                if (valor.getText().toString().isEmpty())
                {
                    valor.setError("Temperatura necessária!");
                    valor.requestFocus();
                }

                else {
                    h = Float.parseFloat(valor.getText().toString());
                    peso = (62.1F * h)- 44.7F;
                }

                Toast.makeText(Tela3.this, "O peso ideal é de: " + peso, Toast.LENGTH_SHORT).show();

            }
        });

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }

    @Override
    public void onBackPressed(){

        Toast.makeText(Tela3.this, "CLIQUE NO BOTÃO DE VOLTAR", Toast.LENGTH_SHORT).show();

    }
}