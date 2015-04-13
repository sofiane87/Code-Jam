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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class exone {
	
	ArrayList<ArrayList<Integer>> tableau  = new ArrayList<ArrayList<Integer>>();
	int cas = 0;
	ArrayList<Integer>max = new ArrayList<Integer>();
	
	public void lecture (String s) throws IOException {
		InputStream inStream = new FileInputStream(s);
		  final InputStreamReader streamReader = new InputStreamReader(inStream);
		  final BufferedReader bufferedReader = new BufferedReader(streamReader);
		  String line = "";
		  int i = 0;
		  while ((line = bufferedReader.readLine()) != null) {
			  if (i==0) {cas = Integer.parseInt(line);
			  i++;}
			  else { 
				  i++;
				  ArrayList<Integer> tempo = new ArrayList<Integer>();
				  max.add(Character.getNumericValue(line.charAt(0)));
				  for (int j =2; j<line.length();j++ ) {
					  tempo.add(Character.getNumericValue(line.charAt(j)));		   
				  }
			  tableau.add(tempo);
				  
			  }
		  }
	}
	
	public void ecriture () throws IOException {
		OutputStream outStream = new FileOutputStream("src/output.txt");
		final OutputStreamWriter streamWriter = new OutputStreamWriter (outStream);
		final BufferedWriter bw = new BufferedWriter (streamWriter);
	
		
		for (int k =0; k< cas; k++) {
			bw.write("Case #"+(k+1)+": ");
			int debout = 0;
			int manquant = 0;
		for (int i =0; i< tableau.get(k).size();i++) {
			if (i == 0) { debout += tableau.get(k).get(i);}
			else { if(debout > i) {debout += tableau.get(k).get(i);} 
			else {manquant += i-debout;
				  debout += tableau.get(k).get(i)+i-debout;
			}		
			}
		}
		bw.write(manquant+"\r\n");
	}
	
		bw.flush();
	}
	
	public static void main (String args[] ) throws IOException {
		exone test = new exone();
		
		test.lecture("D:/Boulot/Personnal Project/Code Jam/src/input.in");
		test.ecriture();
	}

}
