package etec.sp.gov.br.app_parametros.vitctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tela2 extends AppCompatActivity {

    TextView nome2, email2;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        nome2 = findViewById(R.id.txnome);
        email2 = findViewById(R.id.txemail);
        voltar = findViewById(R.id.btvoltar);

        Intent telaAtual = getIntent();

        Bundle valoresRecebidos = telaAtual.getExtras();

        nome2.setText(valoresRecebidos.getString("nomeCadastrado"));
        email2.setText(valoresRecebidos.getString("emailCadastrado"));

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(tela2.this, "CLIQUE NO BOTÃO DE VOLTAR", Toast.LENGTH_SHORT).show();
    }
}