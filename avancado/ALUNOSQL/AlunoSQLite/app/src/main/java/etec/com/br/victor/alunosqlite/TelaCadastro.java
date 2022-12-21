package etec.com.br.victor.alunosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    EditText edtNome, edtCurso, edtCidade, edtCPF, edtIdade, edtTelefone;
    TextView txtVariavel;
    Aluno aluno, altAluno;
    AlunoDAO alunoDAO;
    Button btnSalvar;
    long retornoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Intent telaAtual = getIntent();
        altAluno = (Aluno) telaAtual.getSerializableExtra("pessoa-enviada");
        aluno = new Aluno();

        inicializarComponentes();

        if (altAluno != null){
            btnSalvar.setText("Alterar Registro");
            //txVariavel.setText("Alteração");

            // PARA ATUALIZAÇÃO
            edtNome.setText(altAluno.getNome());
            edtCurso.setText(altAluno.getCurso());
            edtCidade.setText(altAluno.getCidade());
            edtCPF.setText(altAluno.getCpf());
            edtIdade.setText(altAluno.getIdade());
            edtTelefone.setText(altAluno.getTelefone());

            aluno.setId(altAluno.getId());
        }
        else{
            btnSalvar.setText("Salvar Registro");
            txtVariavel.setText("Cadastro");
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtNome.getText().toString().length() <= 0){
                    edtNome.setError("Digite o nome!");
                } else if(edtCurso.getText().toString().length() <= 0){
                    edtCurso.setError("Digite o curso!");
                } else if(edtCidade.getText().toString().length() <= 0) {
                    edtCidade.setError("Digite a cidade!");
                } else if(edtCPF.getText().toString().length() <= 0) {
                    edtCPF.setError("Digite o cpf!");
                } else if(edtIdade.getText().toString().length() <= 0) {
                    edtIdade.setError("Digite a idade!");
                } else if(edtTelefone.getText().toString().length() <= 0) {
                    edtTelefone.setError("Digite o telefone!");
                } else{

                    aluno.setNome(edtNome.getText().toString());
                    aluno.setCurso(edtCurso.getText().toString());
                    aluno.setCidade(edtCidade.getText().toString());
                    aluno.setCpf(edtCPF.getText().toString());
                    aluno.setIdade(Integer.parseInt(edtIdade.getText().toString()));
                    aluno.setTelefone(Integer.parseInt(edtTelefone.getText().toString()));

                    if(btnSalvar.getText().toString().equals("SALVAR CADASTRO")){
                        retornoDB = alunoDAO.salvarAluno(aluno);
                        alunoDAO.close();
                        if(retornoDB == -1){
                            mensagem("Erro ao cadastrar!");
                        } else{
                            mensagem("Cadastro com sucesso!");
                        }
                    } else {

                        //ALTERAÇÃO
                        retornoDB = alunoDAO.alterarAluno(aluno);
                        alunoDAO.close();
                        if(retornoDB == -1){
                            mensagem("Erro ao alterar cadastro!");
                        } else{
                            mensagem("Alteração realizada com sucesso!");
                        }
                    }

                    finish();

                }

            }
        });

    }

    private void mensagem(String s){

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    public void btnBuscar(View view) {

        Aluno a = new Aluno();
        a.setNome(edtNome.getText().toString());
        a.setCidade(edtCidade.getText().toString());

        alunoDAO = new AlunoDAO(TelaCadastro.this);

        a = alunoDAO.selectAlunoNome(a);

        if(a == null){
            Toast.makeText(TelaCadastro.this, "Não buscou", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(TelaCadastro.this, "Deu certo!", Toast.LENGTH_SHORT).show();
        }

    }

    public void inicializarComponentes(){

        edtNome = findViewById(R.id.edtNome);
        edtCurso = findViewById(R.id.edtCurso);
        edtCidade = findViewById(R.id.edtCidade);
        edtCPF = findViewById(R.id.edtCpf);
        edtIdade = findViewById(R.id.edtIdade);
        edtTelefone = findViewById(R.id.edtTelefone);
        txtVariavel = findViewById(R.id.txtVariavel);
        btnSalvar = findViewById(R.id.btnSalvar);

    }

}