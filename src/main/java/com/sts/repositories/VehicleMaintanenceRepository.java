package com.sts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.models.Client;
import com.sts.models.VehicleMaintenance;

@Repository
public interface VehicleMaintanenceRepository extends JpaRepository<VehicleMaintenance, Integer> {

}
