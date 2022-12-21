package etec.com.br.victor.menuboom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.ramotion.circlemenu.CircleMenuView;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);

        final CircleMenuView menu = findViewById(R.id.circle_center);
        menu.setEventListener(new CircleMenuView.EventListener() {

            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationStart");
            }

            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationEnd");
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D", "onButtonClickAnimationStart/index" + buttonIndex);
                switch (buttonIndex){
                    case 0:
                        //HOME
                        txt.setText("INICIO");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "INICIO", Toast.LENGTH_SHORT).show();
                            }
                        },1000);
                        break;

                    case 1:
                        //CALENDÁRIO
                        txt.setText("CALENDARIO");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "CALENDARIO", Toast.LENGTH_SHORT).show();
                            }
                        },1000);
                        break;

                    case 2:
                        //NOTIFICAÇÕES
                        txt.setText("NOTIFICAÇÕES");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "NOTIFICAÇÕES", Toast.LENGTH_SHORT).show();
                            }
                        },1000);
                        break;

                    case 3:
                        //MUSICA
                        txt.setText("MUSICA");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "MUSICA", Toast.LENGTH_SHORT).show();
                            }
                        },1000);
                        break;
                    case 4:
                        txt.setText("CONFIGURAÇÕES");
                        //CONFIGURAÇÕES
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "CONFIGURAÇÕES", Toast.LENGTH_SHORT).show();
                            }
                        },800);
                        break;
                }
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D", "onButtonClickAnimationEnd/index" +buttonIndex);
            }

            @Override
            public boolean onButtonLongClick(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D", "onButtonLongClick/index" +buttonIndex);
                return true;
            }

            @Override
            public void onButtonLongClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D", "onButtonLongClickAnimationStart/index" +buttonIndex);
            }

            @Override
            public void onButtonLongClickAnimationEnd(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D", "onButtonLongClickAnimationEnd/index" +buttonIndex);
            }
        });
    }
}