import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;

public class ImageStreamParser extends AbstractSerialParser implements Runnable {
	private final static byte NEW_FRAME = 0x55;
	private final static byte NEW_LINE = (byte) 0xa9;

	private final static int WIDTH = 160;
	private final static int HEIGHT = 120;
	private final static int NBYTES = 3;
	private final static int IMAGE_SIZE = WIDTH * HEIGHT * NBYTES ;
	
	PreviewPanel display;
	byte[] imageBuffer;
	
	boolean newFrame ;

	public ImageStreamParser(InputStream in, PreviewPanel display) {
		this.in = in ;
		imageBuffer = new byte[IMAGE_SIZE];
		this.display = display ;
		setDefaultImage();
	}
	
	public ImageStreamParser(PreviewPanel display) {
		imageBuffer = new byte[IMAGE_SIZE];
		this.display = display ;
		setDefaultImage();
	}
	
	
	public void setDisplay( PreviewPanel display){
		this.display = display ;
		setDefaultImage();
			
	}
	
	public PreviewPanel getDisplay(){
		return this.display;
	}

	public void run() {
		int len;
		int lineIndex = 0;
		int pixelIndex = 0;
		byte[] buffer = new byte[IMAGE_SIZE + 100];
		long start_time = System.currentTimeMillis();
		int nb_frame  = 0;
		try {
			while ((len = this.in.read(buffer)) > -1) {
				for (int i = 0; i < len; i++) {
					if (buffer[i] == NEW_FRAME) {
						setImage();
						//System.out.println("Lines in frame "+ lineIndex);
						lineIndex = -1;
						nb_frame ++ ;
						pixelIndex = 0;
					} else if (buffer[i] == NEW_LINE) {
						//System.out.println("Pixel in line "+ pixelIndex);
						lineIndex += 1;
						pixelIndex = 0;
					} else {
						if ( lineIndex > 0 && pixelIndex < 80 && lineIndex < 60) {
							setValueOfPixel(imageBuffer, buffer[i], buffer[i], buffer[i], pixelIndex,  lineIndex);
							pixelIndex ++ ;
						}
					}
					
					if(System.currentTimeMillis() - start_time >= 1000){
						System.out.println("Frame rate is "+nb_frame+"ps");
						start_time  = System.currentTimeMillis() ;
						nb_frame  = 0 ;
					}
				}
				Thread.currentThread().sleep(5);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setValueOfPixel(byte[] imageBuffer, byte r, byte g, byte b, int pixelPos, int linePos){
		imageBuffer[linePos*2 * WIDTH*NBYTES + (pixelPos*6) ] = r ;
		imageBuffer[linePos*2 * WIDTH*NBYTES + (pixelPos*6) + 1] = g ;
		imageBuffer[linePos*2 * WIDTH*NBYTES + (pixelPos*6) + 2] = b ;
		imageBuffer[((linePos*2) + 1)* WIDTH*NBYTES + (pixelPos*6) + 3] = r ;
		imageBuffer[((linePos*2) + 1) * WIDTH*NBYTES + (pixelPos*6) + 4] = g ;
		imageBuffer[((linePos*2) + 1) * WIDTH*NBYTES + (pixelPos*6) + 5] = b ;
	}


	private void setDefaultImage() {
		byte[] imageData = new byte[IMAGE_SIZE];
		int pixelValue = 0 ;
		 for(int lineIndex = 0 ; lineIndex < 60 ;  lineIndex ++) {
			 for(int pixelIndex = 0 ; pixelIndex < 80 ;  pixelIndex ++) {
				 setValueOfPixel(imageData, (byte) pixelValue, (byte) 0, (byte) 0, pixelIndex , lineIndex);
				 pixelValue ++ ;
			 }
		}
		/*ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
		int[] nBits = { 8,8,8 };
		ColorModel cm = new ComponentColorModel(cs, nBits, false, true,
				Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
		SampleModel sm = cm.createCompatibleSampleModel(WIDTH, HEIGHT);
		DataBufferByte db = new DataBufferByte(imageData, IMAGE_SIZE);
		WritableRaster raster = Raster.createWritableRaster(sm, db, null);
		BufferedImage result = new BufferedImage(cm, raster, false, null);
		*/
		BufferedImage result;
		try {
			result = loadImage(imageData, WIDTH, HEIGHT);
			if(display != null){
				display.setImage(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		newFrame = true ;
	}
	
	private void setImage() {
		
		  
		byte[] imageData = new byte[IMAGE_SIZE];
		/*ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
		int[] nBits = { 8, 8, 8 };
		ColorModel cm = new ComponentColorModel(cs, nBits, false, true,
				Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
		SampleModel sm = cm.createCompatibleSampleModel(WIDTH, HEIGHT);
		*/
		System.arraycopy(imageBuffer, 0, imageData, 0, IMAGE_SIZE);
		/*DataBufferByte db = new DataBufferByte(imageData, IMAGE_SIZE);
		WritableRaster raster = Raster.createWritableRaster(sm, db, null);
		BufferedImage result = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		result.setData(raster);
		//BufferedImage result = new BufferedImage(cm, raster, false, null);
		 * */
		BufferedImage result;
		try {
			result = loadImage(imageData, WIDTH, HEIGHT);
			if(result != null && display != null){
				display.setImage(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.notifyObservers();
		newFrame = true ;
	}

	
    private BufferedImage loadImage(byte [] buffer, int width, int height) throws IOException
    {
        int sizeBytes = width * height * 3;

	    GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	    BufferedImage image = gc.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
	    WritableRaster raster = image.getRaster();
	    DataBufferInt dataBuffer = (DataBufferInt) raster.getDataBuffer();
	
	    addAlphaChannel(buffer, sizeBytes, dataBuffer.getData());
	
	    return image;


    }
    
    private void addAlphaChannel(byte[] rgbBytes, int bytesLen, int[] argbInts)
    {
        for(int i=0, j=0; i<bytesLen; i+=3, j++)
        {
            argbInts[j] = ((byte) 0xff) << 24 |                 // Alpha
                        (rgbBytes[i] << 16) & (0xff0000) |      // Red
                        (rgbBytes[i+1] << 8) & (0xff00) |       // Green
                        (rgbBytes[i+2]) & (0xff);               // Blue
        }
    }
	
	public boolean newFrame(){
		if(newFrame){
			newFrame = false ;
			return true ;
		}
		return false ;
	}
}
