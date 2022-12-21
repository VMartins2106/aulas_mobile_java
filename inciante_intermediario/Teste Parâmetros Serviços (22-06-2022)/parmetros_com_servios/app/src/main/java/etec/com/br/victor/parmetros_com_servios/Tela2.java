package etec.com.br.victor.parmetros_com_servios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    //declarando textView's
    TextView nome, tel,email , end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //resgatando id's
        nome = findViewById(R.id.nomeCad);
        tel = findViewById(R.id.telCad);
        email = findViewById(R.id.emailCad);
        end = findViewById(R.id.endCad);

        //resgatando valores
        Intent telaAtual = getIntent();
        Bundle valoresCadastrados = telaAtual.getExtras();

        //definindo valores recebidos
        nome.setText(valoresCadastrados.getString("nome"));
        tel.setText(valoresCadastrados.getString("tel"));
        email.setText(valoresCadastrados.getString("email"));
        end.setText(valoresCadastrados.getString("end"));

    }

    //método para ligação
    public void ligar(View v){

        //construindo mensagem
        AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
        //título da mensagem
        mensagem.setTitle("Opções: ");
        //texto da mensagem
        mensagem.setMessage("O que deseja fazer ?");
        //botão positivo para ligar
        mensagem.setPositiveButton("Ligar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //comandos para ligar
                Uri ligacao = Uri.parse("tel:"+tel.getText().toString());
                Intent ligar = new Intent(Intent.ACTION_DIAL,ligacao);
                startActivity(ligar);

            }
        });
        //botao negativo para o whatsapp
        mensagem.setNegativeButton("Whatsapp", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String contact = "+55" + tel.getText().toString();//+55 é o código do brasil

                String url = "https://api.whatsapp.com/send?phone=" + contact;

                //verificar se o whatsapp está instalado
                try {
                    PackageManager pm = getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                    Intent whatsapp = new Intent(Intent.ACTION_VIEW);
                    whatsapp.setData(Uri.parse(url));
                    startActivity(whatsapp);

                }catch (PackageManager.NameNotFoundException e){
                    Toast.makeText(Tela2.this, "O whatsapp não está instalado neste telefone !", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
        //mostrar a mensagem do AlertDialog'
        mensagem.show();
    }

    //método para enviar o email
    public void email(View v){

        //conteúdo do email, corpo e etc
        String mailto = "mailto:" + email + "?cc=" + "" + "&Subject=" + Uri.encode("E-mail de teste pelo app") + "&body=" + Uri.encode("");

        //intent para enviar email
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

        //try catch para caso dê erro
        try {
            startActivity(emailIntent);
        }catch(ActivityNotFoundException e){
            //TODO: Handle case where no email app is
            Toast.makeText(this, "Erro ao enviar o e-mail" + e, Toast.LENGTH_SHORT).show();
        }
    }

    //método para abrir o google maps
    public void maps(View v){

        //criar Uri para endereco
        Uri UriMaps = Uri.parse("geo:0,0?q=" + end);
        Intent MapIntent = new Intent(Intent.ACTION_VIEW, UriMaps);
        //colocando para abrir maps
        MapIntent.setPackage("com.google.android.apps.maps");
        startActivity(MapIntent);

    }

}