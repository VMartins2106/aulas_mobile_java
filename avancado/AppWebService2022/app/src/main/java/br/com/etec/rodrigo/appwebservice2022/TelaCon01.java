package br.com.etec.rodrigo.appwebservice2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class TelaCon01 extends AppCompatActivity {

    Button btnCon01;
    EditText edtUsuario;
    ListView lstDados01;

    private List<Login> listaUsuario = new ArrayList<>();
    private ArrayAdapter<Login> adapterUsuario;
    Login pessoa = new Login();
    int codigo;

    String ip = "192.168.1.175";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_con01);

        edtUsuario = findViewById(R.id.edtBuscaUsuario);
        lstDados01 = findViewById(R.id.lstMostra01);
        btnCon01 = findViewById(R.id.btnBusca01);

        btnCon01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario.getText().toString();
                buscaNome(usuario);
            }
        });

    }

    public void buscaNome(String usuario){
        String endereco = "http://"+ip+"/bdescola/controller/loginController.php?acao=consultarUsuario";
        listaUsuario.clear();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, endereco,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray objArray = new JSONArray(response);
                            for(int i = 0; i < objArray.length(); i ++){
                                JSONObject obj = new JSONObject();
                                obj = (JSONObject)objArray.get(i);

                                Login objLogin = new Login();
                                objLogin.setCodigo(obj.getInt("codigo"));
                                objLogin.setUsuario(obj.getString("usuario"));
                                objLogin.setSenha(obj.getString("senha"));
                                listaUsuario.add(objLogin);
                            }
                            adapterUsuario = new ArrayAdapter<Login>(getApplicationContext(), android.R.layout.simple_list_item_1,listaUsuario);
                            lstDados01.setAdapter(adapterUsuario);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erro ao pesquisar " + error.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("usuario",usuario);
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
    }
}