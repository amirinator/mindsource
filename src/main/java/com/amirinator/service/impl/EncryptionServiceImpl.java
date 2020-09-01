package com.amirinator.service.impl;

import com.amirinator.model.Message;
import com.amirinator.service.EncryptionService;

public class EncryptionServiceImpl implements EncryptionService {

	@Override
	public Integer getRowSize(Message message) {
		String reformattedMessage =
				message.getContent().toLowerCase().replaceAll("[^a-z]", "");
		return reformattedMessage.length() / message.getColumnWidth();
	}

	@Override
	public Message decrypt(Message message) {

		int ROWS = getRowSize(message);
		int COLUMNS = message.getColumnWidth();

		// verify the column size is greater than 1
		if (COLUMNS < 1) {
			throw new RuntimeException("You must specify a column size greater than 1");
		}

		Message decryptedMessage = new Message("", message.getColumnWidth());

		char[][] multiArray = new char[ROWS][COLUMNS];
		char[] encryptedChars = message.getContent().toCharArray();
		char[] decryptedChars = new char[encryptedChars.length];
		int position = 0;

		for (int i = 0; i < ROWS; i++) {

			for (int ii = 0; ii < COLUMNS; ii++) {

				//insert into [row][column] the encrypted character value

				if (i % 2 == 0) {
					multiArray[i][ii] = encryptedChars[(i * COLUMNS) + ii];
				} else {
					//since it's an odd row number adjust for obtaining the correct character position
					multiArray[i][ii] = encryptedChars[((i + 1) * COLUMNS) - (ii + 1)];
				}
				position++;
			}
		}

		position = 0;
		for (int i = 0; i < COLUMNS; i++) {
			for (int ii = 0; ii < ROWS; ii++) {
				decryptedChars[position] = multiArray[ii][i];
				position++;
			}
		}

		decryptedMessage.setContent(String.valueOf(decryptedChars));
		return decryptedMessage;
	}
}
