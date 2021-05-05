package de.tekup.DS_WS.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.DS_WS.service.ExamsListService;
import de.tekup.DS_WS.service.WhiteTestService;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ExamsRequest;
import de.tekup.soap.models.whitetest.ExamsResponse;
import de.tekup.soap.models.whitetest.StudentRequest;

import java.util.List;


@Endpoint
public class ExamsListEndPoint {

	public static final String nameSpace = "http://www.tekup.de/soap/models/whitetest";
	
	@Autowired
	private ExamsListService service;
	
	@PayloadRoot(namespace = nameSpace, localPart = "ExamsRequest")
	@ResponsePayload
	public ExamsResponse getExams(@RequestPayload ExamsRequest examsRequest)
	{
		return service.examsList(examsRequest);
	}

}
