package compilingPrinciple.CompileFrontEnd;

import java.io.IOException;

public class GrammarMain {

	public static void main(String[] args) throws IOException {
		
        Preprocessing preprocessing=new Preprocessing();
        Compile compile=new Compile();
        GrammarAnalyze analyze = new GrammarAnalyze();
        
        String inputExpression="";
        String path="C:\\Users\\Wangy\\Desktop\\CompileFrontEnd.txt";
        System.out.println("*********************Դ����Ԥ������*********************");
        inputExpression=preprocessing.preprocessing(path);
        System.out.println("*********************�ʷ�����������ʾ*********************");
        compile.scanner(inputExpression);
        inputExpression = inputExpression.trim();
        if("".equals(inputExpression) || inputExpression == null) {
        	System.out.println("��ȡ�ı�����Ϊ�գ�����ϸ��飡");
        }else {
        	System.out.println("*********************�﷨����������ʾ*********************");
        	String result = analyze.work(inputExpression);
        	System.out.println(result);
        }
	}
	
}
