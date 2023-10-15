package negocio;

import java.util.ArrayList;

public class Memoria {

	private ArrayList<String> numeros;
	private String valor = "";
	private String parte1 = "";
	private String parte2 = "";
	private String controle = "";
	private boolean igual = false;
	
	public Memoria() {
		numeros = new ArrayList<String>();
	}

	public String getNumeros() {
		String resultado = "";
		
		if (igual) {
			resultado = String.valueOf(realizarOperacao());
			if (resultado == "null") {
				return "error";
			} else {
				return resultado;
			}
		}else {
			for (String num : numeros) {
				resultado += "" + num;
			}
			
			if (controle == "") { 
				parte1 += valor;
			}else if (controle != "") {
				parte2 += valor;
			}
			valor = "";
			return resultado;
		}
	}
	
	private Float realizarOperacao() {

		switch (controle) {
		case "+":
			return Float.valueOf(parte1) + Float.valueOf(parte2);
		case "-":
			return Float.valueOf(parte1) - Float.valueOf(parte2);
		case "*":
			return Float.valueOf(parte1) * Float.valueOf(parte2);
		case "/":
			if (Float.valueOf(parte2) != 0) {
				return Float.valueOf(parte1) / Float.valueOf(parte2);
			} else {
				break;
			}
		default:
			break;
		}
		return null;
	}
	
//	primeiraParte opera��o segundaParte =  resultado
	
	public void setNumero(String numero) {
		if(numero.equals("/")) {
			controle = numero;
		} else if (numero.equals("*")) {
			controle = numero;
		} else if (numero.equals("-")) {
			controle = numero;
		} else if (numero.equals("+")) {
			controle = numero;
		} else if (numero.equals("=")) {
			igual = true;
		}else
			valor = numero;
		
		numeros.add(numero);
	}

}
