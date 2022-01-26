package com.example.clinicsystem.repo;

import com.example.clinicsystem.table.Appointement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointement, Integer> {

    List<Appointement> findByDate(String date);
    List<Appointement> findByPatientId(Integer patientId);
}
