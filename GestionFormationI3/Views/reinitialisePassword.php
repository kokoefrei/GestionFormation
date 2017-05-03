<?php
    /*
    *   couche view
    */
?>

<!DOCTYPE HTML>
    <html>
        <head>
            <title>FORGET PASSWORD</title>
            <link href="Css/indexCss.css" style="text/css" rel="stylesheet">
            <meta lang="fr" charset="utf-8">
        </head>

        <body>
            <div align="center">
                <form action="#" method="POST">
                    <fieldset>
                        <legend> REINITIALISION MOT DE PASSE</legend>
                        <h4> IDENTIFIANT</h4>
                        <input type="text" name="mail" placeHolder="nom.prenom@M2L.com" required 
                               pattern="[A-Za-z0-9._-]+\.[A-Za-z0-9._-]+@M2L\.[a-z]{2,6}"
                                title="prenom.nom@M2L.com">
                        <h4> MOT CLE</h4>
                        <input type="text" name="keyword" placeHolder="Mot clé" required pattern="[\w-\s-éèêïîôûàâë-]+{1,256}">
                        <h4>NOUVEAU MOT DE PASSE:</h4>
                        <input type="password" name="mdp" placeHolder="MajusculeMinusculeChiffre"
                            required pattern="[A-Z]+[a-z]+[0-9]+" title="Mdp10"> <br>
                        <h4>
                            <input type="submit" name="submit" value="Reinitialiser"> 
                            <a href="index.php?page=Controllers/connexion.php"> 
                            <input type="button" value="Annuler">
                            </a>
                        </h4>
                    </fieldset>
               </form>
            </div>
        </body>
    </html>