package model.leitura_de_arquivos;


public class Instante {
	private Integer NumeroDoInstante;
	private Integer Python;
	private Integer JavaScript;
	private Integer RubyOnRails;
	private Integer PHP;
	private Integer Csharp;
	private Integer Cpp;
	private Integer C;
	private Integer Bug;
	private Integer Dev;
	
	public Instante(String[] valor) {
		InformarInstante(valor);
	}
	
	public Integer getNumeroDoInstante() {
		return NumeroDoInstante;
	}

	public Integer getPython() {
		return Python;
	}

	public Integer getJavaScript() {
		return JavaScript;
	}

	public Integer getRubyOnRails() {
		return RubyOnRails;
	}

	public Integer getPHP() {
		return PHP;
	}

	public Integer getCsharp() {
		return Csharp;
	}

	public Integer getCpp() {
		return Cpp;
	}

	public Integer getC() {
		return C;
	}

	public Integer getBug() {
		return Bug;
	}

	public Integer getDev() {
		return Dev;
	}

	
	private void InformarInstante(String[] valor) {
		this.NumeroDoInstante = Integer.valueOf(valor[0]);
		this.Python = Integer.valueOf(valor[1]);
		this.JavaScript = Integer.valueOf(valor[2]);
		this.RubyOnRails = Integer.valueOf(valor[3]);
		this.PHP = Integer.valueOf(valor[4]);
		this.Csharp = Integer.valueOf(valor[5]);
		this.Cpp = Integer.valueOf(valor[6]);
		this.C = Integer.valueOf(valor[7]);
		this.Bug = Integer.valueOf(valor[8]);
		this.Dev = Integer.valueOf(valor[9]);
	}
}
