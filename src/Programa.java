import java.awt.*;
import javax.swing.*;

public class Programa {	
	public static void main(String args[])	{   	 
		String palavra;   	 
		palavra = JOptionPane.showInputDialog("Digite a Palavra");   	 
		Automato automato = new Automato(palavra);    	 
		automato.e0();   	 
		System.exit(0);	}
}