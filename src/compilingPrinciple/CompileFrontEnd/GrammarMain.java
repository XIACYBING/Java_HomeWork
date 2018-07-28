package compilingPrinciple.CompileFrontEnd;

import java.io.IOException;

public class GrammarMain {

	public static void main(String[] args) throws IOException {
		
        Preprocessing preprocessing=new Preprocessing();
        Compile compile=new Compile();
        GrammarAnalyze analyze = new GrammarAnalyze();
        
        String inputExpression="";
        String path="C:\\Users\\Wangy\\Desktop\\CompileFrontEnd.txt";
        System.out.println("*********************源程序预处理结果*********************");
        inputExpression=preprocessing.preprocessing(path);
        System.out.println("*********************词法分析如下所示*********************");
        compile.scanner(inputExpression);
        inputExpression = inputExpression.trim();
        if("".equals(inputExpression) || inputExpression == null) {
        	System.out.println("读取文本内容为空！请仔细检查！");
        }else {
        	System.out.println("*********************语法分析如下所示*********************");
        	String result = analyze.work(inputExpression);
        	System.out.println(result);
        }
	}
	
}
