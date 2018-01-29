/*
*   Created by : Rhyder Quinlan & Roland Stojkoski
*
*   Description : Program that mimics the game Battleship
*
*/

import java.util.*;

/**
 *
 * @author Rhyder Quinlan & Roland Stojkoski
 * Upon planning it was decided Rhyder Quinlan would focus mainly on the Player objects.
 * Of course Co-operation and Combinations of code work were required.
 */
public class Player {
    
    private int[][] grid = new int [10][10];
    private int[][] hitGrid = new int[10][10];    
    
    public Player(){
        
    }
    
    //Ship Placement by Rhyder Quinlan
    public int[][] setShipGrid(String playerName) {
        Scanner input = new Scanner(System.in);
        int xCord;
        int yCord;
        int heading; 
        boolean valid = false;
        int shipNumber = 0;
        
        //Heading: 0 = Across 1 = Down
        //Placement of Aircraft Carrier
        System.out.println("  ---------" + playerName + "---------");
        System.out.println("\n--- Place your Aircraft Carrier ---\n");
        System.out.println("Size = 5\n");
        while(valid == false){                
                System.out.print("Enter Boat X Co-Ordinate : ");
                xCord = input.nextInt();
                System.out.println();
                System.out.print("Enter Boat Y Co-Ordinate : ");
                yCord = input.nextInt();
                System.out.println();
                System.out.println("Enter the direction of the boat:");
                System.out.println("0 = Across 1 = Down : ");
                heading = input.nextInt();
                if(heading == 0                         //A check to make sure it is a valid placement
                   && xCord>= 0
                   && xCord < 6){
                    for(int y = 0; y<=4; y++){                        
                        grid[yCord][xCord + y] = 1;
                    }
                    valid = true;
                }
                else if(heading == 1
                   && yCord >= 0
                   && yCord < 6){
                    for(int y = 0; y<=4; y++){
                        grid[yCord + y][xCord] = 1;
                    }
                    valid = true;
                } else {
                    System.out.println("This is an invalid placement. Ship is over the board.\n");
                }
        }
        shipNumber++;
        
        printShipGrid();
            
            //Placement of Battleship
            System.out.println("+--------------------------------------------------+");
            System.out.println("\n--- Place your BattleShip ---\n");
            System.out.println("Size = 4\n");
            valid = false;            
            while(valid == false){                
                System.out.print("Enter Boat X Co-Ordinate : ");
                xCord = input.nextInt();
                System.out.println();
                System.out.print("Enter Boat Y Co-Ordinate : ");
                yCord = input.nextInt();
                System.out.println();
                System.out.println("Enter the direction of the boat:");
                System.out.println("0 = Across 1 = Down : ");
                heading = input.nextInt();
                if(heading == 0
                   && xCord>= 0
                   && xCord < 7){ //Across                    
                    if(grid[yCord][xCord] == 0
                            && grid[yCord][xCord + 1] == 0
                            && grid[yCord][xCord + 2] == 0
                            && grid[yCord][xCord + 3] == 0){
                        for(int y = 0; y<=3; y++){
                            grid[yCord][xCord + y] = 1;
                        }
                        valid = true;
                    } else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }                      
                }
                else if(heading == 1
                    && yCord >= 0
                    && yCord < 7){
                    if(grid[yCord][xCord] == 0
                            && grid[yCord + 1][xCord] == 0
                            && grid[yCord + 2][xCord] == 0
                            && grid[yCord + 3][xCord] == 0){
                        for(int y = 0; y<=3; y++){
                            grid[yCord + y][xCord] = 1;
                        }
                        valid = true;
                    }
                    else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }
                } else {
                    System.out.println("This is an invalid placement. Ship is over the board.\n");
                }
            }
            shipNumber++;
            
            printShipGrid();
          
            //Placement of Destroyer
            System.out.println("+--------------------------------------------------+");
            System.out.println("\n--- Place your Destroyer ---\n");
            System.out.println("Size = 3\n");
            valid = false;            
            while(valid == false){                
                System.out.print("Enter Boat X Co-Ordinate : ");
                xCord = input.nextInt();
                System.out.println();
                System.out.print("Enter Boat Y Co-Ordinate : ");
                yCord = input.nextInt();
                System.out.println();
                System.out.println("Enter the direction of the boat:");
                System.out.println("0 = Across 1 = Down : ");
                heading = input.nextInt();
                if(heading == 0
                   && xCord>= 0
                   && xCord < 8){ //Across                    
                    if(grid[yCord][xCord] == 0
                            && grid[yCord][xCord + 1] == 0
                            && grid[yCord][xCord + 2] == 0){
                        for(int y = 0; y<=2; y++){
                            grid[yCord][xCord + y] = 1;
                        }
                        valid = true;
                    } else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }                      
                }
                else if(heading == 1
                    && yCord >= 0
                    && yCord < 8){
                    if(grid[yCord][xCord] == 0
                            && grid[yCord + 1][xCord] == 0
                            && grid[yCord + 2][xCord] == 0){
                        for(int y = 0; y<=2; y++){
                            grid[yCord + y][xCord] = 1;
                        }
                        valid = true;
                    }
                    else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }
                } else {
                    System.out.println("This is an invalid placement. Ship is over the board.\n");
                }
            }
            shipNumber++;
            printShipGrid();
            
            //Placement of Submarine
            System.out.println("+--------------------------------------------------+");
            System.out.println("\n--- Place your Submarine ---\n");
            System.out.println("Size = 3\n");
            valid = false;            
            while(valid == false){                
                System.out.print("Enter Boat X Co-Ordinate : ");
                xCord = input.nextInt();
                System.out.println();
                System.out.print("Enter Boat Y Co-Ordinate : ");
                yCord = input.nextInt();
                System.out.println();
                System.out.println("Enter the direction of the boat:");
                System.out.println("0 = Across 1 = Down : ");
                heading = input.nextInt();
                if(heading == 0
                   && xCord>= 0
                   && xCord < 8){ //Across                    
                    if(grid[yCord][xCord] == 0
                            && grid[yCord][xCord + 1] == 0
                            && grid[yCord][xCord + 2] == 0){
                        for(int y = 0; y<=2; y++){
                            grid[yCord][xCord + y] = 1;
                        }
                        valid = true;
                    } else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }                      
                }
                else if(heading == 1
                    && yCord >= 0
                    && yCord < 8){
                    if(grid[yCord][xCord] == 0
                            && grid[yCord + 1][xCord] == 0
                            && grid[yCord + 2][xCord] == 0){
                        for(int y = 0; y<=2; y++){
                            grid[yCord + y][xCord] = 1;
                        }
                        valid = true;
                    }
                    else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }
                } else {
                    System.out.println("This is an invalid placement. Ship is over the board.\n");
                }
            }
            shipNumber++;
            printShipGrid();
            
            //Placement of Patrol Boat
            System.out.println("+--------------------------------------------------+");
            System.out.println("\n--- Place your Patrol Boat ---\n");
            System.out.println("Size = 2\n");
            valid = false;            
            while(valid == false){                
                System.out.print("Enter Boat X Co-Ordinate : ");
                xCord = input.nextInt();
                System.out.println();
                System.out.print("Enter Boat Y Co-Ordinate : ");
                yCord = input.nextInt();
                System.out.println();
                System.out.println("Enter the direction of the boat:");
                System.out.println("0 = Across 1 = Down : ");
                heading = input.nextInt();
                if(heading == 0
                   && xCord>= 0
                   && xCord < 9){ //Across                    
                    if(grid[yCord][xCord] == 0
                            && grid[yCord][xCord + 1] == 0){
                        for(int y = 0; y<=1; y++){
                            grid[yCord][xCord + y] = 1;
                        }
                        valid = true;
                    } else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }                      
                }
                else if(heading == 1
                    && yCord >= 0
                    && yCord < 9){
                    if(grid[yCord][xCord] == 0
                            && grid[yCord + 1][xCord] == 0){
                        for(int y = 0; y<=1; y++){
                            grid[yCord + y][xCord] = 1;
                        }
                        valid = true;
                    }
                    else {
                        System.out.println("This is an invalid placement. Ships overlap.\n");
                    }
                } else {
                    System.out.println("This is an invalid placement. Ship is over the board.\n");
                }
            }
            printShipGrid();
        return grid;
    }
    
    //Hit Grid Elements by Rhyder Quinlan
    public void setHitGrid(int yCord, int xCord, int input){
        hitGrid[xCord][yCord] = input;
    }
    
    //turn Outcomes by Rhyder Quinlan
    public int setTurn(int yCord, int xCord){
        int hit = -1;
        if(grid[xCord][yCord] == 1){
            grid[xCord][yCord] = 2; 
            System.out.println("\nHit!");
            hit = 2;
        }
        else if(grid[xCord][yCord] == 0) {     
            System.out.println("\nMiss!");
            hit = 3;
        } else if(grid[xCord][yCord] == 2 || hitGrid[xCord][yCord] == 3){
            System.out.println("\nYou have already inputed that, try again.");
            hit = 4;
        } else if(xCord>9 || xCord<0 || yCord>9 || yCord<0){
            System.out.println("\nYou have inserted wrong coordinates, try again."); 
            hit = 5;
        }
        
        return hit;
    }
    
    public void printShipGrid(){
        for(int x = 0; x<grid.length; x++){
            System.out.print(x + " ");
            for(int y = 0; y<grid[x].length; y++){
                System.out.print("| ");
                if(grid[x][y] == 0){
                    System.out.print(" ");
                } else if(grid[x][y] == 1){
                    System.out.print("B");
                } else if(grid[x][y] == 2) {
                    System.out.print("H");
                }         
                System.out.print(" |");
            }
            System.out.println();
        }
        System.out.println("   ________________________________________________");
        System.out.println("    0    1    2    3    4    5    6    7    8    9");
        System.out.println("\n");
    }
    
    public int[][] getShipGrid(){
        return grid;
    }
    
    public void printHitGrid(){
        System.out.println("    0    1    2    3    4    5    6    7    8    9");
        System.out.println("   ________________________________________________");
        for(int x = 0; x<hitGrid.length; x++){
            System.out.print(x + " ");
            for(int y = 0; y<hitGrid[x].length; y++){
                System.out.print("| ");
                if(hitGrid[x][y] == 0){
                    System.out.print(" ");
                } else if(hitGrid[x][y] == 1){
                    System.out.print("H");
                } else if(hitGrid[x][y] == 2) {
                    System.out.print("M");
                }           
                System.out.print(" |");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    
    public int[][] getHitGrid(){
        return hitGrid;
    }
    
    //All load and save elements by ROland Stojkoski
    public void loadShipGrid(int[][] shipGrid){
        grid = shipGrid;
    }
    
    public void loadHitGrid(int[][] loadedHitGrid){
        hitGrid = loadedHitGrid;
    }
    
    public boolean gameOver(){
        boolean gameOver = false;
        int counter = 0;
        for(int row = 0; row<grid.length;row++){
            for(int col = 0; col<grid[row].length;col++){
                if(grid[row][col]==2){
                    counter++;
                }
            }
            if(counter==17){
                gameOver=true;
                break;
            }
        }
        return gameOver;
    }
    
}
