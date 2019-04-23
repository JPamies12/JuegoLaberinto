import java.util.Scanner;

public class laberintov2 {
	public static void main(String[] args) {

		// Declarar variables
		Scanner teclat = new Scanner(System.in);

		int i, fil = 0, col = 0, moviments = 0;
		int numJugadors, numPartidesE = 0, numPartidesI = 0, numPartidesH = 0, seleccioJugador, contPartida=0;

		int[][] nivellFacil;
		int[][] nivellIntermedi;
		int[][] nivellDificil;

		char opcio = 'x', tirada = 'x', dificultat, aux;

		boolean guanya = false;
		boolean sortir = false;
		char[][] laberint = null;

		String[] jugadors;
		String[][] nivell;
		boolean[][] victoria;
		int[][] mov;
		
		System.out.println("Selecciona el numero de jugadors:");
		numJugadors = teclat.nextInt();

		// System.out.println("Indica quantes partides vols jugar:");
		// numPartides = teclat.nextInt();

		jugadors = new String[numJugadors];

		for (i = 0; i < jugadors.length; i++) {
			System.out.print("Nom del jugador " + i + ": ");
			jugadors[i] = teclat.next();
		}

		while (opcio != 'q' && opcio != 'Q') {

			nivell = new String[10][10];
			victoria = new boolean[10][10];
			mov = new int[10][10];
			
			// Seleccio de jugadors
			System.out.println("JUGADORS DISPONIBLES");
			for (i = 0; i < jugadors.length; i++) {
				System.out.println(jugadors[i] + " [" + i + "]");
			}

			System.out.println("Selecciona un jugador:");
			seleccioJugador = teclat.nextInt();

			// Menu del joc
			System.out.println("MENU PRINCIPAL");
			System.out.println("");
			System.out.println("- Jugar partida [J]");
			System.out.println("- Resultats partides [R]");
			System.out.println("- Sortir [Q]");

			// Demanar dades a l'usuari
			System.out.print("Escull una de les tres opcions:");
			opcio = teclat.next().charAt(0);

			// Controlar que l'usuari introdueixi una de les opcions valides
			while (opcio != 'j' && opcio != 'J' && opcio != 'r' && opcio != 'R' && opcio != 'q' && opcio != 'Q') {
				System.out.println("Error. Escull una opcio valida:");
				opcio = teclat.next().charAt(0);
			}

			// Opcions del menu del joc
			switch (opcio) {

			// Jugar partida
			case 'J':
			case 'j':

				System.out.println("Tria un nivell de dificultat:");
				System.out.println("- Facil [E]");
				System.out.println("- Intermedi [I]");
				System.out.println("- Dificil [H]");
				dificultat = teclat.next().charAt(0);

				// Carregar laberint escollit per l'usuari
				switch (dificultat) {

				case 'E':
				case 'e':
					char[][] laberintFacil = { { '#', '#', '#', '#', '#', '#', '#', '#' },
							{ '#', 'J', '#', '#', '#', '#', '#', '#' }, { '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
							{ '#', '#', ' ', '#', ' ', '#', ' ', '#' }, { '#', '#', ' ', '#', ' ', '#', '#', '#' },
							{ '#', ' ', ' ', ' ', '#', ' ', ' ', 'S' }, { '#', '#', '#', ' ', ' ', ' ', '#', '#' },
							{ '#', '#', '#', '#', '#', '#', '#', '#' } };
					laberint = laberintFacil;
					fil = 1;
					col = 1;
					moviments = 0;
					nivell[seleccioJugador][contPartida] = "Facil";

					numPartidesE++;
					break;

				case 'I':
				case 'i':
					char[][] laberintIntermedi = { { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
							{ '#', 'J', '#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#' },
							{ '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#' },
							{ '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#' },
							{ '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#' },
							{ '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#' },
							{ '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#' },
							{ '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', 'S' },
							{ '#', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#' },
							{ '#', ' ', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', '#' },
							{ '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#' },
							{ '#', '#', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', '#', '#' },
							{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
					laberint = laberintIntermedi;
					fil = 1;
					col = 1;
					moviments = 0;
					nivell[seleccioJugador][contPartida] = "Intermedi";
					break;

				case 'H':
				case 'h':
					char[][] laberintDificil = {
							{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
							{ '#', 'P', '#', ' ', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#' },
							{ '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#' },
							{ '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#' },
							{ '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', '#', ' ', '#' },
							{ '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
							{ '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#' },
							{ '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '#' },
							{ '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', 'S' },
							{ '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#' },
							{ '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#' },
							{ '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#' },
							{ '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
							{ '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#' },
							{ '#', ' ', ' ', ' ', '#', '#', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
							{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
					laberint = laberintDificil;
					fil = 1;
					col = 1;
					moviments = 0;
					nivell[seleccioJugador][contPartida] = "Dificil";
					break;
				}

				// Algoritme del joc

				sortir = false;
				guanya = false;
				while ((tirada != 'p' || tirada != 'P') && !guanya && !sortir) {

					// Imprimir laberint en pantalla
					for (int f = 0; f < laberint.length; f++) {
						for (int c = 0; c < laberint[f].length; c++) {
							System.out.print(laberint[f][c] + " ");
						}
						System.out.println();
					}

					// Demanar l'usuari fer un moviment
					System.out.println("Moviment:");
					tirada = teclat.next().charAt(0);

					// Filtre per controlar tecles incorrectes
					while (tirada != 'w' && tirada != 'W' && tirada != 'a' && tirada != 'A' && tirada != 's'
							&& tirada != 'S' && tirada != 'd' && tirada != 'D' && tirada != 'q' && tirada != 'Q'
							&& tirada != 'p' && tirada != 'P') {

						System.out.println("Tecla incorrecta. Torna a provar");

						// Imprimir laberint en pantalla
						for (int f = 0; f < laberint.length; f++) {
							for (int c = 0; c < laberint[f].length; c++) {
								System.out.print(laberint[f][c] + " ");
							}
							System.out.println();
						}

						System.out.println("Moviment:");
						tirada = teclat.next().charAt(0);

					}

					switch (tirada) {

					case 'w':
					case 'W':
						if (laberint[fil - 1][col] != '#') {
							if (laberint[fil - 1][col] == 'S') {
								System.out.println("Has trobat la sortida!");
								guanya = true;
								victoria[seleccioJugador][contPartida] = true;
								mov[seleccioJugador][contPartida] = moviments;
								contPartida++;
							} else {
								aux = laberint[fil][col];
								laberint[fil][col] = laberint[fil - 1][col];
								laberint[fil - 1][col] = aux;

								victoria[seleccioJugador][contPartida] = false;
								mov[seleccioJugador][contPartida] = moviments;
								fil--;
								moviments++;

							}

						} else {
							System.out.println("Moviment no permes, torna a provar.");
						}

						break;

					case 's':
					case 'S':
						if (laberint[fil + 1][col] != '#') {
							if (laberint[fil + 1][col] == 'S') {
								System.out.println("Has trobat la sortida!");
								guanya = true;
								victoria[seleccioJugador][contPartida] = true;
								mov[seleccioJugador][contPartida] = moviments;
								contPartida++;
							} else {
								aux = laberint[fil][col];
								laberint[fil][col] = laberint[fil + 1][col];
								laberint[fil + 1][col] = aux;

								victoria[seleccioJugador][contPartida] = false;
								mov[seleccioJugador][contPartida] = moviments;
								fil++;
								moviments++;
							}
						} else {
							System.out.println("Moviment no permes, torna a provar.");
						}

						break;

					case 'a':
					case 'A':
						if (laberint[fil][col - 1] != '#') {
							if (laberint[fil][col - 1] == 'S') {
								System.out.println("Has trobat la sortida!");
								guanya = true;
								victoria[seleccioJugador][contPartida] = true;
								mov[seleccioJugador][contPartida] = moviments;
								contPartida++;
							} else {
								aux = laberint[fil][col];
								laberint[fil][col] = laberint[fil][col - 1];
								laberint[fil][col - 1] = aux;

								victoria[seleccioJugador][contPartida] = false;
								mov[seleccioJugador][contPartida] = moviments;
								col--;
								moviments++;
							}
						} else {
							System.out.println("Moviment no permes, torna a provar.");
						}

						break;

					case 'd':
					case 'D':
						if (laberint[fil][col + 1] != '#') {
							if (laberint[fil][col + 1] == 'S') {
								System.out.println("Has trobat la sortida!");
								guanya = true;
								
								victoria[seleccioJugador][contPartida] = true;
								mov[seleccioJugador][contPartida] = moviments;
								
								contPartida++;
							} else {
								aux = laberint[fil][col];
								laberint[fil][col] = laberint[fil][col + 1];
								laberint[fil][col + 1] = aux;

								victoria[seleccioJugador][contPartida] = false;
								mov[seleccioJugador][contPartida] = moviments;
								
								col++;
								moviments++;
							}

						} else {
							System.out.println("Moviment no permes, torna a provar.");
						}

						break;

					case 'Q':
					case 'q':
						System.out.println("FI DEL JOC");
						opcio = 'q';
						sortir = true;

						break;

					case 'P':
					case 'p':

						System.out.println("Has sortit de la partida en curs");
						contPartida++;
						sortir = true;
						break;
					}
				}
				break;
			case 'R':
			case 'r':
				System.out.println("Resultats: ");

				// nivellFacil = new int[numJugadors][numPartidesE];
				// nivellIntermedi = new int[numJugadors][numPartidesI];
				// nivellDificil = new int[numJugadors][numPartidesH];

				for (i = 0; i < jugadors.length; i++) {

					System.out.println("Jugador: "+ jugadors[seleccioJugador]);
					
					for (i = 0; i < nivell.length; i++) {

						System.out.println("Partida "+ (i+1) +":");
						System.out.println(nivell[seleccioJugador][i]);
						System.out.println(victoria[seleccioJugador][i]);
						System.out.println(mov[seleccioJugador][i]);
					}
				}

				break;

			case 'Q':
			case 'q':
				System.out.println("FI DEL JOC");
				opcio = 'q';
				break;
			}
		}
	}
}
