package daos.daoInterfaces;

import javabeans.message;
import javabeans.user;

import java.util.List;

public interface DaoMessage {
	
	public List<message> getAllMessages(user user);
	public void sendMessage(message meg);
	public void updateMessageObjectif(message msg, user user, String objectif);
	public void updateMessageText(message msg, user user, String text);
	public void deleteMessage(message msg);
}
