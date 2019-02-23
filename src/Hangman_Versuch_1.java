import java.util.List;
import java.util.Scanner;

public class Hangman_Versuch_1 {

	public static void WordTest() {
	int i=0;
	Scanner eing = new Scanner(System.in);
	  String INWORD = eing.next();	
		
	String TEST_WORD ="TESTWORD";
	String[] selectedWord = TEST_WORD.split("(?<!^)");
	String[] WordInput = INWORD.split("(?<!^)");
		if (WordInput.length>1){
			if (INWORD.equals(TEST_WORD)){
				System.out.println("Yes");
			}
			else {
			System.out.println("Try again!");
			
			
			}
		}
		else {

	
			do {
	
				if (WordInput[1]==selectedWord[i]){
					System.out.println(WordInput[1] + "is true");
				}
	
	
	
	
				i++;
			}while (i<TEST_WORD.length());
			
		}
		}    
	    //System.out.println(INWORD);		
	   	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordTest();
	}

}
