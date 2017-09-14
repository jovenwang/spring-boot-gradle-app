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
@SpringBootTest(classes = Application.class)
// works without "(classes = Application.class)"
class ApplicationGroovyTest extends Specification {

    @Autowired
    private CarRepository repository;

    def "spring context loads for data jpa slice"() {
        given: "some existing car"
        def mcc = new Car(id: null, description: "desc")

        when:
        repository.save(mcc)
        def foundMcc = repository.findOne(mcc.getId())

        then:
        foundMcc.description == mcc.description
    }
}
