import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Imagine {
    private int coordX;
    private int coordY;
    private int number;
    private String path;
    BufferedImage image = null;

    public Imagine(int coordX, int coordY, int number, String path)
    {
        this.coordX = coordX;
        this.coordY = coordY;
        this.number = number;
        this.path=path;
        int width = 300;
        int height = 200;
        try
        {
            File input_file = new File(path);


            image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_ARGB);


            image = ImageIO.read(input_file);


        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }

    }

    public int getCoordX() {
        return coordX;
    }
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }
    public int getCoordY() {
        return coordY;
    }
    public String getPath(){return path;}
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public void drawImagine(Graphics g, int coordX, int coordY)
    {
        g.drawImage(image, coordX, coordY, null);

    }

}
