package com.politecnicomalaga;

import org.junit.Test;

public class MultiplicadorTest {

    @Test (expected = IllegalArgumentException.class)
    public void multiplicar() {
        Multiplicador multiplicador = new Multiplicador();
        multiplicador.multiplicar(1000, 3);
    }
}