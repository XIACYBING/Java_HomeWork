package compilingPrinciple.CompileFrontEnd;

public class GrammarAnalyze {
	
    //������E'�滻Ϊe,T'�滻t
    private String tab[][] = {
        {"$","i","+","*","(",")","#"},
        {"E","Te","$","$","Te","$","$"},
        {"e","$","+Te","$","$","��","��"},
        {"T","Ft","$","$","Ft","$","$"},
        {"t","$","��","*Ft","$","��","��"},
        {"F","i","$","$","(E)","$","$"}
        };
    
    private String input;	//input�д������ı��ʽ
    private StringBuffer tempBuffer;	//���Ҫ������ַ���
    private int ptr, row, col, step;	//ָ�룬Ԥ����е��У��У���ǰ����
    private boolean symbol;
    private Stack stack;
    
    public GrammarAnalyze(){
        stack = new Stack();
        tempBuffer = new StringBuffer();
        symbol=true;
        input="";
        stack.clear();
        stack.push("#");
        row=1;
        ptr=0;
        step=1;
    }
    
    //�ж�Ԥ����е���
    public int column(char c) {
        switch (c) {
        case 'i':
            return 1;
        case '+':
            return 2;
        case '*':
            return 3;
        case '(':
            return 4;
        case ')':
            return 5;
        case '#':
            return 6;
        default:
            return -1;
        }
    }
    
	//�ж�Ԥ����е���
    public int line(char c) {
        switch (c) {
        case 'E':
            return 1;
        case 'e':
            return 2;
        case 'T':
            return 3;
        case 't':
            return 4;
        case 'F':
            return 5;
        default:
            return -1;
        }
    }
    
    public void show(String str) {
        tempBuffer.append(String.format("%-7d%-14s%-20s%-20s\r\n",
                step, filter(stack.toString()), filter(input.substring(ptr)), filter(str)));
        step++;
    }
    
    public void analyse() {
        stack.push(tab[row][0]);	//Ԥ����еĵ�һ��Ԫ�ء�E��
        show("��ʼ��");
        String tmp;
        char ctmp;	//ջ��Ԫ��
        while (!(input.charAt(ptr) == '#' && stack.getTop() == '#')) {
            ctmp = stack.getTop();	//��ȡջ����Ԫ��
            if (input.charAt(ptr) == ctmp) {	//��ջ��Ԫ�رȽ�
                stack.pop();
                ptr++;
                show("" + ctmp + "ƥ��");
                continue;
            }
            //�ж�ptrλ�õ��ս������Ԥ������λ��
            col = column(input.charAt(ptr));
            if (col == -1) {
                symbol = false;
                show("δ������ַ�");
                ptr++;
                break;
            }
            //�ж�ջ��λ������Ԥ������λ��
            row = line(ctmp);
            if (row == -1) {
                symbol = false;
                show("����");
                stack.pop();
                if (input.charAt(ptr) != '#') {
                    ptr++;
                }
                continue;
            }
            tmp = tab[row][col];
            if (tmp.charAt(0) == '$') {
                symbol = false;
                show("����");
                stack.pop();
                if (input.charAt(ptr) != '#') {
                    ptr++;
                }
            } else if (tmp.charAt(0) == '��') {
                stack.pop();
                show("" + ctmp + "->" + '��');
            } else {
                stack.pop();
                stack.push(tmp);
                show("" + ctmp + "->" + tmp);
            }
        }
    }	
    
    //���˷�������ӡ���ַ�����e��t�滻ΪE'��T'
    public String filter(String src) {
        if(src.contains("e") || src.contains("t")) {
            StringBuffer result = new StringBuffer();
            char item;
            for(int i = 0;i < src.length(); i++) {
                item = src.charAt(i);
                if(item == 'e') {
                    result.append("E'");
                    continue;
                }else if(item == 't') {
                    result.append("T'");
                    continue;
                }
                result.append(item);
            }
            return result.toString();
        }else {
            return src;
        }
    }
    
    public String work(String inputExpression) {
        input = inputExpression + '#';
        symbol = true;
        tempBuffer.append(String.format("%-15s%-34s%-43s%-40s\r\n",
                "����","����ջ","ʣ������ջ","���ò���ʽ"));
        analyse();
        if (symbol) {
            tempBuffer.append("\r����ȷ�ķ��Ŵ�\r");
            return tempBuffer.toString();
        } else {
            tempBuffer.append("\r������ȷ�ķ��Ŵ�\r");
            return tempBuffer.toString();
        }
             
    }

    public StringBuffer getTempBuffer() {
        return tempBuffer;
    }
    
    public void setTempBuffer(StringBuffer tempBuffer) {
        this.tempBuffer = tempBuffer;
    }
    
    public Stack getStack() {
        return stack;
    }
    
    public void setStack(Stack stack) {
        this.stack = stack;
    }
    
    public String[][] getTab() {
        return tab;
    }
    
    public void setTab(String[][] tab) {
        this.tab = tab;
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String ns) {
        this.input = ns;
    }
    
    public int getPtr() {
        return ptr;
    }
    
    public void setPtr(int ptr) {
        this.ptr = ptr;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getCol() {
        return col;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    
    public int getStep() {
        return step;
    }
    
    public void setStep(int step) {
        this.step = step;
    }
    
    public boolean isBoo() {
        return symbol;
    }
    
    public void setBoo(boolean boo) {
        this.symbol = boo;
    }

}