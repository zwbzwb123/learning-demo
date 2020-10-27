package leetcode.middle.sort;


import java.util.TreeSet;

public class Solution1387 {


    public int getKth(int lo, int hi, int k) {

        TreeSet<Node> set  =new TreeSet<Node>();
        for (int i = lo; i <= hi; i++) {
            int w = computeWeight(i);
            set.add(new Node(i,w));
        }
        Node[] nodes = set.toArray(new Node[0]);
        return nodes[k-1].value;
    }

    class Node implements Comparable<Node>{
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }


        public int compareTo(Node o) {
            if (this.weight > o.weight)
                return 1;
            else if (this.weight == o.weight) {
                return this.value - o.value;
            } else
                return -1;
        }
    }

    private int computeWeight(int i) {
        int weight = 0;
        while (i != 1) {
            if (i % 2 == 1) {
                i = 3 * i + 1;
            } else {
                i = i / 2;
            }
            weight++;
        }
        return weight;
    }
}
