<<<<<<< HEAD
package pl.eurogeo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;




public interface NadgodzinyDao extends CrudRepository<Nadgodziny, Long> {
Nadgodziny findByDay(LocalDate day);
Nadgodziny findByUser(String userName);
Nadgodziny findByDayAndUser(LocalDate day, String userName);

List<Nadgodziny> findByUwagi(String uwagi);

List<Nadgodziny> findByMonth(int month);
}
=======
package pl.eurogeo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;




public interface NadgodzinyDao extends CrudRepository<Nadgodziny, Long> {
Nadgodziny findByDay(LocalDate day);
Nadgodziny findByUser(String userName);
Nadgodziny findByDayAndUser(LocalDate day, String userName);

List<Nadgodziny> findByUwagi(String uwagi);

List<Nadgodziny> findByMonth(int month);
}
>>>>>>> 76125fe7be162450faf5de35c419081e5ca577f9
