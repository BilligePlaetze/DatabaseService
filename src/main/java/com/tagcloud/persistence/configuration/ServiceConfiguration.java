package com.tagcloud.persistence.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.tagcloud.persistence.repository.TagRepository;
import com.tagcloud.persistence.repository.TagService;
import com.tagcloud.persistence.repository.TagTimeRepository;
import com.tagcloud.persistence.repository.TagWordRepository;

/**
 * Service configuration
 * 
 * @author kkalmus
 */
@Configuration
@PropertySource({"classpath:/context.properties"})
public class ServiceConfiguration {
	
	@Autowired TagRepository tagRepository;
	@Autowired TagWordRepository tagWordRepository;
	@Autowired TagTimeRepository tagTimeRepository;
	
	@Bean
    TagService tagService() {
    	return new TagService(tagRepository,
    						  tagWordRepository,
    						  tagTimeRepository);
    }
	
}