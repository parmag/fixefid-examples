package com.github.parmag.examples.fixefidenum;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.github.parmag.examples.fixefidenum.fieldenum.StudentRecordField;
import com.github.parmag.fixefid.record.Record;

@SpringBootApplication
public class FixefidenumApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixefidenumApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			printStudentRecord();
		};
	}

	private void printStudentRecord() {
		System.out.println("***********************STUDENT*****************************");
		
		Record<StudentRecordField> studentRecord = createStudentRecord();
		studentRecord.toNormalize();
		String studentRecordAsString = studentRecord.toString();
		System.out.println("Student Record=[" + studentRecordAsString + "]");
		
		Record<StudentRecordField> studentRecordFromString = new Record<StudentRecordField>(studentRecordAsString, StudentRecordField.class);
		studentRecordFromString.toNormalize();
		System.out.println("Student PersonId=[" + studentRecordFromString.getValueAsLong(StudentRecordField.personId) + "]");
		System.out.println("Student BirthDate=[" + studentRecordFromString.getValueAsDate(StudentRecordField.birthDate) + "]");
		System.out.println("Student StudentId=[" + studentRecordFromString.getValueAsLong(StudentRecordField.studentId) + "]");
		System.out.println("Student TaxAmount=[" + studentRecordFromString.getValueAsBigDecimal(StudentRecordField.taxAmount)+ "]");
	}

	private Record<StudentRecordField> createStudentRecord() {
		Record<StudentRecordField> student = new Record<StudentRecordField>(StudentRecordField.class);
		student.setValue(StudentRecordField.personId, 1234567890L);
		student.setValue(StudentRecordField.firstName, "Paul");
		student.setValue(StudentRecordField.lastName, "Robinson");
		student.setValue(StudentRecordField.age, 43);
		student.setValue(StudentRecordField.fiscalCode, "XXX18UTR99JKI777");
		student.setValue(StudentRecordField.address, "Via Ugo Bassi");
		student.setValue(StudentRecordField.num, "122");
		student.setValue(StudentRecordField.place, "Centro");
		student.setValue(StudentRecordField.location, "Bologna");
		student.setValue(StudentRecordField.district, "BO");
		student.setValue(StudentRecordField.postalCode, "40100");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1977);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DATE, 21);
		student.setValue(StudentRecordField.birthDate, cal.getTime());
		
		student.setValue(StudentRecordField.birthAddress, "Via Sebastiano Serlio");
		student.setValue(StudentRecordField.birthNum, "18");
		student.setValue(StudentRecordField.birthPlace, "Bolognina");
		student.setValue(StudentRecordField.birthLocation, "Bologna");
		student.setValue(StudentRecordField.birthDistrict, "BO");
		student.setValue(StudentRecordField.birthPostalCode, "40100");
		student.setValue(StudentRecordField.studentId, 1234L);
		student.setValue(StudentRecordField.enabled, true);
		student.setValue(StudentRecordField.level, 4);
		student.setValue(StudentRecordField.cardNumber, "1234-5678-9001");
		student.setValue(StudentRecordField.taxAmount, BigDecimal.valueOf(500.12));
		student.setValue(StudentRecordField.collage, "University of Southern California");
		return student;
	}

}
