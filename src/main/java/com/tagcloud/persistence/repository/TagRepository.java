package com.tagcloud.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository for tags.
 * 
 * @author kkalmus
 */
public interface TagRepository extends CrudRepository<Tag, Long> {

	@Query("Select t "
			+ "FROM Tag t "
			+ "WHERE t.tag LIKE :tag")
	Tag findByTag(@Param("tag") String tag);

	@Query("Select t.tag "
			+ "From Tag t ")
	List<String> findAllTags();

}
