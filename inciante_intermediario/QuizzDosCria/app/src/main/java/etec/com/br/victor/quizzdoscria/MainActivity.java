package etec.com.br.victor.quizzdoscria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nomeText;
    Button btnPrincipal, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeText = findViewById(R.id.nome);
        btnPrincipal = findViewById(R.id.btnPrincipal);
        btnSobre = findViewById(R.id.btnSobre);

        btnPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nomeText.getText().toString().isEmpty()) {

                    nomeText.setError("COLOCA O NOME AI PAE");
                    nomeText.requestFocus();

                }
                else{
                    String nomeTransf = nomeText.getText().toString();

                    Intent tela1 = new Intent(MainActivity.this, Tela1.class);
                    tela1.putExtra("transfTela1", nomeTransf);
                    startActivity(tela1);
                }
            }
        });

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaSobre = new Intent(MainActivity.this, Tela12.class);
                startActivity(telaSobre);

            }
        });
    }
}