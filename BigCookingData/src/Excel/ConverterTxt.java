package Excel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConverterTxt {
	
	public static void main(String[] args) throws IOException {
		File fichier = new File("C:\\Users\\Admin\\git\\BCD\\BigCookingData\\src\\Excel\\a.txt");
		FileWriter file = new FileWriter("C:\\Users\\Admin\\git\\BCD\\BigCookingData\\src\\Excel\\b.txt");
		//System.out.println(fichier.getPath());
	    String ligne= new String();
	    String ecrit= new String();

	    BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(fichier));
	    BufferedWriter bw = new BufferedWriter(file);
	    
	    while((ligne = lecteurAvecBuffer.readLine()) != null) {
		      //System.out.println(ligne);
	    		String[] queries = ligne.split(";");
	    		//ecrit = "l";
	    		//System.out.println("INSERT INTO `ingredient` (`alim_grp_code`, `alim_ssgrp_code`, `alim_ssssgrp_code`, `alim_grp_nom_fr`, `alim_ssgrp_nom_fr`, `alim_ssssgrp_nom_fr`,`alim_code`,`alim_nom_fr`,`Energie, R�glement UE N� 1169/2011 (kcal/100g)`,`Energie, N x facteur Jones, avec fibres  (kJ/100g)`, `Energie, N x facteur Jones, avec fibres  (kcal/100g)`, `Eau (g/100g)`, `Prot�ines (g/100g)`, `Prot�ines brutes, N x 6.25 (g/100g)`, `Glucides (g/100g)`,`Lipides (g/100g)`,`Sucres (g/100g)`,`Amidon (g/100g)`,`Fibres alimentaires (g/100g)`,`Polyols totaux (g/100g)`,`Cendres (g/100g)`,`Alcool (g/100g)`,`Acides organiques (g/100g)`,`AG satur�s (g/100g)`,`AG monoinsatur�s (g/100g)`,`AG polyinsatur�s (g/100g)`,`AG 4:0, butyrique (g/100g)`,`AG 6:0, capro�que (g/100g)`,`AG 8:0, caprylique (g/100g)`,`AG 10:0, caprique (g/100g)`,`AG 12:0, laurique (g/100g)`, `AG 14:0, myristique (g/100g)`, `AG 16:0, palmitique (g/100g)`, `AG 18:0, st�arique (g/100g)`, `AG 18:1 9c (n-9), ol�ique (g/100g)`, `AG 18:2 9c,12c (n-6), linol�ique (g/100g)`,`AG 18:3 c9,c12,c15 (n-3), alpha-linol�nique (g/100g)`,`AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100g)`,`AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100g)`, `AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100g)`, `Cholest�rol (mg/100g)`, `Sel chlorure de sodium (g/100g)`, `Calcium (mg/100g)`, `Chlorure (mg/100g)`,`Cuivre (mg/100g)`,`Fer (mg/100g)`,`Iode (�g/100g)`, `Magn�sium (mg/100g)`, `Mangan�se (mg/100g)`, `Phosphore (mg/100g)`, `Potassium (mg/100g)`,`S�l�nium (�g/100g)`,`Sodium (mg/100g)`,`Zinc (mg/100g)`,`R�tinol (�g/100g)`,`Beta-Carot�ne (�g/100g)`,`Vitamine D (�g/100g)`,`Vitamine E (mg/100g)`,`Vitamine K1 (�g/100g)`,`Vitamine K2 (�g/100g)`,`Vitamine C (mg/100g)`,`Vitamine B1 ou Thiamine (mg/100g)`,`Vitamine B2 ou Riboflavine (mg/100g)`,`Vitamine B3 ou PP ou Niacine (mg/100g)`,`Vitamine B5 ou Acide pantoth�nique (mg/100g)`,`Vitamine B6 (mg/100g)`,`Vitamine B9 ou Folates totaux (�g/100g)`,`Vitamine B12 (�g/100g)`,`Poids`) VALUES" + " ("+ queries[0] +","+ queries[1]+","+ queries[0] +","+ queries[1]+","+ queries[2] +",`"+ queries[3]+"`,`"+ queries[4] +"`,`"+ queries[5]+"`,"+ queries[6]+",`"+ queries[7]+"`,"+ queries[8]+","+ queries[9]+","+ queries[10]+","+ queries[11]+","+ queries[12]+","+ queries[13]+","+ queries[14]+","+ queries[15]+","+ queries[16]+","+ queries[17]+","+ queries[18]+","+ queries[19]+","+ queries[20]+","+ queries[21]+","+ queries[22]+","+ queries[23]+","+ queries[24]+","+ queries[25]+","+ queries[26]+","+ queries[27]+","+ queries[28]+","+ queries[29]+","+ queries[30]+","+ queries[31]+","+ queries[32]+","+ queries[33]+","+ queries[34]+","+ queries[35]+","+ queries[36]+","+ queries[37]+","+ queries[38]+","+ queries[39]+","+ queries[40]+","+ queries[41]+","+ queries[42]+","+ queries[43]+","+ queries[44]+","+ queries[45]+","+ queries[46]+","+ queries[47]+","+ queries[48]+","+ queries[49]+","+ queries[50]+","+ queries[51]+","+ queries[52]+","+ queries[53]+","+ queries[54]+","+ queries[55]+","+ queries[56]+","+ queries[57]+","+ queries[58]+","+ queries[59]+","+ queries[60]+","+ queries[61]+","+ queries[62]+","+ queries[63]+","+ queries[64]+","+ queries[65]+","+ queries[66]+","+ queries[67]+",0);\n");

	    		ecrit = "INSERT INTO `ingredient` (`alim_grp_code`, `alim_ssgrp_code`, `alim_ssssgrp_code`, `alim_grp_nom_fr`, `alim_ssgrp_nom_fr`, `alim_ssssgrp_nom_fr`,`alim_code`,`alim_nom_fr`,`Energie, R�glement UE N� 1169/2011 (kcal/100g)`,`Energie, N x facteur Jones, avec fibres  (kJ/100g)`, `Energie, N x facteur Jones, avec fibres  (kcal/100g)`, `Eau (g/100g)`, `Prot�ines (g/100g)`, `Prot�ines brutes, N x 6.25 (g/100g)`, `Glucides (g/100g)`,`Lipides (g/100g)`,`Sucres (g/100g)`,`Amidon (g/100g)`,`Fibres alimentaires (g/100g)`,`Polyols totaux (g/100g)`,`Cendres (g/100g)`,`Alcool (g/100g)`,`Acides organiques (g/100g)`,`AG satur�s (g/100g)`,`AG monoinsatur�s (g/100g)`,`AG polyinsatur�s (g/100g)`,`AG 4:0, butyrique (g/100g)`,`AG 6:0, capro�que (g/100g)`,`AG 8:0, caprylique (g/100g)`,`AG 10:0, caprique (g/100g)`,`AG 12:0, laurique (g/100g)`, `AG 14:0, myristique (g/100g)`, `AG 16:0, palmitique (g/100g)`, `AG 18:0, st�arique (g/100g)`, `AG 18:1 9c (n-9), ol�ique (g/100g)`, `AG 18:2 9c,12c (n-6), linol�ique (g/100g)`,`AG 18:3 c9,c12,c15 (n-3), alpha-linol�nique (g/100g)`,`AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100g)`,`AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100g)`, `AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100g)`, `Cholest�rol (mg/100g)`, `Sel chlorure de sodium (g/100g)`, `Calcium (mg/100g)`, `Chlorure (mg/100g)`,`Cuivre (mg/100g)`,`Fer (mg/100g)`,`Iode (�g/100g)`, `Magn�sium (mg/100g)`, `Mangan�se (mg/100g)`, `Phosphore (mg/100g)`, `Potassium (mg/100g)`,`S�l�nium (�g/100g)`,`Sodium (mg/100g)`,`Zinc (mg/100g)`,`R�tinol (�g/100g)`,`Beta-Carot�ne (�g/100g)`,`Vitamine D (�g/100g)`,`Vitamine E (mg/100g)`,`Vitamine K1 (�g/100g)`,`Vitamine K2 (�g/100g)`,`Vitamine C (mg/100g)`,`Vitamine B1 ou Thiamine (mg/100g)`,`Vitamine B2 ou Riboflavine (mg/100g)`,`Vitamine B3 ou PP ou Niacine (mg/100g)`,`Vitamine B5 ou Acide pantoth�nique (mg/100g)`,`Vitamine B6 (mg/100g)`,`Vitamine B9 ou Folates totaux (�g/100g)`,`Vitamine B12 (�g/100g)`,`Poids`) VALUES" + " ("+ queries[0] +","+ queries[1]+","+ queries[0] +","+ queries[1]+","+ queries[2] +",`"+ queries[3]+"`,`"+ queries[4] +"`,`"+ queries[5]+"`,"+ queries[6]+",`"+ queries[7]+"`,"+ queries[8]+","+ queries[9]+","+ queries[10]+","+ queries[11]+","+ queries[12]+","+ queries[13]+","+ queries[14]+","+ queries[15]+","+ queries[16]+","+ queries[17]+","+ queries[18]+","+ queries[19]+","+ queries[20]+","+ queries[21]+","+ queries[22]+","+ queries[23]+","+ queries[24]+","+ queries[25]+","+ queries[26]+","+ queries[27]+","+ queries[28]+","+ queries[29]+","+ queries[30]+","+ queries[31]+","+ queries[32]+","+ queries[33]+","+ queries[34]+","+ queries[35]+","+ queries[36]+","+ queries[37]+","+ queries[38]+","+ queries[39]+","+ queries[40]+","+ queries[41]+","+ queries[42]+","+ queries[43]+","+ queries[44]+","+ queries[45]+","+ queries[46]+","+ queries[47]+","+ queries[48]+","+ queries[49]+","+ queries[50]+","+ queries[51]+","+ queries[52]+","+ queries[53]+","+ queries[54]+","+ queries[55]+","+ queries[56]+","+ queries[57]+","+ queries[58]+","+ queries[59]+","+ queries[60]+","+ queries[61]+","+ queries[62]+","+ queries[63]+","+ queries[64]+","+ queries[65]+","+ queries[66]+","+ queries[67]+",0);\n";
	    		bw.write(ecrit);
	    		//System.out.println(queries.length);
	    		//System.out.println("INSERT INTO `ingredient` (`id_site`, `name`, `adress`, `site_price`, `type`, `site_isle`,`busDisponibility`,`boatDisponibility`,`id_coordinate`) VALUES"
//+ "(1, 'Haleakala National Park ', '41 Hana Hwy, Hana, HI 96713, Etats-Unis', 100, 'activity', 'hawaii',TRUE,TRUE,7)");
	    		
	    }
	   
	    bw.close();
	    lecteurAvecBuffer.close();
	  }
	}

