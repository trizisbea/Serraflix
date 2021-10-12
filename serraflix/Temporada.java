package serraflix;

public class Temporada {
	
	//Atributos
	private int quantidadeEpisodios, numeroTemporada;

	//Getters n' Setters
	public int getQuantidadeEpisodios() {
		return quantidadeEpisodios;
	}

	public void setQuantidadeEpisodios(int quantidadeEpisodios) {
		this.quantidadeEpisodios = quantidadeEpisodios;
	}

	public int getNumeroTemporada() {
		return numeroTemporada;
	}

	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}

	//Construtor
	public Temporada(int quantidadeEpisodios, int numeroTemporada) {
		super();
		this.quantidadeEpisodios = quantidadeEpisodios;
		this.numeroTemporada = numeroTemporada;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Temporada [Numero de Epsódios: " + quantidadeEpisodios + ", Numero de Temporadas: " + numeroTemporada + "]";
	}
	
}
