package org.lsc.plugins.connectors.fusiondirectory.beans;

import java.time.Instant;

public class Token {
	private final Instant created;
	private String sessionId;

	public Token(String sessionId) {
		created = Instant.now();
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public boolean hasExpired(int validitySeconds) {
		return validitySeconds > 0 && Instant.now().isAfter(created.plusSeconds(validitySeconds));
	}
}
