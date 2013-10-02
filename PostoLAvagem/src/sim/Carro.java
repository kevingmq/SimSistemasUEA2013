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

		public void Run() {
			
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

}
