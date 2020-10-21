package com.github.parmag.examples.fixefidbean;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.github.parmag.examples.fixefidbean.bean.Address;
import com.github.parmag.examples.fixefidbean.bean.BirthInfo;
import com.github.parmag.examples.fixefidbean.bean.Person;
import com.github.parmag.examples.fixefidbean.bean.Student;
import com.github.parmag.fixefid.record.BeanRecord;
import com.github.parmag.fixefid.record.field.FieldExtendedProperty;

@SpringBootApplication
public class FixefidbeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixefidbeanApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			printPersonRecord();
			printStudentRecord();
		};
	}

	private void printPersonRecord() {
		Person person = createPerson();
		BeanRecord personRecord = new BeanRecord(person, null, null, createPersonMapFieldExtendedProperties());
		personRecord.toNormalize();
		System.out.println("Person  Record=[" + personRecord.toString() + "]");
	}
	
	private void printStudentRecord() {
		Student student = createStudent();
		BeanRecord studentRecord = new BeanRecord(student, null, null, createStudentMapFieldExtendedProperties());
		studentRecord.toNormalize();
		System.out.println("Student Record=[" + studentRecord.toString() + "]");
	}

	private Map<String, List<FieldExtendedProperty>> createPersonMapFieldExtendedProperties() {
		Map<String, List<FieldExtendedProperty>> result = new HashMap<String, List<FieldExtendedProperty>>();
		result.put("firstName", Person.NAME_FIELD_EXTENDED_PROPERTIES);
		result.put("lastName", Person.NAME_FIELD_EXTENDED_PROPERTIES);
		result.put("birthInfo.birthDate", BirthInfo.BIRTH_DATE_FIELD_EXTENDED_PROPERTIES);
		return result;
	}
	
	private Map<String, List<FieldExtendedProperty>> createStudentMapFieldExtendedProperties() {
		Map<String, List<FieldExtendedProperty>> result = new HashMap<String, List<FieldExtendedProperty>>();
		result.putAll(createPersonMapFieldExtendedProperties());
		result.put("enabled", Student.ENABLED_FIELD_EXTENDED_PROPERTIES);
		result.put("cardNumber", Student.CARD_NUMBER_FIELD_EXTENDED_PROPERTIES);
		result.put("taxAmount", Student.TAX_AMOUNT_FIELD_EXTENDED_PROPERTIES);
		result.put("college", Student.COLLEGE_FIELD_EXTENDED_PROPERTIES);
		return result;
	}

	private Person createPerson() {
		Address address = createAddress();
		Address birthAddress = createBirthAddress();
		BirthInfo birthInfo = createBirthInfo(birthAddress); 
		
		Person person = new Person();
		person.setAddress(address);
		person.setAge(43);
		person.setFirstName("Pàul"); // will be normalized without accents
		person.setLastName("Robinson");
		person.setPersonId(1234567890L); 
		person.setBirthInfo(birthInfo); 
		person.setFiscalCode("XXX18UTR99JKI777");
		return person;
	}

	private BirthInfo createBirthInfo(Address birthAddress) {
		Calendar cal = Calendar.getInstance();
		BirthInfo birthInfo = new BirthInfo();
		birthInfo.setBirthAddress(birthAddress);
		cal.set(Calendar.YEAR, 1977);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DATE, 21);
		birthInfo.setBirthDate(cal.getTime());
		return birthInfo;
	}

	private Address createBirthAddress() {
		Address birthAddress = new Address();
		birthAddress.setAddress("Via Sebastiano Serlio");
		birthAddress.setNum("18");
		birthAddress.setPlace("Bolognina");
		birthAddress.setLocation("Bologna");
		birthAddress.setDistrict("BO");
		birthAddress.setPostalCode("40100");
		return birthAddress;
	}

	private Address createAddress() {
		Address address = new Address();
		address.setAddress("Via Ugo Bassi");
		address.setNum("122");
		address.setPlace("Centro");
		address.setLocation("Bologna");
		address.setDistrict("BO");
		address.setPostalCode("40100");
		return address;
	}
	
	private Student createStudent() {
		Address address = createAddress();
		Address birthAddress = createBirthAddress();
		BirthInfo birthInfo = createBirthInfo(birthAddress); 
		
		Student student = new Student();
		student.setStudentId(1234L);
		student.setEnabled(true); 
		student.setLevel(4);
		student.setCardNumber("1234-5678-9001");
		student.setTaxAmount(BigDecimal.valueOf(500.12));
		student.setCollege("University of Southern California");
		
		student.setAddress(address);
		student.setAge(43);
		student.setFirstName("Paul");
		student.setLastName("Robinson");
		student.setPersonId(1234567890L);
		student.setBirthInfo(birthInfo); 
		student.setFiscalCode("XXX18UTR99JKI777");
		
		return student;
	}

}
