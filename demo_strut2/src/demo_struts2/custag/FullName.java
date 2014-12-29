package demo_struts2.custag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FullName extends SimpleTagSupport {

	private String firstName = "";
	private String lastName = "";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstName(Object firstName) {
		this.firstName = (String)firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastName(Object lastName) {
		this.lastName = (String)lastName;
	}
	
	StringWriter sw = new StringWriter();

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (this.firstName != null && !this.firstName.equals("")) {
			out.println("<input type='text' name='firstName' value='" + this.firstName + "'/>");
			out.println("<input type='text' name='lastName' value='" + this.lastName + "'/>");
		} else {
			out.println("<input type='text' name='firstName'/>");
			out.println("<input type='text' name='lastName'/>");
		}
		out.println("</br>");
	}
}
