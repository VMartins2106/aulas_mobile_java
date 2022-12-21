package etec.com.br.victor.quizzdoscria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tela12 extends AppCompatActivity {

    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela12);

        voltar = findViewById(R.id.btnVoltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent voltar = new Intent(Tela12.this, MainActivity.class);
                startActivity(voltar);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(Tela12.this, "Clique no botão de voltar", Toast.LENGTH_SHORT).show();

    }
}