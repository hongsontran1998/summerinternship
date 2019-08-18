package com.demo.repository;

import com.demo.entity.Employee;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PureMongoDbDAO {
	private static final String HOST = "localhost";
	private static final String DATABASE_NAME = "mydatabase";
	private static final int PORT = 27017;

//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "";
	// Cách kết nối vào MongoDB không bắt buộc bảo mật.
	private static MongoClient getMongoClient() {
		return new MongoClient(HOST, PORT);
	}
	private static MongoDatabase getMongoDatabase() {
		return new MongoClient(HOST, PORT).getDatabase(DATABASE_NAME);
	}

	private static List<Employee> findAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		MongoClient mongoClient = null;
		try {
			mongoClient = getMongoClient();
			MongoDatabase db = mongoClient.getDatabase("mydatabase");
			MongoCollection<Document> collectionEmployee = db.getCollection("Employee");
			FindIterable<Document> documents = collectionEmployee.find();
			Iterator<Document> it = documents.iterator();
			while (it.hasNext()) {
				Document doc = it.next();
				employees.add(new Employee(
						doc.getLong("_id"),
						doc.getString("Emp_No"),
						doc.getString("Full_Name"),
						doc.getDate("Hire_Date")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mongoClient != null) {
				mongoClient.close();
			}
		}
		return employees;
	}
	private static Long insertEmployee(Employee employee) {
		MongoClient mongoClient = null;
		try {
			mongoClient = getMongoClient();
			MongoDatabase db = mongoClient.getDatabase("mydatabase");
			MongoCollection<Document> collectionEmployee = db.getCollection("Employee");
			Document doc = new Document();
			doc.put("_id", employee.getId());
			doc.put("Emp_No", employee.getEmpNo());
			doc.put("Full_Name", employee.getFullName());
			doc.put("Hire_Date", employee.getHireDate());
			collectionEmployee.insertOne(doc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mongoClient != null) {
				mongoClient.close();
			}
		}
		return 1L;
	}
	public static void main(String[] args) {
//		MongoClient mongoClient = getMongoClient();
//		// get list database names
//		for (String databaseName : mongoClient.listDatabaseNames()) {
//			System.out.println(databaseName);
//		}
//		mongoClient.close();
		List<Employee> employees = findAllEmployees();
		Employee e = new Employee(444L, "E444L", "fullname", new Date());
		//insertEmployee(e);
		System.out.println("");
	}
}
