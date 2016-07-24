package com.tagcloud.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tagcloud.persistence.configuration.BasicMySqlDataSourceConfiguration;
import com.tagcloud.persistence.configuration.JpaConfiguration;
import com.tagcloud.persistence.configuration.ServiceConfiguration;
import com.tagcloud.persistence.exception.UnsupportedRequestException;
import com.tagcloud.persistence.repository.Tag;
import com.tagcloud.persistence.repository.TagService;
import com.tagcloud.persistence.repository.TagTime;
import com.tagcloud.persistence.repository.TagWord;

/**
 * Handler for requests.
 * 
 * @author kkalmus
 */
public class RequestHandler {

	private static RequestHandler instance;
	
	private AnnotationConfigApplicationContext context;
	private TagService service;
	
	private RequestHandler() { 
		service = open();
	}
	
	public static RequestHandler getInstance() {
		if(RequestHandler.instance == null) {
			RequestHandler.instance = new RequestHandler();
		}
		return RequestHandler.instance;
	}
	
	public TagService open() {
		 context = new AnnotationConfigApplicationContext(BasicMySqlDataSourceConfiguration.class, 
														  JpaConfiguration.class,
														  ServiceConfiguration.class);
		 return context.getBean(TagService.class);
	}
	
	public void close() {
		context.close();
	}
	
	public void insert(TagcloudEntry entry) {
		service.save(service.tagTimeFactory(entry.getTag(), entry.getTagWord(), entry.getTimestamp()));
	}

	public List<String> findAllLabels() {
		return service.findAllTags();
	}
	
	public List<RequestResult> requestRepository(TagcloudRequest tRequest) throws UnsupportedRequestException {
		if(tRequest.getTag() == null) {
			throw new UnsupportedRequestException("Label must be set.");
		}
		if(tRequest.isDurationRequest()) {
			List<RequestResult> results = requestForDuration(tRequest);
			return results;
		} 
		List<RequestResult> results = requestAll(tRequest);
		return results;
	}
	
	public List<RequestResult> requestAll(TagcloudRequest tRequest) {
		List<RequestResult> results = new ArrayList<>();
		Vector<Object[]> vegges;
		if(tRequest.getLimit() == null) {
			vegges = service.findeTagTimesByTag(tRequest.getTag());
		} else {
			vegges = service.findeTagTimesByTag(tRequest.getTag(), tRequest.getLimit());
		}
		for(Object[] object : vegges) {
			TagTime t = (TagTime) object[0];
			RequestResult reuslt = new RequestResult(t.getTag().getTag(),
													 t.getTagWord().getTagWord(),
													 (long) object[1]);
			results.add(reuslt);
		}
		return results;
	}
	
	public RequestResult createRequestResult(Tag tag, TagWord tagWord, Long counts) {
		return new RequestResult(tag.getTag(), tagWord.getTagWord(), counts);
	}

	public List<RequestResult> requestForDuration(TagcloudRequest tRequest) {
		Vector<Object[]> vegges;
		if(tRequest.getLimit() == null) {
			vegges = service.findTagTimesByTagAndDuration(tRequest.getTag(),
														  tRequest.getFromTimestamp(),
														  tRequest.getToTimestamp());
		} else {
			vegges = service.findTagTimesByTagAndDuration(tRequest.getTag(),
														  tRequest.getFromTimestamp(),
														  tRequest.getToTimestamp(),
														  tRequest.getLimit());
		}
		List<RequestResult> results = new ArrayList<>();
		TagTime t;
		RequestResult result;
		for(Object[] object : vegges) {
			t = (TagTime) object[0];
			result = new RequestResult(t.getTag().getTag(),
					 				   t.getTagWord().getTagWord(),
					 				   (long) object[1]);
			results.add(result);
		}
		return results;
	}
		
}