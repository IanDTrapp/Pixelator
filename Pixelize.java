import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Pixelize {
    public String pixelize(String pixelSize, BufferedImage img){
	String end = "No output";
	// Gets image width and height for pixelization algorithm
	int imgW = img.getWidth(); 
	int imgH = img.getHeight();
	// Function for small pixel selection
	if (pixelSize == "small"){
	    final int SIZE = 5;
	    Raster ras = img.getData();
	    WritableRaster writeRas = ras.createCompatibleWritableRaster();
	    for (int y = 0; y < imgH; y += SIZE) {
		for (int x = 0; x < imgW; x += SIZE) {
		    double[] pixel = new double[3];
		    pixel = ras.getPixel(x,y,pixel);
		    // Applies pixel color to surrounding pixels
		    for (int a = y; (a < y + SIZE) && (a < imgH); a++) {
			for (int b = x; (b < x + SIZE) && (b < imgW); b++){
			    writeRas.setPixel(b,a,pixel);
			}
		    }
		}
	    }
	    // Saves the photo and returns the string "filename"
	    img.setData(writeRas);
	    String outputSmall = "outputSmall.png";
	    try {
		File f = new File(outputSmall);
		ImageIO.write(img, "png", f);
	    } catch (IOException ex) {}
	    return outputSmall;
	}
    
	// Function for medium pixel selection
	if (pixelSize == "medium"){
	    final int SIZE = 15;
            Raster ras = img.getData();
            WritableRaster writeRas = ras.createCompatibleWritableRaster();
            for (int y = 0; y < imgH; y += SIZE) {
                for (int x = 0; x < imgW; x += SIZE) {
                    double[] pixel = new double[3];
                    pixel = ras.getPixel(x,y,pixel);
		    // Applies pixel colors to surrounding pixels
                    for (int a = y; (a < y + SIZE) && (a < imgH); a++) {
                        for (int b = x; (b < x + SIZE) && (b < imgW); b++){
                            writeRas.setPixel(b,a,pixel);
                        }
                    }
                }
            }
	    // Saves the photo and returns the string "filename"
            img.setData(writeRas);
            String outputMedium = "outputMedium.png";
            try {
                File f = new File(outputMedium);
                ImageIO.write(img, "png", f);
            } catch (IOException ex) {}
            return outputMedium;
	}
	// Function for large pixel selection
	if (pixelSize == "large"){
	    final int SIZE = 25;
            Raster ras = img.getData();
            WritableRaster writeRas = ras.createCompatibleWritableRaster();
            for (int y = 0; y < imgH; y += SIZE) {
                for (int x = 0; x < imgW; x += SIZE) {
                    double[] pixel = new double[3];
                    pixel = ras.getPixel(x,y,pixel);
		    // Applies pixel color to surrounding pixels
                    for (int a = y; (a < y + SIZE) && (a < imgH); a++) {
                        for (int b = x; (b < x + SIZE) && (b < imgW); b++){
                            writeRas.setPixel(b,a,pixel);
                        }
                    }
                }
            }
	    // Saves the photo and returns the string "filename"
            img.setData(writeRas);
            String outputLarge = "outputLarge.png";
            try {
                File f = new File(outputLarge);
                ImageIO.write(img, "png", f);
            } catch (IOException ex) {}
            return outputLarge;
	}
	// Satifies the need for a return type that doesn't satisfy if-conditions
	return end;
    }
}