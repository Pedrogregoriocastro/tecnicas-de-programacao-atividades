package lista1java;

public class Questao17 {

	public static void main(String[] args) {
		int A=10; //voce pode alterar os valores de A e B
		int B=10;
		
		if(A>10 || A+B==20) {
			System.out.println("numero valido");
		}
		
		else if(A==B) {
			System.out.println("A e igual B");
		}
		
		else if(A!=B && A<10) {
			System.out.println("A e menor que 10");
		}
		else
			System.out.println("numero nao valido");
	}

}
