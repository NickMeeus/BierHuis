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

import be.vdab.entities.Brouwer;
import be.vdab.exceptions.BrouwerNietGevondenException;
import be.vdab.services.BierService;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping(path = "/brouwers")
public class BrouwerController {
	private static final String VIEW = "brouwers/brouwers";
	private static final String BIEREN_VAN_BROUWER_VIEW = "brouwers/brouwerinfo";
	private final BrouwerService brouwerService;
	private final BierService bierService;

	@Autowired
	BrouwerController(BrouwerService brouwerService, BierService bierService) {
		this.brouwerService = brouwerService;
		this.bierService = bierService;
	}

	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(VIEW, "brouwers", brouwerService.findAll());
	}

	@RequestMapping(method = RequestMethod.GET, params = "brouwerId")
	ModelAndView bierenVanEenBrouwer(@RequestParam Long brouwerId) {
		Brouwer brouwer = brouwerService.read(brouwerId);
		if (brouwer == null) {
			throw new BrouwerNietGevondenException();
		}
		return new ModelAndView(BIEREN_VAN_BROUWER_VIEW).addObject("brouwer", brouwer).addObject("bieren",
				bierService.findByBrouwer(brouwer));
	}

	@ExceptionHandler(BrouwerNietGevondenException.class)
	public @ResponseBody ModelAndView brouwerNietGevonden() {
		return new ModelAndView(VIEW, "brouwers", brouwerService.findAll());
	}
}
