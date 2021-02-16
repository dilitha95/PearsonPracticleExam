package com.practicalexam.demo.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practicalexam.demo.repositary.CountryRepositary;
import com.practicalexam.demo.models.*;


import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/v2")
public class CountryController {
	
	@Autowired
	CountryRepositary countryRepository;
	
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getAllCountries() {
		try {
			List<Country> countries = new ArrayList<Country>();

			
				countryRepository.findAll().forEach(countries::add);
			

			if (countries.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(countries, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/countries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") long id) {
		Optional<Country> countryData = countryRepository.findById(id);

		if (countryData.isPresent()) {
			return new ResponseEntity<>(countryData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/countries")
	public ResponseEntity<Country> createCountry(@RequestBody Country country) {
		try {
			Country _country = countryRepository
					.save(country);
			return new ResponseEntity<>(_country, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/countries/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable("id") long id, @RequestBody Country country) {
		Optional<Country> countryData = countryRepository.findById(id);

		if (countryData.isPresent()) {
			Country _country = countryData.get();
			_country.setCountryName(country.getCountryName());
			_country.setCapital(country.getCapital());
			
			return new ResponseEntity<>(countryRepository.save(_country), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/countries/{id}")
	public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") long id) {
		try {
			countryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/countries")
	public ResponseEntity<HttpStatus> deleteAllCountry() {
		try {
			countryRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
