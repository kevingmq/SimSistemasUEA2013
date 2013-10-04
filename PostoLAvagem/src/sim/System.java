package sim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import est.Classe;
import est.GeradorDistFreq;

public class System {

	private static final int NUMEROSIMULACOES = 30;
	// opcoes
	private static final int DEFAULT = 0;// Simulacao comun
	private static final int SEMANAUTIL = 1;// Simulacao de semana util
	private static final int FERIADOS = 3;// simulacao de sabdos,domingos e
											// feriados

	// setar de acordo com as opcoes
	private static final int MODODIA = DEFAULT; // setar

	private static final boolean MODORANDOMCHEGADA = true;
	private static final int MINTIMECHEGADA = 0;
	private static final int MAXTIMECHEGADA = 50;

	private static final boolean MODORANDOMLAVAGEM = true;
	private static final int MINTIMELAVAGEM = 0;
	private static final int MAXTIMELAVAGEM = 15;

	private static final int TEMPODESIMULACAO = 600;// 600 min = 10h
	private static final int TEMPODECHEGADA = 10; // if MODORAMNDOMCHEGADA =
													// false
	private static final int TEMPODELAVAGEM = 10;// if MODORAMNDOMLAVAGEM =
													// false
	public static final int MAXCARROSFILA = 200;
	private static final int NUMEROMAQUINASMAX = 1;
	private static boolean MONTECARLO = false;
	/**
	 * @param args
	 */
	public static Posto vPost;
	public static int tempoDeSimulacao = 0;
	public static int quantTotalCarrosChegaram = 0;
	public static int quantTotalCarrosAtendidos = 0;
	public static int quantTotalCarrosNaoAtendidos = 0;
	public static double tempoTotalMedioDeChegadas = 0;
	public static float tempoTotalMedioDeAtendimento = 0;
	public static float tempoTotalMedioDeEspera = 0;

	public static est.GeradorDistFreq objGeradorTEC;
	public static est.GeradorDistFreq objGeradorTS;
	public static ArrayList<Integer> massaDadosNormalTEC;
	public static ArrayList<Integer> massaDadosNormalTS;
	public static boolean carregarMassa = false;
	public static gna.Gerador g = new gna.Gerador();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		massaDadosNormalTEC = new ArrayList<Integer>();
		massaDadosNormalTS = new ArrayList<Integer>();
		
		objGeradorTEC = new est.GeradorDistFreq("TEC", 10000, 5, 10);
		objGeradorTEC.GerarDistribuicaoFrequencia();

		objGeradorTS = new est.GeradorDistFreq("TS", 10000, 4, 4);
		objGeradorTS.GerarDistribuicaoFrequencia();

		MONTECARLO = true;
		carregarMassa = true;
		for (int q = 1; q <= NUMEROSIMULACOES; q++) {
			vPost = new Posto(q, NUMEROMAQUINASMAX);
			try {
				Simular(TEMPODESIMULACAO);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vPost = null;
		}
		try{
		String fileString = "SimulaçãoDadosGerais.txt";
		File outputfile = new File(fileString);
		FileWriter out = new FileWriter(outputfile);
				
		// java.lang.System.out.println("TotalCarrosChegaram: " +
		// quantTotalCarrosChegaram);
		float media = (float) quantTotalCarrosChegaram / NUMEROSIMULACOES;
		java.lang.System.out.print("TotalMediaCarrosChegaram: ");
		out.write("Total Media Entre Chegadas de carros: " + media + "\n");
		java.lang.System.out.format("%f%n", media);

		// java.lang.System.out.println("TotalCarrosAtendidos: " +
		// quantTotalCarrosAtendidos);
		media = (float) quantTotalCarrosAtendidos / NUMEROSIMULACOES;
		java.lang.System.out.print("TotalMediaCarrosAtendidos: ");
		java.lang.System.out.format("%f%n", media);
		out.write("Total Media Carros Atendidos: " + media + "\n");

		// java.lang.System.out.println("TotalCarrosNaoAtendidos: " +
		// quantTotalCarrosNaoAtendidos);
		media = (float) quantTotalCarrosNaoAtendidos / NUMEROSIMULACOES;
		java.lang.System.out.print("TotalMediaCarrosNaoAtendidos: ");
		java.lang.System.out.format("%f%n", media);
		out.write("Total Media Carros Nao Atendidos: " + media + "\n");

		media = (float) tempoTotalMedioDeChegadas / NUMEROSIMULACOES;
		java.lang.System.out.print("TempoMediaDeChegadasPorSimulacao: ");
		java.lang.System.out.format("%f%n", media);
		out.write("Total Media de Chegadas: " + media + "\n");

		media = (float) tempoTotalMedioDeAtendimento / NUMEROSIMULACOES;
		java.lang.System.out.print("TempoMediaDeAtendimento: ");
		java.lang.System.out.format("%f%n", media);
		out.write("Total Media de Serviço: " + media + "\n");
		

		media = (float) tempoTotalMedioDeEspera / NUMEROSIMULACOES;
		java.lang.System.out.print("TempoMediaDeEspera: ");
		java.lang.System.out.format("%f%n", media);
		out.write("Total Media de Espera: " + media + "\n");
		out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(carregarMassa){
		GeradorDistFreq cenario1TEC = new GeradorDistFreq("TEC", massaDadosNormalTEC.size(), 5, 10,massaDadosNormalTEC);
		GeradorDistFreq cenario1TS = new GeradorDistFreq("TS", massaDadosNormalTS.size(), 4, 4,massaDadosNormalTS);
		cenario1TEC.teste("OUT");
		cenario1TS.teste("OUT");
		}
	}

	/**
	 * @uml.property name="numMaquinasLavar"
	 */
	private String numMaquinasLavar;

	/**
	 * Getter of the property <tt>numMaquinasLavar</tt>
	 * 
	 * @return Returns the numMaquinasLavar.
	 * @uml.property name="numMaquinasLavar"
	 */
	public String getNumMaquinasLavar() {
		return numMaquinasLavar;
	}

	/**
	 * Setter of the property <tt>numMaquinasLavar</tt>
	 * 
	 * @param numMaquinasLavar
	 *            The numMaquinasLavar to set.
	 * @uml.property name="numMaquinasLavar"
	 */
	public void setNumMaquinasLavar(String numMaquinasLavar) {
		this.numMaquinasLavar = numMaquinasLavar;
	}

	public static void Simular(int tempoMaxSimulacao) throws IOException {
		int id = vPost.getIdPosto();
		String fileString = "Simulacoes/Simulação_" + id + ".txt";
		File outputfile = new File(fileString);
		FileWriter out = new FileWriter(outputfile);
		out.write("Cliente|TempoUltimaCheg|TempoChegRelogio|TempoDoServico|TempoInicServRelogio|TempoClientFila|TempoFimServRelogio|TempoClientNoSistema|\n");

		for (tempoDeSimulacao = 1; tempoDeSimulacao <= tempoMaxSimulacao; tempoDeSimulacao++) {

			vPost.Run(tempoDeSimulacao);
		}

		// java.lang.System.out.println("Total Carros que chegaram na simulação: "
		// + vPost.getTotalCarrosChegaram());
		quantTotalCarrosChegaram += vPost.getTotalCarrosChegaram();
		// java.lang.System.out.println("Carros atendidos: " +
		// vPost.getCarrosAtendidos());
		quantTotalCarrosAtendidos += vPost.getCarrosAtendidos();
		// java.lang.System.out.println("Carros na Fila: " +
		// vPost.getCarrosNaFila());
		// java.lang.System.out.println("Carros sendo lavados: " +
		// vPost.getTotalCarrosLavando());
		// java.lang.System.out.println("Carros que foram embora sem ser atendidos: "
		// + vPost.getCarrosNaoAtendidos());
		quantTotalCarrosNaoAtendidos += vPost.getCarrosNaoAtendidos();
		// java.lang.System.out.println("Temp totoal de chegadas: " +
		// vPost.getTempoTotalChegadas());
		tempoTotalMedioDeChegadas += (float) vPost.getTempoTotalChegadas()
				/ vPost.getTotalCarrosChegaram();

		tempoTotalMedioDeAtendimento += vPost
				.getTempoMedioDeAtendimentoPorMaquina();
		tempoTotalMedioDeEspera += vPost.getTempoMedioDeEspera();

		String text;
		for (Carro c : vPost.getListaCarros()) {
			c.calculaTempoNoSistema();
			text = c.getIdCarro() + "\t|\t" + c.getTempoDesdeUltimaChegada()
					+ "\t|\t" + c.getTempoChegadaRelogio() + "\t|\t"
					+ c.getTempoDeServico() + "\t|\t"
					+ c.getTempoInicioServico() + "\t|\t" + c.getTempoEspera()
					+ "\t|\t" + c.getTempoFinalServicoRelogio() + "\t|\t"
					+ c.getTempoNoSistema() + "\n";
			out.write(text);
		}

		out.close();
	}

	public static int getTempoChegada() {
		if (!MONTECARLO) {
			switch (MODODIA) {
			case DEFAULT:
				if (MODORANDOMCHEGADA) {
					Random r = new Random();
					int i1 = r.nextInt(MAXTIMECHEGADA - MINTIMECHEGADA)
							+ MINTIMECHEGADA + 1;
					if(carregarMassa){
						massaDadosNormalTEC.add(i1);
					}
					return i1;
				} else {
					return TEMPODECHEGADA;
				}
			case SEMANAUTIL:
				Random r = new Random();
				int i2 = 0;
				if (tempoDeSimulacao < 240) {
					i2 = r.nextInt(20 - 10) + 10 + 1;
				} else {
					if (tempoDeSimulacao < 360) {
						i2 = r.nextInt(10 - 5) + 5 + 1;
					} else {
						i2 = r.nextInt(15 - 8) + 8 + 1;
					}
				}
				return i2;
			case FERIADOS:
				Random r1 = new Random();
				int i3 = 0;
				if (tempoDeSimulacao < 240) {
					i3 = r1.nextInt(10 - 5) + 5 + 1;
				} else {
					i3 = TEMPODESIMULACAO;
				}

				return i3;
			default:
				throw new IllegalArgumentException("MODO DIA invalido!");
			}
		} else {
			//Random rMonteCarlo = new Random();
			float r = 0;
			///r = rMonteCarlo.nextFloat();
			r = (float)g.NextPosicao();
			float min = 0.0f;
			for (Classe c : objGeradorTEC.getClasses()){
				if(min <= r && r < c.getProbAcomulada()){
					if(carregarMassa){
						massaDadosNormalTEC.add(c.getPontoMedio());
					}
					return c.getPontoMedio();
				}else{
					min = c.getProbAcomulada();
				}
			}
			return (int) min;
		}
	}

	/**
		 */
	public static int getTempoLavagem() {
		if (!MONTECARLO) {
			if (MODORANDOMLAVAGEM) {
				Random r = new Random();
				int i1 = r.nextInt(MAXTIMELAVAGEM - MINTIMELAVAGEM)
						+ MINTIMELAVAGEM + 1;
				if(carregarMassa){
					massaDadosNormalTS.add(i1);
				}
				return i1;
			} else {
				return TEMPODELAVAGEM;
			}
		} else {
			//Random rMonteCarlo = new Random();
			
			float r = 0;
			//r = rMonteCarlo.nextFloat();
			r = (float)g.NextPosicao();
			float min = 0.0f;
			for (Classe c : objGeradorTS.getClasses()){
				if(min <= r && r < c.getProbAcomulada()){
					if(carregarMassa){
						massaDadosNormalTS.add(c.getPontoMedio());
					}
					return c.getPontoMedio();
				}else{
					min = c.getProbAcomulada();
				}
			}
			return (int) min;
		}
	}

}
