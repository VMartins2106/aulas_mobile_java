package etec.com.br.web_services.victor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    Button cadastro, excluir, atualizar, limpar, consulta_um, consulta_dois;
    EditText usuario, senha, nivel;
    ListView listView;

    private List<Login> listaUsuario = new ArrayList<>();
    private ArrayAdapter<Login> adapterUsuario;
    Login pessoa = new Login();
    int codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        inicializarComponentes();
    }

    public void inicializarComponentes(){
        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        nivel = findViewById(R.id.nivel);
        cadastro = findViewById(R.id.cadastrar);
        atualizar = findViewById(R.id.atualizar);
        consulta_um = findViewById(R.id.consultar_um);
        consulta_dois = findViewById(R.id.consultar_dois);
        excluir = findViewById(R.id.excluir);
        limpar = findViewById(R.id.limpar);
        listView = findViewById(R.id.listview);
    }

    private void limparDados(){
        preenchelista();
        usuario.setText(null);
        senha.setText(null);
        nivel.setText(null);
    }

    private void preenchelista(){
        String endereco = "http://192.168.1.32/bdEscola/Controller/LoginController.php?acao=consultar";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.POST, endereco, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listaUsuario.clear();

                        try{
                            for (int i=0; i<response.length();i++){
                                JSONObject obj = response.getJSONObject(i);
                                Login objLogin = new Login();

                                objLogin.setCodigo(obj.getInt("codigo"));
                                objLogin.setUsuario(obj.getString("usuario"));
                                objLogin.setSenha(obj.getString("senha"));
                                objLogin.setNivel(obj.getInt("nivel"));

                                listaUsuario.add(objLogin);
                            }
                            adapterUsuario = new ArrayAdapter<Login>(MainActivity.this, android.R.layout.simple_list_item_1,listaUsuario);
                            listView.setAdapter(adapterUsuario);
                        } catch (JSONException e) {

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possivel receber os dados!", Toast.LENGTH_LONG).show();
                    }
                }
        );
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.getCache().clear();
        queue.add(jsonArrayRequest);
    }

    private void base(){
        String endereco = "http://192.168.1.32/bdEscola/Controller/LoginController.php?acao=consultar";
        StringRequest jar = new StringRequest(
                Request.Method.POST, endereco,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("ok")){
                            Toast.makeText(MainActivity.this, "Dados cadastrados", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possivel receber os dados!", Toast.LENGTH_LONG).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String,String>Params = new HashMap<>();
                Params.put("usuario", pessoa.getUsuario());
                Params.put("senha", pessoa.getSenha());
                Params.put("nivel", String.valueOf(pessoa.getNivel()));
                return Params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jar);
        queue.getCache().clear();
    }

    private void cadastrar(){
        String endereco = "http://192.168.1.32/bdEscola/Controller/LoginController.php?acao=cadastro";
        StringRequest jar = new StringRequest(
                Request.Method.POST, endereco,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("ok")){
                            Toast.makeText(MainActivity.this, "Dados cadastrados", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possivel receber os dados!", Toast.LENGTH_LONG).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String,String>Params = new HashMap<>();
                Params.put("usuario", pessoa.getUsuario());
                Params.put("senha", pessoa.getSenha());
                Params.put("nivel", String.valueOf(pessoa.getNivel()));
                return Params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jar);
        queue.getCache().clear();
    }

    private void atualizar(){
        String endereco = "http://192.168.1.32/bdEscola/Controller/LoginController.php?acao=atualizar";
        StringRequest jar = new StringRequest(
                Request.Method.POST, endereco,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("ok")){
                            Toast.makeText(MainActivity.this, "Dados atualizados", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possivel receber os dados!", Toast.LENGTH_LONG).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String,String>Params = new HashMap<>();
                Params.put("usuario", pessoa.getUsuario());
                Params.put("senha", pessoa.getSenha());
                Params.put("nivel", String.valueOf(pessoa.getNivel()));
                Params.put("codigo", String.valueOf(pessoa.getCodigo()));
                return Params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jar);
        queue.getCache().clear();
    }

    private void excluir(){
        String endereco = "http://192.168.1.32/bdEscola/Controller/LoginController.php?acao=excluir";
        StringRequest jar = new StringRequest(
                Request.Method.POST, endereco,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("ok")){
                            Toast.makeText(MainActivity.this, "Dados atualizados", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Não foi possivel receber os dados!", Toast.LENGTH_LONG).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String,String>Params = new HashMap<>();
                Params.put("codigo", String.valueOf(pessoa.getCodigo()));
                return Params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jar);
        queue.getCache().clear();
    }

}