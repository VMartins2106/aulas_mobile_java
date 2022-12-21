package etec.com.br.victor.teste_som;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView comecar, parar, comecarDois, pararDois, foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comecar = findViewById(R.id.executarSom);
        parar = findViewById(R.id.pararMusica);
        comecarDois = findViewById(R.id.asitwas);
        pararDois = findViewById(R.id.pararMusicaDois);
        foto = findViewById(R.id.testeFoto);

        MediaPlayer musica = MediaPlayer.create(this, R.raw.asitwas);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.paiefoda);
        MediaPlayer botons = MediaPlayer.create(this, R.raw.botoni);

        comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    comecar.setImageResource(R.drawable.ic_play);
                }
                else{
                    mediaPlayer.start();
                    comecar.setImageResource(R.drawable.ic_pause);
                }

            }
        });

        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }

            }
        });

        comecarDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (musica.isPlaying()){
                    musica.pause();
                    comecarDois.setImageResource(R.drawable.ic_play);
                }
                else{
                    musica.start();
                    comecarDois.setImageResource(R.drawable.ic_pause);
                }

            }
        });

        pararDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(musica.isPlaying()){
                    musica.stop();
                }

            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                botons.start();
                foto.setImageResource(R.drawable.botonii);

            }
        });

    }
}