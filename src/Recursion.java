package src;


/*
* Find the index of an item in a list using recursion.
Implement a function that takes in an item and an array of items,
and returns the 0-based index of a sought item: >>> recursive_search(“hey”, [“hey”, “there”, “you”]) 0
If the item isn’t in the list, return -1: >>> recursive_search(“porcupine”, [“hey”, “there”, “you”]) -1
Important: Solve this problem only with recursion—you cannot use a for or while loop in your solution!

What is the runtime of this function?
* */
public class Recursion {


    public static void main (String[] args) {
        System.out.println(findIndex("hey", new String[]{"hey", "there", "you"}, 0)); // 0
        System.out.println(findIndex("porcupine", new String[]{"hey", "there", "you"}, 0)); //-1
        System.out.println(findIndex("there", new String[]{"hey", "there", "you"}, 0)); // 1

    }


    //Recursive call: while i < len of s
    //Base case: if the current word is same as item
    // while loop would be: while i < len(s), if s[i] == item, return i, else return -1

    // T: O(n) -> iterates over len of s
    // M: O(1) -> not creating any additional variable
    static int findIndex(String item,String[] s, int i){

        if (item.equals(s[i])){
            return i;
        }

        if (i >= (s.length-1)) {
            return -1;
        }

        return findIndex(item, s, i+1);

    }
}
