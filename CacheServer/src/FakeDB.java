public class FakeDB {

	private static FakeDBObject fakeDBObject = null;
	private static FakeDBObject fakeChangingDBObject = null;

	
	public static FakeDBObject getStaticObject() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (fakeDBObject == null) {
			fakeDBObject = new FakeDBObject(1, "fake object");
		}
		
		return fakeDBObject;
	}
	
	public static FakeDBObject getChangingObject() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fakeChangingDBObject == null) {
			fakeChangingDBObject = new FakeDBObject(1, "fake changing object");
		}
		
		
		return fakeChangingDBObject;
	}
}
