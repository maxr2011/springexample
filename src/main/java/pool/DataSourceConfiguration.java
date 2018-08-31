package pool;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

	@Bean
	public BasicDataSource dataSource() {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("org.postgresql.Driver");
			ds.setUrl("jdbc:postgresql://localhost/exercise");
			ds.setUsername("mare");
			ds.setPassword("toor");
			ds.setMaxActive(10);
			return ds;
	}

}
