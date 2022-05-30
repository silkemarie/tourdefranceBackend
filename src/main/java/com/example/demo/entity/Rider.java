package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Rider {

  @Id
  //@Column(name="riderId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="riderId")
  private String rider_id;
  private String rider_name;
  private int sprint_points;
  private int mountain_points;
  private int total_points;
  private String rider_time;
  private int rider_age;

  @ManyToOne
  @JoinColumn(name="fk_team_id")
  @JsonBackReference
  private Team team;

  public Rider(String rider_id, String rider_name, int sprint_points, int mountain_points, int total_points, String rider_time, int rider_age, Team team) {
    this.rider_id = rider_id;
    this.rider_name = rider_name;
    this.sprint_points = sprint_points;
    this.mountain_points = mountain_points;
    this.total_points = total_points;
    this.rider_time = rider_time;
    this.rider_age = rider_age;
    this.team = team;
  }

  public Rider() {
  }

  public String getRider_id() {
    return rider_id;
  }

  public void setRider_id(String rider_id) {
    this.rider_id = rider_id;
  }

  public String getRider_name() {
    return rider_name;
  }

  public void setRider_name(String rider_name) {
    this.rider_name = rider_name;
  }

  public int getSprint_points() {
    return sprint_points;
  }

  public void setSprint_points(int sprint_points) {
    this.sprint_points = sprint_points;
  }

  public int getMountain_points() {
    return mountain_points;
  }

  public void setMountain_points(int mountain_points) {
    this.mountain_points = mountain_points;
  }

  public int getTotal_points() {
    return total_points;
  }

  public void setTotal_points(int total_points) {
    this.total_points = total_points;
  }

  public String getRider_time() {
    return rider_time;
  }

  public void setRider_time(String rider_time) {
    this.rider_time = rider_time;
  }

  public int getRider_age() {
    return rider_age;
  }

  public void setRider_age(int rider_age) {
    this.rider_age = rider_age;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }
}
