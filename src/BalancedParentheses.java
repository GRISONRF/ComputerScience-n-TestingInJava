package src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class BalancedParentheses {

    public static void main(String[] args){

        System.out.println(balancedParentheses(Arrays.toString(new String[]{"(())"})));  //true
        System.out.println(balancedParentheses(Arrays.toString(new String[]{"(()))"}))); //false
        System.out.println(balancedParentheses(Arrays.toString(new String[]{"(("}))); //false
    }

    /*Write a function that takes in a string and returns true or false
    depending on whether that string has balanced parentheses.
    A string has balanced parantheses if every opening paranthesis “(“ has
    a matching closing paranthesis “)” that closes the corresponding opening paranthesis.*/

    public static boolean balancedParentheses(String s){

        //create a stack
        //iterate over s
        //if s == (, add to the stack
        //if s == ) and last item in stack is (, delete ( from stack
        //else, return false

        Deque<Character> stack = new ArrayDeque<>();

        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));


            } else if (!(stack.isEmpty()) && s.charAt(i) == ')' && stack.peek().equals('(')) {
                stack.pop();
            } else if (s.charAt(i) == ')') {
                return false;
            }
        }

        return stack.isEmpty();
    }

    //T: O(n) -> one iteration depending on size of string, push and pop from array takes O(1)
    //M: O(n) -> worse case, stack would have the length of the string


}
