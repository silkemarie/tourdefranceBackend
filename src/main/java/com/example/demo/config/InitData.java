package com.example.demo.config;

import com.example.demo.entity.Rider;
import com.example.demo.entity.TourTeam;
import com.example.demo.repository.RiderRepository;
import com.example.demo.repository.TourTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TourTeamRepository tourTeamRepository;

  @Override
  public void run(String... args) throws Exception {

    TourTeam tourTeam = new TourTeam();
    tourTeam.setTeamId("1");
    tourTeam.setTeamName("Team Honda");
    tourTeamRepository.save(tourTeam);

    Rider rider = new Rider();
    rider.setRiderId("1");
    rider.setRiderName("Kurt");
    rider.setAge(25);
    rider.setMountainPoints(10);
    rider.setSprintPoints(5);
    rider.setTotalPoints(15);
    rider.setTime("1:15");
    riderRepository.save(rider);


    rider.setRiderId("2");
    rider.setRiderName("Frank");
    rider.setAge(27);
    rider.setMountainPoints(15);
    rider.setSprintPoints(10);
    rider.setTotalPoints(25);
    rider.setTime("1:20");
    riderRepository.save(rider);
  }


}
