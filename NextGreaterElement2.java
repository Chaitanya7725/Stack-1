import java.util.Arrays;
import java.util.Stack;

// TC: O(n) The length of array is traversed twice
// SC: O(n) stack is being used which contributes to extra space

// Runs successfully on leetcode.
// criteria is to check for stack top element with the current traversing 
// element from the array and if current traversing element is large then resultant array values are updated.

public class NextGreaterElement2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 1 }))); // 2,-1,2
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 3, 4, 3 }))); // 2,3,4,-1,4
    }

    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[] {};
        int n = nums.length;
        int[] resultant = new int[n];
        Arrays.fill(resultant, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int popped = stack.pop();
                resultant[popped] = nums[i % n];
            }
            if (i < n)
                stack.push(i);
        }
        return resultant;
    }
}
