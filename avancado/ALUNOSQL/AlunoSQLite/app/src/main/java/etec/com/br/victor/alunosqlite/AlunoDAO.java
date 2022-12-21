package etec.com.br.victor.alunosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AlunoDAO extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBAluno.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "tbpessoa";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String CURSO = "curso";
    private static final String CIDADE = "cidade";
    private static final String CPF = "cpf";
    private static final String IDADE = "idade";
    private static final String TELEFONE = "telefone";


    public AlunoDAO(Context context){

        super(context, NOME_BANCO, null, VERSAO);

    }

    //TABELA DE CADASTRO

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABELA + " ( " +
                " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " " + NOME + " TEXT, " + IDADE + " INTEGER, " +
                " " + CURSO + " TEXT, " + CIDADE + " TEXT, " +
                " " + CPF + " CHAR(11), " + IDADE + " INT, " +
                " " + TELEFONE + " TEXT);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = " DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public long salvarAluno(Aluno a){

        ContentValues valores = new ContentValues();
        long retornoDB;
        valores.put(NOME, a.getNome());
        valores.put(CURSO, a.getCurso());
        valores.put(CIDADE, a.getCidade());
        valores.put(CPF, a.getCpf());
        valores.put(IDADE, a.getIdade());
        valores.put(TELEFONE, a.getTelefone());

        retornoDB = getWritableDatabase().insert(TABELA, null, valores);


        return retornoDB;

    }

    //TABELA DE ALTERAÇÃO

    public long alterarAluno(Aluno a){

        ContentValues valores = new ContentValues();
        long retornoDB;
        valores.put(NOME, a.getNome());
        valores.put(CURSO, a.getCurso());
        valores.put(CIDADE, a.getCidade());
        valores.put(CPF, a.getCpf());
        valores.put(IDADE, a.getIdade());
        valores.put(TELEFONE, a.getTelefone());

        String[] args = {String.valueOf(a.getId())};

        retornoDB = getWritableDatabase().update(TABELA, valores, "id=?", args);

        return retornoDB;

    }

    //TABELA DE EXCLUSÃO

    public long excluirAluno(Aluno a){

        long retornoDB;

        String[] args = {String.valueOf(a.getId())};
        retornoDB = getWritableDatabase().delete(TABELA, ID + "=?", args);

        return retornoDB;

    }

    //CONSULTAS:

    //GERAL
    public ArrayList<Aluno> selectAllAluno(){

        String[] colunas = {ID, NOME, CURSO, CIDADE, CPF, IDADE, TELEFONE};

        Cursor cursor = getWritableDatabase().query(TABELA, colunas, null,
                null, null, null, "upper(nome)", null);

        ArrayList<Aluno> listaAluno = new ArrayList<>();

        while (cursor.moveToNext()){

            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setCurso(cursor.getString(2));
            a.setCidade(cursor.getString(3));
            a.setCpf(cursor.getString(4));
            a.setIdade(cursor.getInt(5));
            a.setTelefone(cursor.getInt(6));
            listaAluno.add(a);

        }

        return listaAluno;

    }

    //POR NOME

    public Aluno selectAlunoNome(Aluno a){

        String[] colunas = {ID, NOME, CURSO, CIDADE, CPF, IDADE, TELEFONE};

        String nomeBusca = a.getNome();
        Aluno al = null;

        Cursor cursor = getWritableDatabase().query(TABELA, colunas, NOME + "= ?",
                new String[]{nomeBusca}, null, null, "upper(nome)", null);
        while (cursor.moveToNext()){

            al = new Aluno();
            al.setId(cursor.getInt(0));
            al.setNome(cursor.getString(1));
            al.setCurso(cursor.getString(2));
            al.setCidade(cursor.getString(3));
            al.setCpf(cursor.getString(4));
            al.setIdade(cursor.getInt(5));
            al.setTelefone(cursor.getInt(6));

        }

        return al;

    }

    //POR CPF

    public Aluno selectAlunoCpf(Aluno c){

        String[] colunas = {ID, NOME, CURSO, CIDADE, CPF, IDADE, TELEFONE};

        String cpfBusca = c.getCpf();
        Aluno al = null;

        Cursor cursor = getWritableDatabase().query(TABELA, colunas, CPF + "= ?",
                new String[]{cpfBusca}, null, null, "upper(nome)", null);
        while (cursor.moveToNext()){

            al = new Aluno();
            al.setId(cursor.getInt(0));
            al.setNome(cursor.getString(1));
            al.setCurso(cursor.getString(2));
            al.setCidade(cursor.getString(3));
            al.setCpf(cursor.getString(4));
            al.setIdade(cursor.getInt(5));
            al.setTelefone(cursor.getInt(6));

        }

        return al;

    }

    //POR CIDADE

    public Aluno selectAlunoCidade(Aluno c){

        String[] colunas = {ID, NOME, CURSO, CIDADE, CPF, IDADE, TELEFONE};

        String cidadeBusca = c.getCidade();
        Aluno al = null;

        Cursor cursor = getWritableDatabase().query(TABELA, colunas, NOME + "= ?",
                new String[]{cidadeBusca}, null, null, "upper(nome)", null);
        while (cursor.moveToNext()){

            al = new Aluno();
            al.setId(cursor.getInt(0));
            al.setNome(cursor.getString(1));
            al.setCurso(cursor.getString(2));
            al.setCidade(cursor.getString(3));
            al.setCpf(cursor.getString(4));
            al.setIdade(cursor.getInt(5));
            al.setTelefone(cursor.getInt(6));

        }

        return al;

    }

}
