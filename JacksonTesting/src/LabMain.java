import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;



public class LabMain {

	public static void main(String[] args) throws IOException {
//		objectToJSON();
//		JSONtoObject();
//		JSONstringToList();
//		listToJSON();
//		hashMapToJSON();
//		JSONtoHashMap();
//		addRecordToJSON();

		System.out.println(retrieveFromJson ("gamer97"));
		

//		ObjectMapper objectMapper = new ObjectMapper();
//		File myFile = new File("data/users.json");
//		JsonNode parsedJson = objectMapper.readTree(myFile);
		
//		System.out.println(parsedJson);
//		JsonNode output = null;
//		for (JsonNode jsonNode : parsedJson) {
//			System.out.println(jsonNode.path("userName"));
//			if (jsonNode.path("userName").asText().equals("mindundi")) {
//				output = jsonNode;
//				break;
//			}
//		}
//		System.out.println("***");
//		System.out.println(output);
//		
//		UserJackson user = objectMapper.convertValue(output, UserJackson.class);
//		System.out.println("***");
//		System.out.println(user);
		
	}
	
	
	public static UserJackson retrieveFromJson (String userName) throws JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File myFile = new File("data/users.json");
		JsonNode parsedJson = objectMapper.readTree(myFile);
		for (JsonNode jsonNode : parsedJson) {
			System.out.println(jsonNode.path("userName"));
			if (jsonNode.path("userName").asText().equals(userName)) {
				return objectMapper.convertValue(jsonNode, UserJackson.class);
			}
		}
		return null;
	}
	
	
	
	
	// add record to Json file
	public static void addRecordToJSON()
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File myFile = new File("data/list.json");
		
		Car myCar = new Car("pink", "ferrari");
		JsonNode node = objectMapper.convertValue(myCar, JsonNode.class);
		
		JsonNode parsedJson = objectMapper.readTree(myFile);
		((ArrayNode)parsedJson).add(node);
		System.out.println(parsedJson);
		
		objectMapper.writeValue(myFile, parsedJson);
	}

	/*
	 * public static void jsonArrayAppendExample2() { try { File file = new
	 * File("u:\\test.json"); FileWriter fileWriter = new FileWriter(file,
	 * true);
	 * 
	 * ObjectMapper mapper = new ObjectMapper();
	 * 
	 * SequenceWriter seqWriter =
	 * mapper.writer().writeValuesAsArray(fileWriter); 
	 * seqWriter.write(new Person("Foo", 20)); 
	 * seqWriter.write(new Person("Bar", 30));
	 * seqWriter.write(new Person("Baz", 40)); 
	 * seqWriter.close(); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */

	// return same field in all records of json file
	public static List<JsonNode> readFieldFromJSON() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File myFile = new File("data/list.json");
		JsonNode tree = objectMapper.readTree(myFile);
		List<JsonNode> fieldList = tree.findValues("color");
		return fieldList;
	}

	public static void JSONtoHashMap() {

//		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, ArrayList<Car>> carMap = new HashMap<String, ArrayList<Car>>();

		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("data/map2.json");

		try {
			carMap = objectMapper.readValue(file,
					new TypeReference<Map<String, ArrayList<Car>>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(carMap);
	}

	public static void hashMapToJSON() {
		List<Car> array1 = new ArrayList<Car>();
		List<Car> array2 = new ArrayList<Car>();
		List<Car> array3 = new ArrayList<Car>();
		List<Car> array4 = new ArrayList<Car>();

		array1.add(new Car("green", "toyota"));
		array1.add(new Car("white", "volkswagen"));
		array1.add(new Car("black", "citroen"));
		array1.add(new Car("red", "mercedes"));

		array2.add(new Car("white", "volkswagen"));
		array2.add(new Car("black", "citroen"));
		array2.add(new Car("yellow", "peugeot"));

		array3.add(new Car("pink", "lotus"));
		array3.add(new Car("grey", "audi"));

		array4.add(new Car("orange", "fiat"));
		array4.add(new Car("red", "seat"));
		array4.add(new Car("white", "chrysler"));
		array4.add(new Car("green", "skoda"));

		Map<String, ArrayList<Car>> carMap = new HashMap<String, ArrayList<Car>>();
		carMap.put("mike", (ArrayList<Car>) array1);
		carMap.put("mary", (ArrayList<Car>) array2);
		carMap.put("sam", (ArrayList<Car>) array3);
		carMap.put("ann", (ArrayList<Car>) array4);

		System.out.println(carMap);

		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("data/map.json");

		try {
			objectMapper.writeValue(file, carMap);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void listToJSON() {
		// System.out.print(System.getProperty("user.dir"));
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("data/list.json");
		Car car1 = new Car("green", "toyota");
		Car car2 = new Car("white", "volkswagen");
		Car car3 = new Car("black", "citroen");
		Car car4 = new Car("yellow", "seat");
		Car car5 = new Car("red", "mitsubishi");
		List<Car> carList = Arrays
				.asList(new Car[] { car1, car2, car3, car4, car5 });

		String arrayToJson = "";
		// arrayToJson = objectMapper.writeValueAsString(myList);

		try {
			objectMapper.writeValue(file, carList);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void JSONstringToList() {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Car> carList = null;
		String jsonCarArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, "
				+ "{ \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		try {
			carList = objectMapper.readValue(jsonCarArray,
					new TypeReference<List<Car>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(carList.get(0));
		System.out.println(carList.get(1));
	}

	public static void JSONtoObject() {
		ObjectMapper objectMapper = new ObjectMapper();
		File myFile = new File("data/lab.json");
		myFile = new File("data/newcar.json");
		Car car = null;
		try {
			car = objectMapper.readValue(myFile, Car.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(car.toString());
	}

	public static void objectToJSON() {
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = new Car("yellow", "renault");
		File myFile = new File("data/lab.json");

		try {
			objectMapper.writeValue(myFile, car);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(car.toString());
	}

}
