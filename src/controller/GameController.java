package controller;
import service.GameService;
import entity.CellRender;
/**
 * @author 陌意随影
 * @create 2020-05-11 22:14
 * @desc 游戏控制器
 **/
public class GameController {
    GameService gameService = new GameService();
    /**
     * @Param * @param cellRenders：所有的细胞的二维数组
     * @param row ：第row行
     * @param col ：第col列
     * @return boolean：返回细胞活着（true），死亡（false）
     * @Description :
     * 1.如果细胞的周围有3活着的个细胞则该细胞活着。
     * 2.如果有两个活着的细胞，则该细胞的状态不变，原来死亡的还是死亡，活着的还是活着。
     * 3.其它情况下该细胞军事死亡。
     * @Date 19:53 2020/5/11 0011
     **/
    public  boolean isAliveControl(CellRender[][] cellRenders,int row,int col){
        return  gameService.isAlive(cellRenders,row,col);
    }

}
