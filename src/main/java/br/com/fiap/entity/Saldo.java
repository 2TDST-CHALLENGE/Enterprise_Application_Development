package br.com.fiap.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "SALDO")
public class Saldo {

    @Column(name = "SALDO", nullable = false)
    private double saldo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SALDO", nullable = false)
    private Calendar dataSaldo;

}
