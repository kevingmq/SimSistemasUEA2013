package sim;


public class Carro implements Time{

	public static final int SUJO = 0;
	public static final int LAVANDO = 1;
	public static final int LIMPO = 2;
	public static final int FOIEMBORA = 3;
	private static int idstart = 1;
	
	/**
	 * @uml.property  name="idCarro"
	 */
	private int idCarro;

	/** 
	 * Getter of the property <tt>id</tt>
	 * @return  Returns the id.
	 * @uml.property  name="idCarro"
	 */
	public int getIdCarro() {
		return idCarro;
	}

	/** 
	 * Setter of the property <tt>id</tt>
	 * @param id  The id to set.
	 * @uml.property  name="idCarro"
	 */
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	/**
	 * @uml.property  name="statusLavagem"
	 */
	private int statusLavagem;

	/**
	 * Getter of the property <tt>statusLavagem</tt>
	 * @return  Returns the statusLavagem.
	 * @uml.property  name="statusLavagem"
	 */
	public int getStatusLavagem() {
		return statusLavagem;
	}

	/**
	 * Setter of the property <tt>statusLavagem</tt>
	 * @param statusLavagem  The statusLavagem to set.
	 * @uml.property  name="statusLavagem"
	 */
	public void setStatusLavagem(int statusLavagem) {
		this.statusLavagem = statusLavagem;
	}

		
	

		/** 
		 * @uml.property name="fila"
		 * @uml.associationEnd inverse="filaEspera:sim.Fila"
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
		 * @uml.property  name="maquinaUtilizada"
		 * @uml.associationEnd  inverse="carroLavando:sim.MaquinaLavar"
		 */
		private MaquinaLavar maquinaUtilizada;

		/**
		 * Getter of the property <tt>maquinaUtilizada</tt>
		 * @return  Returns the maquinaUtilizada.
		 * @uml.property  name="maquinaUtilizada"
		 */
		public MaquinaLavar getMaquinaUtilizada() {
			return maquinaUtilizada;
		}

		/**
		 * Setter of the property <tt>maquinaUtilizada</tt>
		 * @param maquinaUtilizada  The maquinaUtilizada to set.
		 * @uml.property  name="maquinaUtilizada"
		 */
		public void setMaquinaUtilizada(MaquinaLavar maquinaUtilizada) {
			this.maquinaUtilizada = maquinaUtilizada;
		}
		public Carro(){
			this.idCarro = idstart;
			idstart++;
			statusLavagem = SUJO;
		}

		public void Run(int tempoRelogio) {
			
			if(statusLavagem == Carro.SUJO){
				tempoEspera++;
			}
			
		}

		/**
		 * @uml.property  name="tempoEspera"
		 */
		private int tempoEspera;

		/**
		 * Getter of the property <tt>tempoEspera</tt>
		 * @return  Returns the tempoEspera.
		 * @uml.property  name="tempoEspera"
		 */
		public int getTempoEspera() {
			return tempoEspera;
		}

		/**
		 * Setter of the property <tt>tempoEspera</tt>
		 * @param tempoEspera  The tempoEspera to set.
		 * @uml.property  name="tempoEspera"
		 */
		public void setTempoEspera(int tempoEspera) {
			this.tempoEspera = tempoEspera;
		}

		/**
		 * @uml.property  name="tempoChegadaRelogio"
		 */
		private int tempoChegadaRelogio;

		/**
		 * Getter of the property <tt>tempoChegadaRelogio</tt>
		 * @return  Returns the tempoChegadaRelogio.
		 * @uml.property  name="tempoChegadaRelogio"
		 */
		public int getTempoChegadaRelogio() {
			return tempoChegadaRelogio;
		}

		/**
		 * Setter of the property <tt>tempoChegadaRelogio</tt>
		 * @param tempoChegadaRelogio  The tempoChegadaRelogio to set.
		 * @uml.property  name="tempoChegadaRelogio"
		 */
		public void setTempoChegadaRelogio(int tempoChegadaRelogio) {
			this.tempoChegadaRelogio = tempoChegadaRelogio;
		}

		/**
		 * @uml.property  name="tempoSaidaRelogio"
		 */
		private int tempoSaidaRelogio;

		/**
		 * Getter of the property <tt>tempoSaidaRelogio</tt>
		 * @return  Returns the tempoSaidaRelogio.
		 * @uml.property  name="tempoSaidaRelogio"
		 */
		public int getTempoSaidaRelogio() {
			return tempoSaidaRelogio;
		}

		/**
		 * Setter of the property <tt>tempoSaidaRelogio</tt>
		 * @param tempoSaidaRelogio  The tempoSaidaRelogio to set.
		 * @uml.property  name="tempoSaidaRelogio"
		 */
		public void setTempoSaidaRelogio(int tempoSaidaRelogio) {
			this.tempoSaidaRelogio = tempoSaidaRelogio;
		}

		/**
		 * @uml.property  name="tempoDeServico"
		 */
		private int tempoDeServico;

		/**
		 * Getter of the property <tt>tempoDeServico</tt>
		 * @return  Returns the tempoDeServico.
		 * @uml.property  name="tempoDeServico"
		 */
		public int getTempoDeServico() {
			return tempoDeServico;
		}

		/**
		 * Setter of the property <tt>tempoDeServico</tt>
		 * @param tempoDeServico  The tempoDeServico to set.
		 * @uml.property  name="tempoDeServico"
		 */
		public void setTempoDeServico(int tempoDeServico) {
			this.tempoDeServico = tempoDeServico;
		}

		/**
		 * @uml.property  name="tempoDesdeUltimaChegada"
		 */
		private int tempoDesdeUltimaChegada;

		/**
		 * Getter of the property <tt>tempoDesdeUltimaChegada</tt>
		 * @return  Returns the tempoDesdeUltimaChegada.
		 * @uml.property  name="tempoDesdeUltimaChegada"
		 */
		public int getTempoDesdeUltimaChegada() {
			return tempoDesdeUltimaChegada;
		}

		/**
		 * Setter of the property <tt>tempoDesdeUltimaChegada</tt>
		 * @param tempoDesdeUltimaChegada  The tempoDesdeUltimaChegada to set.
		 * @uml.property  name="tempoDesdeUltimaChegada"
		 */
		public void setTempoDesdeUltimaChegada(int tempoDesdeUltimaChegada) {
			this.tempoDesdeUltimaChegada = tempoDesdeUltimaChegada;
		}

		/**
		 * @uml.property  name="tempoInicioServico"
		 */
		private int tempoInicioServico;

		/** 
		 * Getter of the property <tt>tempoServico</tt>
		 * @return  Returns the tempoServico.
		 * @uml.property  name="tempoInicioServico"
		 */
		public int getTempoInicioServico() {
			return tempoInicioServico;
		}

		/** 
		 * Setter of the property <tt>tempoServico</tt>
		 * @param tempoServico  The tempoServico to set.
		 * @uml.property  name="tempoInicioServico"
		 */
		public void setTempoInicioServico(int tempoInicioServico) {
			this.tempoInicioServico = tempoInicioServico;
		}

		/**
		 * @uml.property  name="tempoFinalServicoRelogio"
		 */
		private int tempoFinalServicoRelogio;

		/**
		 * Getter of the property <tt>tempoFinalServicoRelogio</tt>
		 * @return  Returns the tempoFinalServicoRelogio.
		 * @uml.property  name="tempoFinalServicoRelogio"
		 */
		public int getTempoFinalServicoRelogio() {
			return tempoFinalServicoRelogio;
		}

		/**
		 * Setter of the property <tt>tempoFinalServicoRelogio</tt>
		 * @param tempoFinalServicoRelogio  The tempoFinalServicoRelogio to set.
		 * @uml.property  name="tempoFinalServicoRelogio"
		 */
		public void setTempoFinalServicoRelogio(int tempoFinalServicoRelogio) {
			this.tempoFinalServicoRelogio = tempoFinalServicoRelogio;
		}

		/**
		 * @uml.property  name="tempoNoSistema"
		 */
		private int tempoNoSistema;

		/**
		 * Getter of the property <tt>tempoNoSistema</tt>
		 * @return  Returns the tempoNoSistema.
		 * @uml.property  name="tempoNoSistema"
		 */
		public int getTempoNoSistema() {
			return tempoNoSistema;
		}

		/**
		 * Setter of the property <tt>tempoNoSistema</tt>
		 * @param tempoNoSistema  The tempoNoSistema to set.
		 * @uml.property  name="tempoNoSistema"
		 */
		public void setTempoNoSistema(int tempoNoSistema) {
			this.tempoNoSistema = tempoNoSistema;
		}

			
			/**
			 */
			public void calculaTempoNoSistema(){
				if(this.statusLavagem == Carro.LIMPO){
					this.tempoNoSistema = tempoFinalServicoRelogio-tempoChegadaRelogio;
				}
			}

}
