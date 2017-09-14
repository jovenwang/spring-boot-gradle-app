package ru.tkachenko.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.tkachenko.app.db.entity.Car
import ru.tkachenko.app.db.repository.CarRepository
import spock.lang.Specification

/**
 * @author Dmitry Tkachenko
 * 14.09.17
 */
@SpringBootTest
class ApplicationGroovyTest extends Specification {

    @Autowired
    private CarRepository repository;

    def "remove all Mcc from database"() {
        given:
        repository.deleteAll()
        when:
        List<Car> allCars = repository.findAll()
        then:
        allCars.isEmpty()
    }

    def "insert and find Car to/in database"() {
        given: "some existing car"
        def mcc = new Car(id: null, description: "desc")

        when:
        repository.save(mcc)
        def foundMcc = repository.findOne(mcc.getId())

        then:
        foundMcc.description == mcc.description
    }
}
