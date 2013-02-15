import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;


public class PreviewPanel extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6096800483515469435L;

	public Image image ;
	public BufferedImage bi ;
	public Graphics g2 ;

	public PreviewPanel(){
		super();
		setSize(new Dimension(160, 120));
		bi = new BufferedImage(160, 120, BufferedImage.TYPE_4BYTE_ABGR);
		g2 = bi.createGraphics();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 0 ;
		int y = 0 ;
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		if(width > 0 && height > 0){
			x = (160 - width) /2 ;
			y = (120- height) /2 ;
		}
		g2.drawImage(image, x, y, this);
		g.drawImage(bi, 0, 0, this);
	}

	public void setImage(Image img) {
		image = img ;
	}
}
