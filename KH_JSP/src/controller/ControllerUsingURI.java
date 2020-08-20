package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmd.CommandHandler;
import cmd.NullHandler;

public class ControllerUsingURI extends HttpServlet{

	private Map<String, CommandHandler> commandHandlerMap = new HashMap<String, CommandHandler>();
	
	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties property = new Properties();
		FileInputStream fis = null;
		try {
			String configFilePath = getServletContext().getRealPath(configFile);
			fis = new FileInputStream(configFilePath);
			property.load(fis);
		}catch(IOException e) {
			throw new ServletException(e);
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Iterator keyIt = property.keySet().iterator();
		while(keyIt.hasNext()) {
			String command = (String)keyIt.next();
			String handlerClassName = property.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				Class.forName(handlerClassName);
				
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				
				commandHandlerMap.put(command, handlerInstance);
			} catch(ClassNotFoundException e) {
				throw new ServletException(e);
			}catch(InstantiationException e) {
				throw new ServletException(e);
			}
			catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		String command = req.getParameter("cmd");
		String command = req.getRequestURI();
		if(command.indexOf(req.getContextPath())==0) {
			//ContextPath와 같은 요청이라면
			command = command.substring(req.getContextPath().length());
			//ContextPath를 제거하고 URI 정보만 명령어(command)로 활용
		}
		System.out.println(command);
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
		
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, resp);
	}
}
