package com.example.vitao.appradiogroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText salario;
    RadioGroup rgp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularSalario(View v){

        Float valor, novoSalario=0F;

        salario = findViewById(R.id.txtValue);
        rgp = findViewById(R.id.rgpOpcoes);

        if(salario.getText().toString().length()<=0){
            salario.setError("Informe seu salário!");
        }
        else{

            valor = Float.parseFloat(salario.getText().toString());
            int op = rgp.getCheckedRadioButtonId();

            if(op==R.id.r40){
                novoSalario = valor + (valor*0.40F);
            }
            else if(op==R.id.r45){
                novoSalario = valor + (valor*0.45F);
            }
            else if(op==R.id.r50){
                novoSalario = valor + (valor*0.50F);
            }

            /*EXIBINDO EM TOAST
            Toast.makeText(MainActivity.this, "Seu novo salário é: R$" +novoSalario, Toast.LENGTH_SHORT).show();*/

            //EXIBINDO EM ALERT DIALOG
            AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
            mensagem.setTitle("Resultado");
            mensagem.setMessage("Seu novo salário é: R$ " +novoSalario);
            mensagem.setNeutralButton("Ok", null);
            mensagem.setCancelable(false);
            mensagem.show();

        }

    }

}