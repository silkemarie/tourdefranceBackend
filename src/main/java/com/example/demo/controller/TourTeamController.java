package com.example.demo.controller;


import com.example.demo.entity.TourTeam;
import com.example.demo.repository.TourTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TourTeamController {

  @Autowired
  TourTeamRepository tourTeamRepository;

  //READ
  //FIND ALL
  @GetMapping("/teams")
  public List<TourTeam> getAllTeams() {
    return tourTeamRepository.findAll();
  }

  //FIND BY ID
  @GetMapping("/team/{teamId}")
  public TourTeam findTeamById(@PathVariable String teamId) {
    Optional<TourTeam> obj = tourTeamRepository.findById(teamId);
    if (obj.isPresent()) {
      return obj.get();
    }
    TourTeam notfoundTeam = new TourTeam();
    notfoundTeam.setTeamId("Team with id " + teamId + " could not be found.");
    return notfoundTeam;
  }

  //FIND BY NAME
  @GetMapping("/team/{teamName}")
  public TourTeam findTeamByName(@PathVariable String teamName) {
    Optional<TourTeam> obj = tourTeamRepository.findTourTeamByName(teamName);
    if (obj.isPresent()) {
      return obj.get();
    }
    TourTeam notfoundTeam = new TourTeam();
    notfoundTeam.setTeamId("Team with name " + teamName + " could not be found.");
    return notfoundTeam;
  }

  //CREATE
  @PostMapping("/team")
  @ResponseStatus(HttpStatus.CREATED)
  public TourTeam createTeam(@RequestBody TourTeam tourTeam) {
    return tourTeamRepository.save(tourTeam);
  }

  //UPDATE
  @PutMapping("/team/{teamId}")
  public ResponseEntity<TourTeam> updateTeam(@PathVariable String teamId, @RequestBody TourTeam tourTeam) {
    Optional<TourTeam> optionalTourTeam = tourTeamRepository.findByTeamId(teamId); //findByTourTeamId?
    if (optionalTourTeam.isPresent()) {
      tourTeamRepository.save(tourTeam);
      return new ResponseEntity<>(tourTeam, HttpStatus.OK);
    } else {
      TourTeam notfoundTeam = new TourTeam();
      notfoundTeam.setTeamId("Team with id " + teamId + " could not be updated.");
      return new ResponseEntity<>(notfoundTeam, HttpStatus.NOT_FOUND);
    }
  }

  //DELETE
  @DeleteMapping("/team/{teamId}")
  public ResponseEntity<String> deleteTeam(@PathVariable String teamId) {
    try {
      tourTeamRepository.deleteById(teamId);
      return new ResponseEntity<>("Deleted team with id " + teamId, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not delete team with id " + teamId, HttpStatus.NOT_FOUND);
    }
  }

}
