package br.net.bonassi.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.bonassi.world.model.entities.Country;
import br.net.bonassi.world.model.repositories.CountryRepository;

@RestController
@RequestMapping(path = "/api/world")
public class ProdutoController {

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping(path = "/country/page/{numeroPagina}/{qtdePorPagina}")
	public Iterable<Country> getCountriesPerPage(@PathVariable int numeroPagina, @PathVariable int qtdePorPagina) {
		if (qtdePorPagina > 10)
			qtdePorPagina = 10;
		Pageable page = PageRequest.of(numeroPagina, qtdePorPagina);
		return countryRepository.findAll(page);
	}

	@GetMapping(path = "/country/{parteNome}")
	public Iterable<Country> getCountryByName(@PathVariable String parteNome) {
		return countryRepository.findByNameContainingIgnoreCase(parteNome);
	}
}
