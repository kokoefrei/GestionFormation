<?php
/*
 * Couche Models
 */
include_once 'Models/initDB.php';

function initRequete ($req, $mail)
{
	$pdo = initDB();
	$sql = $req;
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(':lemail', $mail);
	return $stmt;
}
function findFirstNameByMail ( $mail )
{
	$req = "select prenomUtilisateur from utilisateur where mailUtilisateur = (:lemail)";
	$stmt = initRequete($req, $mail);

	if ($stmt->execute() === false)
	{
		$retour = "UTILISATEUR NON EXISTANT";
	}
	else {
		$retour = $stmt->fetch()[0];
	}
	return $retour;
}
function findLastNameByMail ($mail)
{
	$req = "select nomUtilisateur from utilisateur where mailUtilisateur = (:lemail)";
	$stmt = initRequete($req, $mail);

	if ($stmt->execute() === false)
	{
		$retour = "UTILISATEUR NON EXISTANT";
	}
	else {
		$retour = $stmt->fetch()[0];
	}
	return $retour;
}

function findChefByMail ($mail){
	$req = "select chefUtilisateur from utilisateur where mailUtilisateur = (:lemail)";
	$stmt = initRequete($req, $mail);

	if ($stmt->execute() === false)
	{
		$retour = "ERREUR";
	}
	else {
		$tab = $stmt->fetch();
		if ($tab[0] === "Je suis chef")
			$retour = "ADMINISTRATEUR";
			else
				$retour = "CHEF:\n".$tab[0];
	}
	return $retour;
}

function findHistoriqueByMail ($mail)
{
	$pdo = initDB();
	$numUtilisateur = findUserByMail($mail);
	$sql = "select contenuFormation from choisirformation cf, formation f
			where f.dateFormation > CURDATE()
			and cf.numFormation = f.numFormation
			and cf.numUtilisateur = (:lutilisateur)";
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(':lutilisateur', $numUtilisateur);
	if ($stmt->execute() === true)
	{
		$result = $stmt->fetch();
		if (!empty($result))
			$retour = $result;
		else 
			$retour = "AUCUNE FORMATION DANS L'HISTORIQUE";	
	}
	
	return $retour;
}

function findCreditByMail ($mail)
{
	$req = "select credits from utilisateur where mailUtilisateur = (:lemail)";
	$stmt = initRequete($req, $mail);

	if ($stmt->execute() === false)
	{
		$retour = "ERREUR DE CREDITS";
	}
	else {
		$retour = $stmt->fetch()[0];
	}
	return $retour;
}

function findJoursByMail($mail)
{
	$req = "select joursUtilisateur from utilisateur where mailUtilisateur = (:lemail)";
	$stmt = initRequete($req, $mail);

	if ($stmt->execute() === false)
	{
		$retour = "ERREUR DE JOURS";
	}
	else {
		$retour = $stmt->fetch()[0];
	}
	return $retour;
}

function findStatutByMail($mail)
{
	$req = "select chefUtilisateur from utilisateur where mailUtilisateur = (:lemail)";
	$stmt = initRequete($req, $mail);

	if ($stmt->execute() === false)
	{
		$retour = "ERREUR DE STATUT";
	}
	else {
		$tab = $stmt->fetch();
		$retour = $tab[0];
	}
	return $retour;
}
function findFormationByMail ($mail)
{
	$pdo = initDB();
	$numUtilisateur = findUserByMail($mail);
	$sql = "select contenuFormation 
			from formation f, choisirFormation cf 
			where cf.numUtilisateur = (:lutilisateur) 
			and cf.statutFormation = 'validée'
			and f.numformation = cf.numformation";
	$stmt = $pdo->prepare($sql);
	if ($stmt === false)
		$retour = "ERREUR DE FORMATION";
	else{
		$tab = $stmt->fetch();
		if (empty($tab))
			$retour = "Vous n'avez pas encore choisi de formation";
		else
			$retour = $tab;
		}
	return $retour;
}

function findUserByMail ($mail)
{
	$pdo = initDB();
	$sql = "select numUtilisateur from utilisateur where mailUtilisateur = (:lemail)";
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(':lemail', $mail);
	if ($stmt->execute() == true)
		$retour = $stmt->fetch()[0];
		else
			$retour = 'UTILISATEUR INTROUVABLE';
			return $retour;
}
//TODO implémenter la fonction
function askPower ($mail)
{

}

function formationDisponible(){
	$pdo = initDB();
	$format = "yyyy-mm-dd";
	$date = date($format);
	$sql = "select * from formation where dateFormation < CURDATE()";
	$stmt = $pdo->prepare ( $sql );
	$stmt->bindParam(':dateFormation', $date);
	if ($stmt->execute () === false)
		$retour = "	ERREUR DE REQUETE";
		else {
			$tab = $stmt->fetch ();
			if (! empty ( $tab ))
				$retour = $tab;
				else
					$retour = "VIDE";
		}
		return $retour;
}

?>
