<?php
/*
 * couche Models
 */
include_once 'Models/initDB.php';

function counter() {
	$pdo = initDB ();
	$sql = "select count(*) from utilisateur";
	$stmt = $pdo->prepare ( $sql );
	
	if ($stmt->execute () === false) {
		$retour = "ERREUR DE COUNT";
	} 
	else {
		$tab = $stmt->fetch ();
		$retour = $tab[0];
	}
	return $retour;
}
function checkChief($emailchef) {
	$pdo = initDB ();
	$sql = "select * from utilisateur where mailUtilisateur = (:mail) and chefUtilisateur = 'je suis chef'";
	$stmt = $pdo->prepare ( $sql );
	$stmt->bindParam ( ':mail', $emailchef );
	if ($stmt->execute () === true) {
		$tab = $stmt->fetch ();
		if (! empty ( $tab ))
			$retour = true;
		else
			$retour = false;
	} 
	else {
		$retour = false;
	}
	
	return $retour;
}
function addUser($nom, $prenom, $pass, $mail, $keyword, $chef) {
	$pdo = initDB ();
	$numUtilisateur = counter()+1;

			$sql = "INSERT INTO utilisateur
					(numUtilisateur, nomUtilisateur, prenomUtilisateur,passeUtilisateur, mailUtilisateur, keywordUtilisateur, chefUtilisateur)
					VALUES (:lenum, :lenom, :leprenom, :lepass, :lemail, :lekeyword, :lechef)
					";
			$stmt = $pdo->prepare ( $sql );
			$stmt->BindParam ( ':lenum', $numUtilisateur );
			$stmt->BindParam ( ':lenom', $nom );
			$stmt->BindParam ( ':leprenom', $prenom );
			$stmt->BindParam ( ':lepass', $pass );
			$stmt->BindParam ( ':lemail', $mail );
			$stmt->BindParam ( ':lekeyword', $keyword );
			$stmt->BindParam ( ':lechef', $chef );
			
		if ($stmt->execute () === false) {
			echo "ERREUR DE CREATION : CONTACTEZ ADMINISTRATEUR";
		}
	}
?>