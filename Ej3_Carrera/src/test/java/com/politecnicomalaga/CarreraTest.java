package com.politecnicomalaga;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class CarreraTest {

    private Carrera carrera = new Carrera();

    @Test
    public void listaVacía_listaEsNulo_listaAunVacíaYEsNulo(){
        assertNull(carrera.getListadoParticipantes());
    }

    @Test
    public void listaVacía_addParticipante_listaNoVacíaYNoEsNulo(){
        String participanteAAñadir = "Toretto";
        carrera.addParticipante(participanteAAñadir);
        assertNotNull(carrera.getListadoParticipantes());
    }

    @Test
    public void listaNoVacía_addCuatroParticipantes_listaNoVacíaYParticipantesAñadidosConExito(){
        int resultadoEsperado = 4;
        String participanteAAñadir1 = "O´Conner";
        assertTrue(carrera.addParticipante(participanteAAñadir1));
        String participanteAAñadir2 = "Roman";
        assertTrue(carrera.addParticipante(participanteAAñadir2));
        String participanteAAñadir3 = "Han";
        assertTrue(carrera.addParticipante(participanteAAñadir3));
        String participanteAAñadir4 = "Tej";
        assertTrue(carrera.addParticipante(participanteAAñadir4));
        int resultadoObtenido = carrera.getTotalParticipantes();
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void insertarParticipanteRepetidoSinExito(){
        //given
        carrera.addParticipante("Toretto");
        carrera.addParticipante("O´Conner");
        carrera.addParticipante("Roman");
        carrera.addParticipante("Han");
        int tamañoListaParticipantes=carrera.getTotalParticipantes();
        //when
        String participanteAAñadir = "Toretto";
        boolean participanteAñadidoConExito = carrera.addParticipante(participanteAAñadir);
        int tamañoListaParticipantesDespuesDeIntentoDeAñadir = carrera.getTotalParticipantes();
        //then
        assertFalse(participanteAñadidoConExito);
        assertEquals(tamañoListaParticipantes, tamañoListaParticipantesDespuesDeIntentoDeAñadir);
    }

    @Test
    public void insertarParticipanteEnSegundoLugarYVerificarSiEsElMismoObjeto(){
        //given
        carrera.addParticipante("Toretto");
        carrera.addParticipante("O´Conner");
        carrera.addParticipante("Roman");
        carrera.addParticipante("Han");
        //when
        String participanteAAñadir = "John Wick";
        carrera.addParticipante(participanteAAñadir);
        carrera.setPosicion("John Wick", 1);
        //then
        assertSame(carrera.getParticipantePorPosicion(1), participanteAAñadir);
    }

    @Test
    public void comprobarQueListaOriginalYClonadaNoSonElMismoObjeto(){
        //given
        carrera.addParticipante("Toretto");
        carrera.addParticipante("O´Conner");
        ArrayList<String> listaParticipantesOriginal = carrera.getListadoParticipantes();
        //when
        ArrayList<String> copiaListaParticipantes = carrera.cloneCarrera();
        //then
        assertNotSame(copiaListaParticipantes, listaParticipantesOriginal);
    }

    @Test
    public void ListaDeParticipantesConMismosElementosTrasVariosMovimientosDeParticipantes(){
        //given
        carrera.addParticipante("Toretto");
        carrera.addParticipante("O´Conner");
        carrera.addParticipante("Roman");
        carrera.addParticipante("Han");
        Collections.sort(carrera.getListadoParticipantes());
        Object[] listaParticipantesAntesDeMovimientos = carrera.getListadoParticipantes().toArray();
        //when
        carrera.setPosicion("Toretto", 3);
        carrera.setPosicion("Roman", 1);
        carrera.setPosicion("OConner", 2);
        carrera.setPosicion("Han", 0);
        Collections.sort(carrera.getListadoParticipantes());
        Object[] listaParticipantesDespuesDeMovimientos = carrera.getListadoParticipantes().toArray();
        //then
        assertArrayEquals(listaParticipantesAntesDeMovimientos, listaParticipantesDespuesDeMovimientos);
    }
}