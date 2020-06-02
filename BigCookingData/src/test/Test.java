package test;


import java.io.File;
import java.io.IOException;

		public class Test {
		 
		    public static void main(String[] argv) throws IOException {
		    	String curDir = System.getProperty("user.dir");
		        System.out.println ("Le répertoire courant est: "+curDir);
		        
		        File dossier = new File("C:/Chemin/Vers/Votre/Répertoire/A/Préciser"); // Precisez repertoire ou il y a vos photos 
		        File[] liste = dossier.listFiles();

		        for (int i = 0; i < liste.length; i++) {

		            if (liste[i].isFile()) { // si c'est un fichier
		             
		             //récupérer le fichier en cours
		             File f = new File("C:/Chemin/Vers/Votre/Répertoire/A/Préciser/"+liste[i].getName()); //Ici aussi écrivez sans retirer le "/" à la fin
		             String extension = "";
		             String ancien = liste[i].getName();
		             
		             //vérifier que l'extension est txt
		             int index = ancien.lastIndexOf('.');
		             if (index > 0) {
		                 extension = ancien.substring(index+1);
		             }
		             if(extension.equals("png")){
		                 String nouveau = liste[i].getName().replaceAll(".png", ".jpg");
		                 f.renameTo(new File("C:/Chemin/Vers/Votre/Répertoire/A/Préciser/"+nouveau)); //Ici aussi écrivez sans retirer le "/" à la fin
		                 f.delete();
		                 System.out.println(ancien+" renommé => "+nouveau);
		             }
		             else{
		               
		             }
		            }
		        }

		        System.out.println("Opération terminée!");
		    }
		}
			

		
	


