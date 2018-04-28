package controllers;

import views.AlertWindow;


public class AlertController {
	public static void createAlert(String head,String text)	{
		
		AlertWindow.display(head,text);
		
	}
}
