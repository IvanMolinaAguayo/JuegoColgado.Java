package JuegoColgado;
import java.util.Scanner;
public class JuegoColgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scr = new Scanner(System.in);
		
        int jugadors;
        int maxIntents = 6;
        int rondes;
        String paraulaSecreta;
        String paraulaOculta;

        
        //Pedimos el número de jugadores totales
        System.out.println("Juego del colgado");
        do {
            System.out.println("¿Cuántos jugadores van a participar? (Mínimo 2 jugadores): ");
            jugadors = scr.nextInt();
            scr.nextLine(); 
        } while (jugadors < 2);
        
        //Pedimos el número de rondas que se van a jugar
        System.out.println("¿Cuántas rondas van a jugar?");
        rondes = scr.nextInt();
        scr.nextLine();
        
        //Nombres de los jugadores
        String[]nomJugadors = new String[jugadors];
        for (int i = 0;i <jugadors;i++) {
        	System.out.println("Ingresa el nombre del jugador"+(i+1)+":");
        	nomJugadors[i]=scr.nextLine();
        }
        
        //Recuento de las victorias de cada jugador
        int[] victories = new int[jugadors];
        
        //Rondes
        for(int ronda = 1; ronda <= rondes; ronda++) {
        	System.out.println("\nRonda" + ronda +" comenzando...");
        }
        

	}

}
