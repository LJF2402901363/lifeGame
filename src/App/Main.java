package App;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.MainGameView;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = new MainGameView();
        primaryStage.setTitle("生命游戏");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
