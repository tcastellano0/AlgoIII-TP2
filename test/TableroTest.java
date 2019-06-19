import Materiales.*;
import Juego.Mapa.*;
import Juego.Jugador.Jugador;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TableroTest {

	@Test(expected = TableroCreacionException.class)
	public void test01CrearMapaConNumFilasNegativoLanzaError() {
		new Tablero<Material>(-1, 1);
	}

	@Test(expected = TableroCreacionException.class)
	public void test02CrearMapaConNumColumnasNegativoLanzaError() {
		new Tablero<Material>(1, -1);
	}

	@Test(expected = TableroCreacionException.class)
	public void test03CrearMapaConNumFilasCeroLanzaError() {
		new Tablero<Material>(0, 1);
	}

	@Test(expected = TableroCreacionException.class)
	public void test04CrearMapaConNumColumnasCeroLanzaError() {
		new Tablero<Material>(1, 0);
	}

	@Test
    public void test05CreoUnTableroTresPorTresAgregoUnDiamanteEn3Y3YAlSacarloEsElMismo() {
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();
		tablero.poner(diamante, new Posicion(3, 3));
		
		assertEquals(diamante, tablero.sacar(new Posicion(3, 3)));
    }

    @Test(expected = UbicacionFueraDeRangoException.class)
	public void test06AgregarEnUnTableroEnPosicionCeroYCeroLanzaError(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, new Posicion(0, 0));
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void test07AgregarEnUnTableroEnPosicionCeroYUnoLanzaError(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, new Posicion(0, 1));
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void test08AgregarEnUnTableroEnPosicionConFilaMasAltaQueLaDelTableroLanzaError(){
		int fila = 3;

		Tablero<Material> tablero = new Tablero<Material>(fila, 3);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, new Posicion(fila + 2, 2));
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void test09AgregarEnUnTableroEnPosicionConColumnaMasAltaQueLaDelTableroLanzaError(){
		int columna = 3;

		Tablero<Material> tablero = new Tablero<Material>(3, columna);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, new Posicion(2, columna+2));
	}
	
	@Test(expected = UbicacionFueraDeRangoException.class)
	public void test10SacarDeUnaPosicionConColumnaMasAltaQueLaDelTableroLanzaError(){
		int columna = 3;
		Tablero<Material> tablero = new Tablero<Material>(3, columna);

		tablero.sacar(new Posicion(2, columna + 2));
	}
	
	@Test(expected = UbicacionFueraDeRangoException.class)
	public void test11SacarDeUnaPosicionConFilaMasAltaQueLaDelTableroLanzaError(){
		int fila = 3;
		Tablero<Material> tablero = new Tablero<Material>(fila, 3);

		tablero.sacar(new Posicion(fila + 2, 2));
	}

	@Test(expected = ContenedorOcupadoException.class)
	public void test12PonerDosVecesEnUnaMismaPosicionTieneQueLanzarException(){
		Tablero<Material> tablero = new Tablero<>(5, 5);
		Material madera = new Madera();
		Material piedra = new Piedra();

		tablero.poner(madera, new Posicion(3, 3));
		tablero.poner(piedra, new Posicion(3, 3));
	}

	@Test(expected = ContenedorVacioException.class)
	public void test13SacarDeUnaPosicionQueNoTieneNadaLanzaError(){
		Tablero<Material> tablero = new Tablero<>(1, 1);

		tablero.sacar(new Posicion(1, 1));
	}

	@Test
	public void testPonerUnaPiedraEnUnTableroYVerLaPosicionDosVecesDebeDarLaMismaPiedra(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Piedra piedra = new Piedra();

		tablero.poner(piedra, new Posicion(1, 1));
		
		assertEquals(piedra, tablero.ver(new Posicion(1, 1)));
		assertEquals(piedra, tablero.ver(new Posicion(1, 1)));
	}
	
	@Test
	public void testVerEnUnaPosicionSinContenidoDeberiaSerNull(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);

		assertEquals(tablero.ver(new Posicion(1, 1)), null);
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void testAgregarEnUnTableroConObjetoPosicionCeroYCeroLanzaError(){
		Posicion posicion = new Posicion(0, 0);
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, posicion);
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void testAgregarEnUnTableroConObjetoPosicionCeroYUnoLanzaError(){
		Posicion posicion = new Posicion(0, 1);
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, posicion);
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void testAgregarEnUnTableroConObjetoPosicionConFilaMasAltaQueLaDelTableroLanzaError(){
		int fila = 3;

		Posicion posicion = new Posicion(fila + 2, 2);
		Tablero<Material> tablero = new Tablero<Material>(fila, 3);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, posicion);
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void testAgregarEnUnTableroConObjetoPosicionConColumnaMasAltaQueLaDelTableroLanzaError(){
		int columna = 3;

		Posicion posicion = new Posicion(2, columna+2);
		Tablero<Material> tablero = new Tablero<Material>(3, columna);
		Diamante diamante = new Diamante();

		tablero.poner(diamante, posicion);
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void testSacarConObjetoPosicionConColumnaMasAltaQueLaDelTableroLanzaError(){
		int columna = 3;

		Posicion posicion = new Posicion(2, columna+2);
		Tablero<Material> tablero = new Tablero<Material>(3, columna);

		tablero.sacar(posicion);
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void testSacarDeObjetoPosicionConFilaMasAltaQueLaDelTableroLanzaError(){
		int fila = 3;

		Posicion posicion = new Posicion(fila + 2, 2);
		Tablero<Material> tablero = new Tablero<Material>(fila, 3);

		tablero.sacar(posicion);
	}

	@Test
	public void testSePuedeOcuparUnCasilleroVacioConUnJugador() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Jugador jugador = new Jugador();
		Posicion posicion = new Posicion(1,1);

		mapa.poner(jugador, posicion);
		assertEquals(mapa.sacar(posicion), jugador);
	}

	@Test
	public void testSePuedeOcuparUnCasilleroVacioConUnaMadera() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Madera madera = new Madera();
		Posicion posicion = new Posicion(1,1);

		mapa.poner(madera, posicion);
		assertEquals(mapa.sacar(posicion), madera);
	}

	@Test
	public void testSePuedeOcuparUnCasilleroVacioConUnaPiedra() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Piedra piedra = new Piedra();
		Posicion posicion = new Posicion(1,1);

		mapa.poner(piedra, posicion);
		assertEquals(mapa.sacar(posicion), piedra);
	}

	@Test
	public void testSePuedeOcuparUnCasilleroVacioConUnMetal() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Metal metal = new Metal();
		Posicion posicion = new Posicion(1,1);

		mapa.poner(metal, posicion);
		assertEquals(mapa.sacar(posicion), metal);
	}

	@Test
	public void testSePuedeOcuparUnCasilleroVacioConUnDiamante() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(1,1);

		mapa.poner(diamante, posicion);
		assertEquals(mapa.sacar(posicion), diamante);
	}

	@Test(expected = ContenedorOcupadoException.class)
	public void testNoSePuedeOcuparUnCasilleroOcupadoConUnMaterial() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Madera madera = new Madera();
		Diamante diamante = new Diamante();

		Posicion posicion = new Posicion(1,1);

		mapa.poner(diamante, posicion);
		mapa.poner(madera, posicion);
	}

	@Test(expected = ContenedorOcupadoException.class)
	public void testNoSePuedeOcuparUnCasilleroOcupadoConElJugador() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Jugador jugador = new Jugador();
		Diamante diamante = new Diamante();

		Posicion posicion = new Posicion(1,1);

		mapa.poner(diamante, posicion);
		mapa.poner(jugador, posicion);
	}

	@Test(expected = UbicacionFueraDeRangoException.class)
	public void testNoSePuedeOcuparUnCasilleroFueraDelTablero() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Diamante diamante = new Diamante();

		Posicion posicion = new Posicion(25,25);

		mapa.poner(diamante, posicion);
	}

	@Test
	public void testAlPonerYSacarUnMaterialDeUnCasilleroEsteDebeSerElMismo() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(1,1);

		mapa.poner(diamante, posicion);

		assertEquals(mapa.sacar(posicion), diamante);
	}

	@Test(expected = ContenedorVacioException.class)
	public void testAlSacarUnMaterialDeUnCasilleroOcupadoEsteLuegoDebeEstarVacio() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(1,1);

		mapa.poner(diamante, posicion);
		mapa.sacar(posicion);
		mapa.sacar(posicion);
	}

	@Test(expected = ContenedorVacioException.class)
	public void testAlSacarUnMaterialDeUnCasilleroVacioEsteNoDebePermitirlo() {
		Tablero<Ubicable> mapa = new Tablero<Ubicable>(20,20);
		Posicion posicion = new Posicion(1,1);

		mapa.sacar(posicion);
	}

}

