package mini.springboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 인증되지 않아도 모든 요청 허락
        http.authorizeHttpRequests().antMatchers("/**").permitAll()
                .and()
                // h2-console은 csrf 토큰을 발행하는 기능이 없기 때문에 예외 처리
                .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                // H2 콘솔 화면이 frame 구조로 작성되어 있고 스프링 시큐리티는 X-Frame-Options 헤더값을 사용해
                //  clickjacking 공격을 막기 때문에 h2화면이 깨져보임, 이를 위해 수정
                // URL 요청 시 X-Frame-Options 헤더 값을 sameorigin으로 주게 되면 frame에 포함된 페이지가
                //  페이지를 제공하는 사이트와 동일한 경우 계속 사용 가능
                .headers().addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN
                ));
        return http.build();
    }
}

