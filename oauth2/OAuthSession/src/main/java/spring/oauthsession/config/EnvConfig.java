package spring.oauthsession.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    @PostConstruct
    public void loadEnv() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing() // .env 파일이 없으면 무시
                .load();

        System.setProperty("OAUTH_NAVER_CLIENT_ID", dotenv.get("OAUTH_NAVER_CLIENT_ID"));
        System.setProperty("OAUTH_NAVER_CLIENT_SECRET", dotenv.get("OAUTH_NAVER_CLIENT_SECRET"));
        System.setProperty("OAUTH_GOOGLE_CLIENT_ID", dotenv.get("OAUTH_GOOGLE_CLIENT_ID"));
        System.setProperty("OAUTH_GOOGLE_CLIENT_SECRET", dotenv.get("OAUTH_GOOGLE_CLIENT_SECRET"));
    }
}
