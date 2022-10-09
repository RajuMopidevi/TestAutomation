Feature: Task Management portal

   @chrome
  Scenario: Add a task to todos List
    Given : I am at the home page
    When : I Enter "Create Report" on the "What needs to be Done?" text box
    Then : I should see "Create Report" in tasks list
    And : I should see a empty circle next to "Create Report" in tasks list    
    When : I Enter "Send Report to Stake holders" on the "What needs to be Done?" text box
    Then : I should see "Send Report to Stake holders" in tasks list
    And : I should see a empty circle next to "Create Report" in tasks list        
  
  @chrome
  Scenario: Mark a task as completed
    Given : I am at the home page with two tasks
    When : I Click empty circle next to "Create Report" in tasks list
    Then : I should see a green tick mark next to "Create Report" in tasks list
    And : I should see the task "Create Report" striked off in tasks list
    And : I should see a new button with name "Clear completed"
   
  
  @chrome
  Scenario: View completed tasks
    Given : I am at the home page with two tasks
    When : I Click empty circle next to "Create Report" in tasks list    
    And : I Click link "Completed" in tasks list
    Then : I should see the task "Create Report" striked off in tasks list   
  
  @chrome
  Scenario: View Active tasks
    Given : I am at the home page with two tasks with only one in active status
    When : I Click link "Active" in tasks list
    Then : I should see "Send Report to Stake holders" in tasks list         

  @chrome
  Scenario: View All tasks
    Given : I am at the home page with two tasks with only one in active status
    When : I Click link "All" in tasks list
    Then : I should see the task "Create Report" striked off in tasks list   
    And : I should see "Send Report to Stake holders" in tasks list  
 
  @chrome
  Scenario: Reverse tasks status
    Given : I am at the home page with two tasks with only one in active status
    When : I Click green circle next to "Create Report" in tasks list    
    Then : I should see a empty circle next to "Create Report" in tasks list 
   
   @chrome
  Scenario: Delete a task using cross button
    Given : I am at the home page with two tasks with only one in active status
    When : I Click link "All" in tasks list
    Then : I should see the "1" items left in tasks list      
    When : I Click cross button next to "Create Report" task
    Then : I should see the "0" items left in tasks list      
    