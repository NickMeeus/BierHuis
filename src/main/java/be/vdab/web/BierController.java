package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;
import be.vdab.exceptions.BierNietGevondenException;
import be.vdab.services.BierService;

@Controller
@RequestMapping(path = "/bieren")
public class BierController {
	private static final String BIEREN_BESTELLEN_VIEW = "bieren/bier";
	private static final String REDIRECT_URL = "redirect:/";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/winkelwagen";
	private final BierService bierService;
	private final Mandje mandje;

	@Autowired
	BierController(BierService bierService, Mandje mandje) {
		this.bierService = bierService;
		this.mandje = mandje;
	}

	@GetMapping
	ModelAndView getIndex() {
		return new ModelAndView(REDIRECT_URL);
	}

	@RequestMapping(path = "bestellen", method = RequestMethod.GET, params = "bierId")
	ModelAndView detailsVanBieren(@RequestParam Long bierId) {
		Bier bier = bierService.read(bierId);
		if (bier == null) {
			throw new BierNietGevondenException();
		}
		return new ModelAndView(BIEREN_BESTELLEN_VIEW).addObject("bier", bier);
	}

	@RequestMapping(method = RequestMethod.POST, params = { "bierId", "aantal" })
	ModelAndView toevoegen(@RequestParam Long bierId, @RequestParam Integer aantal) {
		if (aantal < 1) {
			return new ModelAndView(BIEREN_BESTELLEN_VIEW).addObject("bier", bierService.read(bierId)).addObject("fout",
					"Geef een geldig geheel positief getal op");
		}
		mandje.addBestelbonlijn(bierId, aantal);
		return new ModelAndView(REDIRECT_URL_NA_TOEVOEGEN).addObject("bierId", bierId).addObject("aantalFlessen",
				aantal);
	}

	@ExceptionHandler(BierNietGevondenException.class)
	public @ResponseBody ModelAndView bierNietGevonden() {
		return new ModelAndView(REDIRECT_URL);
	}
}