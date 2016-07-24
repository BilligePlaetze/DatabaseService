package com.tagcloud.persistence;

import java.util.List;

import com.tagcloud.persistence.exception.UnsupportedRequestException;

/**
 * Not to use!
 * Just a example for querying and insert data.
 * 
 * @author kkalmus
 */
public class TagPersistence {
	
	public static void main(String[] args) {
		
		String tag = "Karlsruhe";
//		String tagWord = "Pokemon GO";
//		long timestamp = 123413l;
		Long fromTimestamp = null;
		Long toTimestamp = null;
		Integer limit = null;
		
		RequestHandler handler = RequestHandler.getInstance();

		// insert into db example
//		TagcloudEntry entry = TagcloudEntry.builder() //
//		.tag(tag) //
//		.tagWord(tagWord)//
//		.timestamp(timestamp) //
//		.build();
//		
//		handler.insert(entry);
		
		TagcloudRequest request = new TagcloudRequest(tag, fromTimestamp, toTimestamp, limit);
		
		try {
			List<RequestResult> results = handler.requestRepository(request);
			for(RequestResult result : results) {
				System.out.println("\n");
				System.out.println(result.getTag());
				System.out.println(result.getTagWord());
				System.out.println(result.getCounts());
			}
		} catch (UnsupportedRequestException e) {
			e.printStackTrace();
		}
		
	}
	
}