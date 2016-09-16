import java.io.*;
import java.util.ArrayList;

public class MontarPrograma {
	
	public boolean programaInicial(int estadoInicial) throws Exception{
		String arquivo = "C:/TEMP/Programa.java";
		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));

		writer.write(
		"import java.awt.*;"+
		"import javax.swing.*;"+
		"public class Programa {"+
		"	public static void main(String args[])"+
		"	{"+
		"   	 String palavra;"+
		"   	 palavra = JOptionPane.showInputDialog(\"Digite a Palavra\");"+
		"   	 Automato automato = new Automato(palavra);"+
		"    	 automato.e"+ estadoInicial +"();"+
		"   	 System.exit(0);"+
		"	}"+
		"}"
		);
		writer.close();
		return true;
	}
	
	
	public boolean programaAutomato(String linha) throws Exception{
		String arquivo = "C:/TEMP/Automato.java";
		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
		
		writer.write(
				
		"import java.awt.*;"+
		"import javax.swing.*;"+
		"public class Automato{"+
		"	private String palavra;"+
		"	private int posicao;"+
		"	public Automato(String palavra)"+
		"	{"+
		"		this.palavra = palavra;"+
		"		posicao = 0;"+
		"	}"+
		"	public void aceita()"+
		"   {"+
		"		System.out.println(\"ACEITA\");"+
		"		System.exit(0);"+
		"	}"+
		"	public void rejeita()"+
		"   {"+
		"		System.out.println(\"REJEITA\");"+
		"		System.exit(0);"+
		"	}"+linha+"}");
		
		writer.close();
		return true;
		
	}
	
	public String criarFuncao(int[][] mapaEstados, ArrayList<String> simbolo, int[] estadoFinal){
			String linha = "";
			for(int i = 0;i<mapaEstados.length-1;i++){
			linha = linha + "public void e"+i+"(){ ";
				for(int j = 0;simbolo.size()>j;j++){
					for(int k=0;estadoFinal.length>k;k++){
						if(estadoFinal[k] == i){
							linha = linha+"if (posicao == palavra.length()){aceita();}";
						}
					}
					if(mapaEstados[i][j]!=-1){
						linha = linha + "if(palavra.charAt(posicao) == '"+simbolo.get(j)+"'){";
						linha = linha + "posicao++; e"+mapaEstados[i][j]+"();}";
					}
				}
			linha = linha + "rejeita();";
			linha = linha + "}";
			}
			
			return linha;
	}

}