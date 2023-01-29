package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {

    public static void main(String[] args){
        System.out.println(missingNumberSort(new int[]{2, 1, 4, 3, 8, 5, 7, 9, 10}, 10));
        System.out.println(missingNumberSet(new int[]{2, 1, 4, 3, 8, 5, 7, 9, 10}, 10));
        System.out.println(missingNumbersOne(new int[]{2, 1, 4, 3, 8, 5, 7, 9, 10}, 10));
    }


    //function that takes a list of numbers and the max_num, and return the missing number
    //
    // sort nums. loop from 1 to maxNumber
    // create a counter, for each iteration, add 1 to the counter and check if the num iterated is not the same as the num at counter, return the counter
    static int missingNumberSort(int[] nums, int maxNumber){

        int counter = 1;
        Arrays.sort(nums);

        for (var i = 1; i < maxNumber; i++){
            counter+=1;
            if (nums[i] != counter){
                return counter;
            }
        }
        return 0;
        //O(nlogn) -> because of the sorting method
        //O(1) memory -> variable counter does not change it's size, nums has a constant size
    }

    //using a set, time complexity of O(n) and memory O(n)
    public static int missingNumberSet(int[] nums, int maxNum){
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (var i = 1; i < maxNum; i++){
            if(!numSet.contains(i)){
                return i;
            }
        }
        return 0;
    }

    //time complexity O(n), memory (1)
    public static int missingNumbersOne(int[] nums, int maxNum){
        //var to store the sum of numbers between 1 - maxNum
        int sum = 0;
        for (var i = 1; i <= maxNum; i++){
            sum+=i;
        }

        //get the sum of nums
        int numSum = Arrays.stream(nums).sum();

        return sum - numSum;
    }
}
