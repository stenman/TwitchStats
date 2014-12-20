package com.example.twitchstats;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TwitchStatsMain extends Application {

	private static Stats stats = new Stats();
	private static UpdateTime updateTime = new UpdateTime();
	private static ViewersLabel viewersLabel = new ViewersLabel(stats);
	private static UpdateTimeLabel updateTimeLabel = new UpdateTimeLabel(updateTime);
	private RandomExecutor executorTimer = new RandomExecutor(new Runnable() {
		@Override
		public void run() {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						stats.update();
						updateTime.update();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}, 5, 10);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Twitch Stats");

		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(viewersLabel);
		root.getChildren().add(updateTimeLabel);
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
