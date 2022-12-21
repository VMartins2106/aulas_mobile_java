package etec.com.br.victor.primeiroexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome, senha;
    Button logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nome.getText().toString();
                String pswd = senha.getText().toString();

                if((name.equals("Victor") || name.equals("victor")) && pswd.equals("victor2004")){
                    Toast.makeText(MainActivity.this, "LOGADO !!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Nome e/ou senha estão incorretas", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void inicializarComponentes(){

        nome = findViewById(R.id.nome);
        senha = findViewById(R.id.senha);
        logar = findViewById(R.id.logar);

    }

}