package com.example.hms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.models.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

}
