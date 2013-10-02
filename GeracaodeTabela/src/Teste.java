import java.io.IOException;


public class Teste {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		table tabela = new table();
		tabela.setQtdeMinute(600); //Seta a quantidade de minutos em 600 minutos(10 hrs)
		tabela.setQtdeCarros(40); //Seta a quantidade de carros que chegarão no dia
		
		tabela.GerarValores(); // Gera os Valores da Tabela
		tabela.EscreverTabela();
		
	}

}
