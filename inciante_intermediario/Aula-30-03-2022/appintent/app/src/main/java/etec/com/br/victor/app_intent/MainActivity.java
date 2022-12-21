package etec.com.br.victor.app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btUm, btDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btUm = findViewById(R.id.btnt2);
        btDois = findViewById(R.id.btnt3);

        btUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tela2 = new Intent(MainActivity.this, Tela2.class);
                startActivity(tela2);

            }
        });

        btDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tela3 = new Intent(MainActivity.this, Tela3.class);
                startActivity(tela3);

            }
        });

    }
}