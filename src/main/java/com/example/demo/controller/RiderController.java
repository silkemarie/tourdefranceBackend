package com.example.demo.controller;


import com.example.demo.entity.Rider;
import com.example.demo.entity.TourTeam;
import com.example.demo.repository.RiderRepository;
import com.example.demo.repository.TourTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RiderController {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TourTeamRepository tourTeamRepository;

  //GET
  //FIND ALL
  @GetMapping("/riders")
  public List<Rider> getAllRiders() {
    return riderRepository.findAll();
  }

  //FIND BY ID
  @GetMapping("/riders/{riderId}")
  public Rider findRiderById(@PathVariable String riderId) {
    Optional<Rider> obj = riderRepository.findRiderById(riderId);
    if (obj.isPresent()) {
      return obj.get();
    }
    Rider rider = new Rider();
    rider.setRiderId("Rider with the id " + riderId + "could not be found.");
    return rider;
  }

  //FIND BY NAME
  @GetMapping("/riders/{riderName}")
  public Rider findRiderByName(@PathVariable String riderName) {
    Optional<Rider> obj = riderRepository.findRiderByName(riderName);
    if (obj.isPresent()) {
      return obj.get();
    }
    Rider rider = new Rider();
    rider.setRiderName("Rider with the name " + riderName + "could not be found.");
    return rider;
  }

  //FIND BY TEAM
  @GetMapping("/riders/{teamId}")
  public List<Rider> findRiderByTeam(@PathVariable String teamId) {
    return riderRepository.findRiderByTeam(teamId);
  }

  //PART 2 ???
  @GetMapping("/riders2/{teamId}")
  public List<Rider> findRiderByTeam2(@PathVariable String teamId) {
    Optional<TourTeam> tourTeam = tourTeamRepository.findByTeamId(teamId);
    if (tourTeam.isPresent()) {
      TourTeam team = tourTeam.get();
      return riderRepository.findRiderByTeam(teamId);
    } else
    return null;
  }

  //CREATE
  @PostMapping("/rider")
  @ResponseStatus(HttpStatus.CREATED)
  public Rider createRider(@RequestBody Rider rider) {
    return riderRepository.save(rider);
  }

  //UPDATE
  @PutMapping("/rider/{riderId}")
  public ResponseEntity<Rider> updateRider(@PathVariable String riderId, @RequestBody Rider rider) {
    Optional<Rider> optionalRider = riderRepository.findRiderById(riderId);
    if (optionalRider.isPresent()) {
      riderRepository.save(rider);
      return new ResponseEntity<Rider>(rider, HttpStatus.OK);
    } else {
      Rider notfoundRider = new Rider();
      notfoundRider.setRiderId("Rider with the id " + riderId + " could not be found.");
      return new ResponseEntity<Rider>(notfoundRider, HttpStatus.NOT_FOUND);
    }
  }

  //DELETE
  @DeleteMapping("/rider/{riderId}")
  public ResponseEntity<String> deleteRider(@PathVariable String riderId) {
    try {
      riderRepository.deleteById(riderId);
      return new ResponseEntity<>("Deleted rider with id " + riderId, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not delete rider with id " + riderId, HttpStatus.NOT_FOUND);
    }
  }
}
