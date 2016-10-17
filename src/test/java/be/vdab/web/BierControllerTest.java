package be.vdab.web;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;
import be.vdab.entities.Soort;
import be.vdab.services.BierService;
import be.vdab.valueobjects.Adres;

public class BierControllerTest {
	private Bier bier;
	private BierController bierController;
	private BierService bierService;
	private Mandje mandje;

	@Before
	public void before() {
		bier = new Bier("Big Chouffe (=Chouffe )",
				new Brouwer("Achouffe", new Adres("Achouffe-Wibrin", "Route du Village", "32", 6666), 10000L),
				new Soort("Edelbier"), new BigDecimal(8), new BigDecimal(25));
		bierService = Mockito.mock(BierService.class);
		Mockito.when(bierService.read(135L)).thenReturn(bier);
		mandje = new MandjeImpl(bierService);
		bierController = new BierController(bierService, mandje);
	}

	@Test
	public void getIndexActiveertJuisteView() {
		assertEquals("redirect:/", bierController.getIndex().getViewName());
	}

	@Test
	public void detailsVanBierenActiveertJuisteView() {
		assertEquals("bieren/bier", bierController.detailsVanBieren(135L).getViewName());
	}

//	@Test
//	public void toevoegenActiveertJuisteView() {
//		
//	}

}
