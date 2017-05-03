<?php
    /*
     * couche Models
     */
    include_once 'Models/initDB.php';

    function connexion ($mail, $pass){
        $pdo = initDB();
        $pass = sha1($pass);
        $sql = "select count(*) from utilisateur where mailUtilisateur = :lemail and passeUtilisateur = :lepass";

        $stmt = $pdo->prepare($sql);
        $stmt->bindParam(':lemail', $mail);
        $stmt->bindParam(':lepass', $pass);

        if ($stmt->execute() === false)
        {
            echo "ERREUR DE LA REQUETE";
            $retour = false;
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
?>
