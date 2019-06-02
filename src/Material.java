public abstract class Material implements Desgastable, Golpeable{

	protected DurabilidadConFactor durabilidad;

	public Material() {
		this.durabilidad = new DurabilidadConFactor(1, 10);
	}

	public double getDurabilidad() {
		return this.durabilidad.getDurabilidad();
	}

	@Override
	public void desgastar(int fuerzaDesgaste) {
		this.durabilidad.desgastar(fuerzaDesgaste);
	}

	@Override
	public void golpeadoPor(Herramienta herramienta) {
		herramienta.golpear(this);
	}

	@Override
	public abstract void golpeadoPor(Hacha hacha);

	@Override
	public abstract void golpeadoPor(Pico pico);
}
