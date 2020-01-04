package com.jsonar.DVDRentals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable; 

@SpringBootTest
class DvdRentalsTestFind {

	@Test
	void contextLoads() {
		// Creating a Mongo client
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Creating Credentials
		// MongoCredential credential;
		// credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
		// System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongo.getDatabase("DVDRentals");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("customers");
		System.out.println("Collection sampleCollection selected successfully");

		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();

		// Getting the iterator
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
