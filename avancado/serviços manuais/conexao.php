<?php

class Conexao{
    function conectar(){
        $con = new PDO("mysql:host=localhost;dbname=bdescola","root","");
        $con->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
        return $con;
    }
}

?>