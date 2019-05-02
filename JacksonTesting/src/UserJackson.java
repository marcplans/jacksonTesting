

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserJackson {
	private String userName;
	private String name;
	private String lastname;
	private String password;
	private String registrationDate;
	private ArrayList<Integer> userVideoList;

	public UserJackson() {
		super();
	}

	public UserJackson(String userName) {
		this.userName = userName;
	}

	public UserJackson(String userName, String name, String lastname,
			String password) {
		this.userName = userName;
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.registrationDate = getDate();
		this.userVideoList = new ArrayList<Integer>();
	}
	
	public UserJackson(String userName, String name, String lastname,
			String password, String registrationDate) {
		this.userName = userName;
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.registrationDate = registrationDate;
		this.userVideoList = new ArrayList<Integer>();
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getLastname() {
		return lastname;
	}

	public final void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final ArrayList<Integer> getUserVideoList() {
		return userVideoList;
	}

	public final void setUserVideoList(ArrayList<Integer> userVideoList) {
		this.userVideoList = userVideoList;
	}

	public final String getUserName() {
		return userName;
	}

	public final String getRegistrationDate() {
		return registrationDate;
	}

	
	// Returns current date string formatted
	public static String getDate() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return date.format(format);
	}
	
	
	
	
	public String toString() {
		return "\nUsername: " + this.getUserName() + "\nName: " + this.getName()
				+ "\nLastname: " + this.getLastname() + "\nPassword: "
				+ this.getPassword() + "\nRegistration date: "
				+ this.getRegistrationDate() + "\nVideos indices: "
				+ this.getUserVideoList();
	}

}
