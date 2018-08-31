package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.cds.SgtPeppers;

@Configuration
public class CDConfig {

	@Bean
	public CompactDisc compactDisc() {
		return new SgtPeppers();
	}

}
