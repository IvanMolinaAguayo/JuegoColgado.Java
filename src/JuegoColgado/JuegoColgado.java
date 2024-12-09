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
        	
        	   // Elegir la palabra secreta
            System.out.println(nomJugadors[0] + ", ingresa la palabra secreta: ");
            paraulaSecreta = scr.nextLine().toLowerCase();
            while (paraulaSecreta.isEmpty()) {
                System.out.println("La palabra secreta no puede estar en blanco.");
                paraulaSecreta = scr.nextLine().toLowerCase();
            }
            
            // Ocultar la palabra secreta
            paraulaOculta = paraulaSecreta.replaceAll(".", "_");

            // Inicializar los intentos
            int[] intentsRestants = new int[jugadors];
            for (int i = 0; i < jugadors; i++) {
                intentsRestants[i] = maxIntents;

            }
            
            // Empezar a jugar
            boolean paraulaAdivinada = false;
            while (!paraulaAdivinada) {
                for (int i = 0; i < jugadors; i++) {
                    if (intentsRestants[i] <= 0) {
                        System.out.println(nomJugadors[i] + " se ha quedado sin intentos.");
                        continue;
                    }
                    
                    System.out.println("nTurno de " + nomJugadors[i]);
                    System.out.println("Palabra oculta: " + paraulaOculta);
                    System.out.println("Intentos restantes: " + intentsRestants[i]);
                    System.out.print("Ingresa una letra: ");
                    String lletra = scr.nextLine().toLowerCase();
                    
                    // Verificamos que la letra es válida
                    if (lletra.length() != 1 || !Character.isLetter(lletra.charAt(0))) {
                        System.out.println("Por favor, ingresa solo una letra.");
                        i--;
                        continue;   
                        }
                    // Comprovamos que la letra elegida está en la palabra oculta
                    if (paraulaSecreta.contains(lletra)) {
                        System.out.println("¡Correcto!");
                        // Si la letra se encuentra en la palabra, actualizamos los espacios vacios donde se encuntra la palabra
                        StringBuilder novaparaulaOculta = new StringBuilder(paraulaOculta);
                        for (int j = 0; j < paraulaSecreta.length(); j++) {
                            if (paraulaSecreta.charAt(j) == lletra.charAt(0)) {
                                novaparaulaOculta.setCharAt(j, lletra.charAt(0));
                            }
                        }
                        paraulaOculta = novaparaulaOculta.toString();
                    } else {
                        System.out.println("¡Incorrecto!");
                        intentsRestants[i]--;
                    }

                }
            }
                  
        }
        

	}

}
