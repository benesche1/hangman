package hangman;

import java.util.ArrayList;
import java.io.FileWriter;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.*;

public class test_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("top10000de.txt");
		List<String> words = Files.asCharSource(file, Charsets.ISO_8859_1).readLines();
		List<String> words_processed = new ArrayList<String>();
		
		for(int i=0;i<words.size();i++){
			
			if(words.get(i).length()<=3){
				//System.out.println(words.get(i));
				//System.out.println(words.get(i));

			}else if(words.get(i).contains(" ")){
				
			}else if(words.get(i).contains("0")||words.get(i).contains("1")||words.get(i).contains("2")||words.get(i).contains("3")||words.get(i).contains("4")||words.get(i).contains("5")||words.get(i).contains("6")||words.get(i).contains("7")||words.get(i).contains("8")||words.get(i).contains("9")){
				
			}
			else{
				words_processed.add(words.get(i));
				System.out.println(words.get(i));
			}
			
		}
		System.out.println(words_processed.size());
		//System.out.println(words_processed.get(9413).contains("?"));
		FileWriter writer = new FileWriter("output.txt");
		for(String str: words_processed){
			writer.write(str+System.getProperty( "line.separator" ));
		}
		writer.close();
		
		
		
		//System.out.println(words_processed);
		
	}

}
