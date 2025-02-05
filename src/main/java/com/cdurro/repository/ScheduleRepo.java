package com.cdurro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdurro.model.Schedule;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
	public List<Schedule> findAllByMovieId(int movieId);
}
