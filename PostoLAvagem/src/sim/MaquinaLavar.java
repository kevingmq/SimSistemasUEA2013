package sim;


public class MaquinaLavar implements Time {

	public static final int LIVRE = 0;
	public static final int LAVANDO = 1;
	private static int idstart = 1;
	/**
	 * @uml.property  name="idMaquinaLavar"
	 */
	private int idMaquinaLavar;

	/**
	 * Getter of the property <tt>idMaquinaLavar</tt>
	 * @return  Returns the idMaquinaLavar.
	 * @uml.property  name="idMaquinaLavar"
	 */
	public int getIdMaquinaLavar() {
		return idMaquinaLavar;
	}

	/**
	 * Setter of the property <tt>idMaquinaLavar</tt>
	 * @param idMaquinaLavar  The idMaquinaLavar to set.
	 * @uml.property  name="idMaquinaLavar"
	 */
	public void setIdMaquinaLavar(int idMaquinaLavar) {
		this.idMaquinaLavar = idMaquinaLavar;
	}

	/** 
	 * @uml.property name="tempoLavagem"
	 */
	private int tempoLavagem;

	/** 
	 * Getter of the property <tt>tempoLavagem</tt>
	 * @return  Returns the tempoLavagem.
	 * @uml.property  name="tempoLavagem"
	 */
	public int getTempoLavagem() {
		return tempoLavagem;
	}

	/**
		 */
		public void Run(int tempoRelogio){
			
			if(statusMaquina == LIVRE){ //maquina livre
				if(posto.getFila().temCarros()){
					carroLavando = posto.getFila().getNextCarro();
					this.LavarCarro(carroLavando);
					statusMaquina = LAVANDO;
					tempoLavagem = System.getTempoLavagem();
					this.tempoTotalDeAtendimento += tempoLavagem;
					carroLavando.setTempoDeServico(tempoLavagem);
					carroLavando.setTempoInicioServico(tempoRelogio);
					
				}
			}
			
			if(statusMaquina == LAVANDO){ // maquina lavando
				tempoLavagem--;
			}
			if(tempoLavagem == 0 && statusMaquina == LAVANDO){
				statusMaquina = LIVRE;
				carroLavando.setTempoFinalServicoRelogio(tempoRelogio+1);
				LiberarCarro(carroLavando);
				this.carrosAtendidos++;
			}
			
		}

		/** 
		 * Setter of the property <tt>tempoLavagem</tt>
		 * @param tempoLavagem  The tempoLavagem to set.
		 * @uml.property  name="tempoLavagem"
		 */
		public void setTempoLavagem(int tempoLavagem) {
			this.tempoLavagem = tempoLavagem;
		}

		/** 
		 * @uml.property name="statusMaquina"
		 */
		private int statusMaquina;

		/** 
		 * Getter of the property <tt>statusMaquina</tt>
		 * @return  Returns the statusMaquina.
		 * @uml.property  name="statusMaquina"
		 */
		public int getStatusMaquina() {
			return statusMaquina;
		}

		/** 
		 * @uml.property name="tempoMaxLavagem"
		 */
		

		/**
		 * @uml.property  name="posto"
		 * @uml.associationEnd  inverse="maquinaLavar:sim.Posto"
		 */
		private Posto posto;

		/**
		 * Getter of the property <tt>posto</tt>
		 * @return  Returns the posto.
		 * @uml.property  name="posto"
		 */
		public Posto getPosto() {
			return posto;
		}

		/**
		 * Setter of the property <tt>posto</tt>
		 * @param posto  The posto to set.
		 * @uml.property  name="posto"
		 */
		public void setPosto(Posto posto) {
			this.posto = posto;
		}

			
			/**
			 */
			public void LavarCarro(Carro carro_p){
				carro_p.getFila().sairFila(carro_p);
				carro_p.setMaquinaUtilizada(this);
				setCarroLavando(carro_p);
				carro_p.setStatusLavagem(Carro.LAVANDO);
			}

			/** 
			 * Setter of the property <tt>statusMaquina</tt>
			 * @param statusMaquina  The statusMaquina to set.
			 * @uml.property  name="statusMaquina"
			 */
			public void setStatusMaquina(int statusMaquina) {
				this.statusMaquina = statusMaquina;
			}

			/**
			 * @uml.property  name="carroLavando"
			 * @uml.associationEnd  inverse="maquinaUtilizada:sim.Carro"
			 */
			private Carro carroLavando;

			/**
			 * Getter of the property <tt>carroLavando</tt>
			 * @return  Returns the carroLavando.
			 * @uml.property  name="carroLavando"
			 */
			public Carro getCarroLavando() {
				return carroLavando;
			}

			/**
			 * Setter of the property <tt>carroLavando</tt>
			 * @param carroLavando  The carroLavando to set.
			 * @uml.property  name="carroLavando"
			 */
			public void setCarroLavando(Carro carroLavando) {
				this.carroLavando = carroLavando;
			}

				
				/**
				 */
				public void LiberarCarro(Carro carro_p){
					carro_p.setStatusLavagem(Carro.LIMPO);
					this.carroLavando = null;
					posto.CarroSaiu(carro_p);
				}

					
					/**
					 */
					public MaquinaLavar(int tempoLavagem_p,Posto posto_p){
						this.tempoTotalDeAtendimento = 0;
						idMaquinaLavar = idstart;
						idstart++;
						posto = posto_p;
						tempoLavagem = tempoLavagem_p;
						statusMaquina = LIVRE;
						carroLavando = null;
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
						public float getTempoMedioAtendimento(){
							return (float)tempoTotalDeAtendimento/carrosAtendidos;
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

}
