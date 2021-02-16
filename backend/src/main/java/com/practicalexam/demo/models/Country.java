package com.practicalexam.demo.models;
import javax.persistence.*;


@Entity
@Table(name = "countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String countryId;
	@Column(name = "countryName")
	private String countryName;
	@Column(name = "capital")
	private String capital;
	
	
	public Country() {
		
	}
	
	public Country(String countryId, String countryName, String capital) {
		
		this.countryId = countryId;
		this.countryName = countryName;
		this.capital = capital;
	}
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", capital=" + capital + "]";
	}
	
	
	
	

}
