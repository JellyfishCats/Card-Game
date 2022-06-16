import java.util.*;
import java.awt.*;
public class EnemyCard extends Card{
   
   public EnemyCard(int h, int d){
   
   super.health = h;
   super.damage = d;
   
   }
   //Draws this card on the board
   public void drawCard(Graphics pen, int col, int roh, int cw, int cl){

      pen.setColor(Color.RED);
      pen.fillRect(col, roh, cw, cl);
      pen.setColor(Color.WHITE);
      pen.fillRect(col + 5, roh + 5, cw - 10, cl - (cl / 2));
      pen.setColor(Color.BLACK);
      pen.drawString("ENEMY", col + 20, roh + 25);
   }
   //Attacks a specified card
   public void attack(Card c1){
      c1.health = c1.health - this.damage;
   }
   public void turn(Card[][] boardSlots, int row, int colum){
      Random rand = new Random(); //Creates Random Generator   
      boolean activeTurn = true;
      while(activeTurn){
         int up = rand.nextInt(3) - 1;
         int over = rand.nextInt(3) - 1;
         if(row + up <= 3 && colum + over <= 2 && row + up >= 0 && colum + over >= 0 && boardSlots[row + up][colum + over] == null){
            boardSlots[row + up][colum + over] = boardSlots[row][colum];
            boardSlots[row][colum] = null;
            activeTurn = false;
         }
      }
   }
}