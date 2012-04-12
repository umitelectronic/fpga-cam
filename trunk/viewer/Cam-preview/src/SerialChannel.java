import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialChannel {

	private InputStream serialIn ;
	private OutputStream serialOut ;
	
	
	public SerialChannel() {
		super();
	}

	void connect(String portName, AbstractSerialParser parser, int baudrate) throws Exception {
		CommPortIdentifier portIdentifier = CommPortIdentifier
				.getPortIdentifier(portName);
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			CommPort commPort = portIdentifier.open(this.getClass().getName(),
					2000);

			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
				serialIn = serialPort.getInputStream();
				serialOut = serialPort.getOutputStream();
				parser.setInputStream(serialIn);
				(new Thread(parser)).start();

			} else {
				System.out
						.println("Error: Only serial ports are handled by this example.");
			}
		}
	}
	
	public void writeDate(byte[] input, int length) throws IOException{
		serialOut.write(input, 0, length);
	}


}
