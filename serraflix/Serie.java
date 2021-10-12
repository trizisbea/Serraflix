package serraflix;
import java.util.List;

public class Serie extends Programa {
	
	//Atributos
	private List<Temporada> temporadas;

	//Getters n' Setters
	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	public Temporada getQuantidadeTemporada(Temporada numeroTemporada) {
        return numeroTemporada;
    }
	
	//Construtor
	public Serie(int pontuacao, String nome, Categoria categoria, List<Temporada> temporadas) {
		super(pontuacao, nome, categoria);
		this.temporadas = temporadas;
	}
		
	//Métodos
	
	//ToString
	@Override
	public String toString() {
		return super.toString() + "(Serie) Temporadas: " + temporadas + "]";
	}
	
	//Classificar o Programa
	@Override
	public void classificar(int pontuacao) throws ClassificacaoForaDoRangeException {
	        try {
	            if( pontuacao < 0 ||  pontuacao > 10) {
	                throw new ClassificacaoForaDoRangeException("O valor da classificação deve ser entre 0 e 10!");
	            }
	            else {
	            	setPontuacao(pontuacao);
	            }
	        }catch(ClassificacaoForaDoRangeException e){
	        	System.err.println("ERRO:"+ e.getMessage());
	        } 
	}
	
}
