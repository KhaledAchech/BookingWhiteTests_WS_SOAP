package de.tekup.DS_WS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.models.whitetest.Student;

@Service
public class WhiteTestService {
	
	public List<Student> students = new ArrayList<Student>();
	
	public List<Student> exams = new ArrayList<Student>();

	public WhiteTestResponse checkExam(StudentRequest studentRequest)
	{
		
		WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();
		
		return null;
	}

}
