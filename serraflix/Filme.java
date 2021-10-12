package serraflix;
public class Filme extends Programa {

	//Atributos
	private int duracao;

	//Getters n' Setters
	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	//Construtor
	public Filme(int pontuacao, String nome, Categoria categoria, int duracao) {
		super(pontuacao, nome, categoria);
		this.duracao = duracao;
	}
	
	//ToString
	@Override
	public String toString() {
		return super.toString() + "(Filme) Duracao: " + duracao + "]";
	}
	
}
