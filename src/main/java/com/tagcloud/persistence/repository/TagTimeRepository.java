package com.tagcloud.persistence.repository;

import java.util.Vector;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository for tag time.
 * 
 * @author kkalmus
 */
public interface TagTimeRepository extends CrudRepository<TagTime, Long> {

	@Query("SELECT t, COUNT(b.idTagWord) AS counts "
			+ "FROM TagTime t "
			+ "JOIN t.tag a "
			+ "JOIN t.tagWord b "
			+ "WHERE a.tag LIKE :tag "
			+ "GROUP BY b.idTagWord "
			+ "ORDER BY counts DESC ")
	Vector<Object[]> findTagTimesByTag(@Param("tag") String tag);

	@Query("SELECT t, COUNT(b.idTagWord) AS counts "
			+ "FROM TagTime t "
			+ "JOIN t.tag a "
			+ "JOIN t.tagWord b "
			+ "WHERE a.tag LIKE :tag "
			+ "GROUP BY b.idTagWord "
			+ "ORDER BY counts DESC ")
	Vector<Object[]> findTagTimesByTag(@Param("tag") String tag, Pageable pageable);

	@Query("SELECT t, COUNT(b.idTagWord) AS counts "
			+ "FROM TagTime t "
			+ "JOIN t.tag a "
			+ "JOIN t.tagWord b "
			+ "WHERE a.tag LIKE :tag "
			+ "AND t.timestamp >= :from "
			+ "AND t.timestamp <= :to "
			+ "GROUP BY b.idTagWord "
			+ "ORDER BY counts DESC ")
	Vector<Object[]> findTagTimesByTagAndDuration(@Param("tag") String tag,
												  @Param("from") long from,
												  @Param("to") long to);
	
	@Query("SELECT t, COUNT(b.idTagWord) AS counts "
			+ "FROM TagTime t "
			+ "JOIN t.tag a "
			+ "JOIN t.tagWord b "
			+ "WHERE a.tag LIKE :tag "
			+ "AND t.timestamp >= :from "
			+ "AND t.timestamp <= :to "
			+ "GROUP BY b.idTagWord "
			+ "ORDER BY counts DESC ")
	Vector<Object[]> findTagTimesByTagAndDuration(@Param("tag") String tag,
												  @Param("from") long from,
												  @Param("to") long to,
												  Pageable pageable);

}