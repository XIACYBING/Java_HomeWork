package compilingPrinciple.CompileFrontEnd;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Compile {

	public int ch;

	/**
	 * ������״̬��
	 */
	public int code;

	/**
	 * ��Ź��ɵ��ʷ��ŵ��ַ���
	 */
	public StringBuffer strToken = new StringBuffer();

	/**
	 * ������
	 */
	public String [] retainWord = new String[]{"int","if","else","return","main","void","while","break"};

	/**
	 * �ж��Ƿ�����ĸ
	 */
	public boolean isLetter(){
		return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
	}

	/**
	 * �ж��Ƿ�������
	 */
	public boolean isDigit(){
		return ch >= 48 && ch <= 57;
	}

	/**
	 * �ж��Ƿ��ǿո�
	 */
	public boolean isBc(int ch){
		return ch == 32;
	}

	/**
	 * �����ַ�
	 */
	public void concat(char ch){
		strToken.append(ch);
	}

	/**
	 * �ж��Ƿ��Ǳ�����
	 */
	@SuppressWarnings("all")
	public int reserve(){
		for (String s : retainWord) {
			if (strToken.toString().equals(s)) {
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

	public void retract(){
		code = reserve();
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
					word.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
			while((ch = br.read()) != -1){
				if(!isBc(ch)){
					if(isLetter()){
						if(isLetter() || isDigit()){
							concat((char) ch);
						}
					}else if(isDigit()){
						concat((char)ch);
					}else if(isDigit()){
						concat((char) ch);
					}else if(ch == 61){
						if((strToken.length() != 0 ) && (strToken.charAt(0) == '=')){
							strToken.append((char)ch);
							System.out.println("('�����','"+strToken+"')");
							strToken.delete(0, strToken.length());
						}else if(strToken.length() != 0 ){
							retract();
							System.out.println("('�����','"+(char) ch+"')");
						}else{
							strToken.append((char)ch);
						}
					}else if(ch == 43){
						retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if(ch == 45){
						retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if(ch == 42){
						retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if(ch == 47){
						retract();
						System.out.println("('�����','"+(char) ch+"')");
					}else if((char) ch == '.'){
						concat((char)ch);
					}else if((char) ch == ';'){
						retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == '('){
						retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == ')'){
						retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == '{'){
						retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == '}'){
						retract();
						System.out.println("('���','"+(char) ch+"')");
					}else if((char) ch == ','){
						retract();
						System.out.println("('���','"+(char) ch+"')");
					}
				}else{
					retract();
				}

			}
			retract();
			System.out.println("('������','#')");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
