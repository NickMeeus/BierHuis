package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;
import be.vdab.repositories.BierRepository;

@Service
public class BierServiceImpl implements BierService {
	private final BierRepository bierRepository;

	@Autowired
	BierServiceImpl(BierRepository bierRepository) {
		this.bierRepository = bierRepository;
	}

	@Override
	public void create(Bier bier) {
		bierRepository.save(bier);
	}

	@Override
	public Bier read(long id) {
		return bierRepository.findOne(id);
	}

	@Override
	public void update(Bier bier) {
		bierRepository.save(bier);
	}

	@Override
	public void delete(long id) {
		bierRepository.delete(id);
	}

	@Override
	public List<Bier> findAll() {
		return bierRepository.findAll();
	}

	@Override
	public long findAantalBieren() {
		return bierRepository.count();
	}

	@Override
	public Iterable<Bier> findByBrouwer(Brouwer brouwer) {
		return bierRepository.findByBrouwerIsOrderByNaamAsc(brouwer);
	}
}
