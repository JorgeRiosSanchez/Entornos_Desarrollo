package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TemperaturasTest {

    private Temperaturas temperaturas;
    private Temperaturas espiaTemperaturas;

    @Before
    public void setUp(){
        temperaturas = new Temperaturas();
        espiaTemperaturas = spy(temperaturas);
    }

    @Test public void esteTestTieneUnProblema(){
        doReturn(30).when (espiaTemperaturas).diferenciaMaxima();
        assertEquals(30,espiaTemperaturas.diferenciaMaxima());
    }
}