package SetMatrixZeroes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroCol = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    zeroRow.add(i);
                    zeroRow.add(j);
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(zeroRow.contains(i) || zeroCol.contains(j)) matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row1_0 = false;
        boolean col1_0 = false;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
                if(i == 0) row1_0 = true;
                if(j == 0) col1_0 = true;
            }
        }

        for(int i=row-1; i>=1; i--){
            for(int j=col-1; j>=1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if(row1_0){
            for(int j=0; j<col; j++){
                matrix[0][j] = 0;
            }
        }
        if(col1_0){
            for(int i=0; i<row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
