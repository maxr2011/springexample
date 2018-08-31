package pool;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {

	public static void main(String[] args) {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/exercise");
		ds.setUsername("mare");
		ds.setPassword("toor");

		if(ds == null){
			System.out.println("ist null!");
		} else {
			System.out.println("nicht null");
		}

	}

}
