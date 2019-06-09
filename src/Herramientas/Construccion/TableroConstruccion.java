package Herramientas.Construccion;

import Herramientas.Construccion.CeldaConstruccion;
import Herramientas.Herramienta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableroConstruccion {
    private int filas = 3;
    private int columnas = 3;
    private List<CeldaConstruccion> celdas = new ArrayList<>();
    private Map<String, Herramienta> maquetas = new HashMap<>();


    public TableroConstruccion() {
        for (int i = 0; i < this.filas * this.columnas; i++) {
            celdas.add(new CeldaConstruccion());
        }
        maquetas.put("MMVMMVVMV", Herramienta.hachaDeMadera());
    }

    private CeldaConstruccion getCelda(int fila, int columna){
       return celdas.get((fila - 1) * this.columnas + columna - 1);
    }

    public void ponerMadera(int fila, int columna) {
        getCelda(fila,columna).madera();
    }

    public String maqueta() {
        String maqueta = "";
        StringBuilder sb = new StringBuilder();
        for (CeldaConstruccion c : celdas) {
            sb.append(c.getContenido());
        }
        maqueta = sb.toString();
        return maqueta;
    }

    public Herramienta construir() {
        Herramienta herramienta = this.maquetas.get(this.maqueta());
        return herramienta;
    }
}
