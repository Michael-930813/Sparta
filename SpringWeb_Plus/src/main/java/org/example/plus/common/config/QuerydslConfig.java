package org.example.plus.common.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuerydslConfig {
// - Properties
    @PersistenceContext
    private EntityManager em;

// - Methods
    @Bean
    public JPAQueryFactory jpaQeuryFactory() {
        return new JPAQueryFactory(em);
    }
}
