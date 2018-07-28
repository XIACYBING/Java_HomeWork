package compilingPrinciple.CompileFrontEnd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Preprocessing {

	public String preprocessing(String path) throws IOException{
		String word="";
		BufferedReader br=new BufferedReader(new InputStreamReader(
				new FileInputStream(path),"UTF-8"));
		String wor;
		word=br.readLine();
		while((wor=br.readLine())!=null){
			word=word+"\\n"+wor;
		}
		word=word.replaceAll("/\\*.+\\*/", "");
		word=word.replace("\\n", "");
		word=word.replace("\t", "");
		word=word.replace("\\", "");
		word=word.toLowerCase();
		System.out.println(word+"#");
		return word;
	}
	
}
