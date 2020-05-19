package view;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * @author 陌意随影
 * @create 2020-05-17 14:01
 * @desc 主程序窗口
 **/
public class MainGameView extends VBox {
    private GameView gameView = null;
    private HBox    hBox = null;
    private ComboBox<Integer> circleTime = null;
    private Button startBtn = null;
    private  static  Integer[] time = new Integer[]{
          100,200,300,400,500,600,700,900,1000
        };
    public MainGameView() {
        this.gameView = new GameView();
        this.hBox=new HBox();
        this.startBtn = new Button("开始");
        this.circleTime = new ComboBox<Integer>(FXCollections.observableArrayList(time));
         initConponents();
         initEvent();
        this.getChildren().addAll(gameView,hBox);
    }

    private void initEvent() {
        //给开始按钮添加点击事件
        this.startBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameView.grow();
            }
        });
        //给细胞周期选择添加点击事件
        this.circleTime.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Integer selectedItem = circleTime.getSelectionModel().getSelectedItem();
                System.out.println(selectedItem);
                gameView.setCircleTime(selectedItem);
            }
        });
    }

    private void initConponents() {
        Label circleTimeText = new Label("细胞周期");
        hBox.setPrefHeight(200);
        this.hBox.getChildren().addAll(circleTimeText,circleTime,startBtn);
        circleTimeText.setPrefHeight(30);
        circleTimeText.setStyle("-fx-font-size: 16");
        circleTimeText.setPadding(new Insets(0,10,0,0));
        circleTime.setPrefHeight(30);
        this.circleTime.getSelectionModel().select(0);
        hBox.setAlignment(Pos.CENTER);
    }
}
