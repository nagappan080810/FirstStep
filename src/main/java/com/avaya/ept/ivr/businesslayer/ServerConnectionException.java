package com.avaya.ept.ivr.businesslayer;

public class ServerConnectionException extends Exception {

	private static final long serialVersionUID = 436427393528064470L;

	private String host = null;

	public ServerConnectionException() {
	}

	public ServerConnectionException(String message) {
		super(message);
	}

	public ServerConnectionException(String message, String host) {
		super(message);
		this.host = host;
	}

	public ServerConnectionException(Throwable cause) {
		super(cause);
	}

	public ServerConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerConnectionException(String message, String host, Throwable cause) {
		super(message, cause);
		this.host = host;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
