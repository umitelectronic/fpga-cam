

import gnu.io.CommPortIdentifier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CamPreviewGUI extends JFrame implements Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int PORT = 9745;

	PreviewPanel panel;
	JComboBox imageComPortField;
	JComboBox dataComPortField;
	JButton connectImageButton;
	JButton connectDataButton;
	JButton sendConf;
	SerialChannel serialChannelImage;
	SerialChannel serialChannelData;
	String comPort;
	
	JLabel dummy, upper, lower, yLabel, uLabel, vLabel, channelLabel ;
	JTextField yu, yl, uu, ul, vu, vl , channel;
	List<JTextField> registers ;
	
	ImageStreamParser imageParser;
	DataStreamParser dataParser;
	List<String> ports;

	public CamPreviewGUI() {
		this.setPreferredSize(new Dimension(370, 220));
		panel = new PreviewPanel();
		panel.setSize(160, 120);
		panel.setImage(Toolkit.getDefaultToolkit().getImage("jojo.jpeg"));
		Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier
				.getPortIdentifiers();
		ports = new ArrayList<String>();
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier portIdentifier = portEnum.nextElement();
			ports.add(portIdentifier.getName());
		}
		imageComPortField = new JComboBox(ports.toArray());
		imageComPortField.setSize(320, 12);
		connectImageButton = new JButton("connect");
		connectImageButton.addActionListener(this);
		dataComPortField = new JComboBox(ports.toArray());
		dataComPortField.setSize(320, 12);
		connectDataButton = new JButton("connect");
		connectDataButton.addActionListener(this);
		
		sendConf = new JButton("Send");
		sendConf.addActionListener(this);
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(3, 3));
		this.add("Center", panel);
		
		dummy = new JLabel();
		upper = new JLabel("<=");
		lower = new JLabel(">=");
		yLabel = new JLabel("Y");
		uLabel = new JLabel("U");
		vLabel = new JLabel("V");
		channelLabel = new JLabel("chan");
		
		registers = new ArrayList<JTextField>();

		yu = new JTextField("55", 3);
		registers.add(yu);
		yl = new JTextField("00", 3);
		registers.add(yl);
		uu = new JTextField("55", 3);
		registers.add(uu);
		ul = new JTextField("00", 3);
		registers.add(ul);
		vu = new JTextField("55", 3);
		registers.add(vu);
		vl = new JTextField("00", 3);
		registers.add(vl);
		channel = new JTextField("00", 3);
		registers.add(channel);
		
		JPanel confPanel = new JPanel();
		confPanel.setLayout(new GridLayout(5, 3, 2, 2));
		
		confPanel.add(dummy);
		confPanel.add(upper);
		confPanel.add(lower);
		
		confPanel.add(yLabel);
		confPanel.add(yu);
		confPanel.add(yl);
		
		confPanel.add(uLabel);
		confPanel.add(uu);
		confPanel.add(ul);
		
		confPanel.add(vLabel);
		confPanel.add(vu);
		confPanel.add(vl);
		
		confPanel.add(channelLabel);
		confPanel.add(channel);
		
		
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2, 3, 10, 10));
		
		inputPanel.add(imageComPortField);
		inputPanel.add(connectImageButton);
		inputPanel.add(sendConf);
		inputPanel.add(dataComPortField);
		inputPanel.add(connectDataButton);
		
		this.add("South", inputPanel);
		this.add("East", confPanel);
		
		
		this.pack();
		this.setVisible(true);
		imageParser = new ImageStreamParser(this.panel);
		this.repaint();
	}

	public boolean listenImageSerialPort(String comPortName) throws Exception {
		serialChannelImage = new SerialChannel();
		serialChannelImage.connect(comPortName, imageParser, 3000000);
		return true;
	}
	
	public boolean listenDataSerialPort(String comPortName) throws Exception {
		dataParser = new DataStreamParser(this.panel);
		serialChannelData = new SerialChannel();
		serialChannelData.connect(comPortName, dataParser, 115200);
		return true;
	}


	public static void main(String[] args) {
		CamPreviewGUI frame = new CamPreviewGUI();
		frame.setTitle("Client Program");
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		frame.addWindowListener(l);
		frame.pack();
		frame.setVisible(true);
		// frame.listenSocket();
		Thread frameThread = new Thread(frame);
		frameThread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (serialChannelImage != null) {
					if (imageParser != null && imageParser.newFrame()) {
						this.repaint();
					}

				} else if (serialChannelImage == null) {
					connectImageButton.setText("connect");
					this.repaint();
				}
				Thread.sleep(10);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connectImageButton) {
			if (connectImageButton.getText().equals("connect")) {
				if (serialChannelImage == null) {
					try {
						this.listenImageSerialPort((String) imageComPortField
								.getSelectedItem());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					connectImageButton.setText("disconnect");
				}
			}
			this.repaint();
		}if (e.getSource() == connectDataButton) {
			try {
				this.listenDataSerialPort((String) dataComPortField
						.getSelectedItem());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			connectDataButton.setText("disconnect");
			this.repaint();
		}else if (e.getSource() == sendConf) {
			if (serialChannelImage != null) {
				try {
					byte[] registerVals = new byte[7] ;
					for(int i = 0; i < 7; i ++){
						String val = registers.get(i).getText();
						int iVal = Integer.decode(val);
						if(iVal > 255){
							iVal = 255 ;
						}
						registerVals[i] = (byte) iVal;
						
					}
					serialChannelImage.writeDate(registerVals, 7);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				connectImageButton.setText("disconnect");
			}
			this.repaint();
		}

	}
}