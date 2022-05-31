package com.example.demo.config;

import com.example.demo.entity.Rider;
import com.example.demo.entity.Team;
import com.example.demo.repository.RiderRepository;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;

  @Override
  public void run(String... args) throws Exception {

    Team team = new Team();
    team.setTeam_id("1");
    team.setTeam_name("Team Honda");


    Rider rider = new Rider();
    rider.setRider_id("1");
    rider.setRider_name("Kurt");
    rider.setRider_age(25);
    rider.setMountain_points(10);
    rider.setSprint_points(5);
    rider.setTotal_points(15);
    rider.setRider_time("1:15");
    riderRepository.save(rider);

    rider.setRider_id("2");
    rider.setRider_name("Frank");
    rider.setRider_age(27);
    rider.setMountain_points(15);
    rider.setSprint_points(10);
    rider.setTotal_points(25);
    rider.setRider_time("1:20");
    riderRepository.save(rider);


    teamRepository.save(team);

  }




}
