package com.example.demo.controller;


import com.example.demo.entity.Rider;
import com.example.demo.entity.TourTeam;
import com.example.demo.repository.RiderRepository;
import com.example.demo.repository.TourTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RiderController {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TourTeamRepository tourTeamRepository;

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

}
