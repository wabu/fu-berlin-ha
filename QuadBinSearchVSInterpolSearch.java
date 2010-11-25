/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kmochi
 */
public class QuadBinSearchVSInterpolSearch {
    int vergleichs_zae = 0;
        /**
         * @param args
         */
        public static void main(String[] args){
        	int itemanz=10000000;
            List<Double> liste = new ArrayList<Double>();
            Random rand = new Random();
            Double[] a = new Double[itemanz];
            System.out.println("generating random arrays");
            for(int i=0; i< itemanz; i++){
                a[i]=(rand.nextDouble());
//                System.out.println(a[i]);
            }
            System.out.println("sorting array");
            liste=Arrays.asList(a);
            Collections.sort(liste);
            for(int i=0; i< itemanz; i++){
                a[i]=liste.get(i);
            }
            System.out.println("starting serach");
            QuadBinSearchVSInterpolSearch q = new QuadBinSearchVSInterpolSearch();
            int k = rand.nextInt(itemanz);
            int inter = q.interpolationssuche(a, 0, a.length-1,a[k]);
            System.out.println("noetige Vergleiche "+q.vergleichs_zae+" interpolationssuche");
            q.vergleichs_zae=0;
            int quad =q.quadbin(a, 0, a.length-1, a[k]);
            System.out.println("noetige Vergleiche "+q.vergleichs_zae+" quad. binsuche");
            q.vergleichs_zae=0;
            
//            System.out.println("k:"+k+", quad:"+quad+" "+a[quad]+", inter"+ inter+" "+a[inter]);
            System.out.println(quad+" "+a[quad]);
            System.out.println(inter+" "+a[inter]);
        }

    private int quadbin(Double[] S, int l, int r, Double a){
    	//Interpoliere um wahrscheinliche Position zu ermitteln
    	int locall = l;
    	int localr = r;
    	double varianz = (S[r] - S[l]);
    	int interpol = l + (int) (((double) r - l) * (a - S[l]) / varianz);
        if(l>r) {
            return -1;
        }
    	
    	if(S[interpol]<a){ //das gesuchte a liegt rechts der interpolierten Stelle
    		locall=interpol;
    		localr=(int) (locall+ Math.sqrt(r-l+1));
    		vergleichs_zae++;
    		do {
    			vergleichs_zae++;
    			locall = localr;
    			localr = (int) (locall+ Math.sqrt(r-l+1));
    			if(localr>=S.length){
    				localr=S.length-1;
    			}
    		} while(S[localr]<a);
    	}else if(S[interpol]>a){//das gesuchte a liegt links der interpolierten Stelle
    		vergleichs_zae++;
    		localr=interpol;
    		locall=(int) (localr - Math.sqrt(r-l+1));
    		do {
    			vergleichs_zae++;
    			localr = locall;
    			locall = (int) (localr - Math.sqrt(r-l+1));
    			if(locall<0){
    				locall=0;
    			}
    		} while(S[locall]>a);	
    	} else {
    		return interpol;
    	}
        return quadbin(S, locall, localr, a);
    }

    private int interpolationssuche(Double[] S, int l, int r, double a) {
		if (S[l] <= a && a <= S[r]) { // durch rundungsfehler, ist diese Abfrage
										// mehr zu empfehlen
			vergleichs_zae += 2;

			double varianz = (S[r] - S[l]);
			int k = l + (int) (((double) r - l) * (a - S[l]) / varianz);
			if (a > S[k]) {
				vergleichs_zae++;

				return interpolationssuche(S, k + 1, r, a);
			} else if (a < S[k]) {
				vergleichs_zae++;

				return interpolationssuche(S, l, k - 1, a);
			} else {
				
				return k;
			}

		} else {
			return -1;
		}

	}
}
