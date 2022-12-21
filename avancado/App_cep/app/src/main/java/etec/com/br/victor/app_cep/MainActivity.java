package etec.com.br.victor.app_cep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView logradouro, tipo_logradouro, bairro, cidade, uf;
    EditText edtCep;
    String cep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

    }

    public void btnBuscarCEP(View view) {
        if(edtCep.getText().length()<0){
            Toast.makeText(this, "Informe um cep para realizar a busca!", Toast.LENGTH_SHORT).show();
        } else {
            cep = edtCep.getText().toString();
            String endereco = "http://cep.republicavirtual.com.br/web_cep.php?cep="+cep+"&formato=json";
            buscar(endereco);
        }
    }

    public void buscar(String endereco){
        RequestQueue queue = Volley.newRequestQueue(this);
        //STRING - JSON
        StringRequest strReq = new StringRequest(Request.Method.GET, endereco, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject rua = null;
                try {
                    rua = new JSONObject(response);
                    if (rua.getString("resultado").equals("1")) {
                        logradouro.setText("Logradouro - " + rua.getString("tipo_logradouro"));
                        tipo_logradouro.setText("Tipo Logradouro - " + rua.getString("logradouro"));
                        bairro.setText("Bairro - " + rua.getString("bairro"));
                        cidade.setText("Cidade - " + rua.getString("cidade"));
                        uf.setText("UF - " + rua.getString("uf"));
                    } else {
                        Toast.makeText(MainActivity.this, "CEP não encontrado", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Erro: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams(){
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        queue.add(strReq);
    }

    public void btnLimparCampos(View view) {
        limpar();
    }

    private void limpar() {
        edtCep.setText("");
        edtCep.requestFocus();

        logradouro.setText("Logradouro - ");
        tipo_logradouro.setText("Tipo Logradouro - ");
        bairro.setText("Bairro - ");
        cidade.setText("Cidade - ");
        uf.setText("UF - ");
    }

    private void inicializarComponentes() {
        logradouro = findViewById(R.id.logradouro);
        tipo_logradouro = findViewById(R.id.tipo_logradouro);
        bairro = findViewById(R.id.bairro);
        cidade = findViewById(R.id.cidade);
        uf = findViewById(R.id.uf);
        edtCep = findViewById(R.id.cep);
    }
}