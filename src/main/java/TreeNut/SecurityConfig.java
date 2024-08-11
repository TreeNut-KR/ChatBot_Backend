package TreeNut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/login**", "/css/**", "/js/**").permitAll() // 로그인 페이지와 정적 리소스는 허용
                    .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
            )
            .oauth2Login(oauth2Login ->
                oauth2Login
                    .loginPage("/login")  // 커스텀 로그인 페이지 설정
                    .defaultSuccessUrl("/", true)  // 로그인 성공 시 리디렉션할 URL
                    .failureUrl("/login?error=true")  // 로그인 실패 시 리디렉션할 URL
            );
        
        return http.build();
    }
}
