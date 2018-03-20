package cz.B6B36NSS;
import java.util.Timer;
import java.util.TimerTask;

public class FakeDBObject {
	
	private int id;
	private String text;
	private Timer t;
	private TimerTask task;
	
	public FakeDBObject (int id, String text) {
		this.id = id;
		this.text = text;
		
		
		t = new Timer();
		task = new TimerTask() {
		        @Override
		        public void run() {

		        	setId(getId() + 1);

		         }
		 } ;

		t.scheduleAtFixedRate(task , 60000, 60000 );
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
