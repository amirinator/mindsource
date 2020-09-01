package com.amirinator.application;

import com.amirinator.model.Message;
import com.amirinator.service.EncryptionService;
import com.amirinator.service.impl.EncryptionServiceImpl;

public class EncryptionApplication {

	public static void main(String[] args) {
		EncryptionService service = new EncryptionServiceImpl();
		Integer columnWidth = Integer.valueOf(args[0]);
		String encryptedMessage = args[1].toLowerCase();
		Message message = new Message(encryptedMessage, columnWidth);
		Message decryptedMessage = service.decrypt(message);
		System.out.println("The encrypted message \"" + encryptedMessage + "\" is decrypted as \""
				+ decryptedMessage.getContent() + "\"");
	}
}
