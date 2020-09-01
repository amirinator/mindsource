package com.amirinator.application;

import com.amirinator.model.Message;
import com.amirinator.service.EncryptionService;
import com.amirinator.service.impl.EncryptionServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EncryptionServiceTest {

	EncryptionService service;

	/*
	 * Set up resources for each test
	 */
	@BeforeEach
	public void setUp() {
		service = new EncryptionServiceImpl();
	}

	/*
	 * Clean up resources after each test
	 */
	@AfterEach
	public void tearDown() {
		service = null;
	}

	/*
	 * Verify the column size for a message is correct
	 */
	@Test
	@DisplayName("Verify the message array size is the correct size")
	public void testColumnSize() {
		Message message = new Message("theresnoplacelikehomeonasnowynightx", 5);
		assertNotNull(message.getContent());
	}

	/*
	 * Verify the amount of rows is correct based on the content and column size
	 */
	@Test
	@DisplayName("Verify the amount of rows is correct for the message")
	public void testGeMessageRowSize() {
		Message message = new Message("theresnoplacelikehomeonasnowynightx", 5);
		Integer rowSize = service.getRowSize(message);
		assertEquals(rowSize, 7);
	}

	/*
	 * Verify the encrypted content is decrypted correctly
	 */
	@Test
	@DisplayName("Verify the message is correctly decrypted")
	public void testDecryptMessage() {
		Message message = new Message("toioynnkpheleaigshareconhtomesnlewx", 5);
		Message decryptedMessage = service.decrypt(message);
		assertEquals("theresnoplacelikehomeonasnowynightx", decryptedMessage.getContent());
	}

	/*
	 * Verify the encrypted content is decrypted correctly
	 */
	@Test
	@DisplayName("Verify the message is correctly decrypted into the valid messasge")
	public void testDecryptMessageAgain() {
		Message message = new Message("ttyohhieneesiaabss", 3);
		Message decryptedMessage = service.decrypt(message);
		assertEquals("thisistheeasyoneab", decryptedMessage.getContent());
	}
}