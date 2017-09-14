package ru.tkachenko.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tkachenko.app.db.entity.Car;
import ru.tkachenko.app.db.repository.CarRepository;

import java.sql.SQLException;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * @author Dmitry Tkachenko
 *         14.09.17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class ApplicationTest {

    @Autowired
    private CarRepository repository;

    @Test
    public void testInsertAndFindData() throws SQLException {
        final Car car = new Car();
        car.setId(null);
        car.setDescription("desc");
        repository.save(car);
        final Car foundCar = repository.findOne(car.getId());

        assertNotNull(foundCar);
        assertEquals(car, foundCar);
    }
}