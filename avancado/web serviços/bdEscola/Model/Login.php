<?php
    class Login implements JsonSerializable{
        private $codigo;
        private $usuario;
        private $senha;
        private $nivel;

        function jsonSerialize(){
            return[
                'codigo' => $this->codigo,
                'usuario' => $this->usuario,
                'senha' => $this->senha,
                'nivel' => $this->nivel
            ];
        }

        function __set($atributo, $value){
            $this->$atributo = $value;
        }

        function __get($atributo, $value){
            return $this->$atributo;
        }

        private $con;

        function __construct(){
            include("Conexao.php");
            $classe_con = new Conexao();
            $this->con = $classe_con->conectar();
        }

        function cadastrar(){
            $comandoSql = "INSERT INTO tblogin (usuario, senha, nivel) VALUES (?,?,?)";
            $valores = array($this->usuario, $this->senha, $this->nivel);
            $exec = $this->con->prepare($comandoSql);
            $exec->execute($valores);
        }

        function atualizar(){
            $comandoSql = "UPDATE tblogin set usuario = ?, senha = ?, nivel = ? WHERE codigo = ?";
            $valores = array($this->usuario, $this->senha, $this->nivel, $this->codigo);
            $exec = $this->con->prepare($comandoSql);
            $exec->execute($valores);
        }

        function excluir(){
            $comandoSql = "DELETE FROM tblogin WHERE codigo = ?";
            $valores = array($this->codigo);
            $exec = $this->con->prepare($comandoSql);
            $exec->execute($valores);
        }

        function consultar(){
            $comandoSql = "SELECT * FROM tblogin";
            $exec = $this->con->prepare($comandoSql);
            $exec->execute();
            $dados = array();
            $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
            return $dados;
        }

        function consultarCodigo(){
            $comandoSql = "SELECT * FROM tblogin WHERE codigo = ?";
            $valores = array($this->codigo);
            $exec = $this->con->prepare($comandoSql);
            $exec->execute($valores);
            $dados = array();
            $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
            return $dados;
        }

        function consultarUsuario(){
            $comandoSql = "SELECT * FROM tblogin WHERE usuario LIKE ?";
            $valores = array("%".$this->usuario."%");
            $exec = $this->con->prepare($comandoSql);
            $exec->execute($valores);
            $dados = array();
            $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
            return $dados;
        }

        function logar(){
            $comandoSql = "SELECT usuario, senha FROM tblogin WHERE usuario = ? AND senha = ?";
            $valores = array($this->usuario, $this->senha);
            $exec = $this->con->prepare($comandoSql);
            $exec->execute($valores);
            $dados = array();
            $dados = $exec->fetchAll(PDO::FETCH_ASSOC);
            return $dados;
        }
    }
?>