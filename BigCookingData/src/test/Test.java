package test;


import java.io.File;
import java.io.IOException;

		public class Test {
		 
		    public static void main(String[] argv) throws IOException {
		    	String curDir = System.getProperty("user.dir");
		        System.out.println ("Le r�pertoire courant est: "+curDir);
		        
		        File dossier = new File(".\\WebContent\\images\\marmiton_imgs");
		        File[] liste = dossier.listFiles();

		        for (int i = 0; i < liste.length; i++) {

		            if (liste[i].isFile()) { // si c'est un fichier
		             
		             //r�cup�rer le fichier en cours
		             File f = new File(".\\WebContent\\images\\marmiton_imgs\\"+liste[i].getName()); 
		             String extension = "";
		             String ancien = liste[i].getName();
		             
		             //v�rifier que l'extension est txt
		             int index = ancien.lastIndexOf('.');
		             if (index > 0) {
		                 extension = ancien.substring(index+1);
		             }
		             if(extension.equals("png")){
		                 String nouveau = liste[i].getName().replaceAll(".png", ".jpg");
		                 f.renameTo(new File("../../WebContent/images/marmiton_imgs/"+nouveau));
		                 f.delete();
		                 System.out.println(ancien+" renomm� => "+nouveau);
		             }
		             else{
		               
		             }
		            }
		        }

		        System.out.println("Op�ration termin�e!");
		    }
		}
			

		
	


