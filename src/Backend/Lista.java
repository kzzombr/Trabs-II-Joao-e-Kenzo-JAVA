package Backend;

import java.util.Vector;

public class Lista {
	No inicio;
	No fim;
	
	public void inserir(Produto produto) {
		No novo = new No(produto);
		
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		}
		
		else if (inicio.produto.getValidade().isAfter(produto.getValidade())) {
			inicio.prev = novo;
			novo.next = inicio;
			inicio = novo;
		}
		
		else if (fim.produto.getValidade().isBefore(produto.getValidade())) {
			fim.next = novo;
			novo.prev = fim;
			fim = novo;
		}
		else {
			No aux = inicio;
			while(aux.next != null && aux.next.produto.getValidade().isAfter(produto.getValidade())) {
				aux = aux.next;
			}
			novo.prev = aux;
			novo.next = aux.next;
			aux.next.prev = aux;
			aux.next = novo;
		}
	}
	
	public boolean vazia() {
		if (this.inicio == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean remove(Produto produto) {
		No aux = inicio;
		while(aux != null) {
			if(aux.produto == produto) {
				aux.prev.next = aux.next;
				aux.next.prev = aux.prev;
				return true;
			}
			aux = aux.next;
		}
		return false;
	}
	
	public Produto findByName(String nome) {
		No aux = inicio;
		while(aux != null) {
			if(aux.produto.getNome().equals(nome)) {
				return aux.produto;
			}
			aux = aux.next;
		}
		return null;
	}
	
	public Vector<String> gerarVetor() {
		Vector<String> vetor = new Vector<String>();
		No aux = inicio;
		while(aux != null) {
			vetor.add("Nome: " + aux.produto.getNome() + " | Quantidade: " + aux.produto.getQuantidade() + " | Validade: " + aux.produto.getValidade());
			aux = aux.next;
		}
		return vetor;
	}
}
