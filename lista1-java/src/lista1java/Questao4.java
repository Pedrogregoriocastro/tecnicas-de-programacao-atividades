package lista1java;

public class Questao4 {

	public static void main(String[] args) {
		int A=9; //voce pode alterar os valores de A e B
		int B=9;
		
		if(A>10 || A+B==20) {
			System.out.println("numero valido");
		}
		
		else if(A==B) {
			System.out.println("A e igual a B; A e B sao diferentes de 10; A e menor que 10;");
		}
		
		else {
			System.out.println("numero nao valido");
		}
	}

}
