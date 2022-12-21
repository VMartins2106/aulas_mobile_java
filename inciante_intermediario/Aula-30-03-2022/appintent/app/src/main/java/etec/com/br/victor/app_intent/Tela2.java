package etec.com.br.victor.app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    Button btVoltar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        btVoltar2 = findViewById(R.id.btnVoltaT2);

        btVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(Tela2.this, "CLIQUE NO BOTÃO DE VOLTAR", Toast.LENGTH_SHORT).show();

    }
}