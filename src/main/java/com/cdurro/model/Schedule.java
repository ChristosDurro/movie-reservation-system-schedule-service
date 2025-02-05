package com.cdurro.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hall;
	private LocalDateTime showtime;
	private Long movieId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public LocalDateTime getShowtime() {
		return showtime;
	}
	public void setShowtime(LocalDateTime showtime) {
		this.showtime = showtime;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", hall=" + hall + ", showtime=" + showtime + ", movieId=" + movieId + "]";
	}
}
