package com.java.keep;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.keep.model.User;
import com.java.keep.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
class KeepDemoNewApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

//	@Test
//	public void whenFindByName_thenReturnEmployee() {
//		User kalpesh = new User("kalpesh");
//		entityManager.persist(kalpesh);
//		entityManager.flush();
//
//		// when
//		Kalpesh found = userRepository.findByName(kalpesh.getName());
//
//		// then
//		assertThat(found.getName()).isEqualTo(kalpesh.getName());
//	}
//
//	@Test
//	void contextLoads() {
//	}

}
