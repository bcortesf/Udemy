package com.bcf.arquitectura.Post.infraestructure.outbound.database.Oracle.entitys;

//import jakarta.persistence.*;
import lombok.Data;

//@Entity
//@Table(name = "post")
@Data
public class PostEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String body;
}
