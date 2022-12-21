package br.com.etec.rodrigo.appwebservice2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    Button btnCad, btnExc, btnAtu, btnCon, btnConUsu, btnLim;
    EditText edtUsuario, edtSenha, edtNivel;
    ListView lstDados;

    private List<Login> listaUsuario = new ArrayList<>();
    private ArrayAdapter<Login> adapterUsuario;
    Login pessoa = new Login();
    int codigo;

    String ip = "192.168.1.175";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNivel = findViewById(R.id.edtNivel);
        edtSenha = findViewById(R.id.edtSenha);
        edtUsuario = findViewById(R.id.edtUsuario);

        btnCad = findViewById(R.id.btnCadastro);
        btnAtu = findViewById(R.id.btnAtualizar);
        btnCon = findViewById(R.id.btnConsultar);
        btnConUsu = findViewById(R.id.btnConsultarUsu);
        btnExc = findViewById(R.id.btnExcluir);
        btnLim = findViewById(R.id.btnLimpar);

        lstDados = findViewById(R.id.lstDados);

        lstDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pessoa = (Login) parent.getItemAtPosition(position);
              //  Log.e("err",String.valueOf(pessoa.getNivel()));
                edtUsuario.setText(pessoa.getUsuario());
                edtNivel.setText(pessoa.getNivel());
                edtSenha.setText(pessoa.getSenha());
            }
        });

        preencheLista();
        btnLim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparDados();
            }
        });

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setUsuario(edtUsuario.getText().toString());
                pessoa.setSenha(edtSenha.getText().toString());
                pessoa.setNivel((edtNivel.getText().toString()));
                cadastrar();
                preencheLista();
                limparDados();
            }
        });
        btnAtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setUsuario(edtUsuario.getText().toString());
                pessoa.setSenha(edtSenha.getText().toString());
                pessoa.setNivel((edtNivel.getText().toString()));
                atualizar();
                preencheLista();
                limparDados();
            }
        });

        btnConUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,TelaCon02.class);
                startActivity(it);
            }
        });
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,TelaCon01.class);
                startActivity(it);
            }
        });
        btnExc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluir();
                preencheLista();
                limparDados();
            }
        });
    }

    private void limparDados(){
        preencheLista();
        edtUsuario.setText(null);
        edtSenha.setText(null);
        edtNivel.setText(null);
    }

    private void preencheLista(){
        String endereco = "http://"+ip+"/bdescola/controller/loginController.php?acao=consultar";
        JsonArrayRequest jar = new JsonArrayRequest(
                Request.Method.POST, endereco, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listaUsuario.clear();
                        try{
                          for (int i = 0; i<response.length(); i++){
                              JSONObject obj = response.getJSONObject(i);
                              Login objLogin = new Login();

                              objLogin.setCodigo(obj.getInt("codigo"));
                              objLogin.setUsuario(obj.getString("usuario"));
                              objLogin.setSenha(obj.getString("senha"));
                              objLogin.setNivel(obj.getString("nivel"));

                              listaUsuario.add(objLogin);
                          }
                          adapterUsuario = new ArrayAdapter<Login>(MainActivity.this,
                                  android.R.layout.simple_list_item_1, listaUsuario);
                          lstDados.setAdapter(adapterUsuario);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("erro", error.getMessage());
                        Toast.makeText(MainActivity.this, "Não foi possível receber os dados" + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

        );
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.getCache().clear();
        queue.add(jar);
    }

    private void cadastrar(){
        String endereco = "http://"+ip+"/bdescola/controller/loginController.php?acao=cadastro";
        StringRequest jar = new StringRequest(
                Request.Method.POST, endereco,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("ok")){
                            Toast.makeText(MainActivity.this, "Dados Cadastrados", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possível receber os dados" + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

        ){
          protected Map<String,String> getParams(){
              Map<String,String>params = new HashMap<>();
              params.put("usuario",pessoa.getUsuario());
              params.put("senha",pessoa.getSenha());
              params.put("nivel",String.valueOf(pessoa.getNivel()));
              return params;
          }
        };
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jar);
        queue.getCache().clear();
        preencheLista();
    }

    private void atualizar(){
        String endereco = "http://"+ip+"/bdescola/controller/loginController.php?acao=atualizar";
        StringRequest jar = new StringRequest(
                Request.Method.POST, endereco,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("ok")){
                            Toast.makeText(MainActivity.this, "Dados Atualizados", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possível receber os dados", Toast.LENGTH_SHORT).show();
                    }
                }

        ){
            protected Map<String,String> getParams(){
                Map<String,String>params = new HashMap<>();
                params.put("usuario",pessoa.getUsuario());
                params.put("senha",pessoa.getSenha());
                params.put("nivel",String.valueOf(pessoa.getNivel()));
                params.put("codigo",String.valueOf(pessoa.getCodigo()));
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jar);
        queue.getCache().clear();
    }
    private void excluir(){
        String endereco = "http://"+ip+"/bdescola/controller/loginController.php?acao=excluir";
        StringRequest jar = new StringRequest(
                Request.Method.POST, endereco,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("ok")){
                            Toast.makeText(MainActivity.this, "Usuário Excluído", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possível receber os dados", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            protected Map<String,String> getParams(){
                Map<String,String>params = new HashMap<>();
                params.put("codigo",String.valueOf(pessoa.getCodigo()));
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jar);
        queue.getCache().clear();
    }
}