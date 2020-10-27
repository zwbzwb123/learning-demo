package leetcode.simple;


public class Solution1046 {
    public static void main(String[] args) {
        System.out.println(new Solution1046().lastStoneWeight(
                new int[]{2, 2}
        ));
    }

    public int lastStoneWeight(int[] stones) {
        heap heap = new heap(stones);
        while (heap.size >= 1) {
            int x = heap.remove();
            int y = heap.remove();
            if (x == y)
                continue;
            heap.insert(Math.abs(x - y));
        }
        return heap.remove();
    }

    class heap {
        int[] nums;
        int size;

        public heap(int[] nums) {
            this.nums = nums;
            this.size = nums.length - 1;
            buildHeap(this.nums);
        }

        public int remove() {
            if (size == -1)
                return 0;
            int res = nums[0];
            nums[0] = nums[size--];
            precaloteDown(0);
            nums[size + 1] = 0;
            return res;
        }

        public void insert(int value) {
            int hole = ++size;
            while (value > nums[hole / 2] && hole > 0) {
                nums[hole] = nums[hole / 2];
                hole = hole / 2;
            }
            nums[hole] = value;
        }

        public void buildHeap(int[] nums) {
            for (int i = nums.length / 2; i >= 0; i--) {
                precaloteDown(i);
            }
        }

        private void precaloteDown(int hole) {
            int child;
            int size = nums.length - 1;
            for (; hole * 2 + 1 <= size; hole = child) {
                child = hole * 2 + 1;
                if (child != size && nums[child + 1] > nums[child])
                    child++;
                if (nums[child] > nums[hole]) {
                    int t = nums[hole];
                    nums[hole] = nums[child];
                    nums[child] = t;
                } else
                    break;
            }

        }
    }
}
