package com.tagcloud.persistence.repository;

import java.util.List;
import java.util.Vector;

import org.springframework.data.domain.PageRequest;

/**
 * Service for querying repositories.
 * 
 * @author kkalmus
 */
public class TagService {

	private TagRepository tagRepository;
	private TagWordRepository tagWordRepository;
	private TagTimeRepository tagTimeRepository;
	
	public TagService(TagRepository tagRepository,
					  TagWordRepository tagWordRepository,
					  TagTimeRepository tagTimeRepository) {
		this.tagRepository = tagRepository;
		this.tagWordRepository = tagWordRepository;
		this.tagTimeRepository = tagTimeRepository;
	}
	
	public void save(TagTime tagTime) {
		tagTimeRepository.save(tagTime);
	}
	
	public List<String> findAllTags() {
		return tagRepository.findAllTags();
	}
	
	public Tag findTag(String tag) {
		return tagRepository.findByTag(tag);
	}

	public TagWord findTagWord(Long idTagWord) {
		return tagWordRepository.findOne(idTagWord);
	}
	
	public TagWord findTagWord(String tagWord) {
		return tagWordRepository.findObjectByTagWord(tagWord);
	}
	
	public TagTime tagTimeFactory(String tag, 
								  String tagWord,
								  long timestamp) {
		Tag creatingTag = findTag(tag);
		if(creatingTag == null) {
			creatingTag = new Tag(tag);
			tagRepository.save(creatingTag);
		}
		TagWord creatingTagWord = findTagWord(tagWord);
		if(creatingTagWord == null) {
			creatingTagWord = new TagWord(tagWord);
			tagWordRepository.save(creatingTagWord);
		}
		
		return new TagTime(creatingTag, creatingTagWord, timestamp);
	}

	public Vector<Object[]> findeTagTimesByTag(String tag, int limit) {
		PageRequest page = new PageRequest(0, limit);
		return tagTimeRepository.findTagTimesByTag(tag, page);
	}
	
	public Vector<Object[]> findeTagTimesByTag(String tag) {
		return tagTimeRepository.findTagTimesByTag(tag);
	}
	
	public Vector<Object[]> findTagTimesByTagAndDuration(String tag, long from, long to, int limit) {
		PageRequest page = new PageRequest(0, limit);
		return tagTimeRepository.findTagTimesByTagAndDuration(tag, from, to, page);
	}

	public Vector<Object[]> findTagTimesByTagAndDuration(String tag, long from, long to) {
		return tagTimeRepository.findTagTimesByTagAndDuration(tag, from, to);
	}

}