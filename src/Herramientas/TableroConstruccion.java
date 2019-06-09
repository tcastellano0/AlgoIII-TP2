package Herramientas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableroConstruccion {
    private int alto = 3;
    private int ancho = 3;
    private List<CeldaConstruccion> celdas = new ArrayList<>();
    private Map<String, Herramienta> maquetas = new HashMap<>();

    public TableroConstruccion() {
        for (int i = 0; i < this.alto * this.ancho; i++) {
            celdas.add(new CeldaConstruccion());
        }
        maquetas.put("MMVMMVVMV", Herramienta.hachaDeMadera());
    }

    public void ponerMadera(int x, int y) {
        celdas.get((x - 1) * this.ancho + y - 1).madera();
    }

    public String maqueta() {
        String maqueta = "";
        StringBuilder sb = new StringBuilder();
        for (CeldaConstruccion c : celdas) {
            sb.append(c.material());
        }
        maqueta = sb.toString();
        return maqueta;
    }

    public Herramienta construir() {
        Herramienta herramienta = this.maquetas.get(this.maqueta());
        return herramienta;
    }
}
