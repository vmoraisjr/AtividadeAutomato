import java.awt.*;
import javax.swing.*;
public class Automato{	
	private String palavra;	
	private int posicao;	
	public Automato(String palavra)	{		
		this.palavra = palavra;		
		posicao = 0;	}	
	public void aceita()   {		
		System.out.println("ACEITA");		
		System.exit(0);	}	
	public void rejeita()   {		
		System.out.println("REJEITA");		
		System.exit(0);	
		}
	public void e0(){ 
		if(palavra.charAt(posicao) == 'a'){
			posicao++; e0();
			}
		if(palavra.charAt(posicao) == 'b'){
			posicao++; e1();
			}
		rejeita();
		}
	public void e1(){ 
		if (posicao == palavra.length()){
			aceita();
			}
		if(palavra.charAt(posicao) == 'a'){
			posicao++; 
			e0();
			}
		if (posicao == palavra.length()){
			aceita();
			}
		if(palavra.charAt(posicao) == 'b'){
			posicao++; 
			e1();
			}
		rejeita();
		}
}