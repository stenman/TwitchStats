package com.example.twitchstats;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomExecutor implements Runnable {
	private static final Random rand = new Random();
	private Runnable runnable;
	private int minSleep;
	private int maxSleep;

	private ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

	public RandomExecutor(Runnable runnable, int minSleep, int maxSleep) {
		this.runnable = runnable;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		ses.execute(this);
	}

	@Override
	public void run() {
		int randomNum = rand.nextInt((maxSleep - minSleep) + 1) + minSleep;
		runnable.run();
		ses.schedule(this, randomNum, TimeUnit.SECONDS);
	}

	public void shutdown() {
		System.out.println("shutdown");
		ses.shutdown();
	}

}
