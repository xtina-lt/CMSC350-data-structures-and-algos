import java.io.*;
import java.util.*;

public class Stacky {
    // PUSH = ADD to LAST
    static void s_push(Stack<Integer> stack){
        for(int i = 0; i < 5; i++) stack.push(i);
        System.out.println(stack);
    }
      
    // POP = REMOVE from LAST
    static void s_pop(Stack<Integer> stack) {
        for(int i = 0; i < 5; i++){
            Integer y = (Integer) stack.pop();
            System.out.println(y);
        }
    }
  
    // PEEK = DISPLAY LAST
    static void s_peek(Stack<Integer> stack){
        System.out.println( "Element on stack top: " + stack.peek() );
    }
      
    // Searching element in the stack
    static void s_search(Stack<Integer> stack, int element){
        int index = stack.search(element);
        String result = ( index != -1 ) 
            ? "Sorry not found :( " 
            : "Element is found at position: " + index;
        System.out.println(result);
    }
  
  
    public static void main (String[] args){
        Stack<Integer> stack = new Stack<Integer>();
  
        s_push(stack);
        s_pop(stack);
        s_push(stack);
        s_peek(stack);
        // s_search(stack, 2);
        // s_search(stack, 6);
    }
}

