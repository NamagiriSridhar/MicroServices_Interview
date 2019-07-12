package calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calculatorController 
{
	@GetMapping("/add")
	public int add(int x, int y)//http://localhost:8010/add?x=9&y=78
	{
		return x+y;
	}

}
