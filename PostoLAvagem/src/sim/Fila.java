package sim;

import java.util.ArrayList;
import java.util.Collection;


public class Fila {

	/**
	 * @uml.property  name="maxCarros"
	 */
	private int maxCarros;

	/**
	 * Getter of the property <tt>maxCarros</tt>
	 * @return  Returns the maxCarros.
	 * @uml.property  name="maxCarros"
	 */
	public int getMaxCarros() {
		return maxCarros;
	}

	/**
	 * Setter of the property <tt>maxCarros</tt>
	 * @param maxCarros  The maxCarros to set.
	 * @uml.property  name="maxCarros"
	 */
	public void setMaxCarros(int maxCarros) {
		this.maxCarros = maxCarros;
	}

	/** 
	 * @uml.property name="filaEspera"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="fila:sim.Carro"
	 */
	private Collection<Carro> carrosNaFila;

	/**
	 * Getter of the property <tt>filaEspera</tt>
	 * @return  Returns the carro.
	 * @uml.property  name="filaEspera"
	 */
	public Collection<Carro> getFilaEspera() {
		return carrosNaFila;
	}

	/**
	 * Setter of the property <tt>filaEspera</tt>
	 * @param filaEspera  The carro to set.
	 * @uml.property  name="filaEspera"
	 */
	public void setFilaEspera(Collection<Carro> carrosNaFila_p) {
		carrosNaFila = carrosNaFila_p;
	}

		
		/**
		 */
		public boolean temVaga(){
			if(carrosNaFila.isEmpty()){
				return true;
			}else{
				if(maxCarros == carrosNaFila.size()){
					return false;
				}
				else{
					return true;
				}
			}
		}

			
			/**
			 */
			public void entrarNaFila(Carro carro_p){
				carrosNaFila.add(carro_p);
				carro_p.setFila(this);
			}

				
				/**
				 */
				public boolean temCarros(){
					return !carrosNaFila.isEmpty();
				}

					
					/**
					 */
					public Carro getNextCarro(){
						Object x;
						x = carrosNaFila.iterator().next();
						return (Carro) x;
						
					}

						
						/**
						 */
						public void sairFila(Carro carro_p){
							carrosNaFila.remove(carro_p);
						}

						public Fila(int maxCarros_p){
							carrosNaFila = new ArrayList<Carro>();
							maxCarros = maxCarros_p;
						}
						
}
