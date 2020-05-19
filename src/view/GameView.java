package view;
import controller.GameController;
import entity.CellRender;
import javafx.concurrent.Task;
import javafx.scene.layout.GridPane;
import java.util.Random;
/**
 * @author 陌意随影
 * @create 2020-05-11 15:02
 * @desc 游戏视图
 **/
public class GameView extends GridPane {
    /**面板的大小*/
    private static final int WIDTH = 800;
    private  static  final  int HIGHT = 800;
    /**细胞二维数字的行和列数*/
    private  static  final  int row =10;
    private  static  final  int col= 10;
    /**每个细胞的宽和高*/
    int cellWith = WIDTH /row;
    int cellhight = HIGHT /col;
    /**游戏的控制类*/
    private GameController gameController = null;
    public  static  final  int DEFAULT_CIRCLETIME = 100;
    /**细胞周期*/
    private int circleTime = DEFAULT_CIRCLETIME;
    /**细胞的二维数组*/
    private  static CellRender[][]    cellRenders = new CellRender[row][col];
    public GameView() {
        //设置大小
        this.setPrefSize(WIDTH, HIGHT);
        this.gameController = new GameController();
        //细胞界面的初始化
       init();

    }
/**
 * @Description :细胞送生长
 * @Date 16:32 2020/5/15 0015
 * @Param * @param  ：
 * @return void
 **/
    public void grow() {
        for (int i = 0; i< cellRenders.length;i ++ ){
            for (int j = 0; j < cellRenders[0].length; j++) {
                //细胞任务线程开始启动
                new Thread(new CellTask(i,j)).start();
            }
        }
    }
  /**
   * @Description :初始化界面，并给细胞随机设置状态
   * @Date : 2020/5/15 0015
   * @Param * @param  ：
   * @return void
   **/
    private void init() {
        Random random = new Random();
        for (int i = 0; i< row;i ++ ){
            for (int j = 0; j < col; j++) {
                //使用随机生成数生成细胞的状态
                cellRenders[i][j]=new CellRender(cellWith,cellhight,random.nextInt(3)==1?CellRender.ALIVE:CellRender.DIEDED);
                //将细胞添加到面板中
                this.add(cellRenders[i][j],j,i);
            }
        }
    }
    /**
     * @Description :不断循环判断细是否死亡的任务
     * @Date 16:32 2020/5/15 0015
     * @Param * @param null ：
     * @return 
     **/
    class CellTask extends  Task{
        int row;
        int col;
        public  CellTask(int row, int col){
            this.row =row;
            this.col = col;
        }
        @Override
        protected Object call() throws Exception {
            while (true){
                boolean isAlive = gameController.isAliveControl(cellRenders, row, col);
                if (isAlive) {
                    //设置 细胞的状态
                    cellRenders[row][col].setIsAlive(CellRender.ALIVE);
                }else{
                    //设置细胞的状态
                    cellRenders[row][col].setIsAlive(CellRender.DIEDED);
                }
                Thread.sleep(circleTime);
                if ( 1 > 2){
                    //让程序一直循环
                    break;
                }
            }
            return null;
        }
    }
    public void setCircleTime(int circleTime) {
        this.circleTime = circleTime;
    }
}
