package com.cdurro.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cdurro.model.Schedule;
import com.cdurro.repository.ScheduleRepo;

@Service
public class ScheduleService {
	
	@Autowired
	ScheduleRepo repo;
	
	public ResponseEntity<List<Schedule>> getSchedules() {
		
		List<Schedule> schedules = repo.findAll();
		
		return ResponseEntity.ok(schedules);
	}
	
	public ResponseEntity<Schedule> getSchedule(Long id) {
		
		Schedule schedule = repo.findById(id).orElse(null);
		
		return ResponseEntity.ok(schedule);
	}
	
	public ResponseEntity<Schedule> createSchedule(Schedule schedule) {
		Schedule scheduleSaved = repo.save(schedule);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(scheduleSaved);
	}

	public ResponseEntity<List<Schedule>> getSchedulesByMovieId(int movieId) {
		
		List<Schedule> schedules = repo.findAllByMovieId(movieId);
		
		return ResponseEntity.ok(schedules);
	}

	public ResponseEntity<List<Schedule>> getSchedulesByIds(List<Long> scheduleIds) {
		
		List<Schedule> schedules = repo.findAllById(scheduleIds);
		
		return ResponseEntity.ok(schedules);
	}

	public ResponseEntity<Schedule> updateSchedule(Long id, Map<String, Object> updates) {
		
		Optional<Schedule> scheduleOptional = repo.findById(id);
		
		if (scheduleOptional.isPresent()) {
			
			Schedule schedule = scheduleOptional.get();
			
			updates.forEach((key, value) -> {
				switch (key) {
					case "hall":
						schedule.setHall((String) value);
						break;
					case "showTime":
						schedule.setShowtime((LocalDateTime) value);
						break;
					case "movieId":
						schedule.setMovieId((Long) value);
				}
			});
			
			
			repo.save(schedule);

			return ResponseEntity.ok(schedule);	
			
		}
		return ResponseEntity.notFound().build();
	}
}
