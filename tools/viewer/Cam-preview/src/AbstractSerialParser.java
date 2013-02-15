import java.io.InputStream;
import java.util.Observable;


public class AbstractSerialParser extends Observable implements Runnable{

	InputStream in;
	
	public void setInputStream(InputStream in){
		this.in = in ;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
