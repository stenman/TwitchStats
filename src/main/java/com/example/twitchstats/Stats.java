package com.example.twitchstats;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class Stats {

	private TwitchCaller twitchCaller = new TwitchCaller();

	private final ReadOnlyStringWrapper numberOfViewers = new ReadOnlyStringWrapper(twitchCaller.getUpdatedStats());

	public Stats() {
	}

	public void update() {
		numberOfViewers.set(twitchCaller.getUpdatedStats());
	}

	public ReadOnlyStringProperty numberOfViewers() {
		return numberOfViewers.getReadOnlyProperty();
	}

}
