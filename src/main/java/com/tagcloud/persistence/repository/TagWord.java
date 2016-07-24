package com.tagcloud.persistence.repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Tag word data class.
 * 
 * @author kkalmus
 */
@Entity
@Table(name = "TagWord")
public class TagWord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTagWord")
	private Long idTagWord;
	
	@Column(name = "tagWord")
	private String tagWord;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL, mappedBy="tagWord", targetEntity=TagTime.class)
	private TagTime tagTime;

	public TagWord() { }
	
	public TagWord(String tagWord) {
		this.tagWord = tagWord;
	}
	
    public Long getIdTagWord() {
		return idTagWord;
	}
	public void setIdTagWord(Long idTagWord) {
		this.idTagWord = idTagWord;
	}
    
    public String getTagWord() {
		return tagWord;
	}
	public void setTagWord(String tagWord) {
		this.tagWord = tagWord;
	}
	
	public TagTime getTagTime() {
		return tagTime;
	}
	public void setTagTime(TagTime tagTime) {
		this.tagTime = tagTime;
	}
	
}