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
import javax.swing.JPanel;
import javax.swing.JTextField;

class CamPreviewGUI extends JFrame implements Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int PORT = 9745;

	PreviewPanel panel;
	JComboBox<String> comPortField;
	JButton connectButton;
	SerialChannel serialChannel;
	String comPort;
	ImageStreamParser parser;
	List<String> ports ; 

	public CamPreviewGUI() {
		this.setPreferredSize(new Dimension(180, 190));
		panel = new PreviewPanel();
		panel.setSize(160, 120);
		panel.setImage(Toolkit.getDefaultToolkit().getImage("jojo.jpeg"));
		Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
		ports = new ArrayList<String>();
		 while ( portEnum.hasMoreElements() ) 
	        {
			 CommPortIdentifier portIdentifier = portEnum.nextElement();
			 ports.add(portIdentifier.getName());
	        }
		comPortField = new JComboBox(ports.toArray());
		comPortField.setSize(320, 12);
		connectButton = new JButton("connect");
		connectButton.addActionListener(this);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(3, 3));
		this.add("Center", panel);
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1, 3, 10, 10));
		inputPanel.add(comPortField);
		inputPanel.add(connectButton);
		this.add("South", inputPanel);
		this.pack();
		this.setVisible(true);
		parser = new ImageStreamParser(this.panel);
		this.repaint();
	}

	public boolean listenSerialPort(String comPortName) throws Exception {
		serialChannel = new SerialChannel();
		serialChannel.connect(comPortName, parser);
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
				if (serialChannel != null) {
					if (parser != null && parser.newFrame()) {
						this.repaint();
					}

				} else if (serialChannel == null) {
					connectButton.setText("connect");
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
		if (e.getSource() == connectButton || e.getSource() == comPortField) {
			if (connectButton.getText().equals("connect")) {
				if (serialChannel == null) {
					try {
						this.listenSerialPort((String) comPortField.getSelectedItem());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					connectButton.setText("disconnect");
				}
			}
			this.repaint();
		}

	}
}