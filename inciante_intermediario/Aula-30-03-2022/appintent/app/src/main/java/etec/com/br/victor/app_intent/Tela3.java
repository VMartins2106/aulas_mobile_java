package etec.com.br.victor.app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tela3 extends AppCompatActivity {

    Button btVoltar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        btVoltar3 = findViewById(R.id.btnVoltaT3);

        btVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               finish();

            }
        });

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(Tela3.this, "CLIQUE NO BOTÃO DE VOLTAR", Toast.LENGTH_SHORT).show();

    }
}