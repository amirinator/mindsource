package com.amirinator.service;

import com.amirinator.model.Message;

public interface EncryptionService {

	/**
	 * Determines the amount of rows this message will contain depending on the message column size
	 *
	 * @param message the message that is encrypted/decrypted with the amount of columns
	 * @return the amount of rows based on the amount of columns
	 */
	Integer getRowSize(Message message);

	/**
	 * Decrypts the content of the encrypted message contain in the Message object
	 *
	 * @param message the encrypted message object
	 * @return a decrypted message object
	 */
	Message decrypt(Message message);
}
