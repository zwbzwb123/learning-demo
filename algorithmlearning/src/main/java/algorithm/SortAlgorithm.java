package algorithm;

import java.util.Comparator;

public class SortAlgorithm {


    // 插入排序
    public <T extends Comparable<? super T>> void insertSort(T[] target) {
        int j;
        int length = target.length;
        for (int i = 1; i < length; ++i) {
            T temp = target[i];
            for (j = i; j >= 0 && target[j - 1].compareTo(temp) > 0; j--)
                target[j] = target[j - 1];
            target[j] = temp;
        }
    }

    // 希尔排序
    public <T extends Comparable<? super T>> void shellSort(T[] target) {
        int k;
        int length = target.length;
        for (int gap = length; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                T temp = target[i];
                for (k = i; k > gap && temp.compareTo(target[k - gap]) < 0; k -= gap)
                    target[k - gap] = target[k];
                target[k] = temp;
            }
        }
    }

    // 快速排序
    public <T extends Comparable<? super T>> void quickSort(T[] target, int lo, int hi) {

        if(lo >= hi) return;
        T v = target[lo];
        int index = lo;
        int left = lo + 1;
        int right = hi;

        while (left <= right) {
            int compare = target[left].compareTo(v);
            if (compare < 0) swap(target,left++,index++);
            else if (compare > 0)swap(target,right--,left);
            else left++;
        }
        quickSort(target,lo,index - 1);
        quickSort(target,index + 1,hi);
    }


    public <T extends Comparable<? super T>> void quickSortSentinel(T[] target, int lo, int hi) {

        if (lo >= hi) return;
        T v = target[hi];
        int index = lo;
        int right = hi - 1;
        for (int i = lo; i <= right;i++) {
            int compare = target[i].compareTo(v);
            if (compare < 0) swap(target,index++,i);
            else if (compare > 0) swap(target,i,right--);
        }
        swap(target,index,hi);
        quickSort(target,lo,index - 1);
        quickSort(target,index + 1,hi);
    }

    private <T extends Comparable<? super T>> void swap(T[] target, int index, int max) {
        T temp = target[index];
        target[index] = target[max];
        target[max] = temp;
    }

    // 堆排序
    static class Heap {

        public <T extends Comparable<? super T>> void heapSort(T[] target) {
            int length = target.length;
            for (int i = length / 2 - 1; i >= 0; i--) {
                percDown(target, i, length);
            }
            for (int i = length - 1; i > 0; i--) {
                swap(target, 0, i);
                percDown(target, 0, i);
            }
        }

        private <T> void swap(T[] target, int i, int j) {
            T temp = target[i];
            target[i] = target[j];
            target[j] = temp;
        }

        private <T extends Comparable<? super T>> void percDown(T[] target, int i, int length) {
            T temp;
            int child;
            for (temp = target[i]; (child = 2 * i + 1) < length; i = child) {
                if (child != length - 1 && target[child].compareTo(target[child + 1]) < 0)
                    child++;
                if (temp.compareTo(target[child]) < 0)
                    target[i] = target[child];
                else
                    break;
            }
            target[i] = temp;
        }
    }

    // 归并排序
    static class Merge {

        @SuppressWarnings("unchecked")
        public <T extends Comparable<? super T>> void MergeSort(T[] target) {
            T[] tempArray = (T[]) new Comparable[target.length];
            MergeSort(target, tempArray, 0, target.length - 1);
        }

        private <T extends Comparable<? super T>> void MergeSort(T[] target, T[] tempArray, int lo, int hi) {
            if (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                MergeSort(target, tempArray, lo, mid);
                MergeSort(target, tempArray, mid + 1, hi);
                if (target[mid].compareTo(target[mid+1]) < 0)
                    return;
                merge(target, tempArray, lo, mid, hi);
            }
        }

        public <T extends Comparable<? super  T>> void merge2(T[] target, T[] tempArray, int lo, int mid, int hi){
            int i = lo,j = mid+1;
        }

        private <T extends Comparable<? super T>> void merge(T[] target, T[] tempArray, int lo, int mid, int hi) {

            int i = lo, j = mid + 1;

            for (int k = lo; k <= hi; k++) {
                tempArray[k] = target[k];
            }

            for (int k = lo; k <= hi; k++) {
                if (i > mid)                                 target[k] = tempArray[j++];
                else if (j > hi)                             target[k] = tempArray[i++];
                else if (tempArray[j].compareTo(tempArray[i]) < 0) target[k] = tempArray[j++];
                else                                         target[k] = tempArray[i++];
            }
        }
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{2, 5, 3, 4, 1, 7};
//        new Heap().heapSort(a);
        new SortAlgorithm().quickSortSentinel(a,0,a.length - 1);
        for (Integer i : a)
            System.out.println(i);
    }
}
