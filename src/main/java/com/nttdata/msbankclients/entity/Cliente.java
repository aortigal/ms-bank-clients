package com.nttdata.msbankclients.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero", nullable = false)
    private Integer clienteid;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "estado", nullable = false, length = 30)
    private boolean estado;
}
