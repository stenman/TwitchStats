package com.example.twitchstats;

import java.time.LocalTime;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;

public class UpdateTimeLabel extends Label {

	public UpdateTimeLabel(final UpdateTime updateTime) {
		textProperty().bind(Bindings.format("Last Update: %s\n", updateTime.timeOfLatestUpdate()));
	}
}