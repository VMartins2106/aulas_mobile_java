package etec.com.br.victor.parmetros_com_servios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declarar textView's
    EditText txtNome, txtFone, txtEmail, txtEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //resgatar textView's
        txtNome =findViewById(R.id.nome);
        txtFone = findViewById(R.id.telefone);
        txtEmail = findViewById(R.id.email);
        txtEndereco = findViewById(R.id.endereco);

    }

    public void cadastrar (View v){
        //criando intent e passando os parâmetros
        Intent tela2 = new Intent(MainActivity.this, Tela2.class);
        tela2.putExtra("nome", txtNome.getText().toString());
        tela2.putExtra("tel", txtFone.getText().toString());
        tela2.putExtra("email", txtEmail.getText().toString());
        tela2.putExtra("end", txtEndereco.getText().toString());
        startActivity(tela2);
        Toast.makeText(this, "Dados enviados com sucesso", Toast.LENGTH_SHORT).show();

    }

}