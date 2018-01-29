/*
*   Created by : Rhyder Quinlan & Roland Stojkoski
*
*   Description : Program that mimics the game Battleship
*
*/

/**
 *
 * @author Rhyder Quinlan & Roland Stojkoski
 * Upon planning it was decided that Roland Stojkoski would focus mainly on the Battleship objects.
 *  Of course co-operation and combinations of code work were required.
 */

import java.util.*;
import java.io.*;

public class battleship {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        String p1Name = "";
        String p2Name = "";
        char xTemp = 0, yTemp = 0;//Current input coordinates
        char input = menu(true);//Call menu function and take in the input
        int check = 0;//Check is it a hit, miss...
        int turn = 1; //Either 1 or 2 (Player 1 or Player 2)
        boolean wrongInput = true;//If in the menu there is a wrong input, menu is printed again
        
        
        while(wrongInput == true){
            wrongInput = false;
            //If the player has pressed [b] to begin the game
            if(input == 'b'){
                //Start the game code;
                
                //Setup the grids and take in the names
                lines();
                System.out.print("Insert your name (P1) : ");
                p1Name=in.nextLine();
                System.out.println();
                player1.setShipGrid(p1Name);
                //player1.getShipPosition();
                System.out.print("Press enter to continue ");
                in.nextLine();
                lines();
                System.out.print("Insert your name (P2) : ");
                p2Name=in.nextLine();
                System.out.println();
                player2.setShipGrid(p2Name);
                //player2.getShipPosition();
                System.out.print("Press enter to continue ");
                in.nextLine();
                lines();
                
                gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                
            }//if input [b] statement closed
            else if (input == 'l')
            {
                //Load method;
                turn = load(player1,player2);
                gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
            }
            else if (input == 'q')
            {
                System.out.println("\nThank you for playing Battle for Griffith!\n\nWe hope we will see you again.\n\nGoodbye.\n\nHave a nice day.\n");
            }else
            {
                System.out.println("You have inserted the wrong character, try again.\n");
                input = in.nextLine().charAt(0);
                wrongInput = true;
            }
        }//while wrong input loop closed
    }//main function closed
    
    public static char menu(boolean intro){
        /*
        *
        *   Method that prints menu system and waits for input
        *
        *   It takes in boolean input that decides if the menu is intro/start menu or pause menu
        *
        *   intro = true ==|> intro/start menu ; intro = false ==|> pause menu
        *
        */
        
        Scanner in = new Scanner(System.in);
        char select = '.';
        
        if(intro == true){
            System.out.println("      ___  ____ ___ ___ _    ____ \n" +
                    "      |__] |__|  |   |  |    |___ \n" +
                    "      |__] |  |  |   |  |___ |___ \n" +
                    "                                  \n" +
                    "      ____ ____ ____ \n" +
                    "      |___ |  | |__/ \n" +
                    "      |    |__| |  \\ \n" +
                    "                     \n" +
                    "      ____ ____ _ ____ ____ _ ___ _  _ \n" +
                    "      | __ |__/ | |___ |___ |  |  |__| \n" +
                    "      |__] |  \\ | |    |    |  |  |  | \n" +
                    "                                       \n" +
                    "         _~        _      __|__ |___| |\\        \n" +
                    "      _~ )_)_~    / o     |o__| |___| | \\       \n" +
                    "      )_))_))_)          _|___| |___| |__o\\     \n" +
                    "      _!__!__!_         /...\\_____|___|____\\_/  \n" +
                    "      \\______t/         \\   o * o * * o o  /     \n" +
                    "      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("+--------------------------------------------------+\n" +
                    "|                                                  |\n" + 
                    "|      Welcome to Battle For Griffith!             |\n" +
                    "|                                                  |\n" +
                    "|      A game that mimics the classical            |\n" +
                    "|                                                  |\n" +
                    "|      battleship game. If you havent't heard      |\n" +
                    "|                                                  |\n" +
                    "|      about battleship, let me explain:           |\n" +
                    "|                                                  |\n" +
                    "|      Battleship is a two player game. Where      |\n" +
                    "|                                                  |\n" +
                    "|      each player will be presented 2 boards.     |\n" +
                    "|                                                  |\n" +
                    "|      One board represents the 'hits and misses'  |\n" +
                    "|                                                  |\n" +
                    "|      that you do, and the other                  |\n" +
                    "|                                                  |\n" +
                    "|      displays the placement of your own ships    |\n" +
                    "|                                                  |\n" +
                    "|      with your opponents moves (hits & misses).  |\n" +
                    "|                                                  |\n" +
                    "|      Each board is a 10x10 grid with co-ordinates|\n" +
                    "|                                                  |\n" +
                    "|      to specify the targeting of your missiles.  |\n" +
                    "|                                                  |\n" +
                    "|      It is a turn based game where users will    |\n" +
                    "|                                                  |\n" +
                    "|      enter the taget (x,y co-ordinates)          |\n" +
                    "|                                                  |\n" +
                    "|      Good Luck!                                  |\n" +
                    "+--------------------------------------------------+\n" +
                    "\n" +
                    "   Press:\n\n" +
                    "   o (b) to begin\n\n" +
                    "   o (l) to load the game\n\n" +
                    "   o (q) to quit\n\n");
            System.out.print("   Then press enter/return : ");
            select = in.nextLine().charAt(0);
            System.out.println();
        } else if (intro == false) {
            System.out.println("\n   Game Paused ||\n\n" +
                    "   Press : \n\n" +
                    "   o (c) to continue\n\n" +
                    "   o (s) to save the game\n\n" +
                    "   o (l) to load the game\n\n" +
                    "   o (q) to quit the game\n\n");
            System.out.print("   Then press enter/return : ");
            select = in.nextLine().charAt(0);
            System.out.println();
        }
        return select;
    }
    
    public static void lines(){
        /*
        *
        *   Method that simply prints out 100 empty lines to the console for the game purposes
        *
        */
        for(int i = 0; i<=100; i++){
            System.out.println();
        }
    }
    
    public static void save(int[][] p1Board, int[][] p2Board, int[][] p1Hits, int[][] p2Hits, int turn){
        /*
        *
        *   Method that saves the current state of game to a txt file
        *
        */
        
        PrintWriter outFile = null;
        Scanner in = new Scanner(System.in);
        File folder = new File("save");//Change this if directory changed
        File[] listOfFiles = folder.listFiles();//Array of files in the save folder
        
        lines();//First print out 100 lines for the clarity purposes
        System.out.println("   Current saved files : \n");
        
        //List the current files in the save folder
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println("   "+listOfFiles[i].getName().substring(0,(listOfFiles[i].getName().length()-4))+ "\n");
        }
        
        System.out.println("   (If you want to overwrite the save just\ninsert the same name as the existing one)");
        
        //Ask for the name of new save
        System.out.print("   Insert the name of the save : ");
        String fileToSave = in.nextLine(); //  Name of the file that will be saved
        System.out.println();
        
        try {
            outFile = new PrintWriter(new FileWriter("save/" + fileToSave + ".txt", false)); // Change this if the directory changed
            arraySaveToFile(p1Board,p2Board,p1Hits,p2Hits,outFile,turn);
            outFile.close();
        } catch (IOException e) {
            System.out.println("   There is an error because of : " + e.getMessage());
        }
    }
    
    public static void arraySaveToFile(int[][] p1Board,int[][] p2Board,int[][] p1Hits, int[][] p2Hits, PrintWriter outFile, int turn){   
        int[][] tempBoard;
        int[][] tempHits;
        
        for(int i = 0; i<2;i++){
            if(i==0){
                tempBoard = p1Board;
                tempHits = p1Hits;
            }else{
                tempBoard = p2Board;
                tempHits = p2Hits;
            }
            for(int row = 0;row<tempBoard.length;row++){
                for(int col = 0;col<tempBoard[row].length;col++){
                        if(col<9){
                            outFile.print(tempBoard[row][col]);
                        }else{
                            outFile.print(tempBoard[row][col]+"|");
                        }
                }
                        outFile.println();
            }
            for(int row = 0;row<tempHits.length;row++){
                for(int col = 0;col<tempHits[row].length;col++){
                        if(col<9){
                            outFile.print(tempHits[row][col]);
                        }else{
                            outFile.print(tempHits[row][col]+"|");
                        }
                }
                outFile.println();
            }
        }
        outFile.println(turn);
    }
    
    public static int load(Player player1, Player player2){
        Scanner in = new Scanner(System.in);
        File folder = new File("save");//Change this if directory changed
        File[] listOfFiles = folder.listFiles();//Array of files in the save folder
        Scanner inFile;
        String input = "";
        String tempFile = "";
        int[][] tempP1B = new int[10][10];
        int[][] tempP1H = new int[10][10];
        int[][] tempP2B = new int[10][10];
        int[][] tempP2H = new int[10][10];
        boolean exists = false;
        String tempLine = "";
        int turn = 0;
        int counter = 0;
        
        System.out.println("   Current saved files : \n");
        
        //List the current files in the save folder
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println("   "+listOfFiles[i].getName().substring(0,(listOfFiles[i].getName().length()-4))+ "\n");
        }
        
        System.out.print("   Choose a file : ");
        input = in.nextLine();
        System.out.println();
        for(int i = 0; i<listOfFiles.length;i++){
            tempFile = listOfFiles[i].getName().substring(0,(listOfFiles[i].getName().length()-4));
            if(tempFile.equals(input)){
                exists = true;
                break;
            }else{
                exists = false;
            }
        }
        while(exists==false){
            System.out.println("You file does not exist. Try again.\n");
            input = in.nextLine();
            System.out.println();
            for(int i = 0; i<listOfFiles.length;i++){
                tempFile = listOfFiles[i].getName().substring(0,(listOfFiles[i].getName().length()-4));
                if(tempFile.equals(input)){
                    exists = true;
                    break;
                }else{
                    exists = false;
                }
            }
        }
        try{
            inFile = new Scanner(new File("save/" + input + ".txt"));
            while(inFile.hasNextLine()){
                tempLine = inFile.nextLine();
                if(counter>=0 && counter <=9){
                    for(int j = 0; j<10;j++){
                            tempP1B[counter][j] = tempLine.charAt(j)-48;
                    }
                } else if(counter>9 && counter <=19){
                    for(int j = 0; j<10;j++){
                            tempP1H[counter-10][j] = tempLine.charAt(j)-48;
                    }
                } else if(counter>19 && counter <=29){
                    for(int j = 0; j<10;j++){
                            tempP2B[counter-20][j] = tempLine.charAt(j)-48;
                    }
                } else if(counter>29 && counter <=39){
                    for(int j = 0; j<10;j++){
                            tempP2H[counter-30][j] = tempLine.charAt(j)-48;
                    }
                } else{
                    turn = tempLine.charAt(0)-48;
                    player1.loadShipGrid(tempP1B);
                    player1.loadHitGrid(tempP1H);
                    player2.loadShipGrid(tempP2B);
                    player2.loadHitGrid(tempP2H);
                }
                counter++;
            }
            inFile.close();
        }catch(IOException e){
            e.getMessage();
        }
        
        return turn;
    }
    
    public static void gameLoop(int turn, String p1Name, String p2Name, Player player1, Player player2, char xTemp, char yTemp, int check){
        boolean invalid = true;
        Scanner in = new Scanner(System.in);
        //Game loop
                while(player1.gameOver()==false && player2.gameOver()==false){
                    boolean wrongInput = true;
                    //Player 1 turn
                    if(turn==1){
                        System.out.print("Player 1 are you ready?\n\nPress enter to continue ");
                        in.nextLine();
                        lines();
                        System.out.println("\nIt's Player 1's turn : \n");
                        System.out.println("\nHIT GRID\n");
                        player1.printHitGrid();
                        System.out.print("Insert the X-coordinate\n\n(or press p for PAUSE menu) : ");
                        xTemp = in.nextLine().charAt(0);
                        System.out.println();
                        
                        //If player has pressed p for PAUSE menu
                        if(xTemp == 'p'){
                            char pauseChar = '.';
                            while(wrongInput == true){
                                pauseChar = menu(false);
                                if(pauseChar == 's'){
                                    save(player1.getShipGrid(),player2.getShipGrid(),player1.getHitGrid(),player2.getHitGrid(),turn);
                                    wrongInput = false;
                                }
                                else if(pauseChar == 'l')
                                {
                                    turn = load(player1,player2); 
                                    wrongInput = false;                               
                                }
                                else if(pauseChar == 'c')
                                {
                                    gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                                    wrongInput = false;
                                }else if(pauseChar == 'q'){
                                    System.out.println("\nThank you for playing Battle for Griffith!\n\nWe hope we will see you again.\n\nGoodbye.\n\nHave a nice day.\n");
                                    break;
                                }
                                else
                                {
                                    System.out.println("You have inserted wrong input, try again!");
                                    wrongInput = false;
                                }
                            }
                            if(pauseChar == 'q'){
                            break;
                            }
                            gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                        }
                        
                        
                        System.out.print("Insert the Y-coordinate\n\n(or press p for PAUSE menu) : ");
                        yTemp = in.nextLine().charAt(0);
                        System.out.println();
                        
                        //If player has pressed p for PAUSE menu
                        if(yTemp == 'p'){
                            char pauseChar = '.';
                            while(wrongInput == true){
                                pauseChar = menu(false);
                                if(pauseChar == 's'){
                                    save(player1.getShipGrid(),player2.getShipGrid(),player1.getHitGrid(),player2.getHitGrid(),turn);
                                    wrongInput = false;
                                }
                                else if(pauseChar == 'l')
                                {
                                    turn = load(player1,player2); 
                                    wrongInput = false;                               
                                }
                                else if(pauseChar == 'c')
                                {
                                    gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                                    wrongInput = false;
                                }else if(pauseChar == 'q'){
                                    System.out.println("\nThank you for playing Battle for Griffith!\n\nWe hope we will see you again.\n\nGoodbye.\n\nHave a nice day.\n");
                                    break;
                                }
                                else
                                {
                                    System.out.println("You have inserted wrong input, try again!");
                                    wrongInput = false;
                                }
                            }
                            if(pauseChar == 'q'){
                            break;
                            }
                            gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                        }
                        
                        check = player2.setTurn(xTemp-48,yTemp-48);
                        if(check == 2){
                            player1.setHitGrid(xTemp-48,yTemp-48,1);
                            //player1.checkHit(xTemp, yTemp);
                        }
                        else if(check == 3)
                        {
                            player1.setHitGrid(xTemp-48,yTemp-48,2);
                        }
                        else if(check == 4 || check==5)
                        {
                            while(player2.setTurn(xTemp-48,yTemp-48) == 4 || player2.setTurn(xTemp-48,yTemp-48) == 5){
                                System.out.print("Insert the X-coordinate\n\n(or press p for PAUSE menu) : ");
                                xTemp = in.nextLine().charAt(0);
                                System.out.print("Insert the Y-coordinate\n\n(or press p for PAUSE menu) : ");
                                yTemp = in.nextLine().charAt(0);
                            }
                        }
                        System.out.println("\nHIT GRID\n");
                        player1.printHitGrid();
                        System.out.println("SHIP GRID\n");
                        player1.printShipGrid();
                        System.out.print("\nPress enter to continue ");
                        in.nextLine();
                        lines();
                        turn = 2;
                    }
                    
                    if(player1.gameOver()==true){
                        System.out.println("\nGAME OVER!!!");
                        System.out.println("\nPlayer 2 has won!");
                        System.out.println("\nPress ENTER/RETURN to end the game.\n");
                        in.nextLine();
                        break;
                    }else if(player2.gameOver()==true){
                        System.out.println("\nGAME OVER!!!");
                        System.out.println("\nPlayer 1 has won!");
                        System.out.println("\nPress ENTER/RETURN to end the game.\n");
                        in.nextLine();
                        break;
                    }
                    
                    //Player 2 turn
                    if(turn==2){
                        System.out.print("Player 2 are you ready?\n\nPress enter to continue ");
                        in.nextLine();
                        lines();
                        System.out.println("\nIt's Player 2's turn : \n");
                        System.out.println("\nHIT GRID");
                        player2.printHitGrid();
                        System.out.print("Insert the X-coordinate\n\n(or press p for PAUSE menu) : ");
                        xTemp = in.nextLine().charAt(0);
                        System.out.println();
                        
                        //Pause method
                        if(xTemp == 'p'){
                            char pauseChar = '.';
                            while(wrongInput == true){
                                pauseChar = menu(false);
                                if(pauseChar == 's'){
                                    save(player1.getShipGrid(),player2.getShipGrid(),player1.getHitGrid(),player2.getHitGrid(),turn);
                                    wrongInput = false;
                                }
                                else if(pauseChar == 'l')
                                {
                                    turn = load(player1,player2); 
                                    wrongInput = false;                               
                                }
                                else if(pauseChar == 'c')
                                {
                                    gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                                    wrongInput = false;
                                }else if(pauseChar == 'q'){
                                    System.out.println("\nThank you for playing Battle for Griffith!\n\nWe hope we will see you again.\n\nGoodbye.\n\nHave a nice day.\n");
                                    break;
                                }
                                else
                                {
                                    System.out.println("You have inserted wrong input, try again!");
                                    wrongInput = false;
                                }
                            }
                            if(pauseChar == 'q'){
                            break;
                            }
                            gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                        }
                        
                        System.out.print("Insert the Y-coordinate\n\n(or press p for PAUSE menu) : ");
                        yTemp = in.nextLine().charAt(0);
                        System.out.println();
                        
                        //Pause method
                        if(yTemp == 'p'){
                            char pauseChar = '.';
                            while(wrongInput == true){
                                pauseChar = menu(false);
                                if(pauseChar == 's'){
                                    save(player1.getShipGrid(),player2.getShipGrid(),player1.getHitGrid(),player2.getHitGrid(),turn);
                                    wrongInput = false;
                                }
                                else if(pauseChar == 'l')
                                {
                                    turn = load(player1,player2); 
                                    wrongInput = false;                               
                                }
                                else if(pauseChar == 'c')
                                {
                                    gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                                    wrongInput = false;
                                }else if(pauseChar == 'q'){
                                    System.out.println("\nThank you for playing Battle for Griffith!\n\nWe hope we will see you again.\n\nGoodbye.\n\nHave a nice day.\n");
                                    break;
                                }
                                else
                                {
                                    System.out.println("You have inserted wrong input, try again!");
                                    wrongInput = false;
                                }
                            }
                            if(pauseChar == 'q'){
                            break;
                            }
                            gameLoop(turn,p1Name,p2Name,player1,player2,xTemp,yTemp,check);
                        }
                        
                        check = player1.setTurn(xTemp-48,yTemp-48);
                        if(check == 2){
                            player2.setHitGrid(xTemp-48,yTemp-48,1);
                        }
                        else if(check == 3)
                        {
                            player2.setHitGrid(xTemp-48,yTemp-48,2);
                        }
                        else if(check == 4 || check==5)
                        {
                            while(player1.setTurn(xTemp-48,yTemp-48) == 4 || player2.setTurn(xTemp-48,yTemp-48) == 5){
                                System.out.print("Insert the X-coordinate\n\n(or press p for PAUSE menu) : ");
                                xTemp = in.nextLine().charAt(0);
                                System.out.print("Insert the Y-coordinate\n\n(or press p for PAUSE menu) : ");
                                yTemp = in.nextLine().charAt(0);
                            }
                        }
                        System.out.println("\nHIT GRID");
                        player2.printHitGrid();
                        System.out.println("SHIP GRID");
                        player2.printShipGrid();
                        System.out.print("Press enter to continue ");
                        in.nextLine();
                        lines();
                        turn = 1;
                    }//Player 2 turn IF statemet closed
                    if(player1.gameOver()==true){
                        System.out.println("\nGAME OVER!!!");
                        System.out.println("\nPlayer 2 has won!");
                        System.out.println("\nPress ENTER/RETURN to end the game.\n");
                        in.nextLine();
                        break;
                    }else if(player2.gameOver()==true){
                        System.out.println("\nGAME OVER!!!");
                        System.out.println("\nPlayer 1 has won!");
                        System.out.println("\nPress ENTER/RETURN to end the game.\n");
                        in.nextLine();
                        break;
                    }
                }//Game loop closed
        }
    
}

