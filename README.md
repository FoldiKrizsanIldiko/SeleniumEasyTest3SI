Practice
General Rules:

Don't use Selenium in JUnit tests, only in keywords or POM.
Don't use assertation in keywords, assert in the test methods.
Solve every exercises with POM and Keyword Driven methods too
Lets get back to the roots! Recreate your former tests as a new project, with Keyword-Driven Testing, Data-Driven Testing and POM (implement at least the Extensions tasks for each excercise).

First exercise - Navigation:

Open the base url. Using the "Menu List" navigate to All Examples/Input Forms/Simpe Form Demo
Base url: https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html
Extension: Create reusable navigation keyword (and reuse it :])
Second exercise - Single field & Button:

Navigate to Simpe Form Demo. In "Single Input Field" enter a message into the field and click "Show Message" button. Validate that the message appeared.
Extension: fill the field data-driven way, use a source file for it
Third exercise - Two fields & Output:

Navigate to Simpe Form Demo. In "Two Input Fields" enter value A and B and click the "Get Total" button. Validate that the answer is correct.
Does your test works even when you enter very large numbers?
Extension: use at least 5 rows from data source with expected results, make positive and negative tests (1, a, expected 1a - failing test)
Fourth exercise - Checkbox:

Navigate to Checkbox Demo. In "Single Checkbox Demo" check the checkbox and validate the message.
Bonus if you write a test for "Multiple Checkbox Demo" and find the bug which is present on the webpage.
Extension: create a data source with at least 5 rows, with input combinations for checkbox (something like 1,0,1,0 should tick the 2nd and 4th checkboxes), dont forget validations
Fifth exercise - Select List:

Navigate to Select Dropdown List. In "Select List Demo" select the current day from the dropdown and validate that it's selected.
Try out all the way you can select a day.
Extension: select each days after each other twice (14 in total), use keywords and data source obviously
Sixth exercise - Radio Buttons:

Navigate to Radio buttons Demo. In "Group Radio Buttons Demo" select a combination and click the "Get values" button. Validate the result.
Try to run several combinations in one test.
Extension: create and validate all possible combinations once, use data source and keywords
Advanced (Optional)
Date Picker - Bootstrap:
Navigate to the Bootstrap Date picker in Date Pickers demo
Open the "Select Date" picker and validate if 2019 January 14 was a Monday
Make your test configurable:Make it possible to select any previous date and validate which day of the week was it e.g.: 2017 Dec 8 and 2015, Jan May 5
Extension: Create a huge data excel manually (~100 rows), with dates, and add days to the next columns randomly (example: 2019 January 14, Monday). Verify how many rows have correct days next to them (should be around 14% pass rate with pure random)
Tip for creating test data: use bottom right of a cell in excel, and drag down for 100 rows for column A, and use random for column B)
