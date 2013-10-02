import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class table {
int qtdeMinute;
int qtdeCarros;
ArrayList <Integer> vetHorario = new ArrayList <Integer> ();


public int getQtdeCarros() {
	return qtdeCarros;
}

public void setQtdeCarros(int qtdeCarros) {
	this.qtdeCarros = qtdeCarros;
}

public int getQtdeMinute() {
	return qtdeMinute;
}

public void setQtdeMinute(int qtdeMinute) {
	this.qtdeMinute = qtdeMinute;
}

public void GerarValores()
{
	int value; // Variavel para guardar o valor aleatório


	//Faz um for para gerar um randomico do tempo de chegada 
	// de cada carro
	for(int i=0;i<getQtdeCarros();i++)
	{
		
		Random random = new Random();
		value = random.nextInt(getQtdeMinute()); // Pega um horario aleatório entre as 10 hrs.
		vetHorario.add(value);
	}
}

public void EscreverTabela() throws IOException
{
	File outputfile = new File("Tabela.txt"); // Cria o arquivo da tabela de saída
	 FileWriter out = new FileWriter(outputfile);
	 
	 out.write(" ID do carro  | Horario de Chegada \r\n");
	 for(int i = 0; i< vetHorario.size(); i++)
	 {
		 int id = i+1;
		 out.write(id + " | " + vetHorario.get(i).intValue() + "\r\n" );

		 //out.write();
		 
	 }
	 
	 out.close();
}

}
