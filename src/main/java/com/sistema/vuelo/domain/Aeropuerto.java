package com.sistema.vuelo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Aeropuerto.
 */
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "codigo", nullable = false, unique = true)
    private Integer codigo;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @NotNull
    @Column(name = "pais", nullable = false)
    private String pais;

    @ManyToMany(mappedBy = "aeropuertos")
    @JsonIgnore
    private Set<Avion> avions = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "aeropuertos", allowSetters = true)
    private Programavuelo programavuelo;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Aeropuerto codigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Aeropuerto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Aeropuerto ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Aeropuerto pais(String pais) {
        this.pais = pais;
        return this;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Avion> getAvions() {
        return avions;
    }

    public Aeropuerto avions(Set<Avion> avions) {
        this.avions = avions;
        return this;
    }

    public Aeropuerto addAvion(Avion avion) {
        this.avions.add(avion);
        avion.getAeropuertos().add(this);
        return this;
    }

    public Aeropuerto removeAvion(Avion avion) {
        this.avions.remove(avion);
        avion.getAeropuertos().remove(this);
        return this;
    }

    public void setAvions(Set<Avion> avions) {
        this.avions = avions;
    }

    public Programavuelo getProgramavuelo() {
        return programavuelo;
    }

    public Aeropuerto programavuelo(Programavuelo programavuelo) {
        this.programavuelo = programavuelo;
        return this;
    }

    public void setProgramavuelo(Programavuelo programavuelo) {
        this.programavuelo = programavuelo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Aeropuerto)) {
            return false;
        }
        return id != null && id.equals(((Aeropuerto) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Aeropuerto{" +
            "id=" + getId() +
            ", codigo=" + getCodigo() +
            ", nombre='" + getNombre() + "'" +
            ", ciudad='" + getCiudad() + "'" +
            ", pais='" + getPais() + "'" +
            "}";
    }
}
