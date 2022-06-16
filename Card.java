import java.awt.*;
public class Card{
   
   int health;
   int damage;
   
   public Card(){
   
   }
   //Draws this card on the board
   public void drawCard(Graphics pen, int col, int roh, int cw, int cl){
   
      pen.setColor(Color.WHITE);
      pen.fillRect(col, roh, cw, cl);

   }
   public void turn(Card[][] boardSlots, int row, int colum){
   }
}