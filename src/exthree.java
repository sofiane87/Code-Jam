import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class exthree {
	
	ArrayList<ArrayList<String>> mult = new ArrayList<ArrayList<String>>();
	
	

	public String multiply (String s1,String s2 ) {
		int signe1 = 1;
		int signe2 = 1;
		String si1 = ""+s1.charAt(0);
		String si2 = ""+s2.charAt(0);
		String l1;
		String l2;
		String reponse = null;
		String sr;
		String fr = null;
		
		//System.out.println("le s1: "+s1 +" le s2: "+s2);
		
		//stockage du signe et de la lettre
		if (si1.equals("-")) 
		{signe1 = -1;
		l1 = ""+s1.charAt(1);}	
		
		else { l1 = ""+s1.charAt(0);}
		
		if (si2.equals("-")) {
			signe2 = -1;
			l2 = ""+s2.charAt(1);
		}
		
		else { l2 = ""+s2.charAt(0);}
		
		//System.out.println(signe1+" "+l1+" "+signe2+" "+l2);
		
		switch (l1) {
		case "1" : switch (l2) {
				   case "1"	: reponse = "1";break;
				   case "i" : reponse = "i";break;
				   case "j" : reponse = "j";break;
				   case "k" : reponse = "k";break;
		}break;
		
		case "i" : switch (l2) {
		   case "1"	: reponse = "i"; break;
		   case "i" : reponse = "-1";break;
		   case "j" : reponse = "k";break;
		   case "k" : reponse = "-j";break;
}break;

		case "j" : switch (l2) {
		   case "1"	: reponse = "j";break;
		   case "i" : reponse = "-k";break;
		   case "j" : reponse = "-1";break;
		   case "k" : reponse = "i";break;
}break;
		
		case "k" : 
			switch (l2) {
		   case "1"	: reponse = "k";break;
		   case "i" : reponse = "j";break;
		   case "j" : reponse = "-i";break;
		   case "k" : reponse = "-1";break;
}break;
		
		}
		
		
	//System.out.println("la reponse1: "+reponse);
	
	sr = ""+reponse.charAt(0);
	
	if (sr.equals("-")) {
		if (signe1*signe2 == -1) { fr = ""+reponse.charAt(1);}
		else {fr = reponse;}
	}
	
	else {if (signe1*signe2 == -1) { fr ="-"+reponse;}
		  else {fr = reponse;}
	}

	return fr;	
	}
	
	
	public void operate (String s) throws NumberFormatException, IOException {
		
		//System.out.println("debut de l'opération");
		
		InputStream inStream = new FileInputStream(s);
		  final InputStreamReader streamReader = new InputStreamReader(inStream);
		  final BufferedReader bufferedReader = new BufferedReader(streamReader);
		  String line = "";
		
		  OutputStream outStream = new FileOutputStream("src/output.txt");
		  final OutputStreamWriter streamWriter = new OutputStreamWriter (outStream);
		  final BufferedWriter bw = new BufferedWriter (streamWriter);
		  
		  int cas = Integer.parseInt(bufferedReader.readLine());
		  //System.out.println("recuperation du nombre de cas :"+ cas);
		  
		  
		  for (int i =0; i< cas; i++) {
			  String[] ligne1 = bufferedReader.readLine().split(" ");
			  String ligne2 = bufferedReader.readLine();
			  
			  long L = Long.parseLong(ligne1[0]);
			  long X = Long.parseLong(ligne1[1]);
			  String util = "";
			  boolean verif = false;
			  
			  // creation de la ligne 
			  for (int k =0; k< X ; k++) {
				  util += ligne2;
			  }
			  
			  //System.out.println("recuperation de L: "+L+" recuperation de X: "+X+" recuperation de la longueur de util: "+util.length());
			  
			  // stockage des resultats obtenus précédemment
			  String resultat_devant = "";
			  String resultat_deriere = "";
			  
			  // stockage des positions des i et des k
			  ArrayList<Integer> is = new ArrayList<Integer>();
			  ArrayList<Integer> ks = new ArrayList<Integer>();
			  
			  //System.out.println("entrée dans la boucle de cacul des i et k");
			  // ajout des i et des k
			  for (int z = 0; z<X*L; z++) {
		
				  //recuperation du caractere à la position z et length -1 -z
				  
				  String sav=""+util.charAt(z);;
				  String sar=""+util.charAt(util.length()-1-z);
				  //if(i != 4 ) {System.out.println(i+" recuperation de sav: "+sav+" et de sar: "+sar);}
				  // cas particulier de l'initialisation 
				  if (z ==0) {	
					  if (sav.equals("i")) {is.add(0); 
					  	//System.out.println("on a ajouté un i!");
					  	}
					  if (sar.equals("k")) {ks.add(util.length()-1);
					  	  //System.out.println("on a ajouté un k!");
					  	  }
					  
					  resultat_devant = sav;
					  resultat_deriere = sar;
				  }
				  
				  // le reste du temps
				  else { //System.out.println("debut de la multiplication");
					   //if(i != 4 ) {System.out.println("cas "+i+" "+resultat_devant+" "+sav+" "+resultat_deriere+" "+sar);}
					  	 resultat_devant = multiply (resultat_devant,sav);
					  	 //System.out.println("affichage resultat_devant: "+resultat_devant);
				  		 resultat_deriere = multiply (sar,resultat_deriere);
				  		//System.out.println("affichage resultat_deriere: "+resultat_deriere);
				  		 
				  		 if (resultat_devant.equals("i")) { is.add(z);
				  		  //System.out.println("un i a été détécté à la position: "+z);
				  		  }
				  		 if (resultat_deriere.equals("k")) {ks.add(util.length()-1-z);
				  		 //System.out.println("un k a été détécté à la position: "+(util.length()-1-z));
				  		 }
					  
				  }
			  }
			  
			  ArrayList<ArrayList<String>> save = new ArrayList<ArrayList<String>>();
			  
			  // liste des is et des ks obtenus ---> recherche des J
			  
			 int u = is.size()-1;
			 
			 if (ks.size()!= 0) {
			 int kmax = ks.get(0);
			 while ( !verif && u >=0) {

			 String r = "";
			 ArrayList<String> tempo = new ArrayList<String>();
			 if (u == is.size()-1) {
			 int m = is.get(u)+1;
			 	while (m<kmax && !verif) {
			 	if (r.equals("")) {r = ""+util.charAt(m);}
			 	
			 	else {r= multiply(r,(""+util.charAt(m)));}
			 	
			 	if (ks.contains(m+1)) {tempo.add(r);}
			 	if (ks.contains(m+1)&&r.equals("j")) {verif = true;}
			 	
			 	m++;
			 	}
			 	
			 	save.add(tempo);
				
			 }
			 else {
				 ArrayList<String> tempo1 = new ArrayList<String>();
				 String rep = "";
				 int a = 0;
				 while (!verif & a<save.get(0).size()) {
					for (int g = is.get(u)+1; g<is.get(u+1); g++) {
						if (g== is.get(u)+1) {rep = ""+util.charAt(g);}
						else {rep = multiply (rep,(""+util.charAt(g)));}
					}
					
					rep = multiply(rep,save.get(is.size()-2-u).get(a));
					tempo1.add(rep);
					if (rep == "j") {verif = true;}	
				a++;	 
				 }
				 	save.add(tempo1);
				 
			 }
			 u--;
			 }
			 }
			 
			 if (verif) {System.out.println("done");
				 bw.write("Case #"+(i+1)+": YES"+"\r\n");
				 bw.flush();}
			 else {System.out.println("done");
				 	bw.write("Case #"+(i+1)+": NO"+"\r\n");
				   bw.flush();}
		  }
		  
		  
	}
	
	
	public static void main (String args[]) throws NumberFormatException, IOException {
		
		exthree test = new exthree();
		test.operate("D:/Boulot/Personnal Project/Code Jam/src/input.in");
		
		/*System.out.println("i * i "+test.multiply("i","i"));
		System.out.println("i * j "+test.multiply("i","j"));
		System.out.println("i * k "+test.multiply("i","k"));
		System.out.println("j * i "+test.multiply("j","i"));
		System.out.println("j * j "+test.multiply("j","j"));
		System.out.println("j * k "+test.multiply("j","k"));
		System.out.println("k * j "+test.multiply("k","j"));
		System.out.println("i * 1 "+test.multiply("i","1"));*/
	}
}
