import java.util.Random;  
import java.lang.Math;

public class Poisson {

//Lambda equivale a media por unidade de tempo
	public int nextPoisson(double lambda) {  
		double elambda = Math.exp(-1*lambda);  
		double product = 1;  
		int count = 0;  
		int result=0;  
		while (product >= elambda) {  
			product *= nextDouble();  
			result = count;  
			count++; // keep result one behind  
			}  
    return result;  
    }  

}

