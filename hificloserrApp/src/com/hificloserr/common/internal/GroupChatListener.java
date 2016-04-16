package com.hificloserr.common.internal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.hificloserr.common.mqtt.IMqttGroupChatSubscriptionFacade;

/**
 * Servlet implementation class GroupChatListener
 */
public class GroupChatListener extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupChatListener() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try{
			System.out.println("GroupSubscription Listener started"+config.getServletName());
			IMqttGroupChatSubscriptionFacade.eINSTANCE.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
