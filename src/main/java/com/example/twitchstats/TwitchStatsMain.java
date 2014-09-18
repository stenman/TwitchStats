package com.example.twitchstats;

import java.util.Set;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TwitchStatsMain extends Application {

	// TODO: 1. updated x seconds ago or last update: hhmmss
	// TODO: 2. javafx on close (full terminate)

	private static Stats stats = new Stats();
	private ExecutorTimer executorTimer = new ExecutorTimer(stats);
	private static ViewersLabel viewersLabel = new ViewersLabel(stats);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Twitch Stats");

		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(viewersLabel);
		root.setStyle("-fx-background-color: cornsilk; -fx-padding: 20; -fx-font-size: 20;");
		primaryStage.setScene(new Scene(root, 300, 100));
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent arg0) {
				executorTimer.shutdown();
			}
		});
	}

}
