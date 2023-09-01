package lista1java;

public class Questao12 {

	public static void main(String[] args) {
		int A=10; //voce pode alterar os valores de A e B
		int B=10;
		boolean b1=false;
		boolean b2=false;
		
		if(A>10) {
			System.out.println("A>10");
			b1=true;
		}
		
		if(A+B==20) {
			System.out.println("A+B==20");
			b2=true;
		}
		
		if(b1 || b2) {
			System.out.println("Sejam bem-vindos a disciplina de Tecnicas de Programacao");
		}
		else
			System.out.println("numeros nao validos");
	}
}
