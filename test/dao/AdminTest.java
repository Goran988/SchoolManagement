package dao;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.school.dao.interfaces.AdminInterface;
import static org.mockito.Mockito.atLeastOnce;
import org.school.model.Admin;

@RunWith(MockitoJUnitRunner.class)
public class AdminTest {
	@Mock
	AdminInterface adminInterface;

	private Admin admin;
	private String username;
	private long id = 1L;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		admin = new Admin();
		username = "username";
	}

	@Test
	public void saveAdmin() {
		Mockito.when(adminInterface.save(admin)).thenReturn(admin);
		assertEquals(admin, adminInterface.save(admin));

	}

	@Test
	public void getUserByUsername() {
		Mockito.when(adminInterface.getAdminByUsername(username)).thenReturn(admin);
		assertEquals(admin, adminInterface.getAdminByUsername(username));
	}

	@Test
	public void getUserById() {
		Mockito.when(adminInterface.get(id)).thenReturn(admin);
		assertEquals(admin, adminInterface.get(id));
	}
	@Test
	public void deleteAdmin() {
		adminInterface.delete(admin);
		Mockito.verify(adminInterface, atLeastOnce()).delete(admin);
	}
}
