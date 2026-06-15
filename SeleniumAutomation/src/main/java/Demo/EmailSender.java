package Demo;

import java.io.File;

import Utils.EmailUtil;

public class EmailSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			String filePath = System.getProperty("user.dir") + "/screnshots/Login Failure.png";
			EmailUtil.sendEmail(new File(filePath));
	}
}
