package JuegoColgado;
import java.util.Scanner;
public class JuegoColgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scr = new Scanner(System.in);
		
        int jugadors;
        int maxIntents = 6;
        int rondes;
        String palabraSecreta;
        String palabraOculta;

        
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

	}

}
