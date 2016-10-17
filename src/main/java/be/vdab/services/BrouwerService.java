package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	void create(Brouwer brouwer);

	Brouwer read(long id);

	void update(Brouwer brouwer);

	void delete(long id);

	List<Brouwer> findAll();
}
