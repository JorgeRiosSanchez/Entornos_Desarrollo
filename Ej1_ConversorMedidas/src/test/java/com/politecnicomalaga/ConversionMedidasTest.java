package com.politecnicomalaga;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionMedidasTest {

    ConversionMedidas conversor = new ConversionMedidas();

    @Test
    public void inchACm() {
        Double resultadoEsperado1=2.54;
        Double resultadoEsperado2=30.48;
        Double resultadoObtenido1=conversor.inchACm(1);
        Double resultadoObtenido2=conversor.inchACm(12);
        assertEquals(resultadoEsperado1, resultadoObtenido1);
        assertEquals(resultadoEsperado2, resultadoObtenido2);
    }

    @Test
    public void cmAInch() {
        Double resultadoEsperado1=4.72441;
        Double resultadoEsperado2=0.0;
        Double resultadoEsperado3=0.1968;
        Double resultadoObtenido1=conversor.cmAInch(12);
        Double resultadoObtenido2=conversor.cmAInch(0);
        Double resultadoObtenido3=conversor.cmAInch(0.5);
        assertEquals(resultadoEsperado1, resultadoObtenido1, 5);
        assertEquals(resultadoEsperado2, resultadoObtenido2);
        assertEquals(resultadoEsperado3, resultadoObtenido3, 4);
    }
}