package compilingPrinciple.CompileFrontEnd;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Compile {

	public int ch;
	public int code;//������״̬��
	
	public StringBuffer strToken = new StringBuffer();//��Ź��ɵ��ʷ��ŵ��ַ���
	
	public String [] retainWord = new String[]{"int","if","else","return","main","void","while","break"};//������
	
	//�ж��Ƿ�����ĸ
	public boolean IsLetter(){
		if((ch>=65 && ch <= 90) || (ch >= 97 && ch <=122)){
			return true;
		}
		return false;
	}
	
	//�ж��Ƿ�������
	public boolean IsDigit(){
		if(ch>=48 && ch <= 57){
			return true;
		}
		return false;
	}
	
	//�ж��Ƿ��ǿո�
	public boolean IsBC(int ch){
		if(ch == 32){
			return true;
		}
		return false;
	}
	
	//�����ַ�
	public void Concat(char ch){
		strToken.append(ch);
	}
	
	//�ж��Ƿ��Ǳ�����
	public int Reserve(){
		for(int i = 0;i < retainWord.length;i++){
			if(strToken.toString().equals(retainWord[i])){
				return 1;
			}
		}
		if(strToken.length() != 0){
			if(strToken.charAt(0)>='0' && strToken.charAt(0)<='9'){
				return 3;
			}
		}
		
		return 2;
	}
	
	//
	public void Retract(){
		code = Reserve();
		if(code == 1){
			System.out.println("('1','"+strToken+"')");
		}else if(code == 2){
			System.out.println("('��ͨ��ʶ��','"+strToken+"')");
		}
		else if(code == 3){
			System.out.println("('�޷���ʵ��','"+strToken+"')");
		}
		strToken.delete(0, strToken.length());
	}
	
	/**
	 * ��ȡ�ļ�
	 */
	public void scanner(String word){
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
					word.getBytes(Charset.forName("utf8"))),Charset.forName("utf8")));
			while((ch = br.read()) != -1){
				if(IsBC(ch) == false){
					if(IsLetter()){
						if(IsLetter() == true || IsDigit() == true){
							Concat((char) ch);
						}
					}else if(IsDigit() == true){
						Concat((char)ch);
					}else if(IsDigit()){
						Concat((char) ch);
					}else if(ch == 61){
						if((strToken.length() != 0 ) && (strToken.charAt(0) == '=')){
							strToken.append((char)ch);
							System.out.println("('�����','"+strToken+"')");
							strToken.delete(0, strToken.length());
						}else if(strToken.length() != 0 ){
							Retract();
							System.out.println("('�����','"+(char) ch+"')");
						}else{
							strToken.append((char)ch);
						}
					}else if(ch == 43){
						Retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if(ch == 45){
						Retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if(ch == 42){
						Retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if(ch == 47){
						Retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if((char) ch == '.'){
						Concat((char)ch);
					}else if((char) ch == ';'){
						Retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == '('){
						Retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == ')'){
						Retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == '{'){
						Retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == '}'){
						Retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == ','){
						Retract();
						System.out.println("('���','"+(char) ch+"')");
					}
				}else{
					Retract();
				}
				
			}
			Retract();
			System.out.println("('������','#')");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
