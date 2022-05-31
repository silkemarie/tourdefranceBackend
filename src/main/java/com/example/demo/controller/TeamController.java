package com.example.demo.controller;

import com.example.demo.entity.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TeamController {

  @Autowired
  TeamRepository teamRepository;

  //READ
  //FIND ALL
  @GetMapping("/teams")
  public List<Team> getAllTeams() {
    return teamRepository.findAll();
  }

  //FIND BY ID
  @GetMapping("/team/{id}")
  public Team findTeamById(@PathVariable String id) {
    Optional<Team> obj = teamRepository.findById(id);
    if (obj.isPresent()) {
      return obj.get();
    }
    Team notfoundTeam = new Team();
    notfoundTeam.setTeam_id("Team with id " + id + " could not be found.");
    return notfoundTeam;
  }

  //CREATE
  @PostMapping("/team")
  @ResponseStatus(HttpStatus.CREATED)
  public Team createTeam(@RequestBody Team team) {
    return teamRepository.save(team);
  }

  //UPDATE
  @PutMapping("/team/{id}")
  public ResponseEntity<Team> updateTeam(@PathVariable String id, @RequestBody Team team) {
    Optional<Team> optionalTourTeam = teamRepository.findById(id);
    if (optionalTourTeam.isPresent()) {
      teamRepository.save(team);
      return new ResponseEntity<>(team, HttpStatus.OK);
    } else {
      Team notfoundTeam = new Team();
      notfoundTeam.setTeam_id("Team with id " + id + " could not be updated.");
      return new ResponseEntity<>(notfoundTeam, HttpStatus.NOT_FOUND);
    }
  }

  //DELETE
  @DeleteMapping("/team/{id}")
  public ResponseEntity<String> deleteTeam(@PathVariable String id) {
    try {
      teamRepository.deleteById(id);
      return new ResponseEntity<>("Deleted team with id " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not delete team with id " + id, HttpStatus.NOT_FOUND);
    }
  }

}
