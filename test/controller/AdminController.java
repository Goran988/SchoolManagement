package controller;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.school.config.RootConfig;
import org.school.config.WebConfig;
import org.school.dao.interfaces.AdminInterface;
import org.school.dao.interfaces.StudentInterface;

@RunWith(MockitoJUnitRunner.class)
public class AdminController {

	@Mock
	private AdminInterface adminImpl;
	@Mock
	private StudentInterface studentImpl;
}
