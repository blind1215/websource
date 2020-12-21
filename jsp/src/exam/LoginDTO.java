package exam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO { //봉지 
	//~DTO(Data Transfer Object)
	private String userid;
	private String userpwd;
}
