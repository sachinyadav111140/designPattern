import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public DatabaseService databaseService() {
        return new DatabaseService();
    }
}

//Bean is bydefault singleton in springboot here we are creating a bean of DatabaseService class
