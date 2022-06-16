import java.awt.*;
public class ActionCard extends PlayerCard{
   
      
   public ActionCard(){
   
      
   
   }
   //Draws this card on the board
   public void drawCard(Graphics pen, int col, int roh, int cw, int cl){

      pen.setColor(Color.GREEN);
      pen.fillRect(col, roh, cw, cl);
      pen.setColor(Color.WHITE);
      pen.fillRect(col + 5, roh + 5, cw - 10, cl - (cl / 2));
      pen.setColor(Color.BLACK);
      pen.drawString("Action", col + 25, roh + 25);
   }
}