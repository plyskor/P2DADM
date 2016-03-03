

import java.util.ArrayList;

import es.uam.eps.multij.*;

public class Main {

	public static void main(String[] args) {
		JugadorAleatorio jugadorAleatorio = new JugadorAleatorio("Máquina"); 
		JugadorHumano jugadorHumano = new JugadorHumano("Humano");
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugadorHumano); 
		jugadores.add(jugadorAleatorio);
		Partida partida = new Partida(new Tablero3Raya(), jugadores); 
		partida.addObservador(new JugadorHumano("Observador"));
		Tablero3Raya tablero = (Tablero3Raya) partida.getTablero();
		partida.comenzar(tablero,jugadores);
		

	}

}
