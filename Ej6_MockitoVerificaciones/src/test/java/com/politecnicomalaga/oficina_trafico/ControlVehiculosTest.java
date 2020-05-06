package com.politecnicomalaga.oficina_trafico;

import com.politecnicomalaga.DAO.TraficoDAO;
import com.politecnicomalaga.modelo.Persona;
import com.politecnicomalaga.modelo.Vehiculo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ControlVehiculosTest {

    TraficoDAO mockedTraficoDAO;
    ControlVehiculos controlVehiculos;

    @Before
    public void setUp(){
        mockedTraficoDAO = mock(TraficoDAO.class);
        controlVehiculos = new ControlVehiculos(mockedTraficoDAO);
        when(mockedTraficoDAO.getVehiculoByMatricula("1234ABC")).thenReturn(new Vehiculo("1234ABC", "12345678A"));
        when(mockedTraficoDAO.getPropietarioByDNI("12345678A")).thenReturn(new Persona("José Pérez", "12345678A"));
    }

    @Test
    public void comprobarMetodoGetPropietarioVehiculo(){
        //given
        Persona personaEsperada = new Persona("José Pérez", "12345678A");
        String matricula="1234ABC";
        String dni="12345678A";
        //when
        Persona personaResultado = controlVehiculos.getPropietarioVehiculo(matricula);
        //then
        InOrder inOrder = Mockito.inOrder(mockedTraficoDAO);
        inOrder.verify(mockedTraficoDAO).getVehiculoByMatricula(matricula);
        inOrder.verify(mockedTraficoDAO).getPropietarioByDNI(dni);
        verifyNoMoreInteractions(mockedTraficoDAO);
        assertEquals(personaEsperada, personaResultado);
    }
}