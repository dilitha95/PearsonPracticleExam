package com.practicalexam.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicalexam.demo.models.Country;

public interface CountryRepositary extends JpaRepository<Country, Long> {
	  
}
