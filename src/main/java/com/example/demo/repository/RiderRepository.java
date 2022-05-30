package com.example.demo.repository;

import com.example.demo.entity.Rider;
import com.example.demo.entity.TourTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiderRepository extends JpaRepository<Rider, String> {

  Optional<Rider> findRiderByName(String riderName);

  Optional<Rider> findRiderById(String riderId); //lav om til int?

  List<Rider> findRiderByTeam(String teamId);


  /*
  List<Rider> findRiderByGree

  find ryttere på:
  - team
  - point
  - grøn trøje
  - gul trøje
  - hvid trøje
  - prikket trøje
   */
}
