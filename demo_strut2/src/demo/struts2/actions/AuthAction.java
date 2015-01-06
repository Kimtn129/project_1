package demo.struts2.actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;  
import com.opensymphony.xwork2.ActionSupport;

import demo.struts2.bean.UserBean;
import demo_struts2.controller.UserController;



public class AuthAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBean form;
	private String error = "";
	private int count = 0;

    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UserBean getForm() {
		return form;
	}

	public void setForm(UserBean form) {
		this.form = form;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String login() throws Exception {
//    	HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("userBean", new UserBean(this.email, this.password));
    	if (this.error.equals("")) {
    		UserBean users = UserController.getUser(this.form.getEmail(), this.form.getPassword());
    		if (users != null) {
    			this.form = users;
    			return Action.SUCCESS;
    		} else {
    			this.error = "Email or Password incorrect!";
    			return Action.ERROR;
    		}
    	} else {
    		return Action.ERROR;
    	}
    }
	
	public void validate() {
		
		// reset error 
		this.error = "";
		
		// validate email
		if (!this.form.getEmail().equals("thinhuockim@gmail.com")) {
			this.error = "Email is invalid!";
		}
		
		// validate password
		if (this.form.getPassword().length() < 6) {
			this.error = "Password must be have 6 characters!";
		}
	}
	
	public String logout() throws Exception {
    	return Action.SUCCESS;
    }
    
    public String resetPwd() throws Exception {
    	return Action.SUCCESS;
    }
}
