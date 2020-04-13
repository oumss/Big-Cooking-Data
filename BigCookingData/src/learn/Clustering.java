package learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.Random; 	

import business.*;
/**
 * Classe repr�sentant un clustring, c'est � dire une liste de variable + la liste des cluster dans lesquelles ils sont distribu�s 
 * 
 * @author Rapha�l
 *
 */
public class Clustering{
	
	//Attributs
	protected ArrayList<Recipe> listeRecipes; //liste de toutes les variables du probl�me
	protected ArrayList<Cluster> listeCluster; // la liste des cluster est de taille K, dans la m�thode du "K-Means"
	
	//Constructeurs
	/**
	 * Construit un clustering � partir d'un jeu de variable et d'un nombre de cluster K
	 * Attribut les centres des K clusters cr��s � des variables al�atoirement choisies parmi le jeu de variable listevar
	 * 
	 * lance une exception si le jeu de variable donn� en param�tre est de taille inf�rieure � valeurK (car dans ce cas on ne peut choisir K variables)
	 * 
	 * @param listevar
	 * @param valeurK
	 */
	public Clustering (ArrayList<Recipe> listevar, int valeurK) {
		this.listeRecipes = listevar ;
		this.listeCluster = new ArrayList <Cluster>(valeurK) ;
		
		//s�lection de K variables au hasard
		ArrayList<Recipe> selectionHasard = new ArrayList<Recipe>(valeurK) ;
		
		
			//test pour savoir s'il y a moins de variables distinctes dans listevar que valeurK
			
			
			//calcul du nombre de valeur distinctesdans listevar
			
			int valeurDistinctes = 0 ; 
			
			for (int i=1 ; i<listevar.size() ; i++){//pour chaque variable, on regarde si elle est �gale aux pr�c�dentes
				boolean doublon = false ; //variable pour d�tecter si la i-�me variable a un doublon parmi les pr�c�dentes
				for (int j=0 ; j<i ; j++ ){
					if (listevar.get(i).equals(listevar.get(j))){
						doublon = true;
					}
					
				}
				if (! doublon){valeurDistinctes++;};
			}
			
	
		
		//mettre dans selection K variables choisies au hasard dans listevar, c'est possible car on vient de tester
		Random random = new Random();
		 for (int i = 0; i < valeurK; i++)
		    {
			 // pour chaque i choisit un nombre au hasard
			 int nbaleatoire = random.nextInt(listevar.size());
			 //et si la variable de cet indice est d�j� pr�sente dans la s�lectin on tire un autre nombre ; on sait que la boucle finira gr�ce aux v�rifications ci-dessus
			 boolean doublon = true ; 
			 while (doublon){
				 doublon = false;
				 if(i==0){doublon =false;}
				 else
				 	{for (int j=0 ; j<i ; j++){
				 		if (selectionHasard.get(j).equals(listevar.get(nbaleatoire))){doublon=true;};
				 	}
				 }
				 nbaleatoire = random.nextInt(listevar.size());
			 }
			 
			 selectionHasard.add(listevar.get(nbaleatoire));
		    }
		
		for (int i=0 ; i < valeurK ; i++){
			//ajout d'un cluster avec pour centre la i-�me variable s�lectionn�e au hasrad ci-dessus
			listeCluster.add(new Cluster(selectionHasard.get(i)));
		}
		
	}
	
	//M�thodes
	
	/**
	 * r�alloue chaque variable de listeVariables dans le cluster le plus proche parmi ceux de listeCluster
	 * renvoie vrai si la r�allocation a engendr� des changements, faux si elle n'a eu aucun effet
	 * 
	 * 2 �tapes :
	 * 
	 * 	1) effacer les listeVariablesCluster de chaque cluster de la listeCluster
	 * 		tout en gardant son centre intact (ce n'est pas un recentrage)
	 * 	2) prendre une � une chaque variable de listeVariables et la copier dans 
	 * 		la liste des variables du cluster le plus similaire
	 * 	3) recalcule les centres des clusters gr�ce � la m�thode recentrer de chaque cluster
	 * 	4) si l'un au moins des clusters a chang� de centre, alors il y a modification donc on renvoie VRAI
	 * 	sinon on renvoie FAUX
	 * 
	 * @param sim : similarit� utilis�e (par exemple distance euclidienne)
	 */	 
	public boolean reallocation(Similarite sim) {
		System.out.println("d�but de la r�allocation");
		//effacer les variables de chaque cluster
		for (int i=0 ; i<this.listeCluster.size();i++){
			this.listeCluster.get(i).getListeRecipesCluster().clear();
		};
		System.out.println("variables effacees");
		
		//r�attribution des variables :
		//pour chaque variable...
		for (int i=0 ; i<this.listeRecipes.size() ; i++){
			//...on cherche parmi les centres de cluster le plus similaire...
			
			int indiceClusterProche = 0 ;
			for (int j=0 ; j<this.listeCluster.size() ; j++){
				//pour chaque cluster on regarde si le centre est plus similaire � la variable consid�r�e que le centre d'indice "indiceClusterProche"
				if (sim.similarite(this.listeRecipes.get(i), this.listeCluster.get(j).getCentre()) < sim.similarite(this.listeRecipes.get(i), this.listeCluster.get(indiceClusterProche).getCentre())){
					indiceClusterProche=j;
				}		
			}
			
			//...et on place la variable dans ce cluster
			this.listeCluster.get(indiceClusterProche).getListeRecipesCluster().add(this.listeRecipes.get(i));
		}
		System.out.println("variables reattribues");
		
		//reclalcul des centres des clusters, en regardant si l'un au moins a change :
		boolean changement = false ;
		for (int i = 0 ; i<this.listeCluster.size() ; i++){
			System.out.println("recalcul du centre du cluster numero "+(i+1));
			if (this.listeCluster.get(i).calculerCentre()){
				changement = true ;
			};
			System.out.print("nouveau centre du cluster "+(i+1)+" : ");
			for (int d=0 ; d<this.listeCluster.get(i).getCentre().coordonnees.size() ; d++){
				System.out.print(this.listeCluster.get(i).getCentre().coordonnees.get(d)+" , ");
			}
			System.out.println("");
		}
		/*
		//Si les variables sont de dimensions 2 on les affiche
		if (listeRecipes.get(0).getCoordonnees().size()==2)
		{
			affichage();
		}
		*/
		
		System.out.println("resultat reallocation : il y a eu du changement ? "+changement);
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Entrer un nombre pour continuer");
		int a = reader.nextInt();
	
		return changement;
		
	}
	
	

	
	/**
	 * M�thode pour afficher les differents cluster pour des variables de dimension 2.
	 * Chaque point poss�de un couleur sp�cifique � son cluster.
	 *//*
	public void affichage(){
		Random rand = new Random();
	    JFrame frame = new JFrame("Points");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //On �tablit une liste des couleurs pour ne pas r�utiliser la m�me
	     LinkedList<Color> listeCouleur = new LinkedList<Color>();
	    
	    //On suppose que les variables sont de dimensions 2
	    for (Cluster clust : listeCluster) {
	    	//On choisit une couleur pour le cluster
	    	Color randomColor;
	    	do 
	    	{ 
	    		float r = rand.nextFloat();
	    		float g = rand.nextFloat();
	    		float b = rand.nextFloat();
	    		randomColor = new Color(r, g, b);
	    	} while (listeCouleur.contains(randomColor));
	    	
	    	
	    	
			for (Recipe var : clust.getListeRecipesCluster()) {
				Point pt = new Point(var.getCoordonnees().get(0), var.getCoordonnees().get(1),randomColor);
				frame.add(pt);
				
			}
		}
	    

	    frame.setSize(300, 300);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
		
	}*/
}