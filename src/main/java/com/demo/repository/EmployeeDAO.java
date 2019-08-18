package com.demo.repository;

import com.demo.entity.Employee;
import com.demo.util.MongoDbConnectionUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeDAO {
	public static final String COLLECTION_NAME = "Employee";
	private MongoClient mongoClient;

	private List<Employee> findAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		MongoClient mongoClient = null;
		try {
			mongoClient = MongoDbConnectionUtil.getMongoClient();
			MongoCollection<Document> collectionEmployee =
					MongoDbConnectionUtil.getMongoCollection(mongoClient, COLLECTION_NAME);
			FindIterable<Document> documents = collectionEmployee.find();
			Iterator<Document> it = documents.iterator();
			while (it.hasNext()) {
				employees.add(getDocumentMapper(it.next()));
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
	private Employee findOneByFullName(String fullName) {
		Employee employee = null;
		try {
			MongoCollection<Document> collectionEmployee = MongoDbConnectionUtil.getMongoCollection(COLLECTION_NAME);
			FindIterable<Document> documents = collectionEmployee.find(Filters.eq("Full_Name", fullName));
            Iterator<Document> it = documents.iterator();
            if (it.hasNext()) {
               employee = getDocumentMapper(it.next());
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return employee;
	}

    private Employee getDocumentMapper(Document doc) {
        Employee employee = null;
        employee = new Employee(
                //doc.getLong("_id"),
                null,
                doc.getString("Emp_No"),
                doc.getString("Full_Name"),
                doc.getDate("Hire_Date")
        );
        return employee;
    }
    private Document getDocumentFromEmployee(Employee employee) {
        Document doc = new Document();
        doc.put("_id", new ObjectId().toString());
        doc.put("Emp_No", new ObjectId().toString());
        doc.put("Full_Name", employee.getFullName());
        doc.put("Hire_Date", employee.getHireDate());
        return doc;
    }

    private Long insertEmployee(Employee employee) {
		try {
			MongoCollection<Document> collectionEmployee = MongoDbConnectionUtil.getMongoCollection(COLLECTION_NAME);
			collectionEmployee.insertOne(getDocumentFromEmployee(employee));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		//List<Employee> employees = findAllEmployees();
		//Employee e = new Employee(null, null, "sonthh", new Date());
		//insertEmployee(e);
        EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.findOneByFullName("sonthh");
		System.out.println("");
	}
}
