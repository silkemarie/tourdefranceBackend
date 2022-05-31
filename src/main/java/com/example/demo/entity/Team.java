package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

  @Id
  //@Column(name="teamId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="teamId")
  private String team_id;
  private String team_name;

  @OneToMany
  @JoinColumn(name="fk_team_id")
  private List<Rider> riders;

  public void addRiders(Rider rider) {
    this.riders.add(rider);
  }

  public String getTeam_id() {
    return team_id;
  }

  public void setTeam_id(String team_id) {
    this.team_id = team_id;
  }

  public String getTeam_name() {
    return team_name;
  }

  public void setTeam_name(String team_name) {
    this.team_name = team_name;
  }

  public List<Rider> getRiders() {
    return riders;
  }

  public void setRiders(List<Rider> riders) {
    this.riders = riders;
  }
}
