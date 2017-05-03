<?php
/*
 * couche Controller
 */
require_once 'Models/connexion.php';
session_start ();

//Vérification du pattern de connexion
function pattern($pattern, $variable, $nomVariable,$message, $count) {
	if (! isset ( $varaible ) || ! preg_match ( $pattern, $variable)) {
		$message = $message. "\nvotre " . $nomVariable . "est vide ou non conforme <br />";
		$count ++;
	}
}


//Si l'utilisateur se connecte
if (isset ( $_POST ['submit'] )) {
	extract ( $_POST );
	$i = 0;
	$mess = "";
	
	
	// mot de passe
	$patternMdp ='#[A-Z]+[a-z]+[0-9]+#';
	$nomVariable = 'mot de passe';
	pattern($patternMdp, $mdp, $nomVariable, $mess, $i);
	
    
	// identifiant
	$patternEmail = '#[A-Za-z0-9._-]+\.[A-Za-z0-9._-]+@M2L\.[a-z]{2,6}#';
	$nomVariable = 'adresse email';
	pattern ( $patternEmail, $mail, $nomVariable, $mess, $i);

	
	if (connexion($mail,$mdp)){
		$_SESSION['email'] = $mail;
        $_SESSION['pass'] = sha1($mdp);
		header('location:index.php?page=Controllers/interfaceUser.php');
	}
	elseif ($i>0)
	{
		echo ("vous avez $i erreurs <br />");
		echo $mess;
	}
	else 
	{
		echo '<center><h2>Vérifiez vos identifiants de connexion</h2></center>';
	}
    
}

//Si l'utilisateur vient de la page Inscription pour la première fois
if (isset($_SESSION['inscription'])){
	if($_SESSION['inscription'] == "ok") {
        echo '<div align="center" id="congratulations">';
		echo "Félicitations, vous avez été rajouté à la communauté<br><br>";
		echo "Veuillez noter vos identifiants, ils ne vous seront plus communiqués explicitement 
				la prochaine fois<br>";
		echo "<br>Votre identifiant:   " . $_SESSION ['id'] . 
			"<br><br>Votre mot de passe:   " . $_SESSION ['pass'];
		echo "<br><br>votre chef:  " . $_SESSION ['chef'].
			"<br><br>Votre mot clé :	".$_SESSION['keyword']."<br><br><br>";
			echo '</div>';
		unset ($_SESSION ['inscription']);
	}
}

//Si l'utilisateur vient de la page Reinitialise
if (isset($_SESSION['reinitialise'])){
    if ($_SESSION['reinitialise'] == 'ok'){
        echo '<div align="center" id="congratulations">';
		echo "Félicitations, vos informations ont été mises à jour<br><br>";
		echo "Veuillez noter vos identifiants, ils ne vous seront plus communiqués explicitement 
				la prochaine fois<br>";
        echo "<br>Votre identifiant:   " . $_SESSION ['id'] .
			"<br><br>Votre mot de passe:   " . $_SESSION ['pass']."<br><br><br>";
        echo '</div>';
		unset ($_SESSION ['reinitialise']);
    }
}
require_once 'Views/connexion.php';