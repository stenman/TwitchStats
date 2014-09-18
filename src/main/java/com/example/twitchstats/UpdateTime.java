package com.example.twitchstats;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class UpdateTime {

	private static final DateTimeFormatter hhmmss = DateTimeFormatter.ofPattern("HH:mm:ss");

	private final ReadOnlyStringWrapper updateTime = new ReadOnlyStringWrapper();

	public void update() {
		updateTime.set(LocalTime.now().format(hhmmss));
	}

	public ReadOnlyStringProperty timeOfLatestUpdate() {
		return updateTime.getReadOnlyProperty();
	}
}
