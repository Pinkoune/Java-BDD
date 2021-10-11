import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner clavier;
	public static void main(String[] args) {
		clavier = new Scanner(System.in);
		
		Modele unModele = new Modele();
		int choix = 0;
		
		do {
			System.out.println("{-------Interaction avec la BDD-------}");
			System.out.println("1 - Ajouter");
			System.out.println("2 - Supprimer");
			System.out.println("3 - Afficher");
			System.out.println("4 - Quitter");
			
			choix = clavier.nextInt();
			clavier.nextLine();
			
			switch(choix) {
			case 1:
				insererSQL(unModele);
				break;
				
			case 2:
				supprimerSQL(unModele);
				break;
				
			case 3:
				affichageSQL(unModele);
				break;
				
			case 4:
				System.out.println("Vous avez quitte le menu.");
				break;
				
			default:
				System.out.println("Entrez un des choix presentes.");
				break;
				
			}
		}while(choix != 4);
	}
	
	public static void insererSQL(Modele unModele) {
		System.out.println("Entrez le numero : ");
		int num = clavier.nextInt();
		clavier.nextLine();
		System.out.println("Entrez le nom : ");
		String nom = clavier.nextLine();
		System.out.println("Entrez le prenom : ");
		String prenom = clavier.nextLine();
		System.out.println("Entrez le mail : ");
		String mail = clavier.nextLine();
		System.out.println("Entrez un commentaire : ");
		String comm = clavier.nextLine();
		unModele.connexion();
		System.out.println(unModele.inserer(num, nom, prenom, mail, comm));
		unModele.deconnexion();
	}
	
	public static void supprimerSQL(Modele unModele) {
		System.out.println("Entrez le numero : ");
		int numero = clavier.nextInt();
		unModele.connexion();
		System.out.println(unModele.supprimer(numero));
		unModele.deconnexion();
	}
	
	public static void affichageSQL(Modele unModele) {
		ArrayList<Contact> lesContacts = unModele.affichage();
		AffichageTable unAffichageTable = new AffichageTable(lesContacts);
		unModele.deconnexion();
	}
}
