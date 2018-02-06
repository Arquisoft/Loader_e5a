package dbupdate;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Test;

import com.lowagie.text.DocumentException;

import executer.ActionSingleton;
import model.User;
import persistence.UserFinder;
import persistence.util.Jpa;

public class TestDb {

	@Test
	public void usuarioYaExistenteIdentificador() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		User user1 = new User("Fernando Perez Menendez", "", "ferpm@gmail.com", "87654321P", 1);
		User user2 = new User("Fernando Perez Menendez", "", "ferpm@gmail.com", "87654321P", 1);
		
		aS.getAF().saveData(user1);
		aS.getAF().saveData(user2);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<User> test = UserFinder.findByIdentificador("87654321P");
		assertEquals(test.get(0).getEmail(), "ferpm@gmail.com");

		trx.commit();
		mapper.close();
	}

	@Test
	public void usuarioYaExistenteEmail() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		Date date = new Date(System.currentTimeMillis());
		User user1 = new User("Sensor temperatura S1", "43,36&-5,85", "francisco@gmail.com", "ST1", 3);
		User user3 = new User("Sensor temperatura S1", "43,36&-5,85", "francisco@gmail.com", "ST1", 3);
		
		aS.getAF().saveData(user1);
		aS.getAF().saveData(user3);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<User> test = UserFinder.findByEmail("francisco@gmail.com");
		assertEquals(test.get(0).getIdentificador(), "87654321P");

		trx.commit();
		mapper.close();

	}

	@After
	public void deleting() {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		List<User> aBorrar = UserFinder.findByDNI("87654321P");
		Jpa.getManager().remove(aBorrar.get(0));
		trx.commit();
		mapper.close();
	}

}
