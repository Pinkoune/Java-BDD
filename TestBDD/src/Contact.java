public class Contact {
	
	//Attributs
	private int numero;
	private String nom;
	private String prenom;
	private String email;
	private String commentaire;
	
	//Accesseurs
	public Contact() {
		
	}
	
	public Contact(int unNum, String unNom, String unPrenom, String unEmail, String unComm) {
		this.numero = unNum;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.email = unEmail;
		this.commentaire = unComm;
	}
	
	//Constructeurs
	public int getNum() {
		return this.numero;
	}
	public void setNum(int unNum) {
		this.numero = unNum;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String unNom) {
		this.nom = unNom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String unPrenom) {
		this.prenom = unPrenom;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String unEmail) {
		this.email = unEmail;
	}
	
	public String getComm() {
		return this.commentaire;
	}
	public void setComm(String unComm) {
		this.commentaire = unComm;
	}
	
	public String toString() {
		String result = null;
		if(this.numero != 0) {
			result += "\nNuméro : " + this.numero;
		}
		if(this.nom != null) {
			result += "\nNom : " + this.nom;
		}
		if(this.prenom != null) {
			result += "\nPrenom : " + this.prenom;
		}
		if(this.email != null) {
			result += "\nEmail : " + this.email;
		}
		if(this.commentaire != null) {
			result += "\nCommentaire : " + this.commentaire;
		}
		return result;
	}
}
