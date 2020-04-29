package com.politecnicomalaga;

import java.util.ArrayList;

public class Carrera {

    private ArrayList<String> listaParticipantes;

    public Carrera(){
        listaParticipantes=new ArrayList<>();
    }

    public boolean addParticipante(String nombreParticipante){
        if(listaParticipantes.isEmpty()){
            listaParticipantes.add(nombreParticipante);
            return true;
        }else {
            boolean encontrado=false;
            for(int i=0; i<listaParticipantes.size(); i++) {
                if (listaParticipantes.get(i).equals(nombreParticipante)) {
                    encontrado=true;
                }
            }
            if(!encontrado){
                listaParticipantes.add(nombreParticipante);
                return true;
            }
        }
        return false;
    }

    public ArrayList getListadoParticipantes(){
        if(!listaParticipantes.isEmpty()){
            return listaParticipantes;
        }
        return null;
    }

    public int getTotalParticipantes(){
        return listaParticipantes.size();
    }

    public ArrayList cloneCarrera(){
        ArrayList<String> clonListaParticipantes=(ArrayList)listaParticipantes.clone();
        return clonListaParticipantes;
    }

    public boolean setPosicion(String nombreParticipante, int posicionDestino){
        for(int i=0; i<listaParticipantes.size(); i++){
            if(listaParticipantes.get(i).equals(nombreParticipante)){
                listaParticipantes.add(posicionDestino, listaParticipantes.remove(i));
                return true;
            }
        }
        return false;
    }

    public String getParticipantePorPosicion(int posicion){
        return listaParticipantes.get(posicion);
    }
}
