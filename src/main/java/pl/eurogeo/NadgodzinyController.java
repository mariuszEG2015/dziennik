package pl.eurogeo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NadgodzinyController {
	@Autowired
	NadgodzinyDao nadgodzinyDao;
	@Autowired
	UserDao userDao;

	private List<Nadgodziny> getAllElements() {
		List<Nadgodziny> nadgodzinyList = new ArrayList<Nadgodziny>();
		nadgodzinyDao.findAll().forEach(nadgodzinyList::add);
		
		return nadgodzinyList;
	}
	private List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		userDao.findAll().forEach(userList::add);
		System.out.println("lista userów"+ userList);
		return userList;
	}

	@CrossOrigin
	@RequestMapping("/getall")
	public String getAll(Model model) {

		model.addAttribute("nadgodzinyElement", getAllElements());
		return "jsonTemplate";
	}
	@CrossOrigin
	@RequestMapping("/getalluser")
	public String getAllUsers(Model model) {

		model.addAttribute("userElement", getAllUsers());
		return "jsonTemplate";
	}

	@CrossOrigin
	@RequestMapping(value = "/getElement/{month}")
	public String getElementByMonth(@PathVariable("month") LocalDate day, Model model) {
		int month = day.getMonthValue();
		model.addAttribute("ZakupyMonth:", nadgodzinyDao.findByMonth(month));
		return "jsonTemplate";
	}

	@CrossOrigin
	@RequestMapping(value = "/create/{year}/{month}/{user}")
	public String createElement(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("user") String user,Model model) {

		LocalDate day = LocalDate.of(year, month, 1);
		
		
		Nadgodziny nadgodzinyElement = new Nadgodziny();
		
		if (nadgodzinyDao.findByDayAndUser(day, user)== null ) {
			LocalDate dayNextMonth = day.plusMonths(1);
			int daysInMonth = dayNextMonth.minusDays(1).getDayOfMonth() - day.getDayOfMonth() + 1;
			
			for (int i = 0; i < daysInMonth; i++) {
				System.out.println("day: " + i);
				nadgodzinyElement = new Nadgodziny();
				nadgodzinyElement.setDay(day.plusDays(i));

				nadgodzinyElement.setUwagi("");
				nadgodzinyElement.setMonth(day.getMonthValue());
				nadgodzinyElement.setYear(day.getYear());
				nadgodzinyElement.setUser(user);
				nadgodzinyDao.save(nadgodzinyElement);
				
			};
		}
		
		model.addAttribute("Month dodano:", getAllElements());
		return "jsonTemplate";

	}
	@CrossOrigin
	@RequestMapping(value = "/newuser")
	public String addNewUser(@RequestBody User userElementHttp, Model model) {
	User userElement = new User();
		userElement.setUserName(userElementHttp.getUserName());
		System.out.println("new user: "+userElement.getUserName());
		userDao.save(userElement);
		model.addAttribute("userElement", getAllUsers());
		return "jsonTemplate";
	}
	

	@CrossOrigin
	@RequestMapping(value = "/updateday")
	public String update(@RequestBody Nadgodziny nadgodzinyElementHttp, Model model) {
		System.out.println(nadgodzinyElementHttp.toString());
		LocalDate day = nadgodzinyElementHttp.getDay();
		int saturdayDay = day.getDayOfWeek().getValue();
		
		double liczbaNadgodzin = nadgodzinyElementHttp.getLiczbaNadgodzin();
		String user =  nadgodzinyElementHttp.getUser();
		Nadgodziny nadgodzinyElement = new Nadgodziny();
		nadgodzinyElement = nadgodzinyDao.findByDayAndUser(day,user);
		nadgodzinyElement.setLiczbaNadgodzin(liczbaNadgodzin);
		if (saturdayDay == 6) {

			nadgodzinyElement.setUwagi("sobota");
		}
		if (saturdayDay == 7) {

			nadgodzinyElement.setUwagi("niedziela");
		}
		
		
		nadgodzinyDao.save(nadgodzinyElement);
		model.addAttribute("nadgodzinyElement", getAllElements());
		return "jsonTemplate";
	}
}
