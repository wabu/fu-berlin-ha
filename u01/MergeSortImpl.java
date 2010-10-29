/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoeherealgorithmik;

/**
 *
 * @author Michael
 */
public class MergeSortImpl implements MergeSort {

    public int[] sort(int[] ints) {
        if (ints.length > 1) {
            int[] as = new int[(int) Math.floor(ints.length / 2.0)];
            int[] bs = new int[(int) Math.ceil(ints.length / 2.0)];

            for (int i = 0; i < as.length; i++) {
                as[i] = ints[i];
            }
            for (int i = 0; i < bs.length; i++) {
                bs[i] = ints[i + as.length];
            }
            as = sort(as);
            bs = sort(bs);
            int posa = 0, posb = 0;
            for (int i = 0; i < ints.length; i++) {
                if (posa < as.length && posb == bs.length) {
                    ints[i] = as[posa];
                    posa++;
                } else if (posa == as.length && posb < bs.length) {
                    ints[i] = bs[posb];
                    posb++;
                } else {
                    if (as[posa] < bs[posb]) {
                        ints[i] = as[posa];
                        posa++;
                    }else{
                        ints[i] = bs[posb];
                        posb++;
                    }
                }
            }

        }
        return ints;
    }
}
