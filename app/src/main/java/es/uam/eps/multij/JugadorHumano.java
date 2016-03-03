

import java.util.Scanner;

import es.uam.eps.multij.AccionMover;
import es.uam.eps.multij.Evento;
import es.uam.eps.multij.Jugador;
import es.uam.eps.multij.Movimiento;
import es.uam.eps.multij.Tablero;

public class JugadorHumano implements Jugador {
	 private String nombre;
	public JugadorHumano(String string) {
		this.nombre=string;
		
	}

	@Override
	public void onCambioEnPartida(Evento evento) {
		Scanner in = new Scanner ( System.in );
		switch (evento.getTipo()) {
        case Evento.EVENTO_CAMBIO:
            break;
            
        case Evento.EVENTO_CONFIRMA:
           
        	System.out.println("Votas a favor (1) o en contra(0)?;");
        	int opt=Character.getNumericValue(in.next().charAt(0));
            try {
            	if(opt==1){
                evento.getPartida().confirmaAccion(
                        this, evento.getCausa(), true);
            	}else{
            		evento.getPartida().confirmaAccion(
                            this, evento.getCausa(), false);
            	}
            }
            catch(Exception e) {
            	
            }
            break;
            
        case Evento.EVENTO_TURNO:
            
            Tablero t = evento.getPartida().getTablero();
            
            String p =new String("Casillas Vacías : ");
            System.out.println("Seleccione en qué casilla [0 a 2(Fila1) 3 a 5(Fila2) 6 a 8(Fila3)] vacía desea colocar su ficha:");
            
            for(Movimiento m :t.movimientosValidos()){
            	p+=((Movimiento3Raya) m).getCasilla();
            	
            }
            
            System.out.println(p);
            opt=Character.getNumericValue(in.next().charAt(0));
            //System.out.println("DEBUG: Elegido movimiento"+opt);
            try {
            	evento.getPartida().realizaAccion(new AccionMover(
            			this, new Movimiento3Raya(opt)));
            	in.close();
            }
            catch(Exception e) {
            	System.out.println(e.getMessage());
            	in.close();
            }
            break;
    }
		
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean puedeJugar(Tablero tablero) {
		
		return false;
	}

}
