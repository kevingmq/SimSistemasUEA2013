package sim;

import java.util.Random;




public class System {
	
	private static final int NUMEROSIMULACOES = 300;
	//opcoes
	private static final int DEFAULT = 0;// Simulacao comun 
	private static final int SEMANAUTIL = 1;// Simulacao de semana util
	private static final int FERIADOS = 3;// simulacao de sabdos,domingos e feriados
	// setar de acordo com as opcoes
	private static final int MODODIA = FERIADOS; // setar
	
	
	
	private static final boolean MODORANDOMCHEGADA = true;
	private static final int MINTIMECHEGADA = 5;
	private static final int MAXTIMECHEGADA = 15;

	private static final boolean MODORANDOMLAVAGEM = true;
	private static final int MINTIMELAVAGEM = 8;
	private static final int MAXTIMELAVAGEM = 15;
	
	
	
	private static final int TEMPODESIMULACAO = 600;// 600 min = 10h
	private static final int TEMPODECHEGADA = 10; //if MODORAMNDOMCHEGADA = false
	private static final int TEMPODELAVAGEM = 10;//if MODORAMNDOMLAVAGEM = false
	public static final int MAXCARROSFILA = 4;
	private static final int NUMEROMAQUINASMAX = 2;
	/**
	 * @param args
	 */
	public static Posto vPost;
	public static int tempoDeSimulacao = 0;
	public static int quantTotalCarrosChegaram = 0;
	public static int quantTotalCarrosAtendidos = 0;
	public static int quantTotalCarrosNaoAtendidos = 0;
	public static float tempoTotalMedioDeChegadas = 0;
	public static float tempoTotalMedioDeAtendimento = 0;
	public static float tempoTotalMedioDeEspera = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	
		for(int q = 1; q<= NUMEROSIMULACOES;q++){
			vPost = new Posto(q,NUMEROMAQUINASMAX);
			Simular(TEMPODESIMULACAO);
			vPost = null;
		}
		//java.lang.System.out.println("TotalCarrosChegaram: " + quantTotalCarrosChegaram);
		float media = (float)quantTotalCarrosChegaram/NUMEROSIMULACOES ;
		java.lang.System.out.print("TotalMediaCarrosChegaram: ");
		java.lang.System.out.format("%f%n", media);
		
		//java.lang.System.out.println("TotalCarrosAtendidos: " + quantTotalCarrosAtendidos);
		media = (float)quantTotalCarrosAtendidos/NUMEROSIMULACOES;
		java.lang.System.out.print("TotalMediaCarrosAtendidos: ");
		java.lang.System.out.format("%f%n", media);
		
		//java.lang.System.out.println("TotalCarrosNaoAtendidos: " + quantTotalCarrosNaoAtendidos);
		media = (float)quantTotalCarrosNaoAtendidos/NUMEROSIMULACOES;
		java.lang.System.out.print("TotalMediaCarrosNaoAtendidos: ");
		java.lang.System.out.format("%f%n", media);
		
		media = (float)tempoTotalMedioDeChegadas/NUMEROSIMULACOES;
		java.lang.System.out.print("TempoMediaDeChegadasPorSimulacao: ");
		java.lang.System.out.format("%f%n", media);
		

		media = (float)tempoTotalMedioDeAtendimento/NUMEROSIMULACOES;
		java.lang.System.out.print("TempoMediaDeAtendimento: ");
		java.lang.System.out.format("%f%n", media);
		
		media = (float)tempoTotalMedioDeEspera/NUMEROSIMULACOES;
		java.lang.System.out.print("TempoMediaDeEspera: ");
		java.lang.System.out.format("%f%n", media);
		
		
	}

	/**
	 * @uml.property  name="numMaquinasLavar"
	 */
	private String numMaquinasLavar;

	/**
	 * Getter of the property <tt>numMaquinasLavar</tt>
	 * @return  Returns the numMaquinasLavar.
	 * @uml.property  name="numMaquinasLavar"
	 */
	public String getNumMaquinasLavar() {
		return numMaquinasLavar;
	}

	/**
	 * Setter of the property <tt>numMaquinasLavar</tt>
	 * @param numMaquinasLavar  The numMaquinasLavar to set.
	 * @uml.property  name="numMaquinasLavar"
	 */
	public void setNumMaquinasLavar(String numMaquinasLavar) {
		this.numMaquinasLavar = numMaquinasLavar;
	}

		
	public static void Simular(int tempoMaxSimulacao){
		
		for(tempoDeSimulacao = 1; tempoDeSimulacao <= tempoMaxSimulacao; tempoDeSimulacao++ ){
		
			vPost.Run();
		}
		
		
		//java.lang.System.out.println("Total Carros que chegaram na simulação: " + vPost.getTotalCarrosChegaram());
		quantTotalCarrosChegaram += vPost.getTotalCarrosChegaram();
		//java.lang.System.out.println("Carros atendidos: " + vPost.getCarrosAtendidos());
		quantTotalCarrosAtendidos += vPost.getCarrosAtendidos();
		//java.lang.System.out.println("Carros na Fila: " + vPost.getCarrosNaFila());
		//java.lang.System.out.println("Carros sendo lavados: " + vPost.getTotalCarrosLavando());
		//java.lang.System.out.println("Carros que foram embora sem ser atendidos: " + vPost.getCarrosNaoAtendidos());
		quantTotalCarrosNaoAtendidos += vPost.getCarrosNaoAtendidos();
		//java.lang.System.out.println("Temp totoal de chegadas: " + vPost.getTempoTotalChegadas());
		tempoTotalMedioDeChegadas += (float)vPost.getTempoTotalChegadas()/vPost.getTotalCarrosChegaram();
		
		tempoTotalMedioDeAtendimento += vPost.getTempoMedioDeAtendimentoPorMaquina();
		tempoTotalMedioDeEspera += vPost.getTempoMedioDeEspera();
		
	}

	public static int getTempoChegada() {
		switch (MODODIA) {
		case DEFAULT:
			if(MODORANDOMCHEGADA){
				Random r = new Random();
				int i1 = r.nextInt(MAXTIMECHEGADA - MINTIMECHEGADA) + MINTIMECHEGADA + 1;
				return i1;
			}
			else{
				return TEMPODECHEGADA;
			}
		case SEMANAUTIL:
			Random r = new Random();
			int i2 = 0;
			if(tempoDeSimulacao < 240){
				i2 = r.nextInt(20 - 10) + 10 + 1;
			}else{
				if(tempoDeSimulacao < 360){
					i2 = r.nextInt(10 - 5) + 5 + 1;
				}else{
					i2 = r.nextInt(15 - 8) + 8 + 1;
				}
			}
			return i2;
		case FERIADOS:
			Random r1 = new Random();
			int i3 = 0;
			if(tempoDeSimulacao < 240){
				i3 = r1.nextInt(10 - 5) + 5 + 1;
			}else{
					i3 = TEMPODESIMULACAO;
				}
			
			return i3;
		default:
			throw new IllegalArgumentException("MODO DIA invalido!");
		}
	}

		
		/**
		 */
		public static int getTempoLavagem(){
			if(MODORANDOMLAVAGEM){
				Random r = new Random();
				int i1 = r.nextInt(MAXTIMELAVAGEM - MINTIMELAVAGEM) + MINTIMELAVAGEM + 1;
				return i1;
			}else{
			return TEMPODELAVAGEM;
			}
		}

}
