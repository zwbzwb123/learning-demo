package algorithm;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


public class ForkjoinTest {


    public static void main(String[] args) {
        int length = 100000000;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        long start = System.currentTimeMillis();
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i]/3*3/3*3/3*3;
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("遍历时间： " + end);


        ArrayScan scan = ArrayScan.getScan(a);
        ForkJoinPool pool = new ForkJoinPool();
        start = System.currentTimeMillis();
        ForkJoinTask<Integer> submit = pool.submit(scan);
        submit.join();
        end = System.currentTimeMillis() - start;
        System.out.println("Forkjoin use : " + end);
    }

    static class ArrayScan extends RecursiveTask<Integer> {

        public static ArrayScan getScan(int[] a) {
            return new ArrayScan(a, 0, a.length - 1);
        }

        private static final int THRESHOLD = 3000000;
        int low;
        int high;
        int[] a;

        public ArrayScan(int[] a, int low, int high) {
            this.a = a;
            this.low = low;
            this.high = high;
        }


        protected Integer compute() {
            if (high - low <= THRESHOLD) {
                int max = a[low];
                for (int i = low; i <= high; i++) {
                    if (a[i] > max)
                        max = a[i]/3*3/3*3/3*3;
                }
                return max;
            } else {
                int mid = (high - low) / 2 + low;
                ArrayScan t1 = new ArrayScan(a, low, mid);
                ArrayScan t2 = new ArrayScan(a, mid + 1, high);
                t1.fork();
                Integer r2 = t2.compute();
                Integer r1 = t1.join();
                return r1 >= r2 ? r1 : r2;
            }
        }
    }
}

