import java.awt.image.BufferedImage;

public class Pixelize {
    public BufferedImage pixelize(String pixelSize, BufferedImage img){
	if (pixelSize == "small"){
	    imgW = img.getWidth();
	    imgH = img.getHeight();

	    
	    for (int x = 0; x < imgW; x += 3){
		for (int y = 0; y < imgH; y += 3){
		    int runningR, runningG, runningB;
		    // Determine red
		    runningR += img.getRed(x,y);
		    x += 2;
		    runningR += img.getRed(x,y);
		    x -= 2;
		    y += 2;
		    runningR += img.getRed(x,y);
		    x += 2; 
		    runningR += img.getRed(x,y);
		    x -= 1;
		    y -= 1;
		    runningR += img.getRed(x,y);

		    // Determine green
		    runningG += img.getGreen(x,y);
                    x += 2;
                    runningG +=img.getGreen(x,y);
                    x -= 2;
                    y += 2;
                    runningG +=img.getGreen(x,y);
                    x += 2;
                    runningG +=img.getGreen(x,y);
                    x -= 1;
                    y -= 1;
                    runningG +=img.getGreen(x,y);
		    
		    // Determine blue - FIX 
		    runningR += img.getRed(x,y);
                    x += 2;
                    runningR +=img.getRed(x,y);
                    x -= 2;
                    y += 2;
                    runningR +=img.getRed(x,y);
                    x += 2;
                    runningR +=img.getRed(x,y);
                    x -= 1;
                    y -= 1;
                    runningR +=img.getRed(x,y);

	}
	if (pixelSize == "medium"){
	}
	if (pixelSize == "large"){
	}
    }
}