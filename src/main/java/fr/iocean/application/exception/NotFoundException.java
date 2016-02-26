package fr.iocean.application.exception;

import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

public class NotFoundException extends NoSuchRequestHandlingMethodException {

	public NotFoundException() {
		super("Not found", NotFoundException.class);
	}

}
