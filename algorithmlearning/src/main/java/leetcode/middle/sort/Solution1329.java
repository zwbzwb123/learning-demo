package leetcode.middle.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        for (int r = 0; r < row; r++) {
            int x = r;
            int y = 0;
            List<Integer> list = new ArrayList<Integer>();
            while (x < row && y < col) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                mat[r+i][i] = list.get(i);
            }
        }

        for (int c = 1; c <col;c++) {
            int x = 0;
            int y = c;
            List<Integer> list = new ArrayList<Integer>();
            while (x < row && y < col) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            for (int i = 0; i <list.size();i++) {
                mat[i][c+i] = list.get(i);
            }
        }

        return mat;
    }

}
