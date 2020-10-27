package leetcode.simple;

public class SolutionLCP01 {

    public static void main(String[] args) {
        System.out.println(new SolutionLCP01().game(new int[]{2, 2, 3}, new int[]{3, 2, 1}));
    }

    public int game(int[] guess, int[] answer) {
        int count = 0;
        int length = guess.length;
        for (int i = 0; i < length; i++) {
            if (guess[i] == answer[i])
                count++;
        }

        return count;
    }
}
