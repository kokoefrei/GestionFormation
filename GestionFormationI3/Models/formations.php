<?php
include_once 'initDB.php';


function formationDisponible($mail){
	$pdo = initDB();
	$format = "yyyy-mm-dd";
	$date = date($format);
	$numUtilisateur = findUserByMail($mail);
	$sql = "SELECT DISTINCT f.numFormation, f.prestaFormation, f.dateFormation, f.dureeFormation, 
			f.lieuFormation, f.creditFormation, f.contenuFormation 
			FROM f_formation f, f_choisirformation cf
			WHERE f.dateFormation > CURDATE() 
			AND
            cf.numFormation != f.numFormation
            AND
            cf.numUtilisateur = (:lutilisateur)
			ORDER BY f.numFormation";
	//$sql = "call formationDisponible()";
	$stmt = $pdo->prepare ( $sql );
	//$stmt->bindParam(':dateFormation', $date);
	$stmt->bindParam(':lutilisateur', $numUtilisateur);
	if ($stmt->execute () === false)
		$retour = "	ERREUR DE REQUETE";
	else {
		$tab = $stmt->fetchAll();
		if (! empty ( $tab ))
			$retour = $tab;
		else
			$retour = "VIDE";
	}
	return $retour;
}

function formationIndisponible($mail)
{
	$pdo = initDB();
	$format = "yyyy-mm-dd";
	$date = date($format);
	$numUtilisateur = findUserByMail($mail);
	$sql = "SELECT DISTINCT f.numFormation, f.prestaFormation, f.dateFormation, f.dureeFormation, 
			f.lieuFormation, f.creditFormation, f.contenuFormation 
			FROM f_formation f, f_choisirformation cf 
			WHERE f.dateFormation < CURDATE() 
			OR
            (cf.numFormation = f.numFormation
            AND
            cf.numUtilisateur = (:lutilisateur))
			ORDER BY f.numFormation";
	$stmt = $pdo->prepare ( $sql );
	//$stmt->bindParam(':dateFormation', $date);
	$stmt->bindParam(':lutilisateur', $numUtilisateur);
	if ($stmt->execute () === false)
		$retour = "	ERREUR DE REQUETE";
		else {
			$tab = $stmt->fetchAll();
			if (! empty ( $tab ))
				$retour = $tab;
			else
					$retour = "VIDE";
		}
		return $retour;
}

function findUserByMail ($mail)
{
	$pdo = initDB();
	$sql = "select numUtilisateur from f_utilisateur where mailUtilisateur = (:lemail)";
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(':lemail', $mail);
	if ($stmt->execute() == true)
		$retour = $stmt->fetch()[0];
	else 
		$retour = 'UTILISATEUR INTROUVABLE';
	return $retour;
}

function addValiderFormation($numformation, $numUtilisateur)
{
	$pdo = initDB();
	$sql = "INSERT INTO kmomokenfack.f_validerformation (numUtilisateur, numFormation, statut, chefResponsable) VALUES (:numUtilisateur, :numFormation, 'En Attente', 'koko.christ@M2L.com')";
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(':numUtilisateur', $numUtilisateur);
	$stmt->bindParam(':numFormation', $numformation);
	if ($stmt->execute() === true)
		$retour = 'SUCCESS';
	else 
		$retour = 'FAILED';
	return $retour;
}

function choixFormation($numformation, $mail)
{
	$pdo = initDB();
	$numUtilisateur = findUserByMail($mail);
	$rep = addValiderFormation($numformation, $numUtilisateur);
	$sql = "INSERT INTO kmomokenfack.f_choisirformation (numUtilisateur, numFormation, statutFormation, chefResponsable) VALUES (:numUtilisateur, :numFormation, 'En Attente', 'koko.christ@M2L.com')";
	$stmt = $pdo->prepare($sql);
	$stmt->bindParam(':numUtilisateur', $numUtilisateur);
	$stmt->bindParam(':numFormation', $numformation);
	if ($stmt->execute() === true && $rep == 'SUCCESS')
		$retour = " FORMATION CHOISIE ";
	else 
		$retour = " IMPOSSIBLE ";
	return $retour;
}
	?>