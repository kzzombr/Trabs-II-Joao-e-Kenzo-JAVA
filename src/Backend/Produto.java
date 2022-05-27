package Backend;

import java.time.LocalDate;

public class Produto {
	private String nome;
	private LocalDate validade;
	private int quantidade;
	
	public Produto(String nome, int quantidade, LocalDate validade) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.validade = validade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
