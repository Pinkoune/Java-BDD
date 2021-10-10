/**
 * Fenetre de l'affichage
 *@author j�r�my 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffichageTable extends JFrame implements ActionListener {
	
	private JPanel monPanel;
	private JTable tableau;
	JScrollPane scrollPane;
	
	public AffichageTable(ArrayList <Contact> lesContacts) {
		
        monPanel = new JPanel ( ) ;
        monPanel.setLayout(new BorderLayout());
        
                                     
        // TABLEAU : compos� d'une ligne de titres de colonnes (title) et de donn�es (data) 
        Object data[][]= new Object[10][10]; 
        int i = 0; 
		for (Contact unContact : lesContacts) {
			data[i][0] = unContact.getNum();
			data[i][1] = unContact.getNom();
			data[i][2] = unContact.getPrenom();
			data[i][3] = unContact.getEmail();
			data[i][4] = unContact.getComm();
			i++;
		}
        String [] title = {"Numero", "Nom", "Prenom", "Email", "Commentaire"};                         
        this.tableau = new JTable(data,title);                
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300)); 

         this.tableau.setRowHeight(30); 
         //espacement des cellules                 
         // le tableau doit �tre obligatoirement ajout� dans un composant JScrollPane         
         this.scrollPane = new JScrollPane(this.tableau);
        
        this.setAlwaysOnTop(true);
        this.monPanel.add(this.scrollPane);
        this.getContentPane().add(monPanel); // UN SEUL panel DANS LE GET CONTENT
        this.setVisible(true);
	}
	
	
	public void actionPerformed (ActionEvent e) {
		
	}
}



