Tagcloud persistence project

For lookup and include data use RequestHandler.

Example:

/*
	public static void main(String[] args) {
		
		String tag = "Karlsruhe";
		String tagWord = "Pokemon Go";
		long timestamp = 123412341237l;
		Long fromTimestamp = null;
		Long toTimestamp = null;
		
		RequestHandler handler = RequestHandler.getInstance();

		// insert into db example
		TagcloudEntry entry = TagcloudEntry.builder() //
		.tag(tag) //
		.tagWord(tagWord)//
		.timestamp(timestamp) //
		.build();
		
  		handler.insert(entry);
		
		TagcloudRequest request = new TagcloudRequest(tag, fromTimestamp, toTimestamp);
		
		try {
			List<RequestResult> results = handler.requestRepository(request);
			for(RequestResult result : results) {
				System.out.println(result.getTag());
				System.out.println(result.getTagWord());
				System.out.println(result.getCounts());
				System.out.println("\n");
			}
		} catch (UnsupportedRequestException e) {
			e.printStackTrace();
		}
		
	}
*/