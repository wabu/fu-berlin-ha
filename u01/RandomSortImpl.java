/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hoeherealgorithmik;

import java.util.Random;

/**
 *
 * @author Michael
 */
public class RandomSortImpl implements RandomSort{
    private Random rand = new Random();
    private long vergleiche=0;
    public int[] sort(int[] ints) {
        while(!sorted(ints)){
            int i= rand.nextInt(ints.length);
            int j=0;
            do{
                j=rand.nextInt(ints.length);
            }while(j==i);
            vergleiche++;
            if(ints[i]>ints[j]){
                
                int dreieckstausch = ints[i];
                ints[i]=ints[j];
                ints[j]=dreieckstausch;
            }
        }
        return ints;
    }

    private boolean sorted(int[] ints) {
        boolean issorted = true;
        for(int i=0; i<ints.length-1; i++){
            if(ints[i]>ints[i+1]){

                issorted=false;
            }
        }
        return issorted;
    }

    public long getAnzVergleiche() {
        long vergleichsave=vergleiche;
        vergleiche=0;
        return vergleichsave;
    }

}
