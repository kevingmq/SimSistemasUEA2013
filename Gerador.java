
public class Gerador {
public static final double a = Math.pow(7, 5);
public static final double m = Math.pow(2, 31);
private double semente;
public double Posicao;


public double getSemente() 
{
	return semente;
}


public void setSemente(double semente) 
{
	this.semente = semente;
}


public double NextPosicao()
{
	double x;
	x = a*semente%(m-1);
	
	this.semente = x;
	
	x = x/m;
	
	
	Posicao = x;
	
	
	
	return Posicao;
}
	

}
