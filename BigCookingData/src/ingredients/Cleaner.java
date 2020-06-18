package ingredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import persistance.RecipePersistance;

public class Cleaner {

	public String cleanSteps(Integer id_recipe) {

		RecipePersistance rp = new RecipePersistance();

		String a = rp.readEtapeById(id_recipe);
		System.out.println(a);
		String result = "";
		String[] line = a.split("},");
		for (int index = 0; index < line.length; index++) {
			String[] partLine = line[index].split("\"");
			for (int index1 = 0; index1 < partLine.length; index1++) {
				if(index1 == 1 || index1 == 2 || index1 ==4 || index1 ==5) {
					if (index1 == 2) {
						char aaa = ',';
						if(partLine[index1].charAt(3) == aaa) {
							partLine[index1] = " "+partLine[index1].charAt(2)+"";
						}
						else {
							partLine[index1] = " "+partLine[index1].charAt(2)+ partLine[index1].charAt(3)+"";
						}
						
						

					}
				result = result + partLine[index1];
				}


			
			}result = result + "\n";
		}
		result = result.replaceAll("\n", "<br />");
		return result;
	}
	
	public String cleanCategory (String category) {
		try {
			
		
		String s = category;
		
		int nb = 0;
		 for (int i=0; i < s.length(); i++)
		 {
		 if (s.charAt(i) == ',')
		 nb++;
		 }
		 System.out.println(nb);
		 if (nb==0) {
			 s = s.replaceAll("\"","");
			 s = s.replace("[", "");
			 s = s.replace("]", "");
			 System.out.println(s);
			 return s;
		 }
		 else {
			 
			 s = s.replaceAll(", ", ";");
		 	 s = s.replaceAll("[^\\w\\s\\.\\,\\:\\;\\-\\'\\Ã©\\Ã¨\\Ã \\Ãª\\Ã´\\Ã¯\\Ã¹\\Ã­\\Ã¬\\Ä«\\Ã¡\\Ã³\\Ç�\\Ã¢\\Ã¤\\Ã§\\Ã«\\Ã®\\Ã¶\\Ã»\\Ã¼\\Ã¿\\Ãº\\Ã¾]", "");
		 	 String[] tabS = s.split(";");
		 	
	        Set set = new HashSet() ;
	        for (int j = 0; j < tabS.length; j++) {
	        set.add(tabS[j]) ;
	        }
	        ArrayList<String> distinctList = new ArrayList(set) ;
	        s = "";
	        for (int i = 0; i < distinctList.size(); i++) {
	        	if (i==distinctList.size()-1) {
	        		s = s + distinctList.get(i);
	        	}
	        	else {
	        		s = s + distinctList.get(i) + "\n";
	        	}
			}
			 
			 s = s.replaceAll("\n", "<br />");
			 
			 System.out.println(s);
			 return s;
		}
	
	} catch (Exception e) {
		return "Aucune";
	}}
	
	public String cleanCategoryForHome (String category) {
		try {
			
		
		String s = category;
		
		int nb = 0;
		 for (int i=0; i < s.length(); i++)
		 {
		 if (s.charAt(i) == ',')
		 nb++;
		 }
		 System.out.println(nb);
		 if (nb==0) {
			 s = s.replaceAll("\"","");
			 s = s.replace("[", "");
			 s = s.replace("]", "");
			 System.out.println(s);
			 return s;
		 }
		 else {
			 
			 s = s.replaceAll(", ", ";");
		 	 s = s.replaceAll("[^\\w\\s\\.\\,\\:\\;\\-\\'\\Ã©\\Ã¨\\Ã \\Ãª\\Ã´\\Ã¯\\Ã¹\\Ã­\\Ã¬\\Ä«\\Ã¡\\Ã³\\Ç�\\Ã¢\\Ã¤\\Ã§\\Ã«\\Ã®\\Ã¶\\Ã»\\Ã¼\\Ã¿\\Ãº\\Ã¾]", "");
		 	 String[] tabS = s.split(";");
		 	
	        Set set = new HashSet() ;
	        for (int j = 0; j < tabS.length; j++) {
	        set.add(tabS[j]) ;
	        }
	        ArrayList<String> distinctList = new ArrayList(set) ;
	        s = "";
	        for (int i = 0; i < distinctList.size(); i++) {
	        	if (i==distinctList.size()-1) {
	        		s = s + distinctList.get(i);
	        	}
	        	else {
	        		s = s + distinctList.get(i) + "\n";
	        	}
			}
			 
			 
			 
			 System.out.println(s);
			 return s;
		}
	
	} catch (Exception e) {
		return "Aucune catégorie";
	}}

	public String cleanBudget (int budget) {
		try {
			String s = "";
		switch (budget) {
		case 1:
			s =  "Bas";
			break;
		case 2:
			s =  "Moyen";
			break;
			
		default:
			s =  "ElevÃ©";
			break;
		}
		return s;
	} catch (Exception e) {
		return "Non renseignÃ©";
	}}
	public String cleanIngredientList(String ingredientsListEntry) {
	String s = ingredientsListEntry;
	String last = "";
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
		ingredientList[i] = ingredientList[i].replace("name" ,"");
		ingredientList[i] = ingredientList[i].replace(":" ,"");
		
		//System.out.println(ingredientList[i]);
		String[] tmp = ingredientList[i].split(";");
		try {
			if(tmp.length==3) {
				String tmp2 = "";
				if(tmp[0].equals("")) {
					tmp2 = tmp[2] +" "+ tmp[0] +" "+ tmp[1];
				}
				else {
				 tmp2 = tmp[2] +" "+ tmp[0] +" de "+ tmp[1];
				}
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
		
				
	}	for(int z = 0; z < newIngredientList.size(); z++) {
		last = last + newIngredientList.get(z) + "<br />"; 
	}
return last;}
}
