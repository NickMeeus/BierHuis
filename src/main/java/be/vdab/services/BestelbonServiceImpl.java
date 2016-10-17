package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.entities.Bestelbon;
import be.vdab.repositories.BestelbonRepository;

@Service
public class BestelbonServiceImpl implements BestelbonService {
	private final BestelbonRepository bestelbonRepository;

	@Autowired
	BestelbonServiceImpl(BestelbonRepository bestelbonRepository) {
		this.bestelbonRepository = bestelbonRepository;
	}

	@Override
	public void create(Bestelbon bestelbon) {
		bestelbonRepository.save(bestelbon);
	}

	@Override
	public Bestelbon read(long id) {
		return bestelbonRepository.findOne(id);
	}

	@Override
	public void update(Bestelbon bestelbon) {
		bestelbonRepository.save(bestelbon);
	}

	@Override
	public void delete(long id) {
		bestelbonRepository.delete(id);
	}

	@Override
	public List<Bestelbon> findAll() {
		return bestelbonRepository.findAll();
	}
}
