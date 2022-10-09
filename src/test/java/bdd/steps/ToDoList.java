package bdd.steps;

import java.io.IOException;

import bdd.pages.HomePage;

import io.cucumber.java.en.*;
import fw.settings.ObjectRepo;

public class ToDoList {

	private HomePage hPage;
	
	@Given("^: I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
			ObjectRepo.getDriver().get(ObjectRepo.reader.getWebsite());
			hPage = new HomePage(ObjectRepo.getDriver());
			ObjectRepo.data.put("HomePage", hPage);	
	}
	
	@Given("^: I am at the home page with two tasks")
	public void i_am_at_the_home_page_with_two_tasks() {
		ObjectRepo.getDriver().get(ObjectRepo.reader.getWebsite());
		hPage = new HomePage(ObjectRepo.getDriver());
		ObjectRepo.data.put("HomePage", hPage);	
		hPage.addTask("Create Report");;
		hPage.addTask("Send Report to Stake holders");;
	}
	
	@Given("^: I am at the home page with two tasks with only one in active status")
	public void i_am_at_the_home_page_with_two_tasks_with_only_one_in_active_status() throws InterruptedException {
		ObjectRepo.getDriver().get(ObjectRepo.reader.getWebsite());
		hPage = new HomePage(ObjectRepo.getDriver());
		ObjectRepo.data.put("HomePage", hPage);	
		hPage.addTask("Create Report");;
		hPage.addTask("Send Report to Stake holders");;
		hPage.clickOnEmptyCircle("Create Report");
	}
	
	@When("^: I Enter \"([^\"]*)\" on the \"([^\"]*)\" text box$")
	public void i_Enter_task_on_the_text_box(String task, String placeholder) throws Throwable {
		hPage.addTask(task);;
	}

	@When("^: I Click empty circle next to \"([^\"]*)\" in tasks list")
	public void i_click_empty_circle_next_to_in_tasks_list(String task) throws InterruptedException {
		 hPage.clickOnEmptyCircle(task);;
	}

	@When("^: I Click green circle next to \"([^\"]*)\" in tasks list")
	public void i_click_green_circle_next_to_in_tasks_list(String task) throws InterruptedException {
		 hPage.clickOnGreenCircle(task);;
	}
	
	@When("^: I Click cross button next to \"([^\"]*)\" task")
	public void i_click_cross_button_next_to_task(String task) {
	    hPage.deleteTask(task);;
	}
	
	@When("^: I Click button \"([^\"]*)\" in tasks list")
	public void i_click_button_in_tasks_list(String buttonName) {
		hPage.ClearCompleted(buttonName);
	}

	@When("^: I Click link \"([^\"]*)\" in tasks list")
	public void i_click_link_in_tasks_list(String filter) {
		hPage.filterLink(filter);
	}
	
	@When("^: I Click \"([^\"]*)\" in tasks list")
	public void i_click_in_tasks_list(String task) throws IOException{
		hPage.taskName(task);
	}
	
	@Then("^: I should not see \"([^\"]*)\" in tasks list")
	public void i_should_not_see_in_tasks_list(String task) throws IOException {
		 hPage.deletedTaskName(task);
	}
	
	@Then("^: I should see the task \"([^\"]*)\" striked off in tasks list")
	public void i_should_see_the_task_striked_off_in_tasks_list(String task) throws IOException {
		hPage.completedTaskName(task);
	}
	
	@Then("^: I should see \"([^\"]*)\"$")
	public void i_should_see_task(String task) throws Throwable {
		/* List<List<String>> data = table.asLists(String.class);
	    String task = data.get(1).get(1); */
	   hPage.taskName(task);
	}
	
	@Then("^: I should see \"([^\"]*)\" in tasks list")
	public void i_should_see_in_tasks_list(String task)  throws Throwable {
		hPage.taskName(task);
	}
	
	@Then("^: I should see a empty circle next to \"([^\"]*)\" in tasks list")
	public void i_should_see_a_empty_circle_next_to_in_tasks_list(String task) {
		hPage.emptyCircleNextToTask(task);
	}

	
	@Then("^: I should see a green tick mark next to \"([^\"]*)\" in tasks list")
	public void i_should_see_a_green_tick_mark_next_to_in_tasks_list(String task) {
	    hPage.greenTickMarkTask(task);
	}

	@Then("^: I should see a new button with name \"([^\"]*)\"")
	public void i_should_see_a_new_button_with_name(String buttonName) {
	    hPage.ClearCompletedExists(buttonName);
	}
	
	@Then("^: I should see the \"([^\"]*)\" items left in tasks list")
	public void i_should_see_the_items_left_in_tasks_list(String items) {
	    hPage.itemsLeft(items);
	}

}
