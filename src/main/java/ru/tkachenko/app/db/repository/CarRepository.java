package ru.tkachenko.app.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tkachenko.app.db.entity.Car;

/**
 * @author Dmitry Tkachenko
 *         14.09.17
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}
