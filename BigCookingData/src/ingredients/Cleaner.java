package ingredients;

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
			
				
			
				/*String[] partLine1 = partLine[index1].split("\"");
				if (index1 == 0) {
					for (int index2 = 0; index2 < partLine1.length; index2++) {
						if (index2 != 0) {
							/*if(partLine1[index2].contains(": ")) {
								System.out.println("n");
								partLine1[index2].replace(": ", "");
							}*/
				/*			result = result + partLine1[index2] + " ";
						}
	
					}
				}
				else {
					for (int index3 = 0; index3 < partLine1.length; index3++) {
						if (index3 != 0 && index3 != 1 ) {
							result = result + partLine1[index3];
						}
				}
				}*/
			
			
			}result = result + "\n";
		}
		return result;
	}
}
