<?php

class Aluno implements JsonSerializable{

    //atributos da classe
    private $codigo;
    private $nome;
    private $turma;
    private $ra;
    private $curso;
    private $modulo;

    //configurar a saída json
    function JsonSerializable(){
        return [

            'codigo' => $this->codigo,
            'nome' => $this->nome,
            'turma' => $this->turma,
            'ra' => $this->ra,
            'curso' => $this->curso,
            'modulo' => $this->modulo
            
        ];
    }

    //get e set
    function __set($atributo, $value){
        $this->$atributo = $value;
    }
    function __get($atributo){
        return $this->$atributo;
    }

    //acessando a conexão com o bando de dados
    private $con;
    function __construct(){
        include("conexao.php");
        $classe_con = new Conexao();
        $this->$con = $classe_con->conectar();
    }

    function cadastrar(){
        $comandoSql = "insert into tbaluno (nome,turma,ra,curso,modulo) values (?,?,?,?,?)";
        $valores = array($this->nome, $this->turma, $this->ra, $this->curso, $this->modulo);
        $exec = $this->con->prepare($comandoSql);
        $exec-> execute($valores);
    }

    function atualizar(){
        $comandoSql = "alter table tbaluno set nome = ?, turma = ?, ra = ?, curso = ?, modulo = ? where codigo = ?";
        $valores = array($this->nome, $this->turma, $this->ra, $this->curso, $this->modulo, $this->codigo);
        $exec = $this->con->prepare($comandoSql);
        $exec-> execute($valores);
    }

    function apagar(){
        $comandoSql = "delete from tbaluno where codigo = ?";
        $valores = array($this->codigo);
        $exec = $this->con->prepare($comandoSql);
        $exec-> execute($valores);
    }

    function consultar(){
        $comandoSql = "select * from tbaluno";
        $exec = $this->con->prepare($comandoSql);
        $exec->execute();

        $dados = array();
        $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
        return $dados;
    }

    //Consulta pelo código
    function consultarCodigo(){
        $comandoSql = "select * from tbaluno where codigo = ?";
        $valores = array($this->codigo);
        $exec = $this->con->prepare($comandoSql);
        $exec->execute($valores);

        $dados = array();
        $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
        return $dados;
    }

}

?>