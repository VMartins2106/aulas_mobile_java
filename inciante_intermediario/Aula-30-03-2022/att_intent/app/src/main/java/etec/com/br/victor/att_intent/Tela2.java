package etec.com.br.victor.att_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

public class Tela2 extends AppCompatActivity {

    Button btnC, btnV;
    EditText valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        btnC = findViewById(R.id.btnCalcularF);
        btnV = findViewById(R.id.btnVoltaF);
        valor = findViewById(R.id.valor1);

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
                    peso = (72.7F * h)- 58F;
                }

                Toast.makeText(Tela2.this, "O peso ideal é de: " + peso, Toast.LENGTH_SHORT).show();
                
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

        Toast.makeText(Tela2.this, "CLIQUE NO BOTÃO DE VOLTAR", Toast.LENGTH_SHORT).show();

    }
}