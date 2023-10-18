package entities;

public class Departamento {
	
	private String nome;
	
	public Departamento() {
		
	}

	public Departamento(String nomeLocal) {
		this.nome = nomeLocal;
	}

	public String getNomeLocal() {
		return nome;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nome = nomeLocal;
	}

}
