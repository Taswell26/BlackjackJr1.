import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Shuffle{
public static Integer[] Fisheryates(Integer[] arr){	
List <Integer> Nums = new ArrayList<Integer>(Arrays.asList(arr));
for (int i=0; i < arr.length; i++ ){
Random ron=new Random();
int sib= ron.nextInt(Nums.size()); 
arr[i]=Nums.get(sib);
Nums.remove(sib);	
}
return arr;
}




public static double shannonEntropy(Integer[] places) {
		int[] diffs = new int[52];
		double shannon = 0.0;
		for (int i=0; i<51; i++) {
			int diff = places[i] - places[(i+1)%52];
			if (diff<0) {
				diff += 52;
				diffs[diff]++;
			}
			else {
				diffs[diff]++;
			}
		}
		for (int i=0; i<51; i++) {
			double p = (double)diffs[i]/52.0;
			if (p>0) {
				shannon -= p * Math.log(p) / Math.log(2.0);
			}
		}
		return shannon;
	} 

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
