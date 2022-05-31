package com.example.demo.controller;

import com.example.demo.entity.Rider;
import com.example.demo.entity.Team;
import com.example.demo.repository.RiderRepository;
import com.example.demo.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RiderControllerTest {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;

  @BeforeEach
  void beforeEach(){
    Team team = new Team();
    team.setTeam_id("1");
    team.setTeam_name("TestTeam");
    teamRepository.save(team);

    Rider rider = new Rider();
    rider.setRider_id("1");
    rider.setRider_name("Hans");
    rider.setSprint_points(10);
    rider.setMountain_points(10);
    rider.setTotal_points(20);
    rider.setRider_time("1h20");
    riderRepository.save(rider);
  }

  @Test
  void getAllRiders() {
  }

  @Test
  void findRiderById() {
  }

  @Test
  void findRiderByTeamId() {
  }
}