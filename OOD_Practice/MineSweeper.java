package ood_disign;

import java.util.Random;
@author Xiaohua Cao
public class MineSweeper {
    /*表示一个棋盘*/
    int m = 5;
    int n = 5;
    // create random object
   // Random random = new Random();
    int bombs = (int)(0.2 * m * n);
    private char[][] pan = new char[m][n];
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1},{1, 1}};
    private Random random = new Random();//一个随机变量，主要用来制定哪些位置为雷
    private int BomNum = 0;//统计地雷总数
    /*游戏是否结束*/
    private boolean GameOver;
    /*接下来就是初始化地图，地图首先要扔个雷在上面，不然怎么叫扫雷呢。接下来是遍历一遍地图*/
    /*初始化数组，生成地图*/
    public void InitArray(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                pan[i][j] = ' ';
            }
        }
        RandomArray();
        CountBomb();
        BomNum = Bomb();
    }
    /*统计地雷总数*/
    private int Bomb(){
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pan[i][j] == '*'){
                    count++;
                }
            }
        }
        return count;

    }

    //随机决定地雷得位置
    private void RandomArray(){
        int i, j, k;
        //先扔15个左右地雷，这里不一定有15个，因为随机可能重复

       while(bombs > 0){
          // System.out.println("bombs= " + bombs);
           k = random.nextInt(m * n);
          // System.out.println("k = " + k);
           i = k / m;
           j = k % n;
           if(pan[i][j] != '*'){
               pan[i][j] = '*'; //指定该位置为雷
               bombs--;
           }
       }
    }
    /*统计棋盘上得数据*/
    private void CountBomb(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pan[i][j] == '*'){
                    continue;
                }
                int count = 0;;
                for(int k = 0; k < 8; k++){
                    int newX = dir[k][0] + i;
                    int newY = dir[k][1] + j;
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                        continue;
                    }
                    else if(pan[newX][newY] == '*'){
                        count++;
                    }
                }
                //System.out.println(count);
                if(count != 0){
                    pan[i][j] = (char) (count + '0');
                }


            }
        }
    }
    private void printPan(){
        for(int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(pan[i][j] + " ");

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        MineSweeper test = new MineSweeper();
        //initailiz array
        test.InitArray();
        //place bombs
        test.RandomArray();
        test. CountBomb();
        test.printPan();

        test.Bomb();
        System.out.println("the number of bombs are : " + test.Bomb());


    }
}
