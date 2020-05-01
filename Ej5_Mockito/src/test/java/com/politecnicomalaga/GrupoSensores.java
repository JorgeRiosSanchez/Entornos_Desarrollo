package com.politecnicomalaga;

import org.mockito.ArgumentMatcher;

public class GrupoSensores implements ArgumentMatcher<Integer> {

    private Integer min;
    private Integer max;

    public GrupoSensores(Integer estadoSensor){
        switch (estadoSensor){
            case Sensor.NO_INICIADO:
                this.min = 0;
                this.max = 9;
                break;
            case Sensor.ESTADO_VACIO:
                this.min = 10;
                this.max = 19;
                break;
            case Sensor.ESTADO_CASI_VACIO:
                this.min = 20;
                this.max = 29;
                break;
            case Sensor.ESTADO_MITAD:
                this.min = 30;
                this.max = 39;
                break;
            case Sensor.ESTADO_CASI_LLENO:
                this.min = 40;
                this.max = 49;
                break;
            case Sensor.ESTADO_LLENO:
                this.min = 50;
                this.max = 59;
                break;
        }
    }

    @Override
    public boolean matches(Integer integer) {
        return (integer >= min) && (integer <= max);
    }
}
