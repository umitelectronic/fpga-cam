import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;

public class ImageStreamParser extends AbstractSerialParser implements Runnable {
	private final static byte NEW_FRAME = 0x55;
	private final static byte NEW_LINE = (byte) 0xa9;

	
	PreviewPanel display;
	byte[] imageBuffer;
	
	boolean newFrame ;

	public ImageStreamParser(InputStream in, PreviewPanel display) {
		this.in = in ;
		imageBuffer = new byte[160 * 120];
		this.display = display ;
		setDefaultImage();
	}
	
	public ImageStreamParser(PreviewPanel display) {
		imageBuffer = new byte[160 * 120];
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
		byte[] buffer = new byte[(160*120)+61];
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
							imageBuffer[lineIndex*2 * 160 + pixelIndex*2] = buffer[i];
							imageBuffer[lineIndex*2 * 160 + (pixelIndex*2 + 1)] = buffer[i];
							imageBuffer[((lineIndex*2)+1) * 160 + pixelIndex*2] = buffer[i];
							imageBuffer[((lineIndex*2)+1) * 160 + (pixelIndex*2 + 1)] = buffer[i];
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

	private void setDefaultImage() {
		byte[] imageData = new byte[160 * 120];
		int pixelValue = 0 ;
		 for(int lineIndex = 0 ; lineIndex < 60 ;  lineIndex ++) {
			 for(int pixelIndex = 0 ; pixelIndex < 80 ;  pixelIndex ++) {
				 imageData[lineIndex*2 * 160 + pixelIndex*2] = (byte) pixelValue;
				 imageData[lineIndex*2 * 160 + (pixelIndex*2 + 1)] = (byte) pixelValue;
				 imageData[((lineIndex*2)+1) * 160 + pixelIndex*2] = (byte) pixelValue;
				 imageData[((lineIndex*2)+1) * 160 + (pixelIndex*2 + 1)] = (byte) pixelValue;
				 pixelValue ++ ;
			 }
		}
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		int[] nBits = { 8 };
		ColorModel cm = new ComponentColorModel(cs, nBits, false, true,
				Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
		SampleModel sm = cm.createCompatibleSampleModel(160, 120);
		DataBufferByte db = new DataBufferByte(imageData, 160 * 120);
		WritableRaster raster = Raster.createWritableRaster(sm, db, null);
		BufferedImage result = new BufferedImage(cm, raster, false, null);
		if(display != null){
			display.setImage(result);
		}
		newFrame = true ;
	}
	
	private void setImage() {
		byte[] imageData = new byte[160 * 120];
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		int[] nBits = { 8 };
		ColorModel cm = new ComponentColorModel(cs, nBits, false, true,
				Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
		SampleModel sm = cm.createCompatibleSampleModel(160, 120);
		System.arraycopy(imageBuffer, 0, imageData, 0, 160 * 120);
		DataBufferByte db = new DataBufferByte(imageData, 160 * 120);
		WritableRaster raster = Raster.createWritableRaster(sm, db, null);
		BufferedImage result = new BufferedImage(cm, raster, false, null);
		if(result != null && display != null){
			display.setImage(result);
		}
		this.notifyObservers();
		newFrame = true ;
	}

	
	public boolean newFrame(){
		if(newFrame){
			newFrame = false ;
			return true ;
		}
		return false ;
	}
}
