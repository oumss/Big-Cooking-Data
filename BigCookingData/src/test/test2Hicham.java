package test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class test2Hicham {



	   
	    	public static void main (String[] args) throws IOException 
			{
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
				
				
			
	 
	        }
	   
	
}
