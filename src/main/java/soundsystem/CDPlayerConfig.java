package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.cds.SgtPeppers;

@Configuration
public class CDPlayerConfig {

	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}

	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
		CDPlayer cdPlayer = new CDPlayer(compactDisc);
		cdPlayer.setCompactDisc(compactDisc);
		return cdPlayer;
	}


}
