import javax.inject.Inject;
import javax.inject.Named;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class InterfaceImpl implements InterfaceTest{
	
	@Inject
	@Named("mapper")
	private ObjectMapper objectMapper;

	@Override
	public String testFunc(String name) throws JsonProcessingException {
		
		User user = new User();
		user.setName(name);
		return objectMapper.writeValueAsString(objectMapper);
		
		

		
	}

}
