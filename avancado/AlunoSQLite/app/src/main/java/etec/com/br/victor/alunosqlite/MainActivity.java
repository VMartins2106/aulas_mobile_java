package etec.com.br.victor.alunosqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaPessoas;
    ProgressBar pb;
    Pessoa pessoa;
    PessoaDAO pessoaDAO;
    ArrayList<Pessoa> arrayListPessoa;
    ArrayAdapter<Pessoa> arrayAdapterPessoa;
    long retornoBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        //PARA EXCLUIR
        registerForContextMenu(listaPessoas);//se der erro

        //CLIQUE SIMPLES PARA EDITAR
        listaPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pessoa pessoaEnviada = arrayAdapterPessoa.getItem(position);
                Intent editar = new Intent(MainActivity.this, TelaCadastro.class);
                editar.putExtra("pessoa-enviada", (Serializable) pessoaEnviada);
                startActivity(editar);

            }
        });

        //CLIQUE LONGO PARA EXCLUIR
        listaPessoas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                pessoa = arrayAdapterPessoa.getItem(position);
                return false;

            }
        });

    }

    public void preencheLista() {

        //MÉTODO RESPONSÁVEL POR REALIZAR UMA SELECT NO BANCO DE DADOS
        //E APRESENTAR NA LISTVIEW - OBJETO DE TELA
        pessoaDAO = new PessoaDAO(MainActivity.this);
        arrayListPessoa = pessoaDAO.selectAllPessoa();
        pessoaDAO.close();

        if (listaPessoas != null) {

            arrayAdapterPessoa = new ArrayAdapter<Pessoa>(MainActivity.this,
                    android.R.layout.simple_list_item_1, arrayListPessoa);
            listaPessoas.setAdapter(arrayAdapterPessoa);

        }

    }

    //ESTADO DE VIDA DA ACTIVITY
    //CHAMADO SEMPRE QUE HÁ UMA ATUALIZAÇÃO DA TELA


    @Override
    protected void onResume() {
        super.onResume();

        preencheLista();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem mDelete = menu.add("Apagar Registro");

        mDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                pessoaDAO = new PessoaDAO(MainActivity.this);

                AlertDialog.Builder msgExcluir = new AlertDialog.Builder(MainActivity.this);
                msgExcluir.setTitle("Excluir");
                msgExcluir.setMessage("Confirma exclusão de registro?");
                msgExcluir.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*retornoBD = AlunoDAO.excluirAluno(aluno);
                        AlunoDAO.close();*/

                        if (retornoBD == -1){
                            mensagemToast("Erro ao excluir");
                        }else{
                            mensagemToast("Excluido com sucesso");
                            preencheLista();
                        }
                    }
                });
                msgExcluir.setNegativeButton("NÃO", null);
                msgExcluir.setCancelable(false);
                msgExcluir.setIcon(getResources().getDrawable(R.drawable.ic_limpar));
                msgExcluir.show();

                return false;
            }
        });
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void mensagemToast(String s){

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    public class Async extends AsyncTask<Void, Integer, Void>{

        @Override
        protected void onPreExecute(){
            //super.onPreExecute();
            pb.setVisibility(View.VISIBLE);

        }
        @Override
        protected Void doInBackground(Void... voids){

            preencheLista();
            return null;

        }
        @Override
        protected void onPostExecute(Void aVoid){

            //super.onPostExecute(aVoid);
            pb.setVisibility(View.INVISIBLE);

        }

    }

    //BOTÃO CADASTRAR
    public void btnCadastrar(View view) {

        Intent cadastro = new Intent(MainActivity.this, TelaCadastro.class);
        startActivity(cadastro);

    }

    //INICIALIZANDO COMPONENTES DECLARADOS
    public void iniciarComponentes(){

        listaPessoas = findViewById(R.id.listView);
        pb = findViewById(R.id.progress_bar);

    }

}