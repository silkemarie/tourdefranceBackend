package com.example.demo.repository;

import com.example.demo.entity.TourTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourTeamRepository extends JpaRepository<TourTeam, String> {

  Optional<TourTeam> findTourTeamByTeamId(TourTeam tourTeam); //slet?

  Optional<TourTeam> findTourTeamByName(String teamName);

  Optional<TourTeam> findByTeamId(String teamId);
}
