package etec.sp.gov.br.att_intent_externa.victor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user, pswd;
    Button logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txt1);
        pswd = findViewById(R.id.txt2);
        logar = findViewById(R.id.btlogar);        

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

		if (user.getText().toString().isEmpty()) {
            		user.setError("Usuário obrigatório!");
            		user.requestFocus();
        	}

        	else if (pswd.getText().toString().isEmpty()){
            		pswd.setError("Senha obrigatória!");
            		pswd.requestFocus();
        	}

		else{
                	String nome, senha;

                	nome = user.getText().toString();
                	senha = pswd.getText().toString();

                	Intent tela2 = new Intent(MainActivity.this, Tela2.class);
                	tela2.putExtra("userCadastrado", nome);
                	tela2.putExtra("senhaCadastrada", senha);
                	startActivity(tela2);
		}

            }
        });

    }
}