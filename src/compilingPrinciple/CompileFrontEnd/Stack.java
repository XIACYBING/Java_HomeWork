package compilingPrinciple.CompileFrontEnd;

public class Stack {
	
    private char s[];
    private int top;
    private int base;
    private final int MAX = 200;
    
   /**
    * <p>Title: </p>
    * <p>Description: 初始化栈</p>
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
    * <p>Description: 获取栈顶元素</p>
    * @return 返回栈顶元素
     */
    
    public char getTop() {
        return s[top-1];
    }
    
    /**
     * 
    * <p>Title: push</p>
    * <p>Description: 进栈方法</p>
    * @param str 进栈的字符
     */
    
    public void push(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            s[top++] = str.charAt(i);
        }
    }
    
    /**
     * 
    * <p>Title: clear</p>
    * <p>Description: 清空栈</p>
     */
    
    public void clear() {
        top = base;
    }
    
    /**
     * 
    * <p>Title: pop</p>
    * <p>Description: 出栈</p>
    * @return 栈顶元素出栈并返回出栈的元素
     */
    
    public char pop() {
        return s[--top];
    }
    
    /**
     * 
    * <p>Title: size</p>
    * <p>Description: 返回栈中元素个数</p>
    * @return 栈中元素个数
     */
    
    public int size() {
        return top;
    }
    
    /**
     * 打印栈里面的元素
     */
    
    public String toString() {
        StringBuffer tempStack = new StringBuffer();
        for (int i = 0; i < top; i++) {
            tempStack.append(s[i]);
        }
        return tempStack.toString();
    }
}