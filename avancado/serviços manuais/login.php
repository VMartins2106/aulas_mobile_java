<?php

class Login implements JsonSerializable{

    //atributos da classe
    private $codigo;
    private $usuario;
    private $senha;
    private $nivel;

    //configurar a saída json
    function JsonSerializable(){
        return [

            'codigo' => $this->codigo,
            'usuario' => $this->usuario,
            'senha' => $this->senha,
            'nivel' => $this->nivel
            
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
        $comandoSql = "insert into tblogin (usuario,senha,nivel) values (?,?,?)";
        $valores = array($this->usuario, $this->senha, $this->nivel);
        $exec = $this->con->prepare($comandoSql);
        $exec-> execute($valores);
    }

    function atualizar(){
        $comandoSql = "alter table tblogin set usuario = ?, senha = ?, nivel = ? where codigo = ?";
        $valores = array($this->usuario, $this->senha, $this->nivel, $this->codigo);
        $exec = $this->con->prepare($comandoSql);
        $exec-> execute($valores);
    }

    function apagar(){
        $comandoSql = "delete from tblogin where codigo = ?";
        $valores = array($this->codigo);
        $exec = $this->con->prepare($comandoSql);
        $exec-> execute($valores);
    }

    function consultar(){
        $comandoSql = "select * from tblogin";
        $exec = $this->con->prepare($comandoSql);
        $exec->execute();

        $dados = array();
        $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
        return $dados;
    }

    //Consulta pelo código
    function consultarCodigo(){
        $comandoSql = "select * from tblogin where codigo = ?";
        $valores = array($this->codigo);
        $exec = $this->con->prepare($comandoSql);
        $exec->execute($valores);

        $dados = array();
        $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
        return $dados;
    }

}

?>