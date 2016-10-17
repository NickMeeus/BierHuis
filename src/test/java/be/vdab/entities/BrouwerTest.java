package be.vdab.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import be.vdab.valueobjects.Adres;

public class BrouwerTest {
	private Brouwer brouwer;
	private Brouwer brouwer2;

	@Before
	public void setUp() {
		Brouwer brouwer = new Brouwer("Nick", new Adres("Heist", "kerkhofstraat", "1", 2220), 1000000);
		Brouwer brouwer2 = new Brouwer("Nick", new Adres("Heist", "kerkhofstraat", "1", 2220), 1000000);
	}

	// @Test
	// public void TestGetNaam() {
	// assertEquals("Nick", brouwer.getNaam());
	// }
	//
	// @Test
	// public void TestSetNaam() {
	// brouwer.setNaam("Hans");
	// assertEquals("Hans", brouwer.getNaam());
	// }
	//
	// @Test
	// public void TestGetOmzet() {
	// assertEquals(1000000L, brouwer.getOmzet());
	// }
	//
	// @Test
	// public void TestSetOmzet() {
	// brouwer.setOmzet(1000L);
	// assertEquals(1000L, brouwer.getOmzet());
	// }

	@Test
	public void TestEqualsBrouwer() {
		assertEquals(brouwer, brouwer2);
	}
}
