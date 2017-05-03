<?php
// couchViews
?>

<!DOCTYPE HTML>
<html>
<head>
<title>Gestion Formation M2L/ Inscription</title>
<meta charset="utf-8">
<link href="Css/indexCss.css" type="text/css" rel="stylesheet">
<meta lang="fr">
</head>
<body>

<?php echo '<div align="center">';?>
	<form action="#" method="POST">
			<fieldset>
				<legend> INSCRIPTION M2LFORMATION</legend>
				<h4>Nom:</h4>
				<input type="text" name="nom" placeHolder="Votre Nom" required
					pattern="[A-Za-z-\s]+" title="MonNomDemploye">
				<h4>Prenom:</h4>
				<input type="text" name="prenom" placeHolder="votre Prenom" required
					pattern="[A-Za-z-\s]+" title="MonPrenomDemploye">
				<h4>Email:</h4>
				<input type="email" name="mail" placeHolder="prenom.nom@M2L.com"
					required pattern="[A-Za-z0-9._-]+\.[A-Za-z0-9._-]+@M2L\.[a-z]{2,6}"
					title="prenom.nom@M2L.com">
				<!-- 			<h4>Admin?:</h4> -->
				<!-- 			<select required> -->
				<!-- 				<option value="True">Oui -->

				<!-- 				<option value="False" selected>Non -->

				<!-- 			</select> -->
				<h4>Mot de Passe:</h4>
				<input type="password" name="mdp" placeHolder="*********" required
					pattern="[A-Z]+[a-z]+[0-9]+" title="MotDePasse12">
				<h4>Chef hiérarchique:</h4>
				<input type="email" name="chef" placeHolder="mon.chef@M2L.com" required pattern="[A-Za-z0-9._-]+\.[A-Za-z0-9._-]+@M2L\.[a-z]{2,6}" title="mon.chef@M2L.com"> 
				<br>
				<h4> Mot clé :</h4>
				<input type="text" name="keyword" placeHolder="mot clé" required pattern="[\w-\s-éèêïîôûàâë-]+{1,256}" title="Servira pour la récupération de votre mot de passe en cas d'oubli">
				<h2>
					<input type="submit" name="submit" value="ENVOYER"> 
					<a href="index.php"> 
						<input type="button" value="ANNULER">
					</a>
				</h2>
			</fieldset>

		</form>
<?php echo '</div>';?>
</body>

</html>