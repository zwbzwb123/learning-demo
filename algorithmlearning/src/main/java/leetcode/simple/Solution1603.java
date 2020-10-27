package leetcode.simple;



public class Solution1603 {


    public static void main(String[] args) {
        Solution1603 solution1603 = new Solution1603(1,1,0);
        System.out.println(solution1603.addCar(1));
        System.out.println(solution1603.addCar(2));
        System.out.println(solution1603.addCar(3));
        System.out.println(solution1603.addCar(1));

    }

    int[] nums;

    public Solution1603(int big, int medium, int small) {
        nums = new int[]{big,medium,small};
    }

    public boolean addCar(int carType) {
        return nums[carType - 1]-- > 0;
    }


}
