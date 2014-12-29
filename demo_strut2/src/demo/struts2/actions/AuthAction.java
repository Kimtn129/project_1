package demo.struts2.actions;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.Action;  
import com.opensymphony.xwork2.ActionSupport;

import demo.struts2.bean.UserBean;

import org.apache.struts2.ServletActionContext;


public class AuthAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email = null;
	private String password = null;
	private String firstName = null;
	private String lastName = null;
	private String error = "";

    public String login() throws Exception {
    	HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userBean", new UserBean(this.email, this.password));
    	if (this.email.equals("admin") && this.password.equals("admin")) {
    		return "thanhcong";
    	} else {
    		this.error = "User or Password incorrect";
    		return "thatbai";
    	}
    }

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String logout() throws Exception {
    	return Action.SUCCESS;
    }
    
    public String resetPwd() throws Exception {
    	return Action.SUCCESS;
    }
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
