package com.example.clinicsystem.controller;

import com.example.clinicsystem.exception.ResourceNotFoundException;
import com.example.clinicsystem.repo.AppointmentRepo;
import com.example.clinicsystem.table.Appointement;
import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class clinicController {

    @Autowired
    private AppointmentRepo appointmentRepo;


    @GetMapping("/appointements/{date}")
    public ResponseEntity<List<Appointement>> getAppintementsbyDate(@PathVariable String date){
        List<Appointement> appointements =  appointmentRepo.findByDate(date);
        return ResponseEntity.ok().body(appointements);
    }

    @GetMapping("/patients/appointements/{patientId}")
    public ResponseEntity<List<Appointement>> getAppointementsbyPatient(@PathVariable Integer patientId){
        List<Appointement> appointements =  appointmentRepo.findByPatientId(patientId);
        return ResponseEntity.ok().body(appointements);
    }

    @PostMapping("/appointement")
    public ResponseEntity<Response> createAppointement(@RequestBody Appointement appointement){
        Appointement createdAppointement = appointmentRepo.save(appointement);
        if (appointement!=null){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/appointement/{appointementId}")
    public ResponseEntity<Response> updateAppointement(@PathVariable Integer appointementId, @RequestBody Appointement appointement)
        throws ResourceNotFoundException {
        if(appointmentRepo.findById(appointementId).isPresent()) {
            Appointement createdAppointement = appointmentRepo.save(appointement);
            if (appointement != null) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

}
