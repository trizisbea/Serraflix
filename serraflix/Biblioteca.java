package serraflix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Biblioteca {

	// Atributos
	private List<Programa> programa = new ArrayList<Programa>();

	// Getters n' Setters
	public List<Programa> getPrograma(Categoria categoria) {
		return programa;
	}

	public List<Programa> getPrograma() {
		return programa;
	}

	public Programa getPrograma(String nome) {
		return (Programa) programa;
	}

	public void setPrograma(List<Programa> programa) {
		this.programa = programa;
	}

	// Construtor
	public Biblioteca() {
		super();
		this.programa = (List<Programa>) programa;
	}

	// Métodos

	// ToString
	@Override
	public String toString() {
		return "Biblioteca [programa=" + programa + "]";
	}

	// Cadastrar
    public void cadastrar(Programa programa) {
        if (!seExiste(programa)) {
            this.programa.add(programa);
        } else {
            System.err.println("ERRO: NÃO Cadastrado! Programa já existe.");
        }
    }

    // Condição para CADASTRO duplicado
    public boolean seExiste(Programa programa) {
    	 for (Programa y : this.programa) {
    		 if (y.getNome().equals(programa.nome)) {
    	            return true;
    	     }           
    	 }
    	 return false;
    }

	// Remover - Abordagem 1 - Por primeiro nome correspondente
	public void remove(String nomePrograma) {
		for (Programa r : programa) {
			if ((Serie.class.isInstance(r)) && (r.nome.equals(nomePrograma))) {
				this.programa.remove(r);
				System.out.println("Removeu!" + r);
				break;
			} else if ((Filme.class.isInstance(r)) && (r.nome.equals(nomePrograma))) {
				this.programa.remove(r);
				System.out.println("Removeu!" + r);
				break;
			} else {
				System.out.println("Não Encontrado!");
			}
		}
	}

	// Remover - Abordagem 2 - Por nome
	public void remover(String nomePrograma) {
		for (Programa r : programa) {
			if (r.nome.equals(nomePrograma)) {
				this.programa.remove(r);
				System.out.println("Removeu!" + r);
				break;
			}
		}
	}

	// Remover - Abordagem 3 - Por código hash correspondente.
	public void remov(long hash) {
		for (Programa r : programa) {
			if (r.hashCode() == (hash)) {
				this.programa.remove(r);
				System.out.println("Removeu!" + r);
				break;
			} // 72345678 -> restanteDados
		}
	}

	// Listar - Abordagem 1 - Toda lista com código hash correspondente
	public void listarTudo() {
		for (Programa f : programa) {
			System.out.println("hashCode: " + f.hashCode() + " -> " + f);
		}
	}

	// Listar - Abordagem 2 - Por Categoria
	public void listar() {
		programa.stream().filter(programa -> programa.getCategoria() == programa.categoria.COMEDIA)
				.forEach(System.out::println);
		programa.stream().filter(programa -> programa.getCategoria() == programa.categoria.TERROR)
				.forEach(System.out::println);
		programa.stream().filter(programa -> programa.getCategoria() == programa.categoria.FANTASIA)
				.forEach(System.out::println);
	}

	// Classificar
	public void classifica(String nome, int pontuacao) throws ClassificacaoForaDoRangeException {
		for (Programa k : programa) {
			if (Serie.class.isInstance(k) && k.getNome().equals(nome)) {
				Serie serial = (Serie) k;
				serial.classificar(pontuacao);
				break;
			} else if (k.getNome().equals(nome)) {
				k.classificar(pontuacao);
				break;
			}
		}

	}

	// Editar
	// Editar Nome
	public void editarNome(String nome, String novoNome) {
		for (Programa n : programa) {
			if (n.nome.equals(nome)) {
				n.setNome(novoNome);
			}
		}
	}

	// Editar duração do Filme
	public void editarDuracaoFilme(String nome, int novaDuracao) {
		for (Programa d : programa) {
			if (Filme.class.isInstance(d) && d.getNome().equals(nome)) {
				Filme filme = (Filme) d;
				filme.setDuracao(novaDuracao);
			}
		}
	}

	// Editar Categoria por Nome.
	public void editarCategoriaPorNome(String nome, Categoria novoCategoria) {
		for (Programa c : programa) {
			if (c.nome.equals(nome)) {
				c.categoria = novoCategoria;
			}
		}
	}

	//validar serie
	public boolean validarSerie(String nome) {
        for (Programa x : programa) {
            if (x.getNome().equals(nome) && Serie.class.isInstance(x)) {
               return true;
            }
            if (x.getNome().equals(nome) && Filme.class.isInstance(x)) {
               return false;
            }
        }
        return validarSerie(nome);
    }
	
	// Editar Temporada
	public void editarTemporadaSerie(String nome, int numeroTemporada, int quantidadedeEpisodios) {
		for (Programa t : programa) {
			if (Serie.class.isInstance(t) && t.getNome().equals(nome)) {												
				Serie serie = (Serie) t;
				for (Temporada te : serie.getTemporadas()) {
					if (Temporada.class.isInstance(te)) {
						Temporada novaT = (Temporada) te;
						novaT.setNumeroTemporada(numeroTemporada);
						novaT.setQuantidadeEpisodios(quantidadedeEpisodios);
					}
				}

			}

		}

	}

}
