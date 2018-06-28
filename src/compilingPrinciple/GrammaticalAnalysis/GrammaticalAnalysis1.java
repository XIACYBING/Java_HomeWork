package compilingPrinciple.GrammaticalAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GrammaticalAnalysis1 {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Wangy\\Desktop\\编译原理\\b.txt")));
		String line,li;
		line=br.readLine();
		while((li=br.readLine())!=null){
			line=line+li;
		}
		String[] gjz={"begin","end","if","then","else","while","write","read","do", "call","const","char",
				"until","procedure","repeat","include"};
		String[] ysf={"+","-","*","/","="};
		String[] jf={"{","}","[","]",";",",",".","(",")",":","<",">",",",";"};
		String[] none={"#"};
		line=line.toLowerCase();
		char[] c=line.toCharArray();
		String a="";
		for(int i=0;i<c.length;i++){
			if(c[i]=='\n'||c[i]=='\t'){
				continue;
			}
			if(c[i]==' '&&c[i+1]==' '||c[i]==' '&&c[i-1]==' '){
				continue;
			}
			if(c[i]==' '&&a!=""){
				System.out.println(a+"---普通标识");
				a="";
				continue;
			}
			a+=String.valueOf(c[i]);
			for(int j=0;j<gjz.length;j++){
				if(a.equals(gjz[j])){
					System.out.println(a+"---关键字");
					a="";
					break;
				}
			}for(int k=0;k<ysf.length;k++){
				if(a.matches("\\d+")&&c[i+1]==ysf[k].charAt(0)){
					System.out.println(a+"---无符号实数");
					a="";
					break;
				}
				if(a.matches("\\d+\\.\\d*")&&c[i+1]==ysf[k].charAt(0)){
					System.out.println(a+"---无符号实数");
					a="";
					break;
				}
				if(c[i+1]==ysf[k].charAt(0)&&a!=""){
					System.out.println(a+"---普通标识");
					a="";
					break;
				}
				if(a.equals(ysf[k])){
					System.out.println(a+"---运算符");
					a="";
					break;
				}
			}for(int l=0;l<jf.length;l++){
				if(a.matches("\\d+")&&c[i+1]==jf[l].charAt(0)){
					break;
				}
				if(c[i+1]==jf[l].charAt(0)&&a!=""){
					System.out.println(a+"---普通标识");
					a="";
					break;
				}
				if(a.equals(jf[l])){
					System.out.println(a+"---界符");
					a="";
					break;
				}
			}for(int p=0;p<none.length;p++){
				if(a.equals(none[p])){
					System.out.println(a+"---无识别");
					a="";
					break;
				}
			}
		}
	}
}
