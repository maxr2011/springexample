package pool;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= DataSourceConfiguration.class)
public class DataSourceTest {

	@Autowired
	private BasicDataSource bds;

	@Test
	public void bdsShouldNotBeNull(){
		assertNotNull(bds);
	}

}
