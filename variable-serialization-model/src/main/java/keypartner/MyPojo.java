package keypartner;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class MyPojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6040069096536772037L;
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime creationTime;
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	
	
	

}
