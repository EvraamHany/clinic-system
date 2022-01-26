package com.example.clinicsystem.table;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "patient", schema = "public")
public class Patient implements Serializable {

    @Id
    private Integer id;

    @Column(name = "name", columnDefinition = "TEXT")
    private String name;

}
