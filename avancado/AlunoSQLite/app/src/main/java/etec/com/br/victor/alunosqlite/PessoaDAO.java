package etec.com.br.victor.alunosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class PessoaDAO extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBPessoa.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "tbpessoa";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String IDADE = "idade";
    private static final String EMAIL = "email";
    private static final String ENDERECO = "endereco";

    public PessoaDAO(Context context) {
        //CRIAÇÃO DO BANCO DE DADOS
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CRIAÇÃO DA TABELA
        String sql = "CREATE TABLE " + TABELA + " ( " +
                " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " " + NOME + " TEXT, " + IDADE + " INTEGER, " +
                " " + EMAIL + " TEXT, " + ENDERECO + " TEXT );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ATUALIZAÇÃO DA TABELA PELA VERSÃO DO BANCO
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }


    public long salvarPessoa(Pessoa p) {
        ContentValues valores = new ContentValues();
        long retornoDB;
        valores.put(NOME, p.getNome());
        valores.put(IDADE, p.getIdade());
        valores.put(EMAIL, p.getEmail());
        valores.put(ENDERECO, p.getEndereco());

        retornoDB = getWritableDatabase().insert(TABELA, null, valores);

        return retornoDB;
    }

    public long alterarPessoa(Pessoa p) {
        ContentValues valores = new ContentValues();
        long retornoDB;
        valores.put(NOME, p.getNome());
        valores.put(IDADE, p.getIdade());
        valores.put(EMAIL, p.getEmail());
        valores.put(ENDERECO, p.getEndereco());

        String[] args = {String.valueOf(p.getId())};
        retornoDB = getWritableDatabase().
                update(TABELA, valores, "id=?", args);

        return retornoDB;
    }


    public long excluirPessoa(Pessoa p) {

        long retornoDB;

        String[] args = {String.valueOf(p.getId())};
        retornoDB = getWritableDatabase().
                delete(TABELA, ID + "=?", args);

        return retornoDB;
    }


    //SELECIONAR REGISTROS PARA PREENCHER A LISTA DA TELA PRINCIPAL
    public Pessoa selectAllPessoa(Pessoa pe) {
        String[] colunas = {ID, NOME, IDADE, EMAIL, ENDERECO};

        String nomeBusca = pe.getNome();
        String emailBusca = pe.getEmail();
        Pessoa p = null;

        Cursor cursor = getWritableDatabase()
                .query(TABELA, colunas, NOME + " = ? AND " + EMAIL + " = ?", new String[]{nomeBusca, emailBusca},
                        null, null, "upper(nome)", null);
        while (cursor.moveToNext()) {

            p = new Pessoa();
            p.setId(cursor.getInt(0)); //0 é o índice do campo id no bd
            p.setNome(cursor.getString(1));
            p.setIdade(cursor.getInt(2));
            p.setEmail(cursor.getString(3));
            p.setEndereco(cursor.getString(4));


        }
        return p;
    }


    //SELECIONAR REGISTROS PARA PREENCHER A LISTA DA TELA PRINCIPAL
    public ArrayList<Pessoa> selectAllPessoa() {
        String[] colunas = {ID, NOME, IDADE, EMAIL, ENDERECO};

        //EXIBIR EM ORDEM DE CADASTRO
        /*Cursor cursor = getWritableDatabase()
         .query(TABELA,colunas,null,null,null,null,null,null);*/

        //EXIBIR EM ORDEM ALFABÉTICA
        Cursor cursor = getWritableDatabase()
                .query(TABELA, colunas, null, null,
                        null, null, "upper(nome)", null);


        ArrayList<Pessoa> listPessoa = new ArrayList<Pessoa>();


        // database.query(MeuDBHelper.TABLE_CONTATOS,
        // todasColunas,
        // MeuDBHelper.COLUMN_NOME + " like '%?%' AND " + MeuDBHelper.COLUMN_TELEFONE + " = ?",
        // new String[] { nome, telefone},
        // null, null, null);


        while (cursor.moveToNext()) {
            Pessoa p = new Pessoa();
            p.setId(cursor.getInt(0)); //0 é o índice do campo id no bd
            p.setNome(cursor.getString(1));
            p.setIdade(cursor.getInt(2));
            p.setEmail(cursor.getString(3));
            p.setEndereco(cursor.getString(4));

            listPessoa.add(p);
        }

        return listPessoa;
    }
}
