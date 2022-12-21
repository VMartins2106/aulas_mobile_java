<?php
    include_once("../Model/Login.php");

    $login = new Login();

    if (isset($_REQUEST["acao"])) {
        switch ($_RESQUEST["acao"]) {
            case 'cadastro':
                $login->usuario = $_POST["usuario"];
                $login->senha = $_POST["senha"];
                $login->nivel = $_POST["nivel"];
                $login->cadastrar();
                echo "ok";
                break;
            
            case 'atulizar':
                $login->usuario = $_POST["usuario"];
                $login->senha = $_POST["senha"];
                $login->nivel = $_POST["nivel"];
                $login->codigo = $_POST["codigo"];
                $login->atualizar();
                echo "ok";
                break;

            case 'excluir':
                $login->codigo = $_POST["codigo"];
                $login->excluir();
                echo "ok";
                break;

            case 'consultar':
                echo json_encode($login->consultar());
                break;

            case 'consultarCodigo':
                $login->codigo = $_POST["codigo"];
                echo json_encode($login->consultarCodigo());
                break;

            case 'consultarCodigo':
                $login->usuario = $_POST["usuario"];
                echo json_encode($login->consultarUsuario());
                break;

            case 'logar':
                $login->usuario = $_POST["usuario"];
                $login->senha = $_POST["senha"];
                echo json_encode($login->logar());
                break;
        }
    }
?>