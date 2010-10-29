/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hoeherealgorithmik;

/**
 *
 * @author Michael
 */
public class SelectionSortImpl implements SelectionSort {
    long vergleiche=0;
    public int[] sort(int[] ints) {
        int minpointer=0;
        int[] ergs = new int[ints.length];
        for(int i=0; i<ints.length; i++){
            for(int j=0; j<ints.length-i; j++){
                vergleiche++;
                if(ints[j]<ints[minpointer]){
                    
                    minpointer=j;
                }
            }
            ergs[i]=ints[minpointer];
            ints[minpointer]=ints[ints.length-1];
            minpointer=0;
        }
        return ergs;

    }

    public long getAnzVergleiche() {
        return vergleiche;
    }

}
