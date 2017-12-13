package chat;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	protected static final long serialVersionUID = 1L;

	static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;

	private int type;
	private String message;

	ChatMessage(int type, String message) {
		this.type = type;
		this.message = message;
	}

	int getType() {
		return type;
	}

	String getMessage() {
		return message;
	}
}