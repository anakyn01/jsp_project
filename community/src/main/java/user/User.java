package user;

public class User {

	//개인만에 프라이버시 getter, setter
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	
	//getter
	public String getUserID() {return userID;}
	public String getUserPassword() {return userPassword;}
	public String getUserName() {return userName;}
	public String getUserGender() {return userGender;}
	public String getUserEmail() {return userEmail;}
	
	//setter
	public void setUserID(String userID) {this.userID = userID;}
	public void setUserPassword(String userPassword) {this.userPassword = userPassword;}
	public void setUserName(String userName) {this.userName = userName;}
	public void setUserGender(String userGender) {this.userGender = userGender;}
	public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
	
	
	
}
