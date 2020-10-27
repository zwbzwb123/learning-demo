package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution894 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer,List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (!map.containsKey(N)){
            List<TreeNode> res = new ArrayList<TreeNode>();
            if (N == 1){
                res.add(new TreeNode(0));
            }else if (N % 2 == 1){
                for(int x = 0;x < N;++x){
                    int y = N -1 -x;
                    for (TreeNode left : allPossibleFBT(x)){
                        for (TreeNode right : allPossibleFBT(y)){
                            TreeNode node = new TreeNode(0);
                            node.left = left;
                            node.right = right;
                            res.add(node);
                        }
                    }
                }
            }
            map.put(N,res);
        }
        return map.get(N);
    }


}
