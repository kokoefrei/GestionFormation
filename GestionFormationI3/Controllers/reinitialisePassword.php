<?php
    /*
    *   couche controller
    */
    require_once 'Models/reinitialisePassword.php';
    session_start();

    if (isset($_SESSION['inscription']))
            unset ($_SESSION['inscription']);

        //Vérification du pattern de connexion
        function pattern($pattern, $variable, $nomVariable,$message, $count) {
            if (! isset ( $varaible ) || ! preg_match ( $pattern, $variable )) {
                $message = $message. "\nvotre " . $nomVariable . "est vide ou non conforme <br />";
                $count ++;
            }
        }

        //If user submit the form
        if (isset ( $_POST ['submit'] )) {
            extract ( $_POST );
            $i = 0;
            $mess = "";

            // identifiant
                $patternEmail = '#[A-Za-z0-9._-]+\.[A-Za-z0-9._-]+@M2L\.[a-z]{2,6}#';
                $nomVariable = 'adresse email';
                pattern ( $patternEmail, $mail, $nomVariable, $mess, $i );

            //mot clé
                $patternKeyword = '#[\w-\s-éèêïîôûàâë-]{1,256}#';
                $nomVariable = 'mot clé';
                pattern ($patternKeyword, $keyword, $nomVariable, $mess, $i);

            //mot de passe
                $patternPassword = "#[A-Z]+[a-z]+[0-9]+#";
                $nomVariable = 'mot de passe';
                pattern ($patternPassword, $mdp, $nomVariable, $mess, $i);

            if ($i > 0) {
            echo "vous avez $i erreur (s) <br />";
            echo $mess;
           } 
            else{
                    if(reinitialise($mail, $keyword, $mdp)){
                        if(isset($_SESSION['reinitialise'])){
                            unset($_SESSION['reinitialise']);
                        }
                        $_SESSION['reinitialise'] = 'ok';
                        
                        if(isset($_SESSION['id'])){
                            unset ($_SESSION['id']);
                        }
                        $_SESSION['id'] = $mail;
                        
                        if(isset($_SESSION['pass'])){
                            unset ($_SESSION['pass']);
                        }     
                        $_SESSION['pass'] =$mdp ;
                        
                        header('location:index.php?page=Controllers/connexion.php');
                }
                else{
                    echo '<center><h2>INFORMATIONS ERRONNEES</h2></center>';   
                }
            }

        }

        require_once 'Views/reinitialisePassword.php';

?>
    
