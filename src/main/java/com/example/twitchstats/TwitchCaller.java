package com.example.twitchstats;


public class TwitchCaller {

	public String getUpdatedStats() {

		String numberOfViewers;
		String somethingElse;

		// // Do REST call and get all info
		// Client client = ClientBuilder.newClient();
		// WebTarget webTarget = client.target("https://api.twitch.tv/kraken/streams/kajrhgkajsdnv");
		// Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
		// Response response = invocationBuilder.get();
		// JSONObject obj = new JSONObject(response.readEntity(String.class));
		//
		// // Extract the stats
		// if (!obj.isNull("stream")) {
		//
		// JSONObject stream = obj.getJSONObject("stream");
		//
		// // Get viewers
		// int viewers = stream.getInt("viewers");
		// numberOfViewers = Integer.toString(viewers);
		//
		// // Get Something Else
		//
		// } else {
		// return "No stream found!";
		// }
		//
		// client.close();

		// return numberOfViewers;

//		Random rand = new Random();
//
//		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
//		return String.valueOf(randomNum);
		
		return "Hej";
	}
}
