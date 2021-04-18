package com.example.hms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.models.BookingStatus;
import com.example.hms.models.Room;
import com.example.hms.models.Suite;
import com.example.hms.repo.RoomRepository;
import com.example.hms.repo.SuiteRepository;

@Service
public class RoomService {
	
	private RoomRepository roomRepository;
	private SuiteRepository suiteRepository;

	@Autowired
	public RoomService(RoomRepository roomRepository, SuiteRepository suiteRepository) {
		this.roomRepository = roomRepository;
		this.suiteRepository = suiteRepository;
	}
	
	public Room createRoom(String description, String name, String code, int price, String suiteCode) {
		
		Suite suite = suiteRepository.findByName(suiteCode).orElseThrow(() -> new RuntimeException("Suite with code " + suiteCode
				+" doesn't exist"));
		
		return roomRepository.findById(code)
		.orElse(roomRepository.save(new Room(code, name, description, price, BookingStatus.AVAILABLE, suite))); 
	}
	
	
	

}
