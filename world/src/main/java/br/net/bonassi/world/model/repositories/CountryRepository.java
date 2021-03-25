package br.net.bonassi.world.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.bonassi.world.model.entities.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

	public Iterable<Country> findByNameContainingIgnoreCase(String parteNome);
}
