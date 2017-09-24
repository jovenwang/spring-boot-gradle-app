package ru.tkachenko.app.db.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Dmitry Tkachenko
 *         14.09.17
 */
@Entity
@Table(name = "BEST_CAR_TAB")
@SequenceGenerator(name = "bestCarGen", sequenceName = "BEST_CAR_SEQ", allocationSize = 1)
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bestCarGen")
    @Column(name = "CAR_ID")
    private Long id;

    private String description;
}
