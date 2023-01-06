package main.java.com.yearup.week4.code.stack;

import java.util.Stack;

class InfixPostfix {

    public static int precedence(char x){

        if(x=='^'){   // highest precedence
            return 2;
        }
        else if(x=='*' || x=='/'){
            return 1;                        // second-highest precedence
        }
        else if(x=='+' || x=='-'){
            // lowest precedence

            return 0;
        }
        return -1; // not an operator
    }

    public static String InfixToPostfix(String str){

        Stack<Character> stk= new Stack<>();             // used for converting infix to postfix

        String ans="";                // string containing our final answer

        int n= str.length();

        for (int i = 0; i <n ; i++) {
            char x= str.charAt(i);

            if(x>='0' && x<='9'){
                ans+=x;
            }

            else if(x=='('){     // push directly in the stack
                stk.push('(');
            }
            else if(x==')'){

                while(!stk.isEmpty() && stk.peek()!='('){          // keep popping till opening bracket is found
                    ans+=stk.pop();
                }
                if(!stk.isEmpty()){
                    stk.pop();
                }

            }
            else{

                while(!stk.isEmpty() && precedence(stk.peek())>=precedence(x)){    // remove all higher precedence values
                    ans+=stk.pop();
                }
                stk.push(x);

            }
        }
        while(!stk.isEmpty()){
            ans+=stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(InfixPostfix.InfixToPostfix("m*n+(p-q)+r"));

    }
}
