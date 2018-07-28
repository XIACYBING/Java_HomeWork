package compilingPrinciple.CompileFrontEnd;

public class Stack {
	
    private char s[];
    private int top;
    private int base;
    private final int MAX = 200;
    
   /**
    * <p>Title: </p>
    * <p>Description: ��ʼ��ջ</p>
    */
    
    public Stack() {
        initStack();
    }
    
    private void initStack() {
        s = new char[MAX];
        base = 0;
        top = 0;
    }
    
    public boolean isEmpty() {
        if(top == base) {
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * 
    * <p>Title: getTop</p>
    * <p>Description: ��ȡջ��Ԫ��</p>
    * @return ����ջ��Ԫ��
     */
    
    public char getTop() {
        return s[top-1];
    }
    
    /**
     * 
    * <p>Title: push</p>
    * <p>Description: ��ջ����</p>
    * @param str ��ջ���ַ�
     */
    
    public void push(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            s[top++] = str.charAt(i);
        }
    }
    
    /**
     * 
    * <p>Title: clear</p>
    * <p>Description: ���ջ</p>
     */
    
    public void clear() {
        top = base;
    }
    
    /**
     * 
    * <p>Title: pop</p>
    * <p>Description: ��ջ</p>
    * @return ջ��Ԫ�س�ջ�����س�ջ��Ԫ��
     */
    
    public char pop() {
        return s[--top];
    }
    
    /**
     * 
    * <p>Title: size</p>
    * <p>Description: ����ջ��Ԫ�ظ���</p>
    * @return ջ��Ԫ�ظ���
     */
    
    public int size() {
        return top;
    }
    
    /**
     * ��ӡջ�����Ԫ��
     */
    
    public String toString() {
        StringBuffer tempStack = new StringBuffer();
        for (int i = 0; i < top; i++) {
            tempStack.append(s[i]);
        }
        return tempStack.toString();
    }
}