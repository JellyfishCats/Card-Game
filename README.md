# Card-Game
My AP CSE Final Project. Somewhat unfinished, but does compile and run with little issue. 
I did not achive the my plan for this project. This program draws a 3 by 4 grid board for a board game, asks the user for what size the game board should be, giving options 1, 2, or 3 (if another integer that is not 1, 2 or 3 is inputted size will be set to 1). It also asks the user what length (number of turns) the game should be, this feature is not fully implemented. The game plays for 10 turns and then stops. 
The game is played in turns, with the player controling a Card labeled player and inputting comands to move it on the board. 2 Enemy Cards are also on placed on the board and move in random directions every turn. Their is also a player hand that fills ups with cards as turns go on. This feature is not fully implemented. 
The player moves by inputing positive or negative numbers when prompted.
Notable issues are: 
  The Enemy cards sometimes move 2 or more spaces, this happens because the program does enemy moves by going slot by slot down the board from the   top, so if an enemy moves further down the board or to the right they will do another turn. 
  If the player enters anything other than a integer for the size, the program breaks.
