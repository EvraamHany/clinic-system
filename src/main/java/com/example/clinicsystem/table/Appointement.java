package com.example.clinicsystem.table;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "appointement", schema = "public")
public class Appointement implements Serializable {

    @Id
    private Integer id;

    @Column(name = "date", columnDefinition = "TEXT")
    private String date;

    @Column(name = "patient")
    private Integer patientId;

    @Column(name = "status")
    private String status;

    @Column(name = "reason")
    private String reason;

}
