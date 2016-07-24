package com.tagcloud.persistence;

import lombok.Builder;
import lombok.Getter;

/**
 * Entry data class for request handler.
 * 
 * @author kkalmus
 */
@Builder
@Getter
public class TagcloudEntry {

	private String tag;
	private String tagWord;
	private long timestamp;
	
}