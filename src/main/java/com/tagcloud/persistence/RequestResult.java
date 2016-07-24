package com.tagcloud.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Tag result data class.
 * 
 * @author kkalmus
 */
@AllArgsConstructor
@Getter
public class RequestResult {

	private final String tag;
	private final String tagWord;
	private final long counts;

}