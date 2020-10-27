package algorithm.search;

public class BinarySearch {

    // 假设数组a默认是已经排好序的,我们需要从a中查找目标k,存在则返回k,不存在返回-1
    public static int find(int[] a,int k){
        if (a == null || a.length == 0)
            return -1;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if      (k < a[mid]) hi = mid -1;
            else if (k > a[mid]) lo = mid +1;
            else    return a[mid];
        }
        return -1;
    }
}
