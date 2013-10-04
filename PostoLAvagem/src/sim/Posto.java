package sim;

import java.util.ArrayList;
import java.util.Collection;


public class Posto implements Time{

	/**
	 * @uml.property  name="idPosto"
	 */
	private int idPosto;

	/**
	 * Getter of the property <tt>idPosto</tt>
	 * @return  Returns the idPosto.
	 * @uml.property  name="idPosto"
	 */
	public int getIdPosto() {
		return idPosto;
	}

	/**
	 * Setter of the property <tt>idPosto</tt>
	 * @param idPosto  The idPosto to set.
	 * @uml.property  name="idPosto"
	 */
	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}

		
		/**
		 */
		public void CarroChegou(Carro carro_p){
			
			if(fila.temVaga()){
				fila.entrarNaFila(carro_p);
			}else{
				carro_p.setStatusLavagem(Carro.FOIEMBORA);
				carrosNaoAtendidos++;
			}
		}

			
			/**
			 */
			public void CarroSaiu(Carro carro_p){
				carrosAtendidos++;
			}


			/**
			 * @uml.property  name="fila"
			 * @uml.associationEnd  multiplicity="(1 1)" inverse="posto:sim.Fila"
			 */
			private Fila fila;

			/**
			 * Getter of the property <tt>fila</tt>
			 * @return  Returns the fila.
			 * @uml.property  name="fila"
			 */
			public Fila getFila() {
				return fila;
			}

			/**
			 * Setter of the property <tt>fila</tt>
			 * @param fila  The fila to set.
			 * @uml.property  name="fila"
			 */
			public void setFila(Fila fila) {
				this.fila = fila;
			}


			/**
			 * @uml.property  name="maquinaLavar"
			 * @uml.associationEnd  multiplicity="(0 -1)" inverse="posto:sim.MaquinaLavar"
			 */
			private Collection<MaquinaLavar> maquinaLavar; 

			/**
			 * Getter of the property <tt>maquinaLavar</tt>
			 * @return  Returns the maquinaLavar.
			 * @uml.property  name="maquinaLavar"
			 */
			public Collection<MaquinaLavar> getMaquinaLavar() {
				return maquinaLavar;
			}

			/**
			 * Setter of the property <tt>maquinaLavar</tt>
			 * @param maquinaLavar  The maquinaLavar to set.
			 * @uml.property  name="maquinaLavar"
			 */
			public void setMaquinaLavar(Collection<MaquinaLavar> maquinaLavar) {
				this.maquinaLavar = maquinaLavar;
			}

			@Override
			public void Run(int tempoRelogio) {
				
				if(tempoChegada == -1){
					tempoChegada = System.getTempoChegada();
					tempoChegadaAnterior = tempoChegada;
					tempoChegada--;
				}
				
				if(tempoChegada == 0){
					Carro newCarro = new Carro();
					newCarro.setTempoDesdeUltimaChegada(tempoChegadaAnterior);
					newCarro.setTempoChegadaRelogio(tempoRelogio);
					listaCarros.add(newCarro);
					CarroChegou(newCarro);
					totalCarrosChegaram++;
					tempoChegada = System.getTempoChegada();
					tempoChegadaAnterior = tempoChegada;
					this.tempoTotalChegadas += tempoChegada;
					tempoChegada--;
				}else{
					tempoChegada--;
				}
				setCarrosNaFila(this.getFila().getFilaEspera().size());
				
				for (MaquinaLavar p : maquinaLavar) {
					p.Run(tempoRelogio);
				}
				for (Carro c : listaCarros){
					c.Run(tempoRelogio);
				}
			}

				
				/**
				 */
				public Posto(int id_p,int maxMaq_p){
					this.listaCarros = new ArrayList<Carro>();
					this.tempoTotalDeAtendimento = 0;
					this.tempoTotalChegadas = 0;
					this.idPosto = id_p;
					carrosNaoAtendidos = 0;
					carrosNaFila = 0;
					maquinaLavar = new ArrayList<MaquinaLavar>();
					for(int x = 0;x<maxMaq_p;x++){
					maquinaLavar.add(new MaquinaLavar(System.getTempoLavagem(),this));
					}
					fila = new Fila(System.MAXCARROSFILA);
					tempoChegada = -1;
					
				}


				/**
				 * @uml.property  name="tempoChegada"
				 */
				private int tempoChegada;

				/**
				 * Getter of the property <tt>tempoChegada</tt>
				 * @return  Returns the tempoChegada.
				 * @uml.property  name="tempoChegada"
				 */
				public int getTempoChegada() {
					return tempoChegada;
				}

				/**
				 * Setter of the property <tt>tempoChegada</tt>
				 * @param tempoChegada  The tempoChegada to set.
				 * @uml.property  name="tempoChegada"
				 */
				public void setTempoChegada(int tempoChegada) {
					this.tempoChegada = tempoChegada;
				}


				/**
				 * @uml.property  name="carrosAtendidos"
				 */
				private int carrosAtendidos;

				/**
				 * Getter of the property <tt>carrosAtendidos</tt>
				 * @return  Returns the carrosAtendidos.
				 * @uml.property  name="carrosAtendidos"
				 */
				public int getCarrosAtendidos() {
					return carrosAtendidos;
				}

				/**
				 * Setter of the property <tt>carrosAtendidos</tt>
				 * @param carrosAtendidos  The carrosAtendidos to set.
				 * @uml.property  name="carrosAtendidos"
				 */
				public void setCarrosAtendidos(int carrosAtendidos) {
					this.carrosAtendidos = carrosAtendidos;
				}


				/**
				 * @uml.property  name="carrosNaFila"
				 */
				private int carrosNaFila;

				/**
				 * Getter of the property <tt>carrosNaFila</tt>
				 * @return  Returns the carrosNaFila.
				 * @uml.property  name="carrosNaFila"
				 */
				public int getCarrosNaFila() {
					return carrosNaFila;
				}

				/**
				 * Setter of the property <tt>carrosNaFila</tt>
				 * @param carrosNaFila  The carrosNaFila to set.
				 * @uml.property  name="carrosNaFila"
				 */
				public void setCarrosNaFila(int carrosNaFila) {
					this.carrosNaFila = carrosNaFila;
				}


				/**
				 * @uml.property  name="CarrosNaoAtendidos"
				 */
				private int carrosNaoAtendidos;

				/**
				 * Getter of the property <tt>CarrosNaoAtendidos</tt>
				 * @return  Returns the carrosNaoAtendidos.
				 * @uml.property  name="CarrosNaoAtendidos"
				 */
				public int getCarrosNaoAtendidos() {
					return carrosNaoAtendidos;
				}

				/**
				 * Setter of the property <tt>CarrosNaoAtendidos</tt>
				 * @param CarrosNaoAtendidos  The carrosNaoAtendidos to set.
				 * @uml.property  name="CarrosNaoAtendidos"
				 */
				public void setCarrosNaoAtendidos(int carrosNaoAtendidos) {
					this.carrosNaoAtendidos = carrosNaoAtendidos;
				}
				/** 
				 * @uml.property name="totalCarrosChegaram"
				 */
				private int totalCarrosChegaram;

				
				/** 
				 * @uml.property  name="totalCarrosChegaram"
				 */
				public int getTotalCarrosChegaram() {
					return totalCarrosChegaram;
				}

				
				/** 
				 * @uml.property  name="totalCarrosChegaram"
				 */
				public void setTotalCarrosChegaram(int totalCarrosChegaram) {
					this.totalCarrosChegaram = totalCarrosChegaram;
				}

				public int getTotalCarrosLavando() {
					int total = 0;
					for (MaquinaLavar maq : this.getMaquinaLavar()) {
						if(maq.getStatusMaquina() == MaquinaLavar.LAVANDO){
							total++;
						}
					}
					return total;
				}


				/**
				 * @uml.property  name="tempoTotalChegadas"
				 */
				private int tempoTotalChegadas;

				/**
				 * Getter of the property <tt>tempoTotalChegadas</tt>
				 * @return  Returns the tempoTotalChegadas.
				 * @uml.property  name="tempoTotalChegadas"
				 */
				public int getTempoTotalChegadas() {
					return tempoTotalChegadas;
				}

				/**
				 * Setter of the property <tt>tempoTotalChegadas</tt>
				 * @param tempoTotalChegadas  The tempoTotalChegadas to set.
				 * @uml.property  name="tempoTotalChegadas"
				 */
				public void setTempoTotalChegadas(int tempoTotalChegadas) {
					this.tempoTotalChegadas = tempoTotalChegadas;
				}


				/**
				 * @uml.property  name="tempoTotalDeAtendimento"
				 */
				private int tempoTotalDeAtendimento;

				/**
				 * Getter of the property <tt>tempoTotalDeAtendimento</tt>
				 * @return  Returns the tempoTotalDeAtendimento.
				 * @uml.property  name="tempoTotalDeAtendimento"
				 */
				public int getTempoTotalDeAtendimento() {
					return tempoTotalDeAtendimento;
				}

				/**
				 * Setter of the property <tt>tempoTotalDeAtendimento</tt>
				 * @param tempoTotalDeAtendimento  The tempoTotalDeAtendimento to set.
				 * @uml.property  name="tempoTotalDeAtendimento"
				 */
				public void setTempoTotalDeAtendimento(
						int tempoTotalDeAtendimento) {
							this.tempoTotalDeAtendimento = tempoTotalDeAtendimento;
						}

					
					/**
					 */
					public float getTempoMedioDeAtendimentoPorMaquina(){
						int tempoTotalDeAtendimento = 0;
						for (MaquinaLavar maq : this.maquinaLavar) {
							tempoTotalDeAtendimento += maq.getTempoMedioAtendimento();
							
						}
						return (float)tempoTotalDeAtendimento/this.maquinaLavar.size();
						
					}


					/** 
					 * @uml.property name="listaCarros"
					 * @uml.associationEnd multiplicity="(0 -1)" inverse="posto:sim.Carro"
					 * @uml.association name="ListaDeCarros"
					 */
					private Collection<Carro> listaCarros;

					/** 
					 * Getter of the property <tt>listaCarros</tt>
					 * @return  Returns the carro.
					 * @uml.property  name="listaCarros"
					 */
					public Collection<Carro> getListaCarros() {
						return listaCarros;
					}

					/** 
					 * Setter of the property <tt>listaCarros</tt>
					 * @param listaCarros  The carro to set.
					 * @uml.property  name="listaCarros"
					 */
					public void setListaCarros(Collection<Carro> listaCarros) {
						this.listaCarros = listaCarros;
					}

						
						/**
						 */
						public float getTempoMedioDeEspera(){
							int tempoTotal = 0;
							for (Carro c : listaCarros) {
								if(c.getStatusLavagem() == Carro.LIMPO ){
								tempoTotal += c.getTempoEspera();
								}
							}
							return (float)tempoTotal/this.carrosAtendidos;
						}


						/**
						 * @uml.property  name="tempoChegadaAnterior"
						 */
						private int tempoChegadaAnterior;

						/**
						 * Getter of the property <tt>tempoChegadaAnterior</tt>
						 * @return  Returns the tempoChegadaAnterior.
						 * @uml.property  name="tempoChegadaAnterior"
						 */
						public int getTempoChegadaAnterior() {
							return tempoChegadaAnterior;
						}

						/**
						 * Setter of the property <tt>tempoChegadaAnterior</tt>
						 * @param tempoChegadaAnterior  The tempoChegadaAnterior to set.
						 * @uml.property  name="tempoChegadaAnterior"
						 */
						public void setTempoChegadaAnterior(
								int tempoChegadaAnterior) {
							this.tempoChegadaAnterior = tempoChegadaAnterior;
						}

}
