import java.sql.*;

public class Modele {
	//Attributs
	private Connection connexion;
	private Statement st;
	private int count;
	private int num;
	private String nom;
	
	public Modele() {
		
	}
	
	public boolean connexion()  {
		boolean rep = false;
		connexion = null;
		//M�thodes
		try {
			//Import du driver mysql connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connexion � la BDD
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.211/repertoire?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
			rep = true;
		} catch (ClassNotFoundException erreur) { //Erreur du driver
			erreur.printStackTrace();
			System.out.println("Le Driver n'a pas pu �tre charg�.");
			
		} catch (SQLException e) { //Erreur de la connexion BDD
			System.out.println("Erreur de la connexion � la BDD.");
			e.printStackTrace();
		}
		return rep;
	}
	
	public void deconnexion() {
		//Fermeture de la connexion � la BDD
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean inserer(int unNum, String unNom, String unPrenom, String unEmail, String unComm) {
		//Insertion
		boolean rep = false;
		try {
			st = connexion.createStatement();
			String req = ("INSERT INTO contacts (numero, nom, prenom, email, commentaire) VALUES("+ unNum +", '"+ unNom +"','"+ unPrenom +"', '"+ unEmail +"', '"+ unComm +"');");
			//System.out.println(req);
			st.executeUpdate(req);
			rep = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
		
	}
	
	public boolean supprimer(int unNum) {
		//Suppression
		boolean rep = false;
		try {
			st = connexion.createStatement();
			String req = ("DELETE FROM contacts WHERE numero = "+ unNum);
			count = st.executeUpdate(req);
			if(count == 1) {
				System.out.println(count + " ligne supprim�e.");
			}
			rep = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	public void affichage() {
		//Selection
		try {
			st = connexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM contacts");
			// Pour acc�der � chacune des lignes du r�sultat de la requ�te :
			while (rs.next()) {
			num = rs.getInt("numero");
			nom = rs.getString(2);
			 System.out.println(" Code = " + num + nom) ;
			}
			rs.close() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*st = connexion.createStatement();
			
			//Insertion
			st.executeUpdate("INSERT INTO contacts (numero, nom, prenom, email, commentaire) VALUES(7, 'Barcelo', 'Jeremy', 'jeremy.barcelo@gmail.com', 'Prout');");
			
			//Suppression
			count = st.executeUpdate("DELETE FROM contacts WHERE numero = 7 ");
			if(count == 1) {
				System.out.println(count + " Lignes supprim�es.");
			}
			
			//Selection
			ResultSet rs = st.executeQuery("SELECT * FROM maTable");
			// Pour acc�der � chacune des lignes du r�sultat de la requ�te :
			while (rs.next()) {
			num = rs.getInt("numero");
			nom = rs.getString(2);
			 System.out.println(" Code = " + num + nom) ;
			}
			rs.close() ;
			
			//Fermeture de la connexion � la BDD
			connexion.close();*/
}