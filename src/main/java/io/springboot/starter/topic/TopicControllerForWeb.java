package io.springboot.starter.topic;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TopicControllerForWeb {
	
	@Autowired
	private TopicService topicService;

	 @Value("${welcome.message}")
	 private String message;

	 private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

	
	 @GetMapping("/welcome")
	    public String showSignUpForm(Model model) {
		 model.addAttribute("message",message);
		 model.addAttribute("tasks",tasks);
		 return "welcome";
	    }
	
	 @GetMapping("/signup")
	    public String showSignUpForm(Topic topic) {
		 return "view-topic";
	  }
	
	 @PostMapping("/addTopic")
	    public String addTopic(Topic topic, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "view-topic";
	        }
	         
	        topicService.addTopic(topic);
	        model.addAttribute("topics", topicService.getAllTopics());
	        return "index";
	    }
	 
	 @GetMapping("/edit/{id}")
	 public String showUpdateForm(@PathVariable("id") String id, Model model) {
	     model.addAttribute("topic", topicService.getTopic(id));
	     return "update-topic";
	 }
	 
	 @PostMapping("/update/{id}")
	 public String updateTopic(@PathVariable("id") String id, Topic topic, 
	   BindingResult result, Model model) {
	     if (result.hasErrors()) {
	         topic.setTopicId(id);
	         return "update-topic";
	     }
	          
	     topicService.updateTopic(id, topic);
	     model.addAttribute("topics", topicService.getAllTopics());
	     return "index";
	 }
	      
	 @GetMapping("/delete/{id}")
	 public String deleteTopic(@PathVariable("id") String id, Model model) {
	     
		 topicService.deleteTopic(id);
		 model.addAttribute("topics", topicService.getAllTopics());
	     return "index";
	 }
	 
/*@RequestMapping("/topics/{id}")
public Topic getTopic(@PathVariable String id){
		
	return topicService.getTopic(id);
}

@RequestMapping(method=RequestMethod.POST,value="/topics")
public void addTopic(@RequestBody Topic topic){
		
   topicService.addTopic(topic);
		
}

@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		
	topicService.updateTopic(id,topic);
		
 }

@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
public void deleteTopic(@PathVariable String id){
		
	topicService.deleteTopic(id);
		
 }*/
}
