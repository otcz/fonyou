package com.fonyou.fonyou.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "nombre")
    @Getter
    @Setter
    private String sNombre;

    @Column(name = "apellido")
    @Getter
    @Setter
    private String sApellidos;

    @Column(name = "email")
    @Getter
    @Setter
    private String sEmail;

    @Column(name = "password")
    @Getter
    @Setter
    private String sPassword;


}
