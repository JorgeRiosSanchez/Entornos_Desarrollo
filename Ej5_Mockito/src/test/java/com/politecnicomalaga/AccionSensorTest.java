package com.politecnicomalaga;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccionSensorTest {
    AccionSensor accionSensor;
    MatrizSensores matrizSensores;
    GrupoSensores grupoSensoresInactivos;
    GrupoSensores grupoSensoresVacios;
    GrupoSensores grupoSensoresCasiVacios;
    GrupoSensores grupoSensoresMedio;
    GrupoSensores grupoSensoresCasiLlenos;
    GrupoSensores grupoSensoresLlenos;

    @Before
    public void setUp(){
        grupoSensoresInactivos = new GrupoSensores(Sensor.NO_INICIADO);
        grupoSensoresVacios = new GrupoSensores(Sensor.ESTADO_VACIO);
        grupoSensoresCasiVacios = new GrupoSensores(Sensor.ESTADO_CASI_VACIO);
        grupoSensoresMedio = new GrupoSensores(Sensor.ESTADO_MITAD);
        grupoSensoresCasiLlenos = new GrupoSensores(Sensor.ESTADO_CASI_LLENO);
        grupoSensoresLlenos = new GrupoSensores(Sensor.ESTADO_LLENO);
        matrizSensores = mock(MatrizSensores.class);
        accionSensor = new AccionSensor(matrizSensores);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresVacios))).thenReturn(Sensor.ESTADO_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresCasiVacios))).thenReturn(Sensor.ESTADO_CASI_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresMedio))).thenReturn(Sensor.ESTADO_MITAD);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresCasiLlenos))).thenReturn(Sensor.ESTADO_CASI_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresLlenos))).thenReturn(Sensor.ESTADO_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresInactivos))).thenThrow(IllegalStateException.class);
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaBaja() {
        //given
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_BAJA);
        //then
        int accionEsperada1=AccionSensor.ACCION_REVISION;
        int accionObtenida1=accionSensor.evaluar(5);
        assertEquals(accionEsperada1, accionObtenida1);
        int accionEsperada2=AccionSensor.ACCION_REPOSICION;
        int accionObtenida2=accionSensor.evaluar(12);
        assertEquals(accionEsperada2, accionObtenida2);
        int accionEsperada3=AccionSensor.ACCION_REPOSICION;
        int accionObtenida3=accionSensor.evaluar(23);
        assertEquals(accionEsperada3, accionObtenida3);
        int accionEsperada4=AccionSensor.ACCION_INNECESARIA;
        int accionObtenida4=accionSensor.evaluar(35);
        assertEquals(accionEsperada4, accionObtenida4);
        int accionEsperada5=AccionSensor.ACCION_INNECESARIA;
        int accionObtenida5=accionSensor.evaluar(45);
        assertEquals(accionEsperada5, accionObtenida5);
        int accionEsperada6=AccionSensor.ACCION_INNECESARIA;
        int accionObtenida6=accionSensor.evaluar(55);
        assertEquals(accionEsperada6, accionObtenida6);
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaMedia() {
        //given
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_MEDIA);
        //then
        int accionEsperada1=AccionSensor.ACCION_REVISION;
        int accionObtenida1=accionSensor.evaluar(5);
        assertEquals(accionEsperada1, accionObtenida1);
        int accionEsperada2=AccionSensor.ACCION_REPOSICION;
        int accionObtenida2=accionSensor.evaluar(12);
        assertEquals(accionEsperada2, accionObtenida2);
        int accionEsperada3=AccionSensor.ACCION_REPOSICION;
        int accionObtenida3=accionSensor.evaluar(23);
        assertEquals(accionEsperada3, accionObtenida3);
        int accionEsperada4=AccionSensor.ACCION_REPOSICION;
        int accionObtenida4=accionSensor.evaluar(35);
        assertEquals(accionEsperada4, accionObtenida4);
        int accionEsperada5=AccionSensor.ACCION_INNECESARIA;
        int accionObtenida5=accionSensor.evaluar(45);
        assertEquals(accionEsperada5, accionObtenida5);
        int accionEsperada6=AccionSensor.ACCION_INNECESARIA;
        int accionObtenida6=accionSensor.evaluar(55);
        assertEquals(accionEsperada6, accionObtenida6);
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaAlta() {
        //given
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_ALTA);
        //then
        int accionEsperada1=AccionSensor.ACCION_REVISION;
        int accionObtenida1=accionSensor.evaluar(5);
        assertEquals(accionEsperada1, accionObtenida1);
        int accionEsperada2=AccionSensor.ACCION_REPOSICION;
        int accionObtenida2=accionSensor.evaluar(12);
        assertEquals(accionEsperada2, accionObtenida2);
        int accionEsperada3=AccionSensor.ACCION_REPOSICION;
        int accionObtenida3=accionSensor.evaluar(23);
        assertEquals(accionEsperada3, accionObtenida3);
        int accionEsperada4=AccionSensor.ACCION_REPOSICION;
        int accionObtenida4=accionSensor.evaluar(35);
        assertEquals(accionEsperada4, accionObtenida4);
        int accionEsperada5=AccionSensor.ACCION_REPOSICION;
        int accionObtenida5=accionSensor.evaluar(45);
        assertEquals(accionEsperada5, accionObtenida5);
        int accionEsperada6=AccionSensor.ACCION_INNECESARIA;
        int accionObtenida6=accionSensor.evaluar(55);
        assertEquals(accionEsperada6, accionObtenida6);
    }
}