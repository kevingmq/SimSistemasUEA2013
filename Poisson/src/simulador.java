import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class simulador {

	
	public static void main(String[] args) throws IOException {
		lavagem posto = new lavagem();
		posto.setMediaChegada(20);
		posto.setMediaLavagem(19);
		int idCarro = 1;
		poisson random = new poisson();
		int servico;
		int chegada;
		int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;
		int cont1S = 0, cont2S = 0, cont3S = 0, cont4S = 0;
		
		
		File outputfile = new File("TabelaTempos.txt"); // Cria o arquivo da tabela de saída
		 FileWriter out = new FileWriter(outputfile);
		File outputfile1 = new File("TabelaGrafico.txt"); // Cria o arquivo da tabela de saída
		 FileWriter outGrafico1 = new FileWriter(outputfile1);
		 out.write(" ID do carro  | Horario de Chegada | Tempo de Servico \r\n");
		
		 
		for(int i = 0; i < 10000 ; i++)
		{
		
	
		

			chegada = random.nextPoisson(posto.getMediaChegada());
		    servico = random.nextPoisson(posto.getMediaLavagem());
			out.write(idCarro + " | " + chegada + " | " + servico +  "\r\n" );
			idCarro++;
			
			if(chegada < 10)
				cont1++;
			if((chegada>=10) && (chegada<20))
				cont2++;
			if((chegada>=20) && (chegada<30))
				cont3++;    
			if((chegada>=30) && (chegada<40))
				cont4++;
		
			if(servico < 10)
				cont1S++;
			if((servico>=10) && (servico<20))
				cont2S++;
			if((servico>=20) && (servico<30))
				cont3S++;    
			if((servico>=30) && (servico<40))
				cont4S++;
			
	
		
		}
		outGrafico1.write("Tabela de Chegada \r\n");
		outGrafico1.write("00 - 10 :" + " | " + cont1 + "\r\n");
		outGrafico1.write("10 - 20 :" + " | " + cont2 + "\r\n");
		outGrafico1.write("20 - 30 :" + " | " + cont3 + "\r\n");
		outGrafico1.write("30 - 40 :" + " | " + cont4 + "\r\n");
		outGrafico1.write("\r\n Tabela de Servico \r\n");
		outGrafico1.write("00 - 10 :" + " | " + cont1S + "\r\n");
		outGrafico1.write("10 - 20 :" + " | " + cont2S + "\r\n");
		outGrafico1.write("20 - 30 :" + " | " + cont3S + "\r\n");
		outGrafico1.write("30 - 40 :" + " | " + cont4S + "\r\n");		
		
		outGrafico1.close();
		out.close();
	}

}
