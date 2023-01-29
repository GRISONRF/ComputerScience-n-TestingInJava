package src;


public class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value, LinkedList next) {
        this.value = value;
        this.next = next;
    }

    /*
    * You will be given two linked lists in “reverse-digit” format.
    * For example, the number 123 would be represented in a linked list like this: 3 → 2 → 1
    * You should return the sum of these two numbers in the same “reverse-digit” format.
    * For 123 + 456, this should return 579, in the form of a linked list like this: 9 → 7 → 5.

    What is the runtime of this function?
    * */

    public void main(String[] args){
        LinkedList l1 = new LinkedList(3, new LinkedList(2, new LinkedList(1, null)));
        LinkedList l2 = new LinkedList(6, new LinkedList(5, new LinkedList(4, null)));

    }



}
