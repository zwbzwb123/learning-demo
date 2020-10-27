package leetcode.middle;


public class Solution845 {

    public static void main(String[] args) {
        System.out.println(new Solution845().longestMountain(new int[]{1, 2, 0, 2, 0, 2}));
    }

    public int longestMountain(int[] A) {
        int res = 0;
        int length = A.length;
        // loop a a1 ----- ai-1 ai
        for (int i = 1; i < length - 1; i++) {
            int ch = A[i];
            // case a[i] > a[i -1 ]
            if (ch > A[i - 1] && ch > A[i +1]){
                int now = 3;

                for (int j = i - 2; j >= 0;j--){
                    if (A[j + 1] > A[j])
                        now++;
                    else
                        break;
                }

                for (int j = i + 2;j < length;j ++){
                    if (A[j] < A[j -1 ])
                        now++;
                    else
                        break;
                }

                if (now > res)
                    res = now;
            }

        }
        return res;
    }
}
