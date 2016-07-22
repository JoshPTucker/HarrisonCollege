package hcservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Servlet implementation class Webmail
 */
@WebServlet("/Webmail")
public class Webmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Webmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       //HttpSession session = request.getSession();
		String body = request.getParameter("body");
		String to = request.getParameter("to");
		String from  = request.getParameter("from");
		String subject =request.getParameter("subject");
		//Get mail session
		Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", 8081);
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.quitwait", "false");
        //NOTE: Session object is part of javax.mail.Session
        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props);
        
        //message object
        boolean bodyIsHTML = false;
        Message message = new MimeMessage(session);
        try{
        message.setSubject(subject);
        if (bodyIsHTML) {
        message.setContent(body, "text/html");
        } else {
        message.setText(body);
        }
        
        //adress the message object
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        // send the message object
        Transport transport = session.getTransport();
        transport.connect();
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        }
        catch(Exception e){
        	System.err.println(e);
        }
        String nextURL ="/webmail.jsp";
        request.getRequestDispatcher(nextURL).forward(request, response);
	}

}
