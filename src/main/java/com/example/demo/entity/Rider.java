package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Rider {

  @Id
  @Column(name = "rider_id")
  private String riderId;
  private String riderName;
  private int sprintPoints;
  private int mountainPoints;
  private int totalPoints;
  private String time;
  private int age;

  @ManyToOne
  @JoinColumn(name = "team_id")
  @JsonBackReference
  private TourTeam tourTeam;

  public String getRiderId() {
    return riderId;
  }

  public void setRiderId(String riderId) {
    this.riderId = riderId;
  }

  public String getRiderName() {
    return riderName;
  }

  public void setRiderName(String riderName) {
    this.riderName = riderName;
  }

  public int getSprintPoints() {
    return sprintPoints;
  }

  public void setSprintPoints(int sprintPoints) {
    this.sprintPoints = sprintPoints;
  }

  public int getMountainPoints() {
    return mountainPoints;
  }

  public void setMountainPoints(int mountainPoints) {
    this.mountainPoints = mountainPoints;
  }

  public int getTotalPoints() {
    return totalPoints;
  }

  public void setTotalPoints(int totalPoints) {
    this.totalPoints = totalPoints;
  }

  public TourTeam getTourTeam() {
    return tourTeam;
  }

  public void setTourTeam(TourTeam tourTeam) {
    this.tourTeam = tourTeam;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Rider{" +
        "riderId=" + riderId +
        ", riderName='" + riderName + '\'' +
        ", sprintPoints=" + sprintPoints +
        ", mountainPoints=" + mountainPoints +
        ", totalPoints=" + totalPoints +
        ", tourTeam=" + tourTeam +
        '}';
  }

}
