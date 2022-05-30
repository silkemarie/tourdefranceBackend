package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TourTeam {

  @Id
  @Column(name="team_id")
  private String teamId;
  private String teamName;

  @OneToMany
  @JoinColumn(name="team_id")
  private Set<TourTeam> tourteams = new HashSet<>();

  public String getTeamId() {
    return teamId;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public Set<TourTeam> getTourteams() {
    return tourteams;
  }

  public void setTourteams(Set<TourTeam> tourteams) {
    this.tourteams = tourteams;
  }

  @Override
  public String toString() {
    return "TourTeam{" +
        "teamId='" + teamId + '\'' +
        ", teamName='" + teamName + '\'' +
        ", tourteams=" + tourteams +
        '}';
  }
}
