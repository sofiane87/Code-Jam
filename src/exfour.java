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


public class exfour {

	
	public void operate (String s ) throws NumberFormatException, IOException {
	InputStream inStream = new FileInputStream(s);
	  final InputStreamReader streamReader = new InputStreamReader(inStream);
	  final BufferedReader bufferedReader = new BufferedReader(streamReader);
	  String line = "";
	
	  OutputStream outStream = new FileOutputStream("src/output.txt");
	  final OutputStreamWriter streamWriter = new OutputStreamWriter (outStream);
	  final BufferedWriter bw = new BufferedWriter (streamWriter);
	  
	  int cas = Integer.parseInt(bufferedReader.readLine());
	  
	  for (int i =0; i<cas; i++) {
		  String[] ligne = bufferedReader.readLine().split(" ");
		  int X = Integer.parseInt(ligne[0]);
		  int R = Integer.parseInt(ligne[1]);
		  int C = Integer.parseInt(ligne[2]);
		  
		  if (((R*C) % X) != 0  ) 
		  { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
		  bw.flush();}
	
		  if ((int)Math.sqrt(X)>Math.max(R, C))  
		  { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
		  bw.flush();}
		  
		  else {bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
 		   bw.flush();}
		  
		  /*else {
			  switch(X) {
			  case 1 : bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
			  		   bw.flush();
			  		   break;
				  
			  case 2 : switch (R) {
			  		  case 1 : 
			  		   if (C == 2 || C == 4) {bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
			  		   bw.flush();} 
			  		   else { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
			 		  bw.flush();}
			  		   break;
			  		   case 2 : {bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
			  		   bw.flush();}
			  		   break;
			  		   case 3: if (C ==2 || C == 4) {bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
			  		   bw.flush();}
			  		   else { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
				 		  bw.flush();}
			  		   break;
			  		   
			  		   case 4: bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
			  		   bw.flush();
			  		   break;		    
			  }break;
			  case 3 :switch (R) { 
			  		  case 1 : { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
			  		  			bw.flush();}
			  		  break;
			  		  
			  		  case 2 : if (C == 3 ) { bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
			 		  bw.flush();}
			  		  		   else { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
	  		  			bw.flush();}
			  		  break;
			  		  
			  		  case 3 : if ( C ==1) { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
	  		  			bw.flush();}
			  		  		else { bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
					 		  bw.flush();}
			  		  break;
			  		  
			  		 case 4 : if ( C ==3) { bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
			 		  bw.flush();}
		  		  		else { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
		  		  			bw.flush();}
		  		  break;
			  }break;
				  
			  case 4 : switch (R) {
			  		   case 1 : { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
	  		  			bw.flush();}
			  		   break;
			  		   
			  		   case 2 : { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
	  		  			bw.flush();}
			  		   break;
			  		   
			  		   case 3: if ( C ==4) { bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
				 		  bw.flush();}
		  		  		else { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
		  		  			bw.flush();}
			  		   break;
			  		   
			  		   case 4: if (C<=2) { bw.write("Case #"+(i+1)+": RICHARD"+"\r\n");
	  		  			bw.flush();}
			  		   			else { bw.write("Case #"+(i+1)+": GABRIEL"+"\r\n");
				 		bw.flush();}
			  		  	break;
			  }break;
			  }
			  
		  
	  }*/
}

}
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			exfour test = new exfour();
			test.operate("D:/Boulot/Personnal Project/Code Jam/src/input.in");
		}
}