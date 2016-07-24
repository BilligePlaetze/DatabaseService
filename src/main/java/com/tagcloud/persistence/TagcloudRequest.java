package com.tagcloud.persistence;

import com.tagcloud.persistence.exception.UnsupportedRequestException;

import lombok.Builder;
import lombok.Getter;

/**
 * Tagcloud request data class.
 * 
 * @author kkalmus
 */
@Builder
@Getter
public class TagcloudRequest {

	private final String tag;
	private final Long fromTimestamp;
	private final Long toTimestamp;
	private final Integer limit;
	
	public boolean isDurationRequest() throws UnsupportedRequestException {
		if(fromTimestamp != null && toTimestamp != null) {
			return true;
		}
		if(fromTimestamp == null && toTimestamp == null) {
			return false;
		}
		throw new UnsupportedRequestException("For duration-request from- and toTimestamp are required.");
	}
	
}		