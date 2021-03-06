package Picture_Lab;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public void blur(int x, int y, int w, int h){
    Pixel[][] pixels = this.getPixels2D();
    for (int row = x; row < x+h; row++)
    {
      for (int col = y; col < y+w; col++)
      {
          Pixel p = pixels[row][col];
          int avgR = p.getRed();
          int avgG = p.getGreen();
          int avgB = p.getBlue();
          int count = 1;
          for (int tempRow = row - 1; tempRow <= row + 1; tempRow++)
            {
                    for (int tempCol = col - 1; tempCol <= col + 1; tempCol++)
                    {
                            Pixel tempP = pixels[tempRow][tempCol];
                            avgR +=tempP.getRed();
                            avgG += tempP.getGreen();
                            avgB +=tempP.getBlue();
                            count++;
                    }
            }
          
            avgR /= count;
            avgB /= count;
            avgG /= count;

            Color avgColor = new Color(avgR, avgB, avgG);

            pixels[row][col].setColor(avgColor);
      }
    } 
  }
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue(){
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  public void negate(){
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }
  
  public void grayscale(){
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int average = (int)(pixelObj.getRed()+pixelObj.getBlue() + pixelObj.getGreen())/3;
        pixelObj.setGreen(average);
        pixelObj.setRed(average);
        pixelObj.setBlue(average);
      }
    }
      
  }
  
  public void fixUnderWater(){
     Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        
        pixelObj.setBlue(pixelObj.getBlue()-50);
      }
    } 
  }
  
   public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
   
   public void mirrorHorizontalBotToTop()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length -1 ;
	  int width = pixels[0].length - 1;
	  for (int row = 0; row < height / 2; row++)
	  {
	    for (int col = 0; col < width; col++) 
	    {
	      bottomPixel = pixels[row][col];
	      topPixel = pixels[height - row][col];
	      bottomPixel.setColor(topPixel.getColor());
	    }
	  }
  }
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[row - height - 1][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  /** Meth  od that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
   public void mirrorArms()
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	    
	  int rightBound = 196, leftBound = 170, bottomBound = 293, topBound = 119;
	  int mirrorPoint = rightBound;
	  Pixel[][] pixels = this.getPixels2D();
	    
	  for (int col = 106; col < bottomBound; col++)
	  {
	    for (int row = topBound; row < mirrorPoint; row++)
	    {
	        
	      leftPixel = pixels[row][col];      
	      rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	      rightPixel.setColor(leftPixel.getColor());
	    }
	  }
  }
   public void mirrorGull()
  {
	  int mirrorPoint = 354;
	  Pixel leftPixel;
	  Pixel rightPixel;
	  Pixel[][] pixels = this.getPixels2D();
	    
	  for (int row = 231; row < 322; row++)
	  {
	    for (int col = 237; col < mirrorPoint; col++)
	    {
	        
	      leftPixel = pixels[row][col];      
	      rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
	      rightPixel.setColor(leftPixel.getColor());
	    }
	  }
  }
   
   public void copyTwo(Picture fromPic, 
          int startRow, int startCol, int sRow, int eRow, int sCol, int eCol)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = fromPic.getPixels2D();
	  for (int fromRow = sRow, toRow = startRow; 
			  fromRow < eRow &&
			  toRow < toPixels.length; 
			  fromRow++, toRow++)
	  {
		  for (int fromCol = sCol, toCol = startCol; 
				  fromCol < eCol &&
				  toCol < toPixels[0].length;  
				  fromCol++, toCol++)
		  {
			  fromPixel = fromPixels[fromRow][fromCol];
			  toPixel = toPixels[toRow][toCol];
			  toPixel.setColor(fromPixel.getColor());
		  }
	  }   
	}

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void myCollage()
  {
	  Picture swan = new Picture("src/images/swan.jpg");
	  Picture water = new Picture("src/images/water.jpg");
	  this.copy(swan,0,200);
	  this.copyTwo(water,120,50,50, 90, 20, 60);
	  Picture g = new Picture(swan);
	  g.grayscale();
	  this.copy(g,100,0);
	  
	  this.write("collage.jpg");
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("src/images/flower1.jpg");
    Picture flower2 = new Picture("src/images/flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("src/images/collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color topColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
        
        bottomPixel = pixels[row][col];
        topPixel = pixels[row][col+1];
        topColor = topPixel.getColor();
        if (bottomPixel.colorDistance(topColor) > edgeDist)
        	bottomPixel.setColor(Color.BLACK);
        else
        	bottomPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("src/images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
