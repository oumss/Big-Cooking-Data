package Excel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConverterTxt {

	public static void main(String[] args) throws IOException {
		File fileA = new File(new File("src//Excel//a.txt").getAbsolutePath());
		FileWriter fileB = new FileWriter(new File("src//Excel//b.txt").getAbsolutePath());
		System.out.println(fileA.getPath());
		String ligne = new String();
		String insert = new String();

		BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(fileA));
		BufferedWriter bw = new BufferedWriter(fileB);
		int nb = 0;
		
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			nb++;
			String[] queries = ligne.split(";");
			System.out.println("### NB LIGNE " + nb);
			System.out.println("lenght " + queries.length);

			System.out.println("37 " + queries[60]);
			System.out.println("38 " + queries[38]);
			System.out.println("39 " + queries[39]);
			System.out.println("65 " + queries[65]);
			System.out.println("66 " + queries[66]);
			System.out.println("67 " + queries[67]);
    		
    		//System.out.println("INSERT INTO `ingredient` (`alim_grp_code`, `alim_ssgrp_code`, `alim_ssssgrp_code`, `alim_grp_nom_fr`, `alim_ssgrp_nom_fr`, `alim_ssssgrp_nom_fr`,`alim_code`,`alim_nom_fr`,`Energie, Règlement UE N° 1169/2011 (kcal/100g)`,`Energie, N x facteur Jones, avec fibres  (kJ/100g)`, `Energie, N x facteur Jones, avec fibres  (kcal/100g)`, `Eau (g/100g)`, `Protéines (g/100g)`, `Protéines brutes, N x 6.25 (g/100g)`, `Glucides (g/100g)`,`Lipides (g/100g)`,`Sucres (g/100g)`,`Amidon (g/100g)`,`Fibres alimentaires (g/100g)`,`Polyols totaux (g/100g)`,`Cendres (g/100g)`,`Alcool (g/100g)`,`Acides organiques (g/100g)`,`AG saturés (g/100g)`,`AG monoinsaturés (g/100g)`,`AG polyinsaturés (g/100g)`,`AG 4:0, butyrique (g/100g)`,`AG 6:0, caproïque (g/100g)`,`AG 8:0, caprylique (g/100g)`,`AG 10:0, caprique (g/100g)`,`AG 12:0, laurique (g/100g)`, `AG 14:0, myristique (g/100g)`, `AG 16:0, palmitique (g/100g)`, `AG 18:0, stéarique (g/100g)`, `AG 18:1 9c (n-9), oléique (g/100g)`, `AG 18:2 9c,12c (n-6), linoléique (g/100g)`,`AG 18:3 c9,c12,c15 (n-3), alpha-linolénique (g/100g)`,`AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100g)`,`AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100g)`, `AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100g)`, `Cholestérol (mg/100g)`, `Sel chlorure de sodium (g/100g)`, `Calcium (mg/100g)`, `Chlorure (mg/100g)`,`Cuivre (mg/100g)`,`Fer (mg/100g)`,`Iode (µg/100g)`, `Magnésium (mg/100g)`, `Manganèse (mg/100g)`, `Phosphore (mg/100g)`, `Potassium (mg/100g)`,`Sélénium (µg/100g)`,`Sodium (mg/100g)`,`Zinc (mg/100g)`,`Rétinol (µg/100g)`,`Beta-Carotène (µg/100g)`,`Vitamine D (µg/100g)`,`Vitamine E (mg/100g)`,`Vitamine K1 (µg/100g)`,`Vitamine K2 (µg/100g)`,`Vitamine C (mg/100g)`,`Vitamine B1 ou Thiamine (mg/100g)`,`Vitamine B2 ou Riboflavine (mg/100g)`,`Vitamine B3 ou PP ou Niacine (mg/100g)`,`Vitamine B5 ou Acide pantothénique (mg/100g)`,`Vitamine B6 (mg/100g)`,`Vitamine B9 ou Folates totaux (µg/100g)`,`Vitamine B12 (µg/100g)`,`Poids`) VALUES" + " ("+ queries[0] +","+ queries[1]+","+ queries[0] +","+ queries[1]+","+ queries[2] +",`"+ queries[3]+"`,`"+ queries[4] +"`,`"+ queries[5]+"`,"+ queries[6]+",`"+ queries[7]+"`,"+ queries[8]+","+ queries[9]+","+ queries[10]+","+ queries[11]+","+ queries[12]+","+ queries[13]+","+ queries[14]+","+ queries[15]+","+ queries[16]+","+ queries[17]+","+ queries[18]+","+ queries[19]+","+ queries[20]+","+ queries[21]+","+ queries[22]+","+ queries[23]+","+ queries[24]+","+ queries[25]+","+ queries[26]+","+ queries[27]+","+ queries[28]+","+ queries[29]+","+ queries[30]+","+ queries[31]+","+ queries[32]+","+ queries[33]+","+ queries[34]+","+ queries[35]+","+ queries[36]+","+ queries[37]+","+ queries[38]+","+ queries[39]+","+ queries[40]+","+ queries[41]+","+ queries[42]+","+ queries[43]+","+ queries[44]+","+ queries[45]+","+ queries[46]+","+ queries[47]+","+ queries[48]+","+ queries[49]+","+ queries[50]+","+ queries[51]+","+ queries[52]+","+ queries[53]+","+ queries[54]+","+ queries[55]+","+ queries[56]+","+ queries[57]+","+ queries[58]+","+ queries[59]+","+ queries[60]+","+ queries[61]+","+ queries[62]+","+ queries[63]+","+ queries[64]+","+ queries[65]+","+ queries[66]+","+ queries[67]+",0);\n");
    		insert = "INSERT INTO `ingredient` (`alim_grp_code`, `alim_ssgrp_code`, `alim_ssssgrp_code`, `alim_grp_nom_fr`, `alim_ssgrp_nom_fr`, `alim_ssssgrp_nom_fr`,`alim_code`,`alim_nom_fr`,`Energie, Règlement UE N° 1169/2011 (kcal/100g)`,`Energie, N x facteur Jones, avec fibres  (kJ/100g)`, `Energie, N x facteur Jones, avec fibres  (kcal/100g)`, `Eau (g/100g)`, `Protéines (g/100g)`, `Protéines brutes, N x 6.25 (g/100g)`, `Glucides (g/100g)`,`Lipides (g/100g)`,`Sucres (g/100g)`,`Amidon (g/100g)`,`Fibres alimentaires (g/100g)`,`Polyols totaux (g/100g)`,`Cendres (g/100g)`,`Alcool (g/100g)`,`Acides organiques (g/100g)`,`AG saturés (g/100g)`,`AG monoinsaturés (g/100g)`,`AG polyinsaturés (g/100g)`,`AG 4:0, butyrique (g/100g)`,`AG 6:0, caproïque (g/100g)`,`AG 8:0, caprylique (g/100g)`,`AG 10:0, caprique (g/100g)`,`AG 12:0, laurique (g/100g)`, `AG 14:0, myristique (g/100g)`, `AG 16:0, palmitique (g/100g)`, `AG 18:0, stéarique (g/100g)`, `AG 18:1 9c (n-9), oléique (g/100g)`, `AG 18:2 9c,12c (n-6), linoléique (g/100g)`,`AG 18:3 c9,c12,c15 (n-3), alpha-linolénique (g/100g)`,`AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100g)`,`AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100g)`, `AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100g)`, `Cholestérol (mg/100g)`, `Sel chlorure de sodium (g/100g)`, `Calcium (mg/100g)`, `Chlorure (mg/100g)`,`Cuivre (mg/100g)`,`Fer (mg/100g)`,`Iode (µg/100g)`, `Magnésium (mg/100g)`, `Manganèse (mg/100g)`, `Phosphore (mg/100g)`, `Potassium (mg/100g)`,`Sélénium (µg/100g)`,`Sodium (mg/100g)`,`Zinc (mg/100g)`,`Rétinol (µg/100g)`,`Beta-Carotène (µg/100g)`,`Vitamine D (µg/100g)`,`Vitamine E (mg/100g)`,`Vitamine K1 (µg/100g)`,`Vitamine K2 (µg/100g)`,`Vitamine C (mg/100g)`,`Vitamine B1 ou Thiamine (mg/100g)`,`Vitamine B2 ou Riboflavine (mg/100g)`,`Vitamine B3 ou PP ou Niacine (mg/100g)`,`Vitamine B5 ou Acide pantothénique (mg/100g)`,`Vitamine B6 (mg/100g)`,`Vitamine B9 ou Folates totaux (µg/100g)`,`Vitamine B12 (µg/100g)`,`Poids`) VALUES" 
    				+ " ("+ queries[0] +","+ queries[1]+","+ queries[2] +",'"+ queries[3]+"','"+ queries[4] +"','"+ queries[5]+"',"+ queries[6]+",'"+ queries[7]+"',"+ queries[8]+","+ queries[9]+","+ queries[10]+","+ queries[11]+","+ queries[12]+","+ queries[13]+","+ queries[14]+","+ queries[15]+","+ queries[16]+","+ queries[17]+","+ queries[18]+","+ queries[19]+","+ queries[20]+","+ queries[21]+","+ queries[22]+","+ queries[23]+","+ queries[24]+","+ queries[25]+","+ queries[26]+","+ queries[27]+","+ queries[28]+","+ queries[29]+","+ queries[30]+","+ queries[31]+","+ queries[32]+","+ queries[33]+","+ queries[34]+","+ queries[35]+","+ queries[36]+","+ queries[37]+","+ queries[38]+","+ queries[39]+","+ queries[40]+","+ queries[41]+","+ queries[42]+","+ queries[43]+","+ queries[44]+","+ queries[45]+","+ queries[46]+","+ queries[47]+","+ queries[48]+","+ queries[49]+","+ queries[50]+","+ queries[51]+","+ queries[52]+","+ queries[53]+","+ queries[54]+","+ queries[55]+","+ queries[56]+","+ queries[57]+","+ queries[58]+","+ queries[59]+","+ queries[60]+","+ queries[61]+","+ queries[62]+","+ queries[63]+","+ queries[64]+","+ queries[65]+","+ queries[66]+","+ queries[67]+",0);\n";
			bw.write(insert);
		}
		
		bw.close();
		lecteurAvecBuffer.close();
	}
}

