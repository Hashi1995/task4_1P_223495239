package sit707_week4;

import org.junit.Assert;
import org.junit.Test;


/**
 * Tests functions in LoginForm.
 * @author Hashini Gunathilaka
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "223495239";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "HashiniGunathilaka";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	
	 @Test
	    public void testFailEmptyUsernameAndEmptyPassword() {
	        LoginStatus status = LoginForm.login(null, null);
	        Assert.assertFalse("Login fail with empty username", status.isLoginSuccess());
	        Assert.assertEquals("Empty Username", status.getErrorMsg());
	    }
	 
	 @Test
	    public void testFailEmptyUsernameAndWrongPassword() {
	        LoginStatus status = LoginForm.login(null, "xyz");
	        Assert.assertFalse("Login fail with empty username", status.isLoginSuccess());
	        Assert.assertEquals("Empty Username", status.getErrorMsg());
	    }
	 
	 @Test
	    public void testFailEmptyUsernameAndCorrectPassword() {
	        LoginStatus status = LoginForm.login(null, "ahsan_pass");
	        Assert.assertFalse("Login fail with empty username", status.isLoginSuccess());
	        Assert.assertEquals("Empty Username", status.getErrorMsg());
	    }
	 
	 @Test
     public void testFailWrongUsernameAndEmptyPassword() {
       LoginStatus status = LoginForm.login("abc", null);
       Assert.assertFalse("Login fail with wrong username", status.isLoginSuccess());
       Assert.assertEquals("Credential mismatch", status.getErrorMsg());
   }

	 @Test
     public void testFailWrongUsernameAndWrongPassword() {
       LoginStatus status = LoginForm.login("abc", "xyz");
       Assert.assertFalse("Login fail with wrong username", status.isLoginSuccess());
       Assert.assertEquals("Credential mismatch", status.getErrorMsg());
   }
	 
	 @Test
	    public void testFailWrongUsernameAndCorrectPassword() {
	        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
	        Assert.assertFalse("Login fail with wrong username", status.isLoginSuccess());
	        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	    }
	 
	 @Test
	    public void testFailCorrectUsernameAndEmptyPassword() {
	        LoginStatus status = LoginForm.login("ahsan", "null");
	        Assert.assertFalse("Login fail with empty password", status.isLoginSuccess());
	        Assert.assertEquals("Empty Password", status.getErrorMsg());
	    }

	 @Test
	    public void testFailCorrectUsernameAndWrongPassword() {
	        LoginStatus status = LoginForm.login("ahsan", "xyz");
	        Assert.assertFalse("Login fail with wrong username", status.isLoginSuccess());
	        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	    }
	 
	 @Test
	    public void testPassCorrectUsernameAndCorrectPassword() {
	        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
	        Assert.assertTrue("Login success with correct username and password", status.isLoginSuccess());
	    }
	 
	
	 @Test
	    public void testPassCorrectUsernameAndCorrectPasswordAndEmptyValidationCode() {
	        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
	        Assert.assertTrue("Login success with correct username and password", status.isLoginSuccess());

	        boolean validationResult = LoginForm.validateCode("wrong_code");
	        Assert.assertFalse("Validation code fail", validationResult);
	    }
	 
	 @Test
	    public void testPassCorrectUsernameAndCorrectPasswordAndWrongValidationCode() {
	        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
	        Assert.assertTrue("Login success with correct username and password", status.isLoginSuccess());

	        boolean validationResult = LoginForm.validateCode("wrong_code");
	        Assert.assertFalse("Validation code fail", validationResult);
	    }
	 
	 @Test
	    public void testPassCorrectUsernameAndCorrectPasswordAndCorrectValidationCode() {
	        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
	       Assert.assertTrue("Login success with correct username and password", status.isLoginSuccess());

	        boolean validationResult = LoginForm.validateCode("123456");
	        Assert.assertTrue("Validation code pass", validationResult);
	    }

	}
