package action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionForward {
	private String path; //어디로 갈것인가?
	private boolean redirct; // 어떤 방식(forward / sendRedirect)
	
}