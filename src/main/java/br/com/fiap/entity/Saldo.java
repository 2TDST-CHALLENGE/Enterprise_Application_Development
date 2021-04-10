package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Table(name = "SALDO")
public class Saldo {

    @Column(name = "SALDO", nullable = false)
    private double saldo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SALDO", nullable = false)
    private Calendar dataSaldo;

}
