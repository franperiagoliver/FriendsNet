package com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class DozerConfiguration.
 */
@Configuration
public class DozerConfiguration {

    /**
     * Define mapper bean.
     *
     * @return the mapper
     */
    @Bean
    public Mapper defineMapperBean() {
        return new DozerBeanMapper();
    }

}
