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
 * Tag data class.
 * 
 * @author kkalmus
 */
@Entity(name = "Tag")
@Table(name = "Tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTag")
	private Long idTag;
	
	@Column(name = "tag")
	private String tag;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL, mappedBy="tag", targetEntity=TagTime.class)
	private TagTime tagTime;
	
	public Tag() { }
	
	public Tag(String tag) {
		this.tag = tag;
	}

    public Long getIdTag() {
		return idTag;
	}
	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}
    
    public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public TagTime getTagTime() {
		return tagTime;
	}
	public void setTagTime(TagTime tagTime) {
		this.tagTime = tagTime;
	}
    
	public boolean isEmpty() {
		if(idTag == null) {
			return true;
		}
		if(tag.isEmpty()) {
			return true;
		}
		return false;
	}
	
}