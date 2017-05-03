<?php
//	couche Controller
require_once 'Models/insciption.php';
echo "Nb Users: ".counter();


function pattern($pattern, $variable, $nomVariable, $message, $count) {
	if (! isset ( $variable ) || ! preg_match ( $pattern, $variable )) {
		$message = "votre " . $nomVariable . "est vide ou non conforme <br />";
		$count ++;
	}
}
 session_start ();

 
if (isset ( $_POST ['submit'] )) {
	extract ( $_POST );
	$i = 0;
	$mess = "";

	// cryptage du mot de passe
	if (isset($mdp))
		$pass = sha1 ( $mdp );

	// Pattern du nom
	if (isset($nom))
	{
		$patternNom = '#[A-Za-z-\s]+#';
		$nomVariable = "nom";
		pattern ( $patternNom, $nom, $nomVariable, $mess, $i );
	}

	// Pattern du prénom
	if (isset($prenom))
	{
		$patternPrenom = "#[A-Za-z-\s]+#";
		$nomVariable = "prénom";
		pattern ( $patternPrenom, $prenom, $nomVariable, $mess, $i );
	}

	// Pattern de l'email
	if (isset ($mail)){
		$patternEmail = '#[A-Za-z0-9._-]+\.[A-Za-z0-9._-]+@M2L\.[a-z]{2,6}#';
		$nomVariable = 'email';
		pattern ( $patternEmail, $mail, $nomVariable, $mess, $i );
	}

	// Pattern du chef
	if (isset ($chef)){
		$patternChef = '#[[A-Za-z0-9._-]+\.[A-Za-z0-9._-]+@M2L\.[a-z]{2,6}#';
		$nomVariable = 'chef';
		pattern ( $patternChef, $chef, $nomVariable, $mess, $i );
	}
	
	//pattern mot clé
	if (isset($keyword)){
		$patternKeyword = '#[\w-\s-éèêïîôûàâë-]{1,256}#';
		$nomVariable = 'keyword';
		pattern ($patternKeyword, $keyword, $nomVariable, $mess, $i);
	}

	if ($i > 0) {
		echo "vous avez $i erreur (s) <br />";
		echo $mess;
	} 
	elseif ($i == 0) {
		if (! (empty ( $chef ))) {
			if (! checkChief ( $chef )) {
				echo '<div align="center">';
				echo "Désolé le Chef  $chef  n'existe pas";
				echo '</div>';
			}
			else{
                addUser ( $nom, $prenom, $pass, $mail, $keyword, $chef );
                $_SESSION ['inscription'] = "ok";
                $_SESSION ['id'] = $mail;
                $_SESSION ['pass'] = $mdp;
                $_SESSION ['chef'] = $chef;
                $_SESSION['keyword'] = $keyword;
                header ('location: index.php?page=Controllers/connexion.php');
			}
		}
	}
}
require_once 'Views/inscription.php';