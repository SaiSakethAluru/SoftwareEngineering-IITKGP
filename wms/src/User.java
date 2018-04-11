
public class User {
	public String name;
        public int UserId;
        private final String contactNumber;
	private final String contactDetails;
	private final String loginId;
	private final String loginPswrd;
	public User(String name,String contactNumber,String contactDetails,String loginId,String loginPswrd) {
		this.name = name;
                this.contactNumber = contactNumber;
		this.contactDetails = contactDetails;
		this.loginId = loginId;
		this.loginPswrd = loginPswrd;
	}
        public String getContactDetails(){
            return this.contactDetails;
        }
        public String getContactNumber(){
            return this.contactNumber;
        }
	public String getLoginId(){
            return this.loginId;
        }
        public String getLoginPswrd(){
            return this.loginPswrd;
        }
	
	public boolean authoriseLogin(String loginId, String loginPswrd) {
            return loginId.equals(this.loginId) && loginPswrd.equals(this.loginPswrd);
	}
	
}

