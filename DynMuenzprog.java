/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ha;

/**
 *
 * @author kmochi
 */
public class DynMuenzprog {
    private static final int EINER = 0, FUENFER = 1, ZEHNER = 2, FUENFUNDZWANZIGER = 3;
    public static void main(String[] args){
        int[][] matrix = new  int[100][4];
        int werte[] = {1,5,10,25};
        for(int y=0; y<matrix.length; y++){
                matrix[y][0]=1;
        }

            for(int x=1; x<werte.length; x++){
        for(int y=0; y<matrix.length; y++){
                if(werte[x]<=y){
                    matrix[y][x]=matrix[y-werte[x]][x]+matrix[y][x-1];
                }else{
                    matrix[y][x]=matrix[y][x-1];
                }
            }
        }
        for(int x=0; x<matrix.length; x++){
            for(int y=0; y<matrix[0].length; y++){
                System.out.print(matrix[x][y]+"\t");
            }
            System.out.println();
        }
        




    }
}
