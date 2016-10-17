package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;

@Service
public class BrouwerServiceImpl implements BrouwerService {
	private final BrouwerRepository brouwerRepository;

	@Autowired
	BrouwerServiceImpl(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwerRepository.save(brouwer);
	}

	@Override
	public Brouwer read(long id) {
		return brouwerRepository.findOne(id);
	}

	@Override
	public void update(Brouwer brouwer) {
		brouwerRepository.save(brouwer);
	}

	@Override
	public void delete(long id) {
		brouwerRepository.delete(id);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll(new Sort("naam"));
	}
}
