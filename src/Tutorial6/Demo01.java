package Tutorial6;

import java.util.*;

/*
Describe the output of the following series of stack operations:
push(5)
push(3)
pop()
push(2)
push(8)
pop()
pop()
push(9)
push(1)
pop()
push(7)
push(6)
pop()
pop()
push(4)
pop()
pop()
*/
public class Demo01
{
    public static void showpush(Stack<Integer> st, int a)
    {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    public static void showpop(Stack<Integer> st)
    {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[])
    {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        showpush(st, 5);
        showpush(st, 4);
        showpop(st);
        showpush(st,2);
        showpush(st,8);
        showpop(st);
        showpop(st);
        showpush(st,9);
        showpush(st,1);
        showpop(st);
        showpush(st,7);
        showpush(st,6);
        showpop(st);
        showpop(st);
        showpush(st,4);
        showpop(st);
        showpop(st);

    }
}