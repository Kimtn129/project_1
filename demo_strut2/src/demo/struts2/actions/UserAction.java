package demo.struts2.actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import demo_struts2.controller.UserController;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229352823965472008L;

	public String list() throws Exception {
    	HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("users", new UserController().getAllUser());
		return SUCCESS;
    }
}
