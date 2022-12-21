package etec.sp.gov.br.app_parametros.vitctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nome1, email1;
    Button cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome1 = findViewById(R.id.txtnome);
        email1 = findViewById(R.id.txtemail);
        cadastro = findViewById(R.id.btcadastrar);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome, email;

                nome = nome1.getText().toString();
                email = email1.getText().toString();

                Intent tela2 = new Intent(MainActivity.this,tela2.class);

                //conteúdo novo:
                tela2.putExtra("nomeCadastrado", nome);
                tela2.putExtra("emailCadastrado", email);

                startActivity(tela2);

            }
        });

    }
}