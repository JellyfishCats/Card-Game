import java.awt.*;
public class Board{
   
   Card[][] boardSlots = new Card[4][3];
   Card[] hand = new Card[4];
   int playerHealth;
   
   public Board(int pH){
   
      playerHealth = pH;
   
   }
   //Updates the board
   public void updateBoard(DrawingPanel panel, int size){
      int w;
      int l;
      int cw;
      int cl;
      if (size == 3){
         w = 500;
         l = 1085; //length of just the board: 853
         cw = 133;
         cl = 182;
      } else if(size == 2) {
         w = 400;
         l = 875; //length of just the board: 671
         cw = 100;
         cl = 136;
      } else {
         w = 300;
         l = 630; //length of just the board: 489
         cw = 67;
         cl = 91;
      }
      panel.setSize(w, l);
      Graphics pen = panel.getGraphics();
      pen.setColor(Color.GRAY);
      pen.fillRect(20, 20, w - 40, l - cl - 50 - 40); //Draws gray Rectangle
      enemyTurn();
      for(int row = 1; row <= 4; row++){ //Scans the board and draws Cards
         int roh = (25 * row) + (cl * (row - 1));
         for(int colum = 1; colum <= 3; colum++){
            int col = (25 * colum) + (cw * (colum - 1)); 
            if (boardSlots[row - 1][colum - 1] != null){
               Card c1 = boardSlots[row - 1][colum - 1];
               c1.drawCard(pen, col, roh, cw, cl); //Draws the Card
            } else {
               pen.setColor(Color.GRAY);
               pen.fillRect(col, roh , cw, cl);
               pen.setColor(Color.BLUE);
               pen.drawRect(col, roh , cw, cl);
            }
         }
      }   
      for(int colum = 1; colum <= 4; colum++){ //Draws the Hand
         int col = (7 * colum) + (cw * (colum - 1)); 
         if (hand[colum - 1] != null){
            Card c1 = hand[colum - 1];
            c1.drawCard(pen, col, 150 + (cl * 4), cw, cl); //Draws the Cards in the inventory
         } else {
            pen.setColor(Color.BLUE);
            pen.drawRect(col, 150 + (cl * 4), cw, cl);
         }
      }
      for(int n = 0; n <= playerHealth; n++){ //Draws the Player Health
    
         //pen.setColor(Color.RED);
         //pen.drawOval();
      
      }
   }
   //Fills a slot with a card
   public void fillSlot(Card c1, int row, int colum){
      boardSlots[row][colum] = c1;
   }
   //Fills a Hands slot with a card
   public void fillHand(Card c1){
      for(int i = 0; i < hand.length; i++){
         if(hand [i] == null){
            hand[i] = c1;
            i = hand.length;
         }
      }
   }
   //Plays a Card from the Hand onto the board
   public void playCard(int handSlot, int boardRow, int boardColum){
      boardSlots[boardRow][boardColum] = hand[handSlot];
      hand[handSlot] = null;
   }
   //Does all the enemie cards turns
   public void enemyTurn(){
      for(int row = 1; row <= 4; row++){ //Scans the board and does the Enemies actions
         for(int colum = 1; colum <= 3; colum++){ 
            if (boardSlots[row - 1][colum - 1] instanceof EnemyCard){
               Card c1 = boardSlots[row - 1][colum - 1];
               c1.turn(boardSlots, row - 1, colum - 1);
            }
         }
      }
   }
   //Moves a specified card
   public void moveCard(Card c1, int over, int up){
      for(int row = 0; row <= 3; row++){
         for(int colum = 0; colum <= 2; colum++){
            if (boardSlots[row][colum] == c1){
               if(row + up <= 3 && colum + over <= 2 && row + up >= 0 && colum + over >= 0 && boardSlots[row + up][colum + over] == null){
                  boardSlots[row + up][colum + over] = c1;
                  boardSlots[row][colum] = null;
                  row = 4;
                  colum = 3;
               } else{
                  System.out.println("That move is invalid");
               }
            }
         }
      }
   
   }

}