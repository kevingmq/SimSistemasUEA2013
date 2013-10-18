import java.util.Random;


public class poisson {
	
	Random random = new Random();
	
	//Lambda equivale a media por unidade de tempo
	public int nextPoisson(int lambda) {  
		double elambda = Math.exp(-1*lambda);  
		double product = 1;  
		int count = 0;  
		int result=0;  
		while (product >= elambda) {  
			product *= random.nextDouble();  
			result = count;  
			count++; // keep result one behind  
			}  
    return result;  
    }  

}
