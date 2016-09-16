import java.util.ArrayList;

import javax.*;

import java.util.Scanner;
import java.io.*;

public class AnalisarAutomato {
	static int quantidadeSimbolos;
	static int quantidadeEstados;
	static int estadoInicial;
	static ArrayList<String> simbolo;
	static int[][] mapaEstados;
	static int quantidadeEstadosFinais;
	static int estadoFinal[];
	
	
	public static void main(String [] arg) throws Exception{
		
		simbolo = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o número de símbolos:\n");
		quantidadeSimbolos = Integer.parseInt(sc.next());
		
		for(int i = 0;quantidadeSimbolos>i;i++){
			System.out.println("Entre com o símbolo "+i+":\n");
			simbolo.add(sc.next());
		}
		
		System.out.println("Digite o número de estados:\n");
		quantidadeEstados = Integer.parseInt(sc.next());
		
		System.out.println("Digite o estado inicial:\n");
		estadoInicial = Integer.parseInt(sc.next());
		
		System.out.println("Digite a quantidade de estados finais:\n");
		quantidadeEstadosFinais = Integer.parseInt(sc.next());
		estadoFinal = new int[quantidadeEstadosFinais];
		
		for(int i = 0;quantidadeEstadosFinais>i;i++){
			System.out.println("Entre com o estado final "+i+":\n");
			estadoFinal[i] = Integer.parseInt(sc.next());
		}
		mapaEstados = new int[quantidadeEstados][quantidadeSimbolos];
		
		for(int i = 0;quantidadeEstados>i;i++){
			for(int j=0;quantidadeSimbolos>j;j++){
				System.out.println("Para o estado e"+i+" e símbolo '"+simbolo.get(j)+"', qual o próximo estado? (caso não exista, digital '-1'):\n");
				mapaEstados[i][j] = Integer.parseInt(sc.next());
			}
		}
		
		MontarPrograma generatePrograma = new MontarPrograma();
		if(generatePrograma.programaInicial(estadoInicial))
			System.out.println("Programa inicial gerado...");
	
		if(generatePrograma.programaAutomato(generatePrograma.criarFuncao(mapaEstados, simbolo, estadoFinal)))
			System.out.println("Programa automato gerado...");
			
		MontarArquivo mta = new MontarArquivo();
		mta.compilar();
		
		System.out.println("concluido");
		System.exit(0);
	}

}

