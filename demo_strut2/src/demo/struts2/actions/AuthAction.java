package demo.struts2.actions;

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
    	if (this.form != null) {
    		UserBean users = UserController.getUser(this.form.getEmail(), this.form.getPassword());
    		if (users != null) {
    			return Action.SUCCESS;
    		} else {
    			this.error = "Email or Password incorrect!";
    			return Action.ERROR;
    		}
    	} else {
    		this.error = "Please insert Email and password!";
    		return Action.ERROR;
    	}
    }

	public String logout() throws Exception {
    	return Action.SUCCESS;
    }
    
    public String resetPwd() throws Exception {
    	return Action.SUCCESS;
    }
}
