package test;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class test2Hicham {



	    public static void main(String[] args) {
	      String urlToReturn = "";
	      URL uneURL=null;
	      
	      try {
	        uneURL = new URL("https://gateuaed.com");
	        HttpURLConnection connexion = (HttpURLConnection)uneURL.openConnection();
	        InputStream flux = connexion.getInputStream();
	        System.out.println("Status de la connexion : " + connexion.getResponseMessage());
	        if (connexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        urlToReturn = "On prend l'id du truc";
	        System.out.println(urlToReturn);}
	        flux.close(); 
	        connexion.disconnect();
	        
	      } 
	      catch(Exception e) {
	          
	    	  urlToReturn = "On prend l'id général";
	          System.out.println(urlToReturn);
	      }
	    }
	
}
