package serraflix;

public abstract class Programa implements Classificar {
	
	//Atributos
	protected int pontuacao;
	protected String nome;
	protected Categoria categoria;
	
	//Getters n' Setters
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Construtor
	public Programa(int pontuacao, String nome, Categoria categoria) {
		super();
		this.pontuacao = pontuacao;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	//Métodos
	//ToString
		@Override
		public String toString() {
			return "Programa | [Classificação: " + pontuacao + ", Nome: " + nome + ", Categoria: " + categoria + " ";
		}
	
	//Classificar o Programa
	@Override
	public void classificar(int pontuacao) throws ClassificacaoForaDoRangeException {
	        try {
	            if( pontuacao < 0 ||  pontuacao > 5) {
	                throw new ClassificacaoForaDoRangeException("O valor da classificação deve ser entre 0 e 5!");
	            }
	            else {
	            	setPontuacao(pontuacao);
	            }
	        }
	        catch(ClassificacaoForaDoRangeException e){
	            System.err.println("ERRO:"+ e.getMessage());   
	        }
	        
	}
	
	
	
	
	
	
}
