package be.vdab.services;

import java.util.List;

import be.vdab.entities.Bestelbon;

public interface BestelbonService {
	void create(Bestelbon bestelbon);

	Bestelbon read(long id);

	void update(Bestelbon bestelbon);

	void delete(long id);

	List<Bestelbon> findAll();
}
