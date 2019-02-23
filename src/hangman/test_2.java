package hangman;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

import com.google.common.base.Charsets;
import com.google.common.io.*;

public class test_2 {

	public static void main(String[] args) throws IOException {
		
		/*File file = new File("output.txt");
		List<String> words = Files.asCharSource(file, Charsets.ISO_8859_1).readLines();
		int n = (int)(words.size()*Math.random());
		System.out.println(words.get(n));*/
		System.out.println(output(20));
		
		
	}
	
	public static String output(int n){
		
		String[][] matrix=new String[8][5]; //define print matrix first rows second columns
		matrix[0][0] = matrix[0][1] = matrix[0][2]=matrix[0][3]=matrix[0][4] = "|"; //filling first row wit "|"
		matrix[1][0] = matrix[2][0] = matrix[3][0]=matrix[4][0]=matrix[5][0]=matrix[6][0]="|"; //filling in the "|" in first column
		matrix[1][1] = matrix[1][2] = matrix[1][3]=matrix[1][4]= matrix[2][1]=matrix[2][3]=matrix[3][1]=matrix[4][1]=matrix[5][1]=matrix[5][2]=matrix[6][1]=matrix[6][2]=" "; //filling everything with the needed whitespace
		matrix[7][0] = matrix[7][1] = matrix[7][2]=matrix[7][3]="-"; //filling the 7th row with "-"
		matrix[6][3] = matrix[4][3] = matrix[2][2]=matrix[2][4]="|";//filled in last "|"
		matrix[5][3] = "O";//head
		matrix[4][2] = "<";//left arm
		matrix[4][4] = ">";//right arm
		matrix[3][2] = matrix[3][4]=".";//knees
		matrix[3][3]= "^";//hip
		
		String return_string = "";
		String top="----";
		String fivepsix=matrix[6][0]+matrix[6][1]+matrix[6][2]+matrix[6][3]+"\n"+matrix[5][0]+matrix[5][1]+matrix[5][2]+matrix[5][3];
		String four=matrix[4][0]+matrix[4][1]+matrix[4][2]+matrix[4][3]+matrix[4][4];
		String three=matrix[3][0]+matrix[3][1]+matrix[3][2]+matrix[3][3]+matrix[3][4];
		for(int i=0;i<5;i++) { 
			return_string=return_string+matrix[0][i];
		}
		
		
		switch(Integer.valueOf(n)) {	
		
		case 1:
			return_string=matrix[1][0]+"\n"+return_string;
			break;
		case 2:
			return_string=matrix[2][0]+"\n"+output(1);
			break;
		case 3:
			return_string=matrix[3][0]+"\n"+output(2);
			break;
		case 4:
			return_string=matrix[4][0]+"\n"+output(3);
			break;
		case 5:
			return_string=matrix[5][0]+"\n"+output(4);
			break;
		case 6:
			return_string=matrix[6][0]+"\n"+output(5);
			break;
		case 7:
			return_string=matrix[7][0]+"\n"+output(6);
			break;
		case 8:
			return_string=matrix[7][1]+output(7);
			break;
		case 9:
			return_string=matrix[7][2]+output(8);
			break;
		case 10:
			return_string=matrix[7][3]+output(9);
			break;
		case 11:
			return_string=top+"\n"+matrix[6][0]+matrix[6][1]+matrix[6][2]+matrix[6][3]+"\n"+output(5);
			break;
		case 12:
			return_string=top+"\n"+fivepsix+"\n"+output(4);
			break;
		case 13:
			return_string=top+"\n"+fivepsix+"\n"+matrix[4][0]+matrix[4][1]+" "+matrix[4][3]+"\n"+output(3);
			break;
		case 14:
			return_string=top+"\n"+fivepsix+"\n"+matrix[4][0]+matrix[4][1]+matrix[4][2]+matrix[4][3]+"\n"+output(3);
			break;
		case 15:
			return_string=top+"\n"+fivepsix+"\n"+matrix[4][0]+matrix[4][1]+matrix[4][2]+matrix[4][3]+matrix[4][4]+"\n"+output(3);
			break;
		case 16:
			return_string=top+"\n"+fivepsix+"\n"+four+"\n"+matrix[3][0]+matrix[3][1]+" "+matrix[3][3]+"\n"+output(2);
			break;
		case 17:
			return_string=top+"\n"+fivepsix+"\n"+four+"\n"+matrix[3][0]+matrix[3][1]+matrix[3][2]+matrix[3][3]+"\n"+output(2);
			break;
		case 18:
			return_string=top+"\n"+fivepsix+"\n"+four+"\n"+matrix[3][0]+matrix[3][1]+matrix[3][2]+matrix[3][3]+matrix[3][4]+"\n"+output(2);
			break;
		case 19:
			return_string=top+"\n"+fivepsix+"\n"+four+"\n"+three+"\n"+matrix[2][0]+matrix[2][1]+matrix[2][2]+"\n"+output(1);
			break;
		case 20:
			return_string=top+"\n"+fivepsix+"\n"+four+"\n"+three+"\n"+matrix[2][0]+matrix[2][1]+matrix[2][2]+matrix[2][3]+matrix[2][4]+"\n"+output(1);
			break;
		case 21:
			return_string="Du hast Verloren!";

			
		}
		
		
		
		
		return return_string;
      
      
      
	}

}
