import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window extends JPanel {

	public static void main(String [] args) throws InterruptedException{
		JFrame frame = new JFrame("Wire Warfare");
		Window game = new Window();
		frame.add(game);
		frame.setSize(910, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D gd = (Graphics2D) g;
		gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		gd.setColor(Color.GRAY);
		gd.fillRect(0, 0, 910, 590);
		try {
			BufferedImage img;
			img = ImageIO.read(new File("src/border.png"));
			gd.drawImage(img, -17, -17, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
