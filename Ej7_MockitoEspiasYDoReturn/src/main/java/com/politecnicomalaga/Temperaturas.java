package com.politecnicomalaga;

import java.util.ArrayList;
import java.util.Collections;

public class Temperaturas {
    ArrayList<Integer> registro;

    public Temperaturas(){
        registro = new ArrayList<>();
    }

    public void addTemperatura(int temperatura){
        registro.add(temperatura);
    }

    public int diferenciaMaxima(){
        ArrayList<Integer> clon = (ArrayList<Integer>) registro.clone();
        Collections.sort(clon);
        return Math.abs(clon.get(0) - clon.get(clon.size()-1));
    }
}
