package test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import business.Recipe;

import persistance.ConnexionPersistence;
import persistance.RecipePersistance;

public class test2Hicham {



	   
	    	public static void main (String[] args) throws IOException 
			{
	    		/*
				BufferedReader in;
				try {
					in = new BufferedReader(new FileReader("C:/Users/G005335/git/Big-Cooking-Data/BigCookingData/src/ingredients/insert_ingredientsRecipe.sql"));
					String line;
					while ((line = in.readLine()) != null)
						System.out.println (line);
					in.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		ConnexionPersistence test = new ConnexionPersistence();
	    		test.updateWhoConnected(100001);
	        }*/
	    		
	    		RecipePersistance rp = new RecipePersistance();
	    		Recipe recipe = new Recipe();
	    		recipe = rp.readRecipeById(1792);
	    		
	    		System.out.println(recipe.getIngredientsList() + "\n");
	    		String s = recipe.getIngredientsList();
	    		
	    		String[] ingredientList = s.split("},");
	    		ArrayList<String> newIngredientList = new  ArrayList<String>();
	    		for (int i = 0; i < ingredientList.length; i++) {
	    		
	    			ingredientList[i] = ingredientList[i].replace("[", "");
	    			ingredientList[i] = ingredientList[i].replace("{", "");
	    			ingredientList[i] = ingredientList[i].replace("]", "");
	    			ingredientList[i] = ingredientList[i].replace("}", "");
					while(!(Character.toString(ingredientList[i].charAt(0)).equals("n")) && !(Character.toString(ingredientList[i].charAt(0)).equals("p") )) {
						
					
							ingredientList[i] = ingredientList[i].replaceFirst(Character.toString(ingredientList[i].charAt(0)),"");
							
							
						// ingredientList[i] = ingredientList[i].replaceFirst(Character.toString(ingredientList[i].charAt(0)),"");
					}  
					ingredientList[i] = ingredientList[i].replace("\", \"complement\": \"" ,"");
					ingredientList[i] = ingredientList[i].replace("prefix\": \"", "");
					ingredientList[i] = ingredientList[i].replace(", \"name\": \"", "");
					ingredientList[i] = ingredientList[i].replace("name\": \" ", "");
					ingredientList[i] = ingredientList[i].replace("\", \"quantity\": \"", ";");
					ingredientList[i] = ingredientList[i].replaceFirst("\"", ";");
					ingredientList[i] = ingredientList[i].replace("\"" ,"");
					//System.out.println(ingredientList[i]);
					String[] tmp = ingredientList[i].split(";");
					try {
						if(tmp.length==3) {
							String tmp2 = tmp[2] +" "+ tmp[0] +" de "+ tmp[1];
							tmp2 = tmp2.replace("de  d'", "d'");
						newIngredientList.add(tmp2);
						}
						else
							newIngredientList.add(tmp[1] +" "+ tmp[0]);

					} catch (Exception e) {
						ingredientList[i] = ingredientList[i].replace(";" ,"");
						newIngredientList.add(ingredientList[i]);
					} 
					System.out.println(newIngredientList.get(i));
				}
	    		
	    		
	    		/*
	    		int nb = 0;
	    		 for (int i=0; i < s.length(); i++)
	    		 {
	    		 if (s.charAt(i) == ',')
	    		 nb++;
	    		 }
	    		 System.out.println(nb);
	    		 if (nb==0) {
	    			 s = s.replaceAll("\"","");
	    			 s = s.replaceAll("[", "");
	    			 s = s.replaceAll("]", "");
	    			// return s;
	    		 }
	    		s = s.replaceAll(", ", ";");
				
				s = s.replaceAll("[^\\w\\s\\.\\,\\:\\;\\-\\'\\é\\è\\à\\ê\\ô\\ï\\ù\\í\\ì\\ī\\á\\ó\\ǐ\\â\\ä\\ç\\ë\\î\\ö\\û\\ü\\ÿ\\ú\\þ]", "");
				s = s.replaceAll(";", "\n");
				System.out.println(s);
	    		 
	    		 
				
			/*	String[] filmTab = s.split("#");
				String contenuTableauFilm = filmTab[1];
				
				contenuTableauFilm = contenuTableauFilm.replaceAll(" ,", "");
				String[] filmTabOnly = contenuTableauFilm.split(",");
				
				for (int i = 0; i < filmTabOnly.length-1; i++) {
						
					filmTabOnly[i] = filmTabOnly[i].replaceAll("[\r\n\t]","");
					filmTabOnly[i] = filmTabOnly[i].replaceAll(";",",");
						
					while(Character.toString(filmTabOnly[i].charAt(0)).equals(" ")) {
						
						filmTabOnly[i] = filmTabOnly[i].replaceFirst(" ", "");
						
					}  
				}
	    // Après traitement, on met tout dans une liste
				java.util.ArrayList<String> listOfFilm = new java.util.ArrayList<String>();
				
				for (int j = 0; j < filmTabOnly.length-1; j++) {	
					listOfFilm.add(filmTabOnly[j]);
				}
		// On retourne la liste de film		
		//		return  listOfFilm;
	    		
	    		*/
	    		
			}
}
