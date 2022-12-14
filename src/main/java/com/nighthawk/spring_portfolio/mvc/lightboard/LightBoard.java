package com.nighthawk.spring_portfolio.mvc.lightboard;

import lombok.Data;
import java.util.Scanner;


@Data  // Annotations to simplify writing code (ie constructors, setters)
public class LightBoard {
    private Light[][] lights;

    /* Initialize LightBoard and Lights */
    public LightBoard(int numRows, int numCols) {
        this.lights = new Light[numRows][numCols];
        // 2D array nested loops, used for initialization
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                lights[row][col] = new Light();  // each cell needs to be constructed
            }
        }
    }

    /* Output is intended for API key/values */
    public String toString() { 
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // data
                "{" + 
                "\"row\": " + row + "," +
                "\"column\": " + col + "," +
                "\"light\": " + lights[row][col] +   // extract toString data
                "}," ;
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0,outString.length() - 1) + "]";
		return outString;
    }

    /* Output is intended for Terminal, effects added to output */
    public String toTerminal() { 
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // reset
                "\033[m" +
                
                // color
                "\033[38;2;" + 
                lights[row][col].getRed() + ";" +  // set color using getters
                lights[row][col].getGreen() + ";" +
                lights[row][col].getBlue() + ";" +
                lights[row][col].getEffect() + "m" +
                // data, extract custom getters
                "{" +
                "\"" + "isOn\": " + lights[row][col].isOn() +
                "," +
                "\"" + "RGB\": " + "\"" + lights[row][col].getRGB() + "\"" +
                "," +
                "\"" + "Effect\": " + "\"" + lights[row][col].getEffectTitle() + "\"" +
                "}," +
                // newline
                "\n" ;
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0,outString.length() - 2) + "\033[m" + "]";
		return outString;
    }

    /* Output is intended for Terminal, draws color palette */
    public String toColorPalette() {
        // block sizes
        final int ROWS = 5;
        final int COLS = 10;

        // Build large string for entire color palette
        String outString = "";
        // find each row
        for (int row = 0; row < lights.length; row++) {
            // repeat each row for block size
            for (int i = 0; i < ROWS; i++) {
                // find each column
                for (int col = 0; col < lights[row].length; col++) {
                    // repeat each column for block size
                    for (int j = 0; j < COLS; j++) {
                        // print single character, except at midpoint print color code
                        if (lights[row][col].isOn()) {
                        String c = (i == (int) (ROWS / 2) && j == (int) (COLS / 2) ) 
                            ? lights[row][col].getRGB()
                            : (j == (int) (COLS / 2))  // nested ternary
                            ? " ".repeat(lights[row][col].getRGB().length())
                            : " ";

                        outString += 
                        // reset
                        "\033[m" +
                        
                        // color
                        "\033[38;2;" + 
                        lights[row][col].getRed() + ";" +
                        lights[row][col].getGreen() + ";" +
                        lights[row][col].getBlue() + ";" +
                        "7m" +

                        // color code or blank character
                        c +

                        // reset
                        "\033[m";
                    }
                }
                }
                outString += "\n";
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString += "\033[m";
		return outString;
    }
    public void flag(String flag) {


if(flag=="what")        {
            short rv = 255;
            short gv = 255;
            short bv = 255;


            
            // for (int rowz = 0; rowz < 5; rowz++) {
            //     for (int colz = 0; colz < 3; colz++) {
                    
            //         lights[rowz][colz].RGBset(rv,gv,bv);
            //     }
                
            // }
             
            // short rva = 255;
            // short gva = 255;
            // short bva = 255;

            // for (int rowz = 0; rowz < 5; rowz++) {
            //     for (int colz = 3; colz < 6; colz++) {
            //         lights[rowz][colz].RGBset(rva,gva,bva);
            //     }
            // } 
            // short rvb = 255;
            // short gvb = 0;
            // short bvb = 0;

            // for (int rowz = 0; rowz < 5; rowz++) {
            //     for (int colz = 6; colz < 9; colz++) {
            //         lights[rowz][colz].RGBset(rvb,gvb,bvb);
            //     }

                
            // } 
    
for (int i = 0; i < 5; i++) {
   for (int j = 0; j < 10 - i; j++)
    System.out.print(" ");
   for (int k = 0; k < (2 * i + 1); k++)
   lights[i][k].RGBset(rv,gv,bv);
   System.out.println();
  }
//   short rva = 212;
// short gva = 255;
//     short bva = 212;
  
//   for (int i = 5; i > 1; i--) {
//     for (int j = 10; j > 2 - i; j--)
//      System.out.print(" ");
//     for (int k = 5; k > (i); k--)
//     lights[i][k].RGBset(rva,gva,bva);
//     System.out.println();
//    }
   short rvb = 0;
short gvb = 0;
    short bvb = 0;

   for (int i = 5; i > 0; i--) {
    for (int j = 10; j < 0 + i; j++)
    lights[i][j].RGBset(rvb,gvb,bvb);
    System.out.println();
   }

   for (int rowz = 0; rowz < 5; rowz++) {
        for (int colz = 1; colz < 9; colz +=2) {
            lights[rowz][colz].RGBset(rvb,gvb,bvb);
        }

        
    } 

}
if(flag=="yes"){
    short rv = 255;
    short gv = 255;
    short bv = 255;
    for (int rowz = 0; rowz < 5; rowz++) {
        for (int colz = 1; colz < 9; colz +=2) {
            lights[rowz][colz].RGBset(rv,gv,bv);
        } 
    } 
    short rva = 0;
    short gva = 0;
    short bva = 0;
    for (int rowz = 0; rowz < 5; rowz++) {
        for (int colz = 0; colz < 9; colz +=2) {
            lights[rowz][colz].RGBset(rva,gva,bva);
        } 
    } 
    short rvb = 0;
    short gvb = 0;
    short bvb = 0;
    for (int rowz = 1; rowz < 5; rowz += 2) {
        for (int colz = 1; colz < 9; colz +=2) {
            lights[rowz][colz].RGBset(rvb,gvb,bvb);
        } 
    } 
    short rvc = 255;
    short gvc = 255;
    short bvc = 255;
    for (int rowz = 1; rowz < 5; rowz += 2) {
        for (int colz = 0; colz < 9; colz +=2) {
            lights[rowz][colz].RGBset(rvc,gvc,bvc);
        } 
    }
}
}

        
        
    
    
    static public void main(String[] args) {
        // create and display LightBoard

        Scanner scan = new Scanner(System.in);
        System.out.println("Number of rows: ");
        int bRows = scan.nextInt();
        System.out.println("Number of columns: ");
        int bCols = scan.nextInt();
        System.out.println("Height dimension of the boxes: ");
        int bHeight = scan.nextInt();
        System.out.println("Length dimension of the boxes: ");
        int bLength = scan.nextInt();
        LightBoard lightBoard = new LightBoard(bRows, bCols);

        System.out.println(lightBoard);  // use toString() method
        System.out.println(lightBoard.toTerminal());
        System.out.println(lightBoard.toColorPalette());
        LightBoard flagBoard = new LightBoard(5, 9);
        flagBoard.flag("what");
        System.out.println(flagBoard.toColorPalette());
        flagBoard.flag("yes");
        System.out.println(flagBoard.toColorPalette());
    }
}

