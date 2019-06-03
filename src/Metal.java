
public class Metal extends Material {

	public Metal() {
        this.durabilidad = new DurabilidadConFactor(1, 50);
    }
	
	@Override
	public void golpeadoPor(GolpeadorHachaDeMadera golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorHachaDePiedra golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorHachaDeMetal golpeador) { 	}

	@Override
	public void golpeadoPor(GolpeadorPicoDeMadera golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorPicoDePiedra golpeador) {
		this.desgastar(golpeador.getFuerza());
	}

	@Override
	public void golpeadoPor(GolpeadorPicoDeMetal golpeador) {
		this.desgastar(golpeador.getFuerza());
	}

	@Override
	public void golpeadoPor(GolpeadorPicoFino golpeador) {
		this.desgastar(golpeador.getFuerza());
	}

}
