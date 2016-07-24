package com.tagcloud.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Tag word repository.
 * 
 * @author kkalmus
 */
public interface TagWordRepository extends CrudRepository<TagWord, Long> {

	List<TagWord> findByTagWord(String tagWord);

	@Query("SELECT t.idTagWord "
			+ "FROM TagWord t "
			+ "WHERE t.tagWord = :tagWord ")
	Long findIdByTagWord(@Param("tagWord") String tagWord);
	
	@Query("SELECT t "
			+ "FROM TagWord t "
			+ "WHERE t.tagWord = :tagWord ")
	TagWord findObjectByTagWord(@Param("tagWord") String tagWord);
	
}