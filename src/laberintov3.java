import java.util.Scanner;

public class laberintov3 {
	public static void main(String[] args) {

		// Declarar variables
		Scanner teclat = new Scanner(System.in);
		char opcio, tirada, dificultat;

		// Vector de jugadors, nombre de jugadors, jugador seleccionat i numero de
		// partides per nivell
		String[] jugadors;
		int numJugadors;
		int seleccioJugador;
		int numPartides;

		// Matriu de resultats per partides en ordre
		String[][] matriuPartidesOrdre;
		int[] vectorContadorsPartidesOrdre;

		// Matrius de resultats per partides a cada nivell
		String[][] matriuPartidesNivellFacil;
		String[][] matriuPartidesNivellIntermedi;
		String[][] matriuPartidesNivellDificil;

		// Matriu de contadors de partides per nivells
		int[][] matriuContadorsPartidesNivell;
		// Contador auxiliar per guardar el nombre de partides per nivells
		int contadorPartidaNivellAux = 0;

		// Posicio fila-columna del jugador al laberint i contador de moviments
		int fil, col, moviments;

		// Emmagatzemar temporalment la posicio del jugador
		char posicioAuxiliar;

		// Alerta per saber si el jugador guanya o surt de la partida
		boolean guanya = false;
		boolean sortir = false;
		boolean partida = false;

		// Matriu laberint buida
		char[][] laberint = null;

		// MENU DEL JOC
		System.out.println("BENVINGUT AL LABERINT DEL PEPITO");

		// Indicar el nombre de jugadors
		System.out.println("Indica el nombre de jugadors:");
		numJugadors = teclat.nextInt();

		// Indicar el nombre de partides per nivell
		System.out.println("Indica quantes partides vols jugar a cada nivell:");
		numPartides = teclat.nextInt();

		// Definir longitud del vector jugadors
		jugadors = new String[numJugadors];

		// Definir dimensions de les matrius
		vectorContadorsPartidesOrdre = new int[numPartides];
		matriuContadorsPartidesNivell = new int[numJugadors][3];
		matriuPartidesOrdre = new String[numJugadors][numPartides * 3];
		matriuPartidesNivellFacil = new String[numJugadors][numPartides];
		matriuPartidesNivellIntermedi = new String[numJugadors][numPartides];
		matriuPartidesNivellDificil = new String[numJugadors][numPartides];

		// Inicialitzar matriu de contadors de partides
		for (int f = 0; f < matriuContadorsPartidesNivell.length; f++) {
			for (int c = 0; c < matriuContadorsPartidesNivell[f].length; c++) {
				matriuContadorsPartidesNivell[f][c] = -1;
			}
		}

		// Inicialitzar vector de contadors de partides
		for (int f = 0; f < vectorContadorsPartidesOrdre.length; f++) {
			vectorContadorsPartidesOrdre[f] = 0;
		}

		// Introduir els noms dels jugadors
		for (int i = 0; i < jugadors.length; i++) {
			System.out.println("Nom del jugador " + i);
			jugadors[i] = teclat.next();
		}

		while (!sortir || partida) {

			// Opcions del joc
			System.out.println("MENU PRINCIPAL");
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

			// Opcio SORTIR
			if (opcio == 'q' || opcio == 'Q') {
				System.out.println("\t\t\t\t.-------------.");
				System.out.println("\t\t\t\t|             |");
				System.out.println("\t\t\t\t| FI DEL JOC  |");
				System.out.println("\t\t\t\t|             |");
				System.out.println("\t\t\t\t·------------·");

				sortir = true;

				continue;
			}

			// Opcio RESULTATS
			if (opcio == 'r' || opcio == 'R') {
				System.out.println("Com vols veure el resultats?");
				System.out.println("- Per nivells [L]");
				System.out.println("- Per ordre d'execucio [O]");

				System.out.print("Escull una de les dues opcions:");
				opcio = teclat.next().charAt(0);

				System.out.println("-------------");
				System.out.println("| RESULTATS |");
				System.out.println("-------------");
				System.out.println(" ");

				// Resultats per nivell
				if (opcio == 'l' || opcio == 'L') {

					for (int i = 0; i < numJugadors; i++) {
						System.out.println("JUGADOR: " + jugadors[i].toUpperCase());
						System.out.println("Nivell FACIL");
						for (int f = 0; f <= matriuContadorsPartidesNivell[i][0]; f++) {
							System.out.println("\t- Partida " + f + ": " + matriuPartidesNivellFacil[i][f]);
						}
						System.out.println(" ");
						System.out.println("Nivell INTERMEDI");
						for (int f = 0; f <= matriuContadorsPartidesNivell[i][1]; f++) {
							System.out.println("\t- Partida " + f + ":" + matriuPartidesNivellIntermedi[i][f]);
						}
						System.out.println(" ");
						System.out.println("Nivell DIFICIL");
						for (int f = 0; f <= matriuContadorsPartidesNivell[i][2]; f++) {
							System.out.println("\t- Partida " + f + ":" + matriuPartidesNivellDificil[i][f]);
						}
						System.out.println(" ");
					}
				}

				// Resultats per ordre d'execucio
				if (opcio == 'o' || opcio == 'O') {
					for (int i = 0; i < numJugadors; i++) {
						System.out.println("JUGADOR: " + jugadors[i].toUpperCase());
						for (int j = 0; j < vectorContadorsPartidesOrdre[i]; j++) {
							System.out.println("- Partida " + j + ": " + matriuPartidesOrdre[i][j]);
						}
					}
				}

				System.out.println("_____________________________");
				System.out.println("  ");

				sortir = true;
			}

			// Mostrar jugadors disponibles
			System.out.println("JUGADORS DISPONIBLES");
			for (int i = 0; i < jugadors.length; i++) {
				System.out.println(jugadors[i] + " [" + i + "]");
			}

			// Seleccionar jugador
			System.out.println("Selecciona un jugador:");
			seleccioJugador = teclat.nextInt();

			// Jugar o Resultats
			if (opcio == 'j' || opcio == 'J') {

				System.out.println("Tria un nivell de dificultat:");
				System.out.println("- Facil [E]");
				System.out.println("- Intermedi [I]");
				System.out.println("- Dificil [H]");
				dificultat = teclat.next().charAt(0);

				// Definir variables
				fil = 1;
				col = 1;
				moviments = 0;

				char[][] laberintFacil = { { '#', '#', '#', '#', '#', '#', '#', '#' },
						{ '#', 'J', '#', '#', '#', '#', '#', '#' }, { '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
						{ '#', '#', ' ', '#', ' ', '#', ' ', '#' }, { '#', '#', ' ', '#', ' ', '#', '#', '#' },
						{ '#', ' ', ' ', ' ', '#', ' ', ' ', 'S' }, { '#', '#', '#', ' ', ' ', ' ', '#', '#' },
						{ '#', '#', '#', '#', '#', '#', '#', '#' } };
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

				// TODO: Instruccions del joc

				// Carregar laberint segons la dificultat escollida per l'usuari
				switch (dificultat) {

				case 'E':
				case 'e':
					laberint = laberintFacil;

					// Contador de partides segons el nivell
					matriuContadorsPartidesNivell[seleccioJugador][0]++;

					break;

				case 'I':
				case 'i':
					laberint = laberintIntermedi;

					// Contador de partides segons el nivell
					matriuContadorsPartidesNivell[seleccioJugador][1]++;
					break;

				case 'H':
				case 'h':
					laberint = laberintDificil;

					// Contador de partides segons el nivell
					matriuContadorsPartidesNivell[seleccioJugador][2]++;
					break;
				}

				// Inicialitzar variables
				sortir = false;
				guanya = false;

				// Inici de partida
				while (!guanya && !sortir) {

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

					// Controlar que l'usuari introdueix un caracter valid.
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

					// Algoritme del joc
					switch (tirada) {

					// Dalt
					case 'w':
					case 'W':
						if (laberint[fil - 1][col] != '#') {
							if (laberint[fil - 1][col] == 'S') {

								// Guardar partides i resultats de cada partida per nivell
								if (laberint == laberintFacil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][0];
									matriuPartidesNivellFacil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintIntermedi) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][1];
									matriuPartidesNivellIntermedi[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintDificil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][2];
									matriuPartidesNivellDificil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}

								System.out.println("Has trobat la sortida!");

								// Guardar partides i resultats de cada partida en ordre d'execucio
								matriuPartidesOrdre[seleccioJugador][vectorContadorsPartidesOrdre[seleccioJugador]] = moviments
										+ " moviments - Ha guanyat";
								vectorContadorsPartidesOrdre[seleccioJugador]++;

								guanya = true;
								moviments++;

							} else {
								posicioAuxiliar = laberint[fil][col];
								laberint[fil][col] = laberint[fil - 1][col];
								laberint[fil - 1][col] = posicioAuxiliar;

								fil--;
								moviments++;
							}

						} else {
							System.out.println("Moviment no permes, torna a provar.");
							moviments++;
						}

						break;

					// Baix
					case 's':
					case 'S':
						if (laberint[fil + 1][col] != '#') {
							if (laberint[fil + 1][col] == 'S') {

								// Guardar partides i resultats de cada partida per nivell
								if (laberint == laberintFacil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][0];
									matriuPartidesNivellFacil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintIntermedi) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][1];
									matriuPartidesNivellIntermedi[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintDificil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][2];
									matriuPartidesNivellDificil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}

								System.out.println("Has trobat la sortida!");

								// Guardar partides i resultats de cada partida en ordre d'execucio
								matriuPartidesOrdre[seleccioJugador][vectorContadorsPartidesOrdre[seleccioJugador]] = moviments
										+ " moviments - Ha guanyat";
								vectorContadorsPartidesOrdre[seleccioJugador]++;

								guanya = true;
								moviments++;

							} else {
								posicioAuxiliar = laberint[fil][col];
								laberint[fil][col] = laberint[fil + 1][col];
								laberint[fil + 1][col] = posicioAuxiliar;

								fil++;
								moviments++;
							}
						} else {
							System.out.println("Moviment no permes, torna a provar.");
							moviments++;
						}

						break;

					// Esquerra
					case 'a':
					case 'A':
						if (laberint[fil][col - 1] != '#') {
							if (laberint[fil][col - 1] == 'S') {
								System.out.println("Has trobat la sortida!");

								// Guardar partides i resultats de cada partida per nivell
								if (laberint == laberintFacil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][0];
									matriuPartidesNivellFacil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintIntermedi) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][1];
									matriuPartidesNivellIntermedi[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintDificil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][2];
									matriuPartidesNivellDificil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}

								// Guardar partides i resultats de cada partida en ordre d'execucio
								matriuPartidesOrdre[seleccioJugador][vectorContadorsPartidesOrdre[seleccioJugador]] = moviments
										+ " moviments - Ha guanyat";
								vectorContadorsPartidesOrdre[seleccioJugador]++;

								guanya = true;
								moviments++;

							} else {
								posicioAuxiliar = laberint[fil][col];
								laberint[fil][col] = laberint[fil][col - 1];
								laberint[fil][col - 1] = posicioAuxiliar;

								col--;
								moviments++;
							}
						} else {
							System.out.println("Moviment no permes, torna a provar.");
							moviments++;
						}

						break;

					// Dreta
					case 'd':
					case 'D':
						if (laberint[fil][col + 1] != '#') {
							if (laberint[fil][col + 1] == 'S') {
								System.out.println("Has trobat la sortida!");

								// Guardar partides i resultats de cada partida per nivell
								if (laberint == laberintFacil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][0];
									matriuPartidesNivellFacil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintIntermedi) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][1];
									matriuPartidesNivellIntermedi[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}
								if (laberint == laberintDificil) {
									contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][2];
									matriuPartidesNivellDificil[seleccioJugador][contadorPartidaNivellAux] = moviments
											+ " moviments - Ha guanyat";
								}

								// Guardar partides i resultats de cada partida en ordre d'execucio
								matriuPartidesOrdre[seleccioJugador][vectorContadorsPartidesOrdre[seleccioJugador]] = moviments
										+ " moviments - Ha guanyat";
								vectorContadorsPartidesOrdre[seleccioJugador]++;

								guanya = true;
								moviments++;

							} else {
								posicioAuxiliar = laberint[fil][col];
								laberint[fil][col] = laberint[fil][col + 1];
								laberint[fil][col + 1] = posicioAuxiliar;

								col++;
								moviments++;
							}

						} else {
							System.out.println("Moviment no permes, torna a provar.");
							moviments++;
						}

						break;

					// Sortir de la partida
					case 'p':
					case 'P':
						System.out.println("Has sortit de la partida en curs.");

						// Guardar partides i resultats de cada partida per nivell
						if (laberint == laberintFacil) {
							contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][0];
							matriuPartidesNivellFacil[seleccioJugador][contadorPartidaNivellAux] = moviments + " moviments - Ha perdut";
						}
						if (laberint == laberintIntermedi) {
							contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][1];
							matriuPartidesNivellIntermedi[seleccioJugador][contadorPartidaNivellAux] = moviments + " moviments - Ha perdut";
						}
						if (laberint == laberintDificil) {
							contadorPartidaNivellAux = matriuContadorsPartidesNivell[seleccioJugador][2];
							matriuPartidesNivellDificil[seleccioJugador][contadorPartidaNivellAux] = moviments + " moviments - Ha perdut";
						}

						// Guardar partides i resultats de cada partida en ordre d'execucio
						matriuPartidesOrdre[seleccioJugador][vectorContadorsPartidesOrdre[seleccioJugador]] = moviments
								+ " moviments - Ha perdut";
						vectorContadorsPartidesOrdre[seleccioJugador]++;
						
						sortir = true;
						partida = true;
						break;

					// Sortir de joc
					case 'Q':
					case 'q':
						opcio = 'q';
						System.out.println("/t/t/t/t.-------------.");
						System.out.println("/t/t/t/t|             |");
						System.out.println("/t/t/t/t| FI DEL JOC  |");
						System.out.println("/t/t/t/t|             |");
						System.out.println("/t/t/t/t·------------·");
						sortir = true;

						break;

					}
				}
			}
		}
	}
}