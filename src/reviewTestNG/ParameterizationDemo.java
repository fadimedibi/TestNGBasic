package reviewTestNG;

import org.testng.annotations.Test;

public class ParameterizationDemo {

	@Test(dataProvider="getData")
	public void testOne(String userName, String password) {
		System.out.println(userName);
		System.out.println(password);
	}
	
public Object getData() {
	Object[][] data= {
			{"test1@yahoo.com", "test1@123"},
			{"test1@gmail.com", "test2.123"},
			{"test3@live.com", "test3@567"}
			
	};
	return data;
}	
	
	
}

