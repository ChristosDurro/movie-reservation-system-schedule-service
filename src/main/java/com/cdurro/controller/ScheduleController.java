package com.cdurro.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdurro.model.Schedule;
import com.cdurro.service.ScheduleService;

@RestController
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/schedules")
	public ResponseEntity<List<Schedule>> getAllSchedules() {
		
		return scheduleService.getSchedules();
	}
	
	@GetMapping("/schedules/{id}")
	public ResponseEntity<Schedule> getSchedule(@PathVariable Long id) {
		
		return scheduleService.getSchedule(id);
	}
	
	@GetMapping("/schedules/movie/{movieId}")
	public ResponseEntity<List<Schedule>> getSchedulesByMovieId(@PathVariable int movieId) {
		
		return scheduleService.getSchedulesByMovieId(movieId);
	}
	
	@PostMapping("/schedules/multiple")
	public ResponseEntity<List<Schedule>> getMultipleSchedules(@RequestBody List<Long> scheduleIds) {
		
		return scheduleService.getSchedulesByIds(scheduleIds);
	}
	
	@PostMapping("/schedules/create")
	public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
		
		return scheduleService.createSchedule(schedule);
	}
	
	@PatchMapping("/schedules/update/{id}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		
		return scheduleService.updateSchedule(id, updates);
	}
}
