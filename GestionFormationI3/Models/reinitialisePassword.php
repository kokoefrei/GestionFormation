<?php
    /*
    *   couche Models
    */
    include_once 'Models/initDB.php';

    function checkUser($mail, $keyword){
        $pdo = initDB();
        $sql = "SELECT count(*) FROM utilisateur WHERE mailUtilisateur= :lemail and keywordUtilisateur= :lekeyword";
        $stmt = $pdo->prepare($sql);
        $stmt->bindParam(':lemail', $mail);
        $stmt->bindParam(':lekeyword', $keyword);

        if ($stmt->execute() === false)
        {
            $retour = "ERREUR DE LA REQUETE";
        }
        else
        {
            $tab = $stmt->fetch();
            if ($tab[0] == 1)
                $retour = true;
            else 
                $retour = false;
        }
        return $retour;
    }

    function reinitialise($mail, $keyword, $pass){
        $retour = true;
        
        if (checkUser($mail, $keyword)){
            $pass = sha1($pass);
            $pdo = initDB();
            
            $sql ="update utilisateur set passeUtilisateur=:lepass  where mailUtilisateur=:lemail and keywordUtilisateur=:lekeyword";
            
            $stmt = $pdo->prepare($sql);
            $stmt->bindParam(':lepass', $pass);
            $stmt->bindParam(':lemail', $mail);
            $stmt->bindParam (':lekeyword', $keyword);
            
            if ($stmt->execute()===false)
                $retour = false;
        }
        else{
            $retour = false;
        }
        return $retour;
    }
?>