package be.vdab.services;

import java.util.List;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;

public interface BierService {
	void create(Bier bier);

	Bier read(long id);

	void update(Bier bier);

	void delete(long id);

	List<Bier> findAll();

	long findAantalBieren();

	Iterable<Bier> findByBrouwer(Brouwer brouwer);
}
