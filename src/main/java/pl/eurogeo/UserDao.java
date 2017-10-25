<<<<<<< HEAD
package pl.eurogeo;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
	User findByUserName(String userName);
	

}
=======
package pl.eurogeo;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
	User findByUserName(String userName);
	

}
>>>>>>> 76125fe7be162450faf5de35c419081e5ca577f9
