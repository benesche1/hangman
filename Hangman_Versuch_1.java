import java.util.List;       						 	//hier wird irgendwas importiert
import java.util.ArrayList;								//				-II-
import java.util.Arrays;								//				-II-
import java.util.List;									//				-II-
import java.io.*;										//				-II-
import java.util.Scanner;								//				-II-
import com.google.common.base.Charsets;					//				-II-
import com.google.common.io.*;							//				-II-


public class Hangman_Versuch_1 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("output.txt");
		List<String> words = Files.asCharSource(file, Charsets.ISO_8859_1).readLines();
		int n = (int)(words.size()*Math.random());
		
		
		String random_word = words.get(n);
		System.out.println(random_word);
		boolean have_won = false;
		int state=0;
		String[] output_word = new String[words.size()];
		
		System.out.println("Wilkommen bei Hangman. Hier ist ihr \"Wort\"");
		for(int i=0;i<random_word.length();i++) {
			System.out.print("_ ");
			output_word[i]="_ ";
		}
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		while(have_won!=true) {
			while(state<21) {
				System.out.println("\nWählen Sie einen Buchstaben: ");
				String input = scanner.next();
				int[][] wordtest_reponse = wordtest(input, random_word); //rückgabe von wort prüfung 
				
				if(wordtest_reponse[0][0]==2) { //richtigs wort gewonnen
					have_won=true;
					System.out.println("GEWONNEN!!!!");
					System.exit(0);
				}else if(wordtest_reponse[0][0]==1) { //falsches wort noch mal
					System.out.println("\n\n\n\n\n");
					state++;
					System.out.println(output(state));
					for(int i=0;i<random_word.length();i++) {
						System.out.print(output_word[i]);
					}
					
				}else if(wordtest_reponse[0][1]==2) { //richtiger buchstabe gibt buchstaben aus
					
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println(output(state));
					for(int i=0;i<random_word.length();i++) {
						if(wordtest_reponse[1][i]==1) {
							output_word[i]=input;
							System.out.print(output_word[i]);
						}else {
							System.out.print(output_word[i]);
						}
					}
					if(Arrays.asList(output_word).contains("_ ")==false) {
						System.out.println("\n\n\n\n\n\n\n\nGEWONNEN!!!!");
						System.exit(0);
					}
				}else if(wordtest_reponse[0][1]==1) { //falscher buchstabe gibt hangman und buchstaben aus
					System.out.println("\n\n\n\n\n\n\n");
					state++;
					System.out.println(output(state));
					for(int i=0;i<random_word.length();i++) {
						System.out.print(output_word[i]);
					}
					
				}
				
			}
		}
			
}

	public static int[][] wordtest(String input,String word) {
	String[] selectedWord = word.split("(?<!^)"); 		//zufällig gewähltes wort wird eingelesen und gespallten
	String[] WordInput = input.split("(?<!^)");   		//eingegebenes wort wird eingelesen und gespallten 
	int[][] response = new int[2][selectedWord.length]; //Syntax [wort,buchstabe] 0: nicht vorhanden; 1:falsch; 2:richtig
	
	
		if (WordInput.length>1){
			if (input.equals(word)){
				response[0][0]=2;
				//System.out.println("Yes");
				return response;	
			}
			else {
				response[0][0]=1;
				//System.out.println("Try again!");
				return response;
			
			}
		}
		else {
			
	
			for (int i=0;i<word.length();i++) {
				
				//System.out.print("Word: "+ WordInput[0]+"\n");
				//System.out.println(selectedWord[i]);
				
				if (WordInput[0].toLowerCase().equals(selectedWord[i].toLowerCase())){   //eventuell: (WordInput[1]==selectedWord[i])
					response[0][1]=2; // wert für prüfung setzenj
					response[1][i]=1; // wert für position
					//System.out.println(WordInput[0] + "is true");  //eventuell: System.out.println(WordInput[1] + "is true");
				
				
				}
	
	
			}
			if(response[0][1]==0) {
				response[0][1]=1;
			}
			return response;
			
			
		}
	}    
	
/*public static String output_(int[][] array, String word) {
	
}*/
	   	
	
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
