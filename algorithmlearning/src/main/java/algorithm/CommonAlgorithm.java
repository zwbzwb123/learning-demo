package algorithm;

public class CommonAlgorithm {

    /*
     * 求最大公约数
     * 欧几里得
     */
    public int gcd(int m, int n) {
        int t;
        if (n > m) {
            t = n;
            n = m;
            m = t;
        }

        while (n != 0) {
            t = m % n;
            m = n;
            n = t;
        }
        return m;
    }

    /*
     * 求某个数的幂次方
     * n^31 == (n^2)^15*n
     * n^30 == (n^2)^15
     */
    public int pow(int n, int p) {
        if (p == 0)
            return 1;
        if (p == 1)
            return n;
        if (p % 2 == 0)
            return pow(n * n, p / 2);
        else
            return pow(n * n, p / 2) * n;
    }
}
