package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.valueobjects.Adres;

@Controller
@RequestMapping(path = "/winkelwagen")
public class WinkelwagenController {
	private static final String VIEW = "winkelwagen/winkelwagen";
	private static final String BEVESTIGING_VIEW = "winkelwagen/bevestiging";
	private final BestelbonService bestelbonService;
	private final Mandje mandje;

	@Autowired
	WinkelwagenController(BestelbonService bestelbonService, Mandje mandje) {
		this.mandje = mandje;
		this.bestelbonService = bestelbonService;
	}

	@GetMapping
	ModelAndView getWinkelwagen() {
		return new ModelAndView(VIEW).addObject("mandje", mandje.getbestelbonlijnen()).addObject("totaalprijs",
				mandje.getTotaalprijs());
	}

	@RequestMapping(method = RequestMethod.POST, params = { "naam", "straat", "huisNr", "postcode", "gemeente" })
	ModelAndView toevoegen(@RequestParam String naam, @RequestParam String straat, @RequestParam String huisNr,
			@RequestParam Integer postcode, @RequestParam String gemeente) {
		if (mandje.isLeeg()) {
			return new ModelAndView(VIEW)
					.addObject("foutMandje", "Graag eerst iets selecteren om te bestellen VOOR je een bestelbon maakt");
		}
		try {
			Adres adres = new Adres(gemeente, straat, huisNr, postcode);
			Bestelbon bestelbon = new Bestelbon(naam, adres, mandje.getbestelbonlijnen());
			bestelbonService.create(bestelbon);
			mandje.maakMandjeLeeg();
			return new ModelAndView(BEVESTIGING_VIEW).addObject("bestelbonNr", bestelbon.getId());
		} catch (Exception ex) {
			return new ModelAndView(VIEW).addObject("fout", "Geef geldige gegevens op")
					.addObject("mandje", mandje.getbestelbonlijnen()).addObject("totaalprijs", mandje.getTotaalprijs());
		}

	}
}