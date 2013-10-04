package est;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeradorDistFreq {

	public static int MAXPOPULACAO;
	public static  int NUMCLASSES;
	public static int AMPLITUDE;

	/**
		 */
	public GeradorDistFreq(String type_p,int maxp, int numclasses,int amplitude) {
		MAXPOPULACAO = maxp;
		NUMCLASSES = numclasses;
		AMPLITUDE = amplitude;	
		type = type_p;
		amostras = new ArrayList<Amostra>();
		classes = new ArrayList<Classe>();
		for(int i = 1; i<=NUMCLASSES;i++){
			classes.add(new Classe(i, AMPLITUDE));
		}
	}

	public GeradorDistFreq(String type_p, int maxp, int numclasses, int amplitude,
			ArrayList<Integer> massaDadosNormalTEC) {
		MAXPOPULACAO = maxp;
		NUMCLASSES = numclasses;
		AMPLITUDE = amplitude;	
		type = type_p;
		amostras = new ArrayList<Amostra>();
		classes = new ArrayList<Classe>();
		for(int i = 1; i<=NUMCLASSES;i++){
			classes.add(new Classe(i, AMPLITUDE));
		}
		int id = 0;
		for(Integer i:massaDadosNormalTEC){
			amostras.add(new Amostra(id, i.intValue()));
			id++;
		}
		
	}

	/**
			 */
	public Object GerarDistribuicaoFrequencia() {
		switch (type) {
		case "TEC":

			for (int i = 1; i <= MAXPOPULACAO; i++) {
				amostras.add(new Amostra(i, sim.System.getTempoChegada()));
			}

			break;
		case "TS":
			for (int i = 1; i <= MAXPOPULACAO; i++) {
				amostras.add(new Amostra(i, sim.System.getTempoLavagem()));
			}

			break;
		default:
			break;
		}
		
		//Polulacao gerada
		teste("IN");
		return classes.clone();
	}

	public void teste(String t) {
		for (Amostra a : amostras) {
			for (Classe c : classes) {
				if(c.IsMyClass(a.getValue())){
					c.moreOne();
					break;
				}
			}
		}
		float acom = 0;
		for(Classe c : classes){
			acom += ((float)c.getFrequencia()/MAXPOPULACAO);
			c.setProbAcomulada(acom);
			c.setPontoMedio((((c.getId()-1)*c.getAmplitude()+c.getId()*c.getAmplitude())/2));
		}
		
		try {
		File outputfile = new File("Frequencia"+type+ t + ".txt"); // Cria o arquivo da tabela de saída
		 FileWriter out = new FileWriter(outputfile);
		 
			out.write(" Classe ID  | Frequencia | Prop.Relatica | Prob.Acom | Ponto.Medio \r\n");
		
		 for (Classe c : classes)
		 {
			
			 out.write(((c.getId()-1)*c.getAmplitude())+ "--" + (c.getId()*c.getAmplitude()-1) + " | " + c.getFrequencia() + " | " + ((float)c.getFrequencia()/MAXPOPULACAO) + " | " + c.getProbAcomulada() + " | " + c.getPontoMedio() + "\r\n" );

			 
		 }
		 
		 out.close();
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @uml.property name="type"
	 */
	private String type;

	/**
	 * Getter of the property <tt>type</tt>
	 * 
	 * @return Returns the type.
	 * @uml.property name="type"
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter of the property <tt>type</tt>
	 * 
	 * @param type
	 *            The type to set.
	 * @uml.property name="type"
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @uml.property name="amostras"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     inverse="geradorDistFreq:est.Amostra"
	 */
	private ArrayList<Amostra> amostras;

	/**
	 * Getter of the property <tt>amostras</tt>
	 * 
	 * @return Returns the amostra.
	 * @uml.property name="amostras"
	 */
	public ArrayList<Amostra> getAmostras() {
		return amostras;
	}

	/**
	 * Setter of the property <tt>amostras</tt>
	 * 
	 * @param amostras
	 *            The amostra to set.
	 * @uml.property name="amostras"
	 */
	public void setAmostras(ArrayList<Amostra> amostras_p) {
		amostras = amostras_p;
	}

	/**
	 * @uml.property  name="classes"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" inverse="geradorDistFreq:est.Classe"
	 */
	private ArrayList<Classe> classes;

	/**
	 * Getter of the property <tt>classes</tt>
	 * @return  Returns the classes.
	 * @uml.property  name="classes"
	 */
	public ArrayList<Classe> getClasses() {
		return classes;
	}

	/**
	 * Setter of the property <tt>classes</tt>
	 * @param classes  The classes to set.
	 * @uml.property  name="classes"
	 */
	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}

}
