package com.example.demo.controller;


import com.example.demo.entity.Rider;
import com.example.demo.entity.Team;
import com.example.demo.repository.RiderRepository;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RiderController {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;

  //READ
  //FIND ALL
  @GetMapping("/riders")
  public List<Rider> getAllRiders() {
    return riderRepository.findAll();
  }

  //FIND BY ID
  @GetMapping("/riders/{id}")
  public Rider findRiderById(@PathVariable String id) {
    Optional<Rider> obj = riderRepository.findById(id);
    if (obj.isPresent()) {
      return obj.get();
    }
    Rider rider = new Rider();
    rider.setRider_id("Rider with the id " + id + "could not be found.");
    return rider;
  }

  //FIND BY TEAM
  @GetMapping("/ridersByTeam/{id}")
  public Optional<Team> findRiderByTeamId(@PathVariable String id) {
    return teamRepository.findById(id);
  }

  //CREATE
  @PostMapping("/rider")
  @ResponseStatus(HttpStatus.CREATED)
  public Rider createRider(@RequestBody Rider rider) {
    return riderRepository.save(rider);
  }

  //UPDATE
  @PutMapping("/rider/{id}")
  public ResponseEntity<Rider> updateRider(@PathVariable String id, @RequestBody Rider rider) {
    Optional<Rider> optionalRider = riderRepository.findById(id);
    if (optionalRider.isPresent()) {
      riderRepository.save(rider);
      return new ResponseEntity<>(rider, HttpStatus.OK);
    } else {
      /*Rider notfoundRider = new Rider();
      notfoundRider.setRider_id("Rider with the id " + id + " could not be found.");

       */
      return new ResponseEntity<>(rider, HttpStatus.NOT_FOUND);
    }
  }

  //DELETE
  @DeleteMapping("/rider/{id}")
  public ResponseEntity<String> deleteRider(@PathVariable String id) {
    try {
      riderRepository.deleteById(id);
      return new ResponseEntity<>("Deleted rider with id " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not delete rider with id " + id, HttpStatus.NOT_FOUND);
    }
  }
}
