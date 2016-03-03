package com.example.jose.connect3;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import es.uam.eps.multij.Jugador;
import es.uam.eps.multij.JugadorAleatorio;
import es.uam.eps.multij.JugadorHumano;
import es.uam.eps.multij.Partida;
import es.uam.eps.multij.Tablero3Raya;

public class MainActivity extends AppCompatActivity {
    protected JugadorAleatorio jugadorAleatorio = new JugadorAleatorio("Maquina");
    protected JugadorHumano jugadorHumano = new JugadorHumano("Humano");
    protected ArrayList<Jugador> jugadores = new ArrayList<>();
    private final int ids []={R.id.button_0,R.id.button_1,R.id.button_2,R.id.button_3,
            R.id.button_4,R.id.button_5,R.id.button_6,R.id.button_7,R.id.button_8};
    private int colorNormal;
    private Button buttonAux;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button buttonInit;
   private Drawable backgroundN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        button0 = (Button) findViewById(R.id.button_0);
        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4 = (Button) findViewById(R.id.button_4);
        button5 = (Button) findViewById(R.id.button_5);
        button6 = (Button) findViewById(R.id.button_6);
        button7 = (Button) findViewById(R.id.button_7);
        button8 = (Button) findViewById(R.id.button_8);
        buttonInit = (Button) findViewById(R.id.Button_newgame);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void newGame(View view){

        jugadores.add(jugadorAleatorio);
        jugadores.add(jugadorHumano);
        Partida partida = new Partida(new Tablero3Raya(), jugadores);
        partida.addObservador(new JugadorHumano("Observador"));
        Tablero3Raya tablero = (Tablero3Raya) partida.getTablero();
        for (int i=0;i<9;i++){
            buttonAux = (Button) findViewById(ids[i]);
            buttonAux.setVisibility(View.VISIBLE);
        }
    }






}
