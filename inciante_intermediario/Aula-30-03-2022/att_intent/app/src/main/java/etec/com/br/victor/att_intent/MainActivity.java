package etec.com.br.victor.att_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnF, btnM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnF = findViewById(R.id.btnf);
        btnM = findViewById(R.id.btnm);

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Tela2 = new Intent(MainActivity.this, Tela2.class);
                startActivity(Tela2);

            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Tela3 = new Intent(MainActivity.this, Tela3.class);
                startActivity(Tela3);

            }
        });

    }
}