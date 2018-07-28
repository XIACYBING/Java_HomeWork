package compilingPrinciple.CompileFrontEnd;

public class GrammarAnalyze {
	
    //分析表将E'替换为e,T'替换t
    private String tab[][] = {
        {"$","i","+","*","(",")","#"},
        {"E","Te","$","$","Te","$","$"},
        {"e","$","+Te","$","$","ε","ε"},
        {"T","Ft","$","$","Ft","$","$"},
        {"t","$","ε","*Ft","$","ε","ε"},
        {"F","i","$","$","(E)","$","$"}
        };
    
    private String input;	//input中存放输入的表达式
    private StringBuffer tempBuffer;	//存放要输出的字符串
    private int ptr, row, col, step;	//指针，预测表中的行，列，当前步骤
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
    
    //判断预测表中的列
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
    
	//判定预测表中的行
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
        stack.push(tab[row][0]);	//预测表中的第一个元素‘E’
        show("初始化");
        String tmp;
        char ctmp;	//栈顶元素
        while (!(input.charAt(ptr) == '#' && stack.getTop() == '#')) {
            ctmp = stack.getTop();	//获取栈顶的元素
            if (input.charAt(ptr) == ctmp) {	//与栈顶元素比较
                stack.pop();
                ptr++;
                show("" + ctmp + "匹配");
                continue;
            }
            //判断ptr位置的终结符所在预测表的列位置
            col = column(input.charAt(ptr));
            if (col == -1) {
                symbol = false;
                show("未定义的字符");
                ptr++;
                break;
            }
            //判断栈顶位置所在预测表的行位置
            row = line(ctmp);
            if (row == -1) {
                symbol = false;
                show("出错");
                stack.pop();
                if (input.charAt(ptr) != '#') {
                    ptr++;
                }
                continue;
            }
            tmp = tab[row][col];
            if (tmp.charAt(0) == '$') {
                symbol = false;
                show("出错");
                stack.pop();
                if (input.charAt(ptr) != '#') {
                    ptr++;
                }
            } else if (tmp.charAt(0) == 'ε') {
                stack.pop();
                show("" + ctmp + "->" + 'ε');
            } else {
                stack.pop();
                stack.push(tmp);
                show("" + ctmp + "->" + tmp);
            }
        }
    }	
    
    //过滤方法将打印的字符串中e和t替换为E'和T'
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
                "步骤","分析栈","剩余输入栈","所用产生式"));
        analyse();
        if (symbol) {
            tempBuffer.append("\r是正确的符号串\r");
            return tempBuffer.toString();
        } else {
            tempBuffer.append("\r不是正确的符号串\r");
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