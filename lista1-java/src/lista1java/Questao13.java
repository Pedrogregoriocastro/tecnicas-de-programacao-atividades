package lista1java;

public class Questao13 {

	public static void main(String[] args) {
		int A=9; //voce pode alterar os valores de A e B
		int B=11;
		boolean b1=false;
		boolean b2=false;
		
		if(A>10) {
			System.out.println("A>10");
		}
		
		else
			b1=true;
		
		if(A+B==20) {
			System.out.println("A+B==20");
		}
		
		else
			b2=true;
		
		if(b1 && b2) {
			System.out.println("numeros nao validos");
		}
	}

}
