import java.util.Scanner;

public class Main {
	
	private static Scanner clavier;
	public static void main(String[] args) {
		clavier = new Scanner(System.in);
		
		Modele unModele = new Modele();
		int choix = 0;
		
		do {
			System.out.println("{-------Int�raction avec la BDD-------}");
			System.out.println("1 - Ajouter");
			System.out.println("2 - Supprimer");
			System.out.println("3 - Quitter");
			
			choix = clavier.nextInt();
			clavier.nextLine();
			
			switch(choix) {
			case 1:
				System.out.println("Entrez le num�ro : ");
				int num = clavier.nextInt();
				clavier.nextLine();
				System.out.println("Entrez le nom : ");
				String nom = clavier.nextLine();
				System.out.println("Entrez le pr�nom : ");
				String prenom = clavier.nextLine();
				System.out.println("Entrez le mail : ");
				String mail = clavier.nextLine();
				System.out.println("Entrez un commentaire : ");
				String comm = clavier.nextLine();
				unModele.connexion();
				System.out.println(unModele.inserer(num, nom, prenom, mail, comm));
				unModele.deconnexion();
				break;
				
			case 2:
				System.out.println("Entrez le num�ro : ");
				int numero = clavier.nextInt();
				unModele.connexion();
				System.out.println(unModele.supprimer(numero));
				unModele.deconnexion();
				break;
				
			case 3:
				System.out.println("Vous avez quitt� le menu.");
				break;
				
			default:
				System.out.println("Entrez un des choix pr�sent�s.");
				break;
				
			}
		}while(choix != 3);
	}
}
