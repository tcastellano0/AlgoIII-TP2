public abstract class Herramienta implements Desgastable{

	protected Durabilidad durabilidad;
	protected Golpeador golpeador;

    public double getDurabilidad() {
        return this.durabilidad.getDurabilidad();
    }

    public int getFuerza() {
        return this.golpeador.getFuerza();
    }

    public void desgastar(int fuerzaDesgaste){
        this.durabilidad.desgastar(fuerzaDesgaste);
    }

    public abstract void golpear(Material material);
}
