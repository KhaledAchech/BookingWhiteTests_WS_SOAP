package de.tekup.DS_WS.endpoint;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.DS_WS.service.WhiteTestService;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Endpoint
public class WhiteTestEndPoint {
	
	public static final String nameSpace = "http://www.tekup.de/soap/models/whitetest";
	
	@Autowired
	private WhiteTestService service;

	@PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse getExamDetails(@RequestPayload StudentRequest studentRequest) throws DatatypeConfigurationException
	{
		return service.checkExam(studentRequest);
	}
}
