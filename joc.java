package Joc;

import java.util.Scanner;

public class joc {
	
	Scanner e = new Scanner(System.in);
	

	public static void main(String[] args) {
		joc p = new joc();
		p.main();
	}
	
	public void main() {
		int option=-1;
		char [][] board=null;
		while (option != 0) {
			 option = menu();
			switch(option) {
			
			case 1: 
				if (option == 1) {
					
					board = board();
					generarTauler(board);
				}
				
				break;
				
			case 2:
				if (option == 2) {
					
					generarTauler(board);
					posicionamentManual(board);
					
					break;
				}
				
			case 3:
				if (option == 3) {

					generarTauler(board);
					posicionamentAuto(board);
						
					break;
				}
				
				
			case 4:
				if (option == 4) {
					
					System.out.println();
					imprimirTauler(board);
				
				break;
				
				}	
				
			case 5:
				if (option == 5) {
					
					int [] normes = definirNormes();
					System.out.println();
					System.out.println("Normes aplicades: ");
					System.out.println(normes[0] + "" + normes[1] + "/" + normes[2]);
					System.out.println();
					
					game(board, normes);
				
				break;	
					
				}
			
			
			}	
		}
	
		System.out.println();
		System.out.println("GAME OVER");
	}
	
	private void game(char [][] board, int [] normes) {
		int contador = 0;
		int iteracions = 0;
		char [][] newBoard = null;
		newBoard = board;
		System.out.println("Quantes iteracions voldràs que faci el joc? ");
		iteracions = e.nextInt();
		for (int s = 0; s < iteracions; s++){
			for (int y = 0; y < board.length; y++) {
				for (int x = 0; x < board[y].length; x++) {
					if (board[y][x] == '■') {
						contador = 0;
						if (board[y].length > (y+1)) {
							if (board[y+1][x] == '■') {
								contador++;
							}
						} 
						
						if (board[y].length > (y+1) && board.length > (x+1)) {
							if (board[y+1][x+1] == '■') {
								contador++;
							}
						} 
						
						if (board.length > (x+1)) {
							if (board[y][x+1] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (y-1) && board.length > (x+1)) {
							if (board[y-1][x+1] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (y-1)) {
							if (board[y-1][x] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (y-1) && 0 <= (x-1)) {
							if (board[y-1][x-1] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (x-1)) {
							if (board[y][x-1] == '■') {
								contador++;
							}
						} 
						
						if (board[y].length > (y+1) && 0 <= (x-1)) {
							if (board[y+1][x-1] == '■') {
								contador++;
							}
						}
						
						if (contador >= normes[0] && contador <= normes[1]) {
							newBoard[y][x] = '■';
						} else {
							newBoard[y][x] = '□';
						}
						
					} else {
						contador = 0;
						if (board[y].length > (y+1)) {
							if (board[y+1][x] == '■') {
								contador++;
							}
						} 
						
						if (board[y].length > (y+1) && board.length > (x+1)) {
							if (board[y+1][x+1] == '■') {
								contador++;
							}
						} 
						
						if (board.length > (x+1)) {
							if (board[y][x+1] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (y-1) && board.length > (x+1)) {
							if (board[y-1][x+1] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (y-1)) {
							if (board[y-1][x] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (y-1) && 0 <= (x-1)) {
							if (board[y-1][x-1] == '■') {
								contador++;
							}
						} 
						
						if (0 <= (x-1)) {
							if (board[y][x-1] == '■') {
								contador++;
							}
						} 
						
						if (board[y].length > (y+1) && 0 <= (x-1)) {
							if (board[y+1][x-1] == '■') {
								contador++;
							}
						}
						
						if (contador == normes[2]) {
							newBoard[y][x] = '■';
						} else {
							newBoard[y][x] = '□';
						}
					}
				}
			}
			
			char next;
			System.out.println("NEXT? (Y/N) ");
			next = e.next().toLowerCase().charAt(0);
			if (next == 'y') {
				imprimirTauler(newBoard);
			}
			
			else if (next == 'n') {
				break;
			}
		} 
	}
	
	private int length() {
		int length;
		
		System.out.println();
		System.out.println("Introdueix la llargada que vols que tingui el tauler: ");
		System.out.print("> ");
		length = e.nextInt();
		
		return length;
	}
	
	private int height() {
		int height;
		
		System.out.println();
		System.out.println("Introdueix l'alçada que vols que tingui el tauler: ");
		System.out.print("> ");
		height = e.nextInt();
		
		return height;
	}
	
	private char [][] board() {
		int length = length();
		int height = height();
		
		char board [][]= new char [height][length];
		return board;
	}
	
	private int menu() {
		int menu = -1;
		System.out.println("BENVINGUT AL JOC DE LA VIDA");
		System.out.println("Escull que vols fer: ");
		System.out.println("1 - Definir tauler");
		System.out.println("2 - Introduïr manualment les cèl·lules");
		System.out.println("3 - Introduïr automàticament les cèl·lules");
		System.out.println("4 - Imprimir tauler");
		System.out.println("5 - Iniciar el joc");
		System.out.println("0 - Sortir");
		System.out.println();
		System.out.print("> ");
		
		menu = e.nextInt();
		return menu;
	}
	
	private char [][] generarTauler(char [][] board) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x] = '□';
			}
		}
		
		return board;
	}
	
	private void imprimirTauler(char [][] board) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				System.out.print(board[y][x] + " ");
			}
			
		System.out.println();
	}
	
	System.out.println();
	}
	
	private int [] definirNormes() {
		int [] normes = {2, 3, 3};
		String norma;
		System.out.println("Introdueix les normes a seguir durant el joc amb el següent format (AA/B) o escriu 00/0 per deixar les normes per defecte (23/3) : ");
		norma = e.next();
		normes[0] = Character.getNumericValue(norma.charAt(0));
		normes[1] = Character.getNumericValue(norma.charAt(1));
		normes[2] = Character.getNumericValue(norma.charAt(3));
		if (normes[0] == 0 && normes[1] == 0 && normes[2] == 0) {
			normes[0] = 2;
			normes[1] = 3;
			normes[2] = 3;
		}
		
		return normes;
	}
	
	private int posicionamentManualx() {
		int x = 0;
		
		System.out.println("Digues a quina llargada vols introduïr la cèl·lula ");
		x = e.nextInt();
		return x;
	}
	
	private int posicionamentManualy() {
		int y = 0;
		
		System.out.println("Digues a quina alçada vols introduïr la cèl·lula ");
		y = e.nextInt();
		return y;
	}
	
	private void posicionamentManual(char [][] board) {
	
		
		for (int i = 0; i < 5; i++) {
			int pos1 = posicionamentManualx();
			int pos2 = posicionamentManualy();
			board[pos1][pos2] = '■';
		}
	}
	
	private int posicionamentAutox(char [][] board) {
		int x  = (int)(Math.random()* board.length);
		return x;
	}
	
	private int posicionamentAutoy(char [][] board) {
		int y = (int)(Math.random()* board[0].length);;
		return y;
	}
	
	private void posicionamentAuto(char [][] board) {
		System.out.println("Introdueix el nombre de grups de cèl·lules a crear: ");
		int N = e.nextInt();
		for (int cont = 0; cont < N; cont++) {
			for (int i = 0; i < 5; i++) {
				int pos1 = posicionamentAutox(board);
				int pos2 = posicionamentAutoy(board);
				board[pos1][pos2] = '■';
			}
		}
			
	}
}
