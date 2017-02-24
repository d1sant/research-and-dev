package com.my.research.and.dev.jfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Pages extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Pagination root = new Pagination(urls.length, 0);

        root.setPageFactory(new Callback<Integer, Node>() {
            // This method will be called every time user clicks on page button
            public Node call(final Integer pageIndex) {
                final Label content = new Label("Please, wait");
                content.setWrapText(true);
                StackPane box = new StackPane();
                box.getChildren().add(content);

                // here we starts long operation in another thread
                new Thread() {
                    String result;
                    public void run() {

                        try {
                            URL url = new URL(urls[pageIndex]);
                            URLConnection urlConnection = url.openConnection();
                            urlConnection.setConnectTimeout(1000);
                            urlConnection.setReadTimeout(1000);
                            BufferedReader breader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                            StringBuilder stringBuilder = new StringBuilder();

                            String line;
                            while ((line = breader.readLine()) != null) {
                                stringBuilder.append(line);
                            }

                            result = stringBuilder.toString();
                        } catch (Exception ex) {
                            result = "Download failed";
                        }

                        // once operation is finished we update UI with results
                        Platform.runLater(new Runnable() {

                            @Override
                            public void run() {
                                content.setText(result);
                            }
                        });
                    }
                }.start();

                return box;
            }
        });

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Pages!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private final static String[] urls = {"http://oracle.com", "http://stackoverflow.com", "http://stackexchange~.com", "http://google.com", "http://javafx.com"};

    public static void main(String[] args) {
        launch(args);
    }
}
