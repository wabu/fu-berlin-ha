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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSortImpl();
        long gesammtvergleiche = 0;
        int gesammtmillisec = 0;
        int n=10;
        int durchlaufanz=100;
        Random rand = new Random();
        for (int durchlaeufe = 0; durchlaeufe < durchlaufanz; durchlaeufe++) {
            int[] tests = new int[n];
            for (int i = 0; i < tests.length; i++) {
                tests[i] = rand.nextInt();
            }
            long time1 = System.currentTimeMillis();
            tests = sorter.sort(tests);
            long time2 = System.currentTimeMillis() - time1;

            gesammtvergleiche+=sorter.getAnzVergleiche();
            gesammtmillisec+=time2;
        }
        System.out.println("Gesammt: "+ gesammtmillisec/durchlaufanz + " ms");
        System.out.println(gesammtvergleiche/durchlaufanz + " Vergleiche");
    }
}
