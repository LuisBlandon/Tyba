package dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE, setterVisibility=JsonAutoDetect.Visibility.NONE, creatorVisibility=JsonAutoDetect.Visibility.NONE)
public class DeleteBookExampleDTO {
	
	@JsonProperty("ID")
	private String ID;

	public DeleteBookExampleDTO()
	{
		
	}
	public DeleteBookExampleDTO(String ID) {
		super();
		this.ID = ID;
	}
	
	public String getId() {
		return ID;
	}

	public void setId(String ID) {
		this.ID = ID;
	}
	

}
