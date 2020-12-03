import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pers {
private String nom_prenom;
private int mat;
private String raison;
private String heure_de_sortie;


public Pers(){
	this.mat=mat;
	this.nom_prenom=nom_prenom;
	this.raison=raison;	
	this.heure_de_sortie=heure_de_sortie;
}
public String getHeure_de_sortie() {
	return heure_de_sortie;
}

public void setHeure_de_sortie(String heure_de_sortie) {
	this.heure_de_sortie = heure_de_sortie;
}

public String getNom_prenom() {
	return nom_prenom;
}

public void setNom_prenom(String nom_prenom) {
	this.nom_prenom = nom_prenom;
}

public int getMat() {
	return mat;
}

public void setMat(int mat) {
	this.mat = mat;
}

public String getRaison() {
	return raison;
}

public void setRaison(String raison) {
	this.raison=raison;	

}

}