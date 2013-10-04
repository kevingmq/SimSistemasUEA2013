package est;

public class Classe {

	/**
	 * @uml.property name="amplitude"
	 */
	private int amplitude;

	/**
	 * Getter of the property <tt>amplitude</tt>
	 * 
	 * @return Returns the amplitude.
	 * @uml.property name="amplitude"
	 */
	public int getAmplitude() {
		return amplitude;
	}

	/**
	 * Setter of the property <tt>amplitude</tt>
	 * 
	 * @param amplitude
	 *            The amplitude to set.
	 * @uml.property name="amplitude"
	 */
	public void setAmplitude(int amplitude) {
		this.amplitude = amplitude;
	}

	/**
	 * @uml.property name="id"
	 */
	private int id;

	/**
	 * Getter of the property <tt>id</tt>
	 * 
	 * @return Returns the id.
	 * @uml.property name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 * 
	 * @param id
	 *            The id to set.
	 * @uml.property name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @uml.property name="frequencia"
	 */
	private int frequencia;

	/**
	 * Getter of the property <tt>frequencia</tt>
	 * 
	 * @return Returns the frequencia.
	 * @uml.property name="frequencia"
	 */
	public int getFrequencia() {
		return frequencia;
	}

	/**
	 * Setter of the property <tt>frequencia</tt>
	 * 
	 * @param frequencia
	 *            The frequencia to set.
	 * @uml.property name="frequencia"
	 */
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	/**
		 */
	public boolean IsMyClass(int value){
			int min = (id-1)*amplitude;
			int max = (id)*amplitude -1;
			if(value <= max && value >=min){
				return true;
			}else{
				return false;
			}
		}

	/**
			 */
	public void moreOne() {
		frequencia++;
	}

	/**
				 */
	public Classe(int id_p, int amplitude_p) {
		id = id_p;
		amplitude = amplitude_p;
		frequencia = 0;
	}

	/**
	 * @uml.property  name="probAcomulada"
	 */
	private float probAcomulada;

	/**
	 * Getter of the property <tt>probAcomulada</tt>
	 * @return  Returns the probAcomulada.
	 * @uml.property  name="probAcomulada"
	 */
	public float getProbAcomulada() {
		return probAcomulada;
	}

	/**
	 * Setter of the property <tt>probAcomulada</tt>
	 * @param probAcomulada  The probAcomulada to set.
	 * @uml.property  name="probAcomulada"
	 */
	public void setProbAcomulada(float probAcomulada) {
		this.probAcomulada = probAcomulada;
	}

	/**
	 * @uml.property  name="pontoMedio"
	 */
	private int pontoMedio;

	/**
	 * Getter of the property <tt>pontoMedio</tt>
	 * @return  Returns the pontoMedio.
	 * @uml.property  name="pontoMedio"
	 */
	public int getPontoMedio() {
		return pontoMedio;
	}

	/**
	 * Setter of the property <tt>pontoMedio</tt>
	 * @param pontoMedio  The pontoMedio to set.
	 * @uml.property  name="pontoMedio"
	 */
	public void setPontoMedio(int pontoMedio) {
		this.pontoMedio = pontoMedio;
	}

}
