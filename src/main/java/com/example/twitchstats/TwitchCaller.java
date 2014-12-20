package com.example.twitchstats;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class TwitchCaller {

	private static final String streamName = "NameOfTheStream";

	public String getUpdatedStats() {

		String numberOfViewers;

		// // Do REST call and get all info
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("https://api.twitch.tv/kraken/streams/" + streamName);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
		Response response = invocationBuilder.get();
		JSONObject obj = new JSONObject(response.readEntity(String.class));

		// Extract the stats
		if (!obj.isNull("stream")) {

			JSONObject stream = obj.getJSONObject("stream");

			// Get viewers
			int viewers = stream.getInt("viewers");
			numberOfViewers = Integer.toString(viewers);

		} else {
			return "No stream found!";
		}

		client.close();

		return numberOfViewers;
	}
}
