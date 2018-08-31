package pool_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

@Repository
public class Main {

	private static final String SQL_INSERT = "INSERT INTO test (id, name) VALUES (?, ?)";

	private DataSource dataSource;

	@Autowired
	public Main(DataSource ds) {
		this.dataSource = ds; this.addPerson();
	}



	public void addPerson(){

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setInt(1, 10);
			stmt.setString(2, "Bernd");
			stmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {

			try {
				if(stmt != null) stmt.close();
				if (conn != null) {
					conn.close();
				} else {
					System.out.println("Connection ist null :/");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

		Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);

		DataSource dsc = (DataSource) ac.getBean("dataSourceJDBC");

		new Main(dsc);

	}

}
