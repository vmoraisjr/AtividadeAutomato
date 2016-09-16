import javax.swing.*;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.io.*;

public class MontarArquivo {

	public static void main(String [] args) throws Exception{
		MontarArquivo mta = new MontarArquivo();
		mta.compilar();
		
	}
	static void compilar() throws Exception{
		
		
		String arquivo01 = "C:/TEMP/Programa.java";   
		String arquivo02 = "C:/TEMP/Automato.java"; 
		
		try {   
		
			Runtime.getRuntime().exec("cmd /c javac "+arquivo02);   
			Runtime.getRuntime().exec("cmd /c javac "+arquivo01);  
		
		} catch (IOException ex) {   
		ex.printStackTrace();   
		}   
	}
}
