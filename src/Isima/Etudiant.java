
package Isima;
public class Etudiant {
private int idetudiant;
private String nom_prenom;
private String email;
private String filiere;
private String niveau ;

public Etudiant(){
	this.idetudiant=idetudiant;
	this.nom_prenom=nom_prenom;
	this.email=email;
	this.filiere=filiere;
	this.niveau=niveau;
	
	// TODO Auto-generated constructor stub
}
public int getNo() {
return idetudiant;
}
public void setNo(int num) {
this.idetudiant = num;
}
public String getFiliere() {
return filiere;
}
public void setFiliere(String fil)
{ this.filiere = fil;
}
public String getNiveau() {
	return niveau;
}
public void setNiveau(String niveau) {
	niveau = niveau;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNom_prenom() {
	return nom_prenom;
}
public void setNom_prenom(String nom_prenom) {
	this.nom_prenom = nom_prenom;
}

	
}
 
