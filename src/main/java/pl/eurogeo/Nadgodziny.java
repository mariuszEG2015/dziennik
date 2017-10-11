package pl.eurogeo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Nadgodziny {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate day;
	@Column(nullable = true)
	private Double liczbaNadgodzin;
	private String uwagi;
	private int month;
	private int year;
	private String user;
	
	
	public Nadgodziny() {}

	public Nadgodziny(long id, LocalDate day, double liczbaNadgodzin, String uwagi, String user) {
		
		this.id = id;
		this.day = day;
		this.liczbaNadgodzin = liczbaNadgodzin;
		this.uwagi = uwagi;
		this.user=user;
		
	}
	
	@JsonSerialize(using = SerializedLocalDate.class)
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public Double getLiczbaNadgodzin() {
		return liczbaNadgodzin;
	}
	public void setLiczbaNadgodzin(double liczbaNadgodzin) {
		this.liczbaNadgodzin = liczbaNadgodzin;
	}
	public String getUwagi() {
		return uwagi;
	}
	public void setUwagi(String uwagi) {
		this.uwagi = uwagi;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
