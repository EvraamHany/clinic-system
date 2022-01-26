package com.example.clinicsystem.table;

import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "patient", schema = "public")
public class Patient implements Serializable {

    @Id
    private Integer id;

    @Column(name = "name", columnDefinition = "TEXT")
    private String name;

}
