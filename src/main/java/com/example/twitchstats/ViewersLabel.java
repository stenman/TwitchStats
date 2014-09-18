package com.example.twitchstats;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;

public class ViewersLabel extends Label {

	public ViewersLabel(final Stats stats) {
		textProperty().bind(Bindings.format("Viewers: %s", stats.numberOfViewers()));
	}
}
