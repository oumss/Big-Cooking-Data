package ingredients;

import persistance.RecipePersistance;

public class Cleaner {

	public String cleanSteps(Integer id_recipe) {
		
		RecipePersistance rp = new RecipePersistance();
		
		String a = rp.readEtapeById(id_recipe);
		String result = "";
		String[] line = a.split("},");
		for (int index = 0; index < line.length; index++) {
			String[] partLine = line[index].split(",");
			for (int index1 = 0; index1 < partLine.length; index1++) {
				String[] partLine1 = partLine[index1].split("\"");
				//result = result + partLine1
			}
		
		}
		return null;
	}
}
