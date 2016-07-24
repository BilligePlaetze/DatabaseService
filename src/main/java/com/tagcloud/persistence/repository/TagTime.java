package com.tagcloud.persistence.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Tag time data class.
 * 
 * @author kkalmus
 */
@Entity
@Table(name = "TagTime")
public class TagTime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTagTime")
	private Long idTagTime;

	@OneToOne(optional=false)
	private Tag tag;

	@OneToOne(optional=false)
	private TagWord tagWord;
	
	@Column(name = "timestamp")
	private long timestamp;
	
	public TagTime() { }
	
	public TagTime(Tag tag, TagWord tagWord, long timesamp) {
		this.tag = tag;
		this.tagWord = tagWord;
		this.timestamp = timesamp;
	}
	
	public Long getIdTagTime() {
		return idTagTime;
	}
	public void setIdTagTime(Long idTagTime) {
		this.idTagTime = idTagTime;
	}

	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	public TagWord getTagWord() {
		return tagWord;
	}
	public void setTagWord(TagWord tagWord) {
		this.tagWord = tagWord;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}