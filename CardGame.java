import java.util.*;
import java.awt.*;

public class CardGame {

   public static void main(String[] args){
      Scanner console = new Scanner(System.in);      
      Board mainBoard = new Board(5); //Creates a board Object
      System.out.println("Game Size 1, 2, or 3?");
      int size = console.nextInt();
      DrawingPanel panel = new DrawingPanel(500, 500); //Creates the drawing panel that serves as the board
      mainBoard.updateBoard(panel, size);
      System.out.println("Game length Short, Medium, or Long?");
      String length = console.next();
      int turns = 10;
      EnemyCard testC = new EnemyCard(3, 3);
      EnemyCard testE = new EnemyCard(3, 3);
      PlayerCard testB = new PlayerCard();
      ActionCard testP = new ActionCard();
      mainBoard.fillSlot(testB, 2, 1);
      mainBoard.fillSlot(testE, 1, 1);
      mainBoard.fillSlot(testC, 0, 1);
      while(turns > 0){ //Runs the turns
         mainBoard.updateBoard(panel, size);
         System.out.println("up?");
         int up = console.nextInt();
         System.out.println("over?");
         int over = console.nextInt();
         mainBoard.moveCard(testB, over, up);
         turns--;
         mainBoard.fillHand(testP);
      }   
   }
}