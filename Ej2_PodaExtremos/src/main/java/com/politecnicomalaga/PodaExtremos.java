package com.politecnicomalaga;

import java.util.List;

public class PodaExtremos {

    public int podarMasProximo (int numero, List<Integer> listaNumeros){
        int diferenciaMenor=Integer.MAX_VALUE;
        int posicionABorrar=-1;
        for (int i=0; i<listaNumeros.size(); i++){
            int resultadoDiferencia= Math.abs(numero - listaNumeros.get(i));
            if (resultadoDiferencia<diferenciaMenor){
                diferenciaMenor=resultadoDiferencia;
                posicionABorrar=i;
            }
        }
        return listaNumeros.remove(posicionABorrar);
    }

    public int podarMasLejano (int numero, List<Integer> listaNumeros){
        int diferenciaMayor=Integer.MIN_VALUE;
        int posicionABorrar=-1;
        for (int i=0; i<listaNumeros.size(); i++){
            int resultadoDiferencia= Math.abs(numero - listaNumeros.get(i));
            if (resultadoDiferencia>diferenciaMayor){
                diferenciaMayor=resultadoDiferencia;
                posicionABorrar=i;
            }
        }
        return listaNumeros.remove(posicionABorrar);
    }
}
