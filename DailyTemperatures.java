import java.util.Arrays;
import java.util.Stack;

// TC: O(n) as all the elements in the input array is visited
// SC: O(n) Stack contributes to the extra space

// Stack makes it easier to modify the resultant array as the index are saved.
// if criteria is satisfied then the resultant array is modified otherwise 
// the elements is pushed in the stack
public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 30, 40, 50, 60 })));
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 30, 60, 90 })));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[] {};
        int n = temperatures.length;
        int resultant[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int popped = stack.pop();
                resultant[popped] = i - popped;
            }
            stack.push(i);
        }
        return resultant;
    }

}