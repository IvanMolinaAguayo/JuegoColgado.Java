package JuegoColgado;
import java.util.Random;
import java.util.Scanner;

public class JuegoColgado {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        int jugadors;
        int maxIntents = 6;
        int rondes;
        String palabraSecreta;
        String palabraOculta;
        
        // Listado de palabras (ciudades)
        String[] listaDePalabras = {
            "Barcelona", "Madrid", "Bilbao", "Valencia", "Sevilla", "Vigo", "Tarragona", "Málaga", "Murcia", "Lérida"
        };
        
        //  Cantidad de jugadores
        System.out.println("Juego del colgado");
        do {
            System.out.println("¿Cuántos jugadores van a participar? (Mínimo 2 jugadores): ");
            jugadors = scr.nextInt();
            scr.nextLine();
        } while (jugadors < 2);

        // Cantidad de rondas
        System.out.println("¿Cuántas rondas se van a jugar?");
        rondes = scr.nextInt();
        scr.nextLine(); 

        // Nombres de los jugadores
        String[] nombresJugadores = new String[jugadors];
        for (int i = 0; i < jugadors; i++) {
            System.out.println("Ingresa el nombre del jugador " + (i + 1) + ": ");
            nombresJugadores[i] = scr.nextLine();
        }

        // Victorias de cada jugador
        int[] victorias = new int[jugadors];

        // Ciclo por rondas
        for (int ronda = 1; ronda <= rondes; ronda++) {
            System.out.println("\nRonda " + ronda + " comenzando...");
            
            // Elección de la palabra aleatoria
            Random rand = new Random();
            palabraSecreta = listaDePalabras[rand.nextInt(listaDePalabras.length)];
            System.out.println("La palabra secreta ha sido seleccionada (es aleatoria y está oculta para los jugadores).");

            // Ocultar la palabra secreta
            palabraOculta = palabraSecreta.replaceAll(".", "_");

            // Inicializar los intentos
            int[] intentosRestantes = new int[jugadors];
            for (int i = 0; i < jugadors; i++) {
                intentosRestantes[i] = maxIntents;
            }

            // Inicio del juego
            boolean palabraAdivinada = false;
            while (!palabraAdivinada) {
                for (int i = 0; i < jugadors; i++) {
                    if (intentosRestantes[i] <= 0) {
                        System.out.println(nombresJugadores[i] + " se ha quedado sin intentos.");
                        continue;
                    }

                    System.out.println("\nTurno de " + nombresJugadores[i]);
                    System.out.println("Palabra oculta: " + palabraOculta);
                    System.out.println("Intentos restantes: " + intentosRestantes[i]);
                    System.out.print("Ingresa una letra: ");
                    String letra = scr.nextLine().toLowerCase();

                    // Verificar si la letra es válida
                    if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
                        System.out.println("Por favor, ingresa solo una letra.");
                        i--; // Repetir el turno del jugador
                        continue;
                    }

                    // Comprobar si la letra está en la palabra secreta
                    if (palabraSecreta.contains(letra)) {
                        System.out.println("¡Correcto!");
                        // Actualizar la palabra oculta
                        StringBuilder nuevaPalabraOculta = new StringBuilder(palabraOculta);
                        for (int j = 0; j < palabraSecreta.length(); j++) {
                            if (palabraSecreta.charAt(j) == letra.charAt(0)) {
                                nuevaPalabraOculta.setCharAt(j, letra.charAt(0));
                            }
                        }
                        palabraOculta = nuevaPalabraOculta.toString();
                    } else {
                        System.out.println("¡Incorrecto!");
                        intentosRestantes[i]--;
                    }

                    // Verificar si la palabra ha sido adivinada
                    if (palabraOculta.equals(palabraSecreta)) {
                        palabraAdivinada = true;
                        victorias[i]++;
                        System.out.println(nombresJugadores[i] + " ha adivinado la palabra: " + palabraSecreta);
                        break;
                    }

                    // Verificar si se han quedado sin intentos
                    if (intentosRestantes[i] <= 0) {
                        System.out.println(nombresJugadores[i] + " se ha quedado sin intentos.");
                    }
                }
            }
        }

        // Mostrar los puntajes finales
        System.out.println("\nPuntajes finales:");
        int maxPuntajes = 0;
        for (int i = 0; i < victorias.length; i++) {
            System.out.println(nombresJugadores[i] + ": " + victorias[i]);
            if (victorias[i] > maxPuntajes) {
                maxPuntajes = victorias[i];
            }
        }

        // Determinar y mostrar el ganador
        System.out.println("\n¡Ganadores!");
        for (int i = 0; i < victorias.length; i++) {
            if (victorias[i] == maxPuntajes) {
                System.out.println(nombresJugadores[i]);
            }
        }

        scr.close();
    }
}


               
