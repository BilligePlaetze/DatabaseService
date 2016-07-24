package com.tagcloud.persistence.repository;

/**
 * Data class for tagcloud data.
 * 
 * @author kkalmus
 */
public class TagcloudData {

	private Tag tag;
	private TagWord tagWord;
	private TagTime tagTime;

	public TagcloudData(Tag tag, TagWord tagWord, TagTime tagTime) {
		this.tag = tag;
		this.tagWord = tagWord;
		this.tagTime = tagTime;
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
	
	public TagTime getTagTime() {
		return tagTime;
	}
	public void setTagTime(TagTime tagTime) {
		this.tagTime = tagTime;
	}
	
}