package serraflix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassificacaoForaDoRangeException, InterruptedException {

		Biblioteca bibli = new Biblioteca();

		int opcao = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("                                                                                                                                             \r\n"
				+ "   d888888o.   8 8888888888   8 888888888o.   8 888888888o.            .8.          8 8888888888   8 8888          8 8888 `8.`8888.      ,8' \r\n"
				+ " .`8888:' `88. 8 8888         8 8888    `88.  8 8888    `88.          .888.         8 8888         8 8888          8 8888  `8.`8888.    ,8'  \r\n"
				+ " 8.`8888.   Y8 8 8888         8 8888     `88  8 8888     `88         :88888.        8 8888         8 8888          8 8888   `8.`8888.  ,8'   \r\n"
				+ " `8.`8888.     8 8888         8 8888     ,88  8 8888     ,88        . `88888.       8 8888         8 8888          8 8888    `8.`8888.,8'    \r\n"
				+ "  `8.`8888.    8 888888888888 8 8888.   ,88'  8 8888.   ,88'       .8. `88888.      8 888888888888 8 8888          8 8888     `8.`88888'     \r\n"
				+ "   `8.`8888.   8 8888         8 888888888P'   8 888888888P'       .8`8. `88888.     8 8888         8 8888          8 8888     .88.`8888.     \r\n"
				+ "    `8.`8888.  8 8888         8 8888`8b       8 8888`8b          .8' `8. `88888.    8 8888         8 8888          8 8888    .8'`8.`8888.    \r\n"
				+ "8b   `8.`8888. 8 8888         8 8888 `8b.     8 8888 `8b.       .8'   `8. `88888.   8 8888         8 8888          8 8888   .8'  `8.`8888.   \r\n"
				+ "`8b.  ;8.`8888 8 8888         8 8888   `8b.   8 8888   `8b.    .888888888. `88888.  8 8888         8 8888          8 8888  .8'    `8.`8888.  \r\n"
				+ " `Y8888P ,88P' 8 888888888888 8 8888     `88. 8 8888     `88. .8'       `8. `88888. 8 8888         8 888888888888  8 8888 .8'      `8.`8888. "); 

		try {
			do {
								
				System.out.println(
						"\n(1) Cadastrar Séries\n(2) Cadastrar Filmes\n(3) Remover\n(4) Editar\n(5) Listar\n(6) Classificar\n(7) Creditos\n(8) Sair\n");
				opcao = input.nextInt();
				input.nextLine();

				if (opcao == 1) {// CADASTRAR SÉRIES
					Categoria setCategoriaSerie = Categoria.COMEDIA;
					int pontuacaoSerie = 0;

					System.out.println(">>> Cadastrar Série <<<\nDigite o NOME da Série: ");
					String opcaoNomeSerie = input.nextLine();

					System.out.println("Total de Temporadas? ");
					int setTemporadasSerie = input.nextInt();
					input.nextLine(); 

					System.out.println("Total de Episódios? ");
					int setEpisodiosSerie = input.nextInt();
					input.nextLine(); 

					System.out.println("Categoria: (1) Comédia - (2) Terror - (3) Fantasia");
					int opcaoCategoriaSerie = input.nextInt();
					input.nextLine(); 

					if (opcaoCategoriaSerie == 1) {
						setCategoriaSerie = Categoria.COMEDIA;
					} else if (opcaoCategoriaSerie == 2) {
						setCategoriaSerie = Categoria.TERROR;
					} else if (opcaoCategoriaSerie == 3) {
						setCategoriaSerie = Categoria.FANTASIA;
					}

					Temporada temporada = new Temporada(setEpisodiosSerie, setTemporadasSerie);
					List<Temporada> listaSerie = new ArrayList<Temporada>();
					listaSerie.add(temporada);
					Serie serie = new Serie(pontuacaoSerie, opcaoNomeSerie, setCategoriaSerie, listaSerie);
					bibli.cadastrar(serie);			

				} else if (opcao == 2) {// CADASTRAR FILMES

					Categoria setCategoriaFilme = Categoria.COMEDIA;
					int pontuacaoFilme = 0;

					System.out.println(">>> Cadastrar Filme <<<\nDigite o NOME do Filme: ");
					String opcaoNomeFilme = input.nextLine();
										
					System.out.println("Qual a duração do Filme em minutos? ");					
					int setDuracaoFilme = input.nextInt();
					input.nextLine(); 

					System.out.println("Categoria:(1)Comédia - (2)Terror - (3)Fantasia");
					int opcaoCategoriaFilme = input.nextInt();
					input.nextLine(); 

					if (opcaoCategoriaFilme == 1) {
						setCategoriaFilme = Categoria.COMEDIA;
					} else if (opcaoCategoriaFilme == 2) {
						setCategoriaFilme = Categoria.TERROR;
					} else if (opcaoCategoriaFilme == 3) {
						setCategoriaFilme = Categoria.FANTASIA;
					}

					Filme filme = new Filme(pontuacaoFilme, opcaoNomeFilme, setCategoriaFilme, setDuracaoFilme);
					bibli.cadastrar(filme);	
					
				} else if (opcao == 3) {// REMOVER

					System.out.println(">>> Remover Programa <<<\nDigite o NOME do Programa para Remover: ");
					String nomePrograma = input.nextLine();

					bibli.remover(nomePrograma);

				} else if (opcao == 4) {// EDITAR

					System.out.println(">>> Editar Programa<<<\n Digite o NOME do programa que deseja editar: ");
                    String editarNomePrograma = input.nextLine();

                    System.out.println(">>> Editar Programa<<<\n Digite o NOVO NOME do programa: ");
                    String novoNomePrograma = input.nextLine();
                    bibli.editarNome(editarNomePrograma, novoNomePrograma);

                    if (bibli.validarSerie(novoNomePrograma) == true) {
                        System.out.println("Digite a nova Temporada da Série: ");
                        int novaTemporada = input.nextInt();
                        input.nextLine(); 
                        System.out.println("Digite total de episódios da Série: ");
                        int novaEpisodios = input.nextInt();
                        input.nextLine(); 
                        bibli.editarTemporadaSerie(novoNomePrograma, novaTemporada, novaEpisodios);
                    }
                    else if (bibli.validarSerie(novoNomePrograma) == false) {
                        System.out.println("Qual a duração do Filme em minutos? ");
                        int novoSetDuracaoFilme = input.nextInt();
                        input.nextLine(); 
                        bibli.editarDuracaoFilme(novoNomePrograma, novoSetDuracaoFilme);
                    }

                    System.out.println("Digite número da nova Categoria:\n(1) Comédia - (2) Terror - (3) Fantasia");
                    Categoria editarSetCategoriaSerie = Categoria.COMEDIA;
                    int opcaoCategoriaSerie = input.nextInt();
                    input.nextLine(); 

                    if (opcaoCategoriaSerie == 1) {
                        editarSetCategoriaSerie = Categoria.COMEDIA;
                    } else if (opcaoCategoriaSerie == 2) {
                        editarSetCategoriaSerie = Categoria.TERROR;
                    } else if (opcaoCategoriaSerie == 3) {
                        editarSetCategoriaSerie = Categoria.FANTASIA;
                    }

                    bibli.editarCategoriaPorNome(novoNomePrograma, editarSetCategoriaSerie);

				} else if (opcao == 5) {// LISTAR

					System.out.println(">>> Listar programas por Categoria <<<\n Digite [ 1 ] para confirmar");
					int confirm = input.nextInt();

					if (confirm == 1) {
						bibli.listar();
					}

				} else if (opcao == 6) {// CLASSIFICAR

					System.out.println(">>> Classificar <<<\n Digite o nome do programa para Classificar:\n");
					String nomeProgramaClassificar = input.nextLine();
					

					System.out.println("\nDigite sua pontuação: ");
					int pontuacaoClassificar = input.nextInt();
					input.nextLine(); 

					bibli.classifica(nomeProgramaClassificar, pontuacaoClassificar);

				} else if (opcao == 7) {//CREDITOS
					
					String art = "   ______________________________________________________________________\r\n"
							+ "  |:..                                                      ``:::%%%%%%HH|\r\n"
							+ "  |%%%:::::..                    CREDITOS                      `:::::%%%%|\r\n"
							+ "  |HH%%%%%:::::....._______________________________________________::::::|\r\n"
							+ "\r\n"
							+ ".    .        .      .             . .     .        .          .          .\r\n"
							+ "         .                 .                    .                .\r\n"
							+ "  .               A long time ago in a galaxy far, far away...   .\r\n"
							+ "     .               .           .               .        .             .\r\n"
							+ "     .      .            .                 .                                .\r\n"
							+ " .      .         .         .   . :::::+::::...      .          .         .\r\n"
							+ "     .         .      .    ..::.:::+++++:::+++++:+::.    .     .\r\n"
							+ "                        .:.  ..:+:..+|||+..::|+|+||++|:.             .     .\r\n"
							+ "            .   .    :::....:::::::::++||||O||O#OO|OOO|+|:.    .\r\n"
							+ ".      .      .    .:..:..::+||OO#|#|OOO+|O||####OO###O+:+|+               .\r\n"
							+ "                 .:...:+||O####O##||+|OO|||O#####O#O||OO|++||:     .    .\r\n"
							+ "  .             ..::||+++|+++++|+::|+++++O#O|OO|||+++..:OOOOO|+  .         .\r\n"
							+ "     .   .     +++||++:.:++:..+#|. ::::++|+++||++O##O+:.++|||#O+    .\r\n"
							+ ".           . ++++++++...:+:+:.:+: ::..+|OO++O|########|++++||##+            .\r\n"
							+ "  .       .  :::+++|O+||+::++++:::+:::+++::+|+O###########OO|:+OO       .  .\r\n"
							+ "     .       +:+++|OO+|||O:+:::::.. .||O#OOO||O||#@###@######:+|O|  .\r\n"
							+ " .          ::+:++|+|O+|||++|++|:::+O#######O######O@############O\r\n"
							+ "          . ++++: .+OO###O++++++|OO++|O#@@@####@##################+         .\r\n"
							+ "      .     ::::::::::::::::::::++|O+..+#|O@@@@#@###O|O#O##@#OO####     .\r\n"
							+ " .        . :. .:.:. .:.:.: +.::::::::  . +#:#@:#@@@#O||O#O@:###:#| .      .\r\n"
							+ "                           `. .:.:.:.:. . :.:.:%::%%%:::::%::::%:::\r\n"
							+ ".      .                                      `.:.:.:.:   :.:.:.:.  .   .\r\n"
							+ "           .                                                                .\r\n"
							+ "      .\r\n"
							+ ".          .                                                       .   .\r\n"
							+ "                                                                             .\r\n"
							+ "    .        .                                                           .\r\n"
							+ "    .     .                                                           .      .\r\n"
							+ "  .     .                                                        .\r\n"
							+ "              .   A terrible job burns throughout the         .        .     .\r\n"
							+ "                 galaxy: a rag-tag group of freedom fighters   .  .\r\n"
							+ "     .       .  has risen from beneath the dark shadow of the            .\r\n"
							+ ".        .     evil monster the SERRAFLIX has become.                        .\r\n"
							+ "   .             Imperial  forces  have  instituted  a reign of   .      .\r\n"
							+ "             terror,  and every  weapon in its arsenal has  been\r\n"
							+ "          . turned upon the Rebels  and  their  allies:  tyranny, .   .\r\n"
							+ "   .       oppression, vast fleets, overwhelming armies, and fear.        .  .\r\n"
							+ ".      .  Fear  keeps  the  individual systems in line,  and is the   .\r\n"
							+ "         prime motivator of the New Order, led by Lord Pimenta, sith.             .\r\n"
							+ "    .      Outnumbered and outgunned,  the Rebellion burns across the   .    .\r\n"
							+ ".      vast reaches of space and a thousand-thousand worlds, with only     .\r\n"
							+ "    . their great courage - and the mystical power known as the Force -\r\n"
							+ "     flaming a fire of hope.                                    .\r\n"
							+ "       This is a  galaxy  of wondrous codes,  bizarre bugs,  strange       .\r\n"
							+ " . codes, powerful weapons, great heroes, and terrible villains.  It is a \r\n"
							+ "  galaxy of fantastic worlds,  magical errors, vast fleets, awesome machi-   .\r\n"
							+ " nery, terrible conflict, and unending hope.              .         .\r\n"
							+ ".        .          .    .    .            .            .                   .\r\n"
							+ "               .               ..       .       .   .             .\r\n"
							+ " .      .     T h i s   i s   t h e   g a l a x y   o f   . . .             .\r\n"
							+ "                     .              .       .                    .      .\r\n"
							+ ".        .               .       .     .            .\r\n"
							+ "   .           .        .                     .        .            .\r\n"
							+ "             .               .    .          .              .   .         .\r\n"
							+ "     _______. _______ .______      . ______         ___       _______  __       __  ___   ___ \r\n"
							+ "    /       ||   ____||   _  \\     |   _  \\        /   \\     |   ____||  |     |  | \\  \\ /  / \r\n"
							+ "   |   (----`|  |__   |  |_)  |    |  |_)  |      /  ^  \\    |  |__   |  |     |  |  \\  V  /  \r\n"
							+ "    \\   \\    |   __|  |      /     |      /      /  /_\\  \\   |   __|  |  |     |  |   >   <   \r\n"
							+ ".----)   |   |  |____ |  |\\  \\----.|  |\\  \\----./  _____  \\  |  |     |  `----.|  |  /  .  \\  \r\n"
							+ "|_______/    |_______|| _| `._____|| _| `._____/__/     \\__\\ |__|     |_______||__| /__/ \\__\\ \r\n"
							+ "                               .                                        .\r\n"
							+ "     .                           .         .               .                 .\r\n"
							+ "                .                                   .            .\r\n"
							+ ".        .           CREATED BY: André Cintra  -  Beatriz Nolasco           .        .\r\n"
							+ "     .       .  Gilnei Lima   -  Guilherme Gusman  -  Luciana Gasparini   .          .\r\n"
							+ "   .       .                       .              .                   .        .  \r\n";
					
					for(int i = 0; i < art.length(); i++) {
						System.out.print(art.charAt(i));
						Thread.sleep(3);
					}
					
				}
				
				else {
					System.out.println("Tchau, Jailsin vulgo Leonardo Pimenta!");
				}

			} while (opcao > 0 && opcao < 8);			

			// } catch (Exception e) {

		} finally {
			input.close();
		}

	}

}
