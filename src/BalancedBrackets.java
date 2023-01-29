package src;

/*
* Write a function that takes in a string and returns true or false based on whether the
* string’s opening-and-closing marks (that is, brackets) are balanced.
* Account for the following bracket types:
()   {}   []    <>
* The string doesn’t need to have all four types of brackets, but if an open bracket appears,
* the pair should also be closed correctly. Assume you can use any libraries in Java needed.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class BalancedBrackets {

    public static void main(String[] args){

        System.out.println(balancedBrackets("{[]}")); //true
        System.out.println(balancedBrackets("{[>"));  //false
        System.out.println(balancedBrackets("))"));  //false

        System.out.println(balancedBracketsNoStack("()"));  //true
        System.out.println(balancedBracketsNoStack("{[>"));  //false
        System.out.println(balancedBracketsNoStack("))"));  //false

    }

    static boolean balancedBrackets(String s){

        //create a map with open and closed brackets
        // iterate over s,
        //if the item of s is an open bracket, add into the stack
        //if the item of s is a close bracket, check if last item in stack is the matching open bracket
            //if it is, pop from stack, if not, return false
        //at the end, check is stack is empty

        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('<', '>');

        Deque<Character> stack = new ArrayDeque<>();

        for (var i = 0; i < s.length(); i++) {
            if (brackets.containsKey(s.charAt(i))){ //means it's an open bracket
               stack.push(s.charAt(i));
            } else if (!stack.isEmpty() && brackets.containsValue(s.charAt(i)) && brackets.get(stack.peek()) == s.charAt(i)){
                stack.pop();
            } else {
                return false;
            }
        }
        return (stack.isEmpty());
        //T:O(n) -> iterates over s
        //M:O(n) -> stack's len could be as long as len of s
    }


    //not using stack: counter for each type of bracket
    //T: O(n) -> iterates through len of string
    //M: O(1) -> constant amount of memory to store the counters
    static boolean balancedBracketsNoStack(String s){

        int bracketsCount = 0;
        int squareBracketsCount = 0;
        int curlyBracketsCount = 0;
        int angleBracketsCount = 0;

        for (var i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                bracketsCount++;
            } else if (c == ')') {
                bracketsCount--;
            } else if (c == '[') {
                squareBracketsCount++;
            } else if (c == ']') {
                squareBracketsCount--;
            } else if (c == '{') {
                curlyBracketsCount++;
            } else if (c == '}') {
                curlyBracketsCount--;
            } else if (c == '<') {
                angleBracketsCount++;
            } else if (c == '>') {
                angleBracketsCount--;
            }
            if (bracketsCount < 0 || squareBracketsCount < 0 || curlyBracketsCount < 0 || angleBracketsCount < 0) {
                return false;
            }
        }
        return bracketsCount == 0 && squareBracketsCount == 0 && curlyBracketsCount == 0 && angleBracketsCount == 0;
    }
}

