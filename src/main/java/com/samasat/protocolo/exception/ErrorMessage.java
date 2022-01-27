package com.samasat.protocolo.exception;

import java.util.Date;

public class ErrorMessage {

	private int status;
	private Date timeStamp;
	private String mensaje;
	private String descripcion;


	public ErrorMessage(int status, Date timeStamp, String mensaje, String descripcion) {
		this.status = status;
		this.timeStamp = timeStamp;
		this.mensaje = mensaje;
		this.descripcion = descripcion;
	}

	
	/** 
	 * @return int
	 */
	public int getStatus() {
		return status;
	}

	
	/** 
	 * @return Date
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	
	/** 
	 * @return String
	 */
	public String getMensaje() {
		return mensaje;
	}

	
	/** 
	 * @return String
	 */
	public String getDescripcion() {
		return descripcion;
	}
}
