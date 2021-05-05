package de.tekup.DS_WS.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.DS_WS.DsWsSoapApplication;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.models.whitetest.Student;

@Service
public class WhiteTestService {
	
	public  List<Student> students = new ArrayList<Student>();
	public  List<Exam> exams = new ArrayList<Exam>();


	public WhiteTestResponse checkExam(StudentRequest studentRequest) throws DatatypeConfigurationException
	{
		

		students.add(new Student(1,"student1","address1"));
		students.add(new Student(2,"student2","address2"));
		students.add(new Student(3,"student3","address3"));
		
		exams.add(new Exam("code_OCA","OCA"));
		exams.add(new Exam("code_OCP","OCP"));
		
		Student falseStudent = new Student (-1, "false","false");
		Exam falseExam = new Exam ("-1","false");
		
		WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();
		
		//default response
		response.setExam(falseExam);
		response.setStudent(falseStudent);
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = 
            datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		
		for (Student student : students) { 		

	           if (student.getId() == studentRequest.getStudentId())
	           {
	        	   System.out.println("student id : "+student.getId());
	        	   System.out.println("studentRequest id : "+studentRequest.getStudentId());
	        	   System.out.println(student.getId() == studentRequest.getStudentId());
	        	   System.out.println(student.toString());
	        	   response.setStudent(student);
	           }
	      }
		for (Exam exam : exams)
		{
			if (exam.getCode().equals(studentRequest.getExamCode()))
			{
				response.setExam(exam);
				response.setDate(now);
			}
		}

		return response;
	}

}
