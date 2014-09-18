package com.example.twitchstats;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import javafx.application.Platform;

public class ExecutorTimer {

	private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	private static final long POLL_FREQUENZY = 3;

	public ExecutorTimer(Stats stats) {

		executor.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							stats.updateStats();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}, 0, POLL_FREQUENZY, TimeUnit.SECONDS);
	}

	public void shutdown() {
		executor.shutdown();
	}
}
