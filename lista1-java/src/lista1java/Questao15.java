package lista1java;

public class Questao15 {

	public static void main(String[] args) {
		int A=9; //voce pode alterar os valores de A e B
		int B=9;
		
		if(A<10) {
			System.out.println("A<10");
			if(A+B==20) {
				System.out.println("A+B==20");
			}
		}
		
		if(A>10 && A+B!=20) {
			System.out.println("numero nao valido");
		}
		
		else if (A+B==20) {
			System.out.println("A+B==20");
		}
			
	}

}
