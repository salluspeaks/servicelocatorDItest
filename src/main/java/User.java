import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
	
	@JsonProperty("name")
	private  String name;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	

}
