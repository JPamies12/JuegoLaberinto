import java.util.Scanner;

public class laberintov1 {

	public static void main(String[] args) {
		// Declarar variables
		Scanner teclat = new Scanner(System.in);
		int opcio, fil = 0, col = 0;
		char tirada = 'x', dificultat, change;
		String nomUsuari;
		boolean guanya = false;
		char[][] laberint = null;
		char[][] laberintFacil = { { 'P', '#', '#', '#', '#', '#' }, { '.', '.', '.', '.', '.', '.', },
				{ '#', '.', '#', '.', '#', '.' }, { '#', '.', '#', '.', '#', '#' }, { '.', '.', '.', '#', '.', 'G' },
				{ '#', '#', '.', '.', '.', '#' } };

		
		System.out.println("BENVINGUT AL LABERINT DEL PEPITO");
		System.out.println("- Jugar partida [1]");
		System.out.println("- Resultats partides [2]");
	    System.out.println("- Sortir [3]");

		System.out.print("Escull una de les tres opcions:");
		opcio = teclat.nextInt();

		while (opcio != 'q') {

			switch (opcio) {

			case 1:

				System.out.print("Introdueix el teu nom d'usuari: ");
				nomUsuari = teclat.next();
				System.out.println("Escolleix un nivell de dificultat:");
				System.out.println("- Facil [E]");
			    System.out.println("- Intermedi [I]");
			    System.out.println("- Dificil [H]");
				dificultat = teclat.next().charAt(0);

				switch (dificultat) {

				case 'E':
				case 'e':
					laberint= laberintFacil;
				
				case 'I':
				case 'i': // Carregar matriu 2
				
				case 'H':
				case 'h': // Carregar matriu 3
				}
				
				
				while (tirada != 'p') {
					
					for (int f = 0; f < laberint.length; f++) {
				          for (int c = 0; c < laberint[f].length; c++) {
				            System.out.print(laberint[f][c] + " ");
				          }
				          System.out.println();
					}
					
					System.out.print("TIRA: ");
					tirada = teclat.next().charAt(0);

					switch (tirada) {

					case 'w':

						change = laberint[fil][col];
						laberint[fil][col] = laberint[fil - 1][col];
						laberint[fil - 1][col] = change;
						fil--;

					break;
					case 's':
					        
						change = laberint[fil][col];
						laberint[fil][col] = laberint[fil + 1][col];
						laberint[fil + 1][col] = change;
						fil++;

					break;
					case 'a':

						change = laberint[fil][col];
						laberint[fil][col] = laberint[fil][col - 1];
						laberint[fil][col - 1] = change;
						col--;

					break;
					case 'd':

						change = laberint[fil][col];
						laberint[fil][col] = laberint[fil][col + 1];
						laberint[fil][col + 1] = change;
						col++;
						
					break;

					}
				}
				
				System.out.println("");
				System.out.println("1.- Jugar Partida");
				System.out.println("2.- Resultats Partides");
				System.out.println("3.- Sortir");
				opcio = teclat.nextInt();

			break;
			case 2:

				System.out.println("");
				System.out.println("1.- Jugar Partida");
				System.out.println("2.- Resultats Partides");
				System.out.println("3.- Sortir");
				opcio = teclat.nextInt();
				
			break;
			case 3:
				
				opcio = 'q';
			
			break;
			}
		}
	}
}
