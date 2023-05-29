## Weather App Documentation:

**1. Introduction:**

Weather Application is a console based application, build on top of Python3.
The application is accessible from console and return textual result back to the console. 
Application prompt the user for input (such as city, country, temperature, daytime, and month) after that, it process the input the result accordingly.

This app has two major goals.

1)  Find Season of a Country.
2)  Find City's temperature difference from its average.

Following are the technologies we have use in this project:

-   Python3
-   Jupyter Notebook / SublimeTextEditor / Visual Studio Code


**2. Modularity:** 

Based on scenarios A and B, find the season of the year when a country name and month of the year are given. Finding whether a given temperature reading is above or below the average temperature of a city (morning or evening)

1. **Module 1: get\_season**

Imports: 'country'(string), month (integer)

Exports: result\_text (string), result\_image (string

Description: This module takes a country name and a month as inputs and determines the corresponding season for the given country and month. It checks the input against a predefined dictionary of countries and their associated seasons. The module returns the season in text format (result\_text) and the file path of the graphical representation of the season (result\_image).


2. **Module 2: get\_average\_temperature**

Imports: city (string),time\_of\_day (string),temperatue\_data(float)

Exports: average\_temperature (float)

Description: This module retrieves the average temperature for a given city from a predefined dictionary of city temperatures. It takes the city name as input and returns the average temperature.

**3. Module 3: compare\_temperature**

Imports: temperature(float),average\_temperature(float) 

Exports: message(string)

Description: This module compares a specific temperature value with the average temperature of the city. If the difference between the temperature and the average temperature is more than 5 degrees Celsius, a message is returned indicating that the temperature is above or below the average. Otherwise, it returns a message that the temperature is within the normal range.

**4. Module 4: display\_output(output)**

Imports: Output(str)

Exports: None



Description: This module displays the output to the user. It takes a string as input and prints it on the screen for the user to see.




All the inputs for these modules are passed as parameters. Inputs for get\_season and get\_average\_temperature are strings and integers, respectively. Outputs for get\_season include the season as a string and the season symbol as a string. Outputs for get\_average\_temperature include the average temperature as a float. The outcome for compare\_temprature is a string message. Output for display\_output is None.



3\. **Modularity:** 

Implementation of the production code, reviewing and refactoring

**Get Season Module:**

```sh
from PIL import Image

# Define the season definitions
season_definitions = {
    'Summer': (12, 1, 2),
    'Autumn': (3, 4, 5),
    'Winter': (6, 7, 8),
    'Spring': (9, 10, 11),
    'Birak': (12, 1),
    'Bunuru': (2, 3),
    'Djeran': (4, 5),
    'Makuru': (6, 7),
    'Djilba': (8, 9),
    'Kambarang': (10, 11),
    'Fall': (9, 10, 11),
    'Northeast-Monsoon': (12, 1, 2),
    'Inter-Monsoon': (3, 4),
    'Southwest-Monsoon': (5, 6, 7, 8),
    'Second Inter-Monsoon': (9, 10, 11),
    'First Inter-Monsoon': (2, 3, 4),
    'Monsoon': (9, 10, 11)
}

def get_season(country, month):
    # Define the seasons for different countries
    seasons = {
        'Australia': {
            'Meteorological': ['Summer', 'Autumn', 'Winter', 'Spring'],
            'Noongar': ['Birak', 'Bunuru', 'Djeran', 'Makuru', 'Djilba', 'Kambarang']
        },
        'Spain': ['Winter', 'Spring', 'Summer', 'Autumn'],
        'Japan': ['Winter', 'Spring', 'Summer', 'Autumn'],
        'Mauritius': ['Winter', 'Spring', 'Summer', 'Autumn'],
        'Sri Lanka': ['Northeast-Monsoon', 'Inter-Monsoon', 'Southwest-Monsoon', 'Second Inter-Monsoon'],
        'Malaysia': ['Northeast-Monsoon', 'First Inter-Monsoon', 'Southwest-Monsoon', 'Second Inter-Monsoon']
        }

    # Convert month string to integer
    month = int(month)

    # Find the season for the given country and month
    season = None
    if country in seasons:
        country_seasons = seasons[country]
        if country == 'Australia':
            # Prompt the user to choose between meteorological and Noongar seasons
            season_type = input("Choose the season type (Meteorological/Noongar): ")
            if season_type.capitalize() in country_seasons:
                country_seasons = country_seasons[season_type.capitalize()]
        for s in country_seasons:
            if month in season_definitions[s]:
                season = s
                break

    # If season not found, return None
    if not season:
        return None, None

    # Return season in text and graphical format
    image_file = f"ISEimages/{season.lower()}.png"
    return f"The season in {country} is {season}", image_file

```

This is how you will test the season module

``` sh

country = input("Enter a country name: ").capitalize()
month = input("Enter a month (1-12): ")

result = get_season(country, month)
print(result)
if result is None:
    print("Season not found for the given input.")
else:
    result_text, result_image = result
    print(result_text)
    with Image.open(result_image) as img:
        img.show()

```

**Result :** 

```sh

Enter a country name: Spain
Enter a month (1-12): 5
('The season in Spain is Autumn', 'ISEimages/autumn.png')
The season in Spain is Autumn

```

**Get Temperature Module:**

```sh

def get_average_temperature(city, time_of_day, temperature_data):
    city = city.lower()
    time_of_day = time_of_day.lower()

    if city in temperature_data and time_of_day in temperature_data[city]:
        average_temperature = temperature_data[city][time_of_day]
        return average_temperature
    else:
        return None

def compare_temperature(temperature, average_temperature):
    difference = temperature - average_temperature
    if difference > 5:
        message = f"Temperature is {difference}°C above average. It's significantly higher!"
    elif difference < -5:
        message = f"Temperature is {abs(difference)}°C below average. It's significantly lower!"
    else:
        message = f"Temperature is within the normal range."
    return message

def display_output(output):
    print(output)

temperature_data = {
    "perth": {"morning": 18.2, "evening": 23.0},
    "adelaide": {"morning": 16.5, "evening": 21.0},
    "nepal": {"morning": 8.5, "evening": 12.0},
    "kathmandu": {"morning": 6.5, "evening": 26.0},
    "pokhara": {"morning": 4.5, "evening": 11.0}
    
   
}

```

Here is how we can execute the above code

```sh

city = input("Enter the city: ").lower()
time_of_day = input("Enter the time of day (morning or evening): ").lower()
temperature = float(input("Enter the temperature reading: "))

average_temperature = get_average_temperature(city, time_of_day, temperature_data)

if average_temperature is not None:
    message = compare_temperature(temperature, average_temperature)
    output = f"Average temperature in {city} during {time_of_day}: {average_temperature}°C\n{message}"
else:
    output = f"No average temperature data found for {city} during {time_of_day}. Please enter a valid city."

display_output(output)


```

Result

```sh

Enter the city: Nepal
Enter the time of day (morning or evening): morning
Enter the temperature reading: 15
Average temperature in nepal during morning: 8.5°C
Temperature is 6.5°C above average. It's significantly higher!

```


**The production code demonstrates the use of good modularity principles. Here's how these principles are applied:**

- **Divide and conquer:**  The code is divided into small functions to handle specific tasks. For example, the ‘get\_season()’ function is responsible for determining the season based on the country and month input. The’get\_average\_temperature()’ function retrieves the average temperature for a given city and time of day from the ‘temperature\_data’ dictionary. The ‘compare\_temperature()’ function compares the input temperature with the average temperature. The ‘display\_output()’ function is responsible for displaying the e output.

- **Encapsulation**: The functionality related to determining the season is encapsulated within the ‘get\_season()’ function, which takes care of processing the input and returning the corresponding season.

- **Maintainabilit**y: The code utilizes meaningful variable names and includes comments to enhance code readability and maintainability.

- **Code complexity reduction:** The code uses dictionaries (‘season\_definitions’ and ‘seasons’) to organize and store season-related information and uses dictionaries ‘temperature\_data’ to store temperature information for different cities and times of the day. This reduces code complexity by providing a clear and structured representation of the data.


- **Coupling:** The modules are loosely coupled as they communicate through function parameters and return values rather than relying on global variables. Control flags are not used in the code. Data is passed explicitly through function parameters.

- **Cohesion:** Each module performs a specific and well-defined task, contributing to the overall functionality of the program. The tasks within each module are related and have a clear purpose.  There is no evidence of poor cohesion or performing unrelated tasks within a module.

- **Redundancy:**  The code avoids redundancy by utilizing functions to encode reusable logic. There are no apparent complications or replications within the code.
- **Code Reuse:** The code separates functionality into different modules, allowing them to be reused independently if needed. The code promotes code reuse by using the ‘season\_definitions’ dictionary to define seasons and reusing it within the ‘get\_season()’ function to determine the season based on the month. Similarly,  the code promotes code reuse by utilizing the ‘temperature\_data’ dictionary in the ‘get\_average\_temprature()’ function to retrieve the average temperature based on the city and time of day inputs.

Here's a short review checklist to evaluate whether good code design principles have been followed:

1. **Modularity:**
- Have you divided your code into smaller, self-contained modules or functions that perform specific tasks?

1. **Encapsulation:**
- Have you encapsulated related functionality within modules, classes , and functions, making them independent and reusable?


1. **Readability:**
- Is your code easy to read and understand? Have you used meaningful variable and function names, and have you added comments when necessary?



1. **Maintainability:**
- Is your code designed to be maintainable? Have you considered code refactoring and ensured that it can be easily modified or extended in the future?



1. **Code Complexity reduction**: 
- Have you minimized code complexity by keeping functions and modules focused on a single task?  
- Are there any unnecessary or redundant code blocks that can be removed?
1. **Coupling and cohesion:** 
- Have you managed the interdependencies between different modules or functions (coupling) to ensure loose coupling and high cohesion? 
- Are there any unnecessary dependencies or tight couplings that can be reduced?
1. **Code Reuse:** 
- Have you promoted code reuse by extracting common functionalities into separate functions or classes that can be used in multiple parts of your codebase?
1. **Performance:**
- **  Have you considered the performance implications of your code design?

**Review Checklist**

- Read all the requirements and understand them well.
- Preliminary design (that must be capable to perform application's goal).
- Identify the need of various modules for an organized and reusable software product.
- Document them all (specify the role of each module).
- Once program structure is ready, it is time to identify branches names for version control.
- It is time to jump into writing code (language of your choice).
- At this stage, you may need version control tool such as git for maintaining application’s version.
- Write White Box and Black Box test cases to see if everything works or behave as intended. 
- If you identify any issues, update your code to fix those issues.
- Finally, deploy the app.


While the production code uses good modularity principles so far I haven’t identified any issues from the generated checklist.



**4. Test Design ( Black box testing )**

1. **Equivalence partitioning method**

**Module 1: ‘get\_season’**



|Category |Test Data|Expected Result|
| :- | :- | :- |
|Valid Input |Country =”Australia”, month =3|<p>result\_text: “ The season in Australia is Autumn “</p><p></p>|
|Invalid Input|country=” Australia”, month=15|<p>Result\_text: “None(season not found for the given input)</p><p></p>|
|Valid Input|country=” Spain”,month=7|<p>result\_text:” The season in Spain is Winter”</p><p></p>|
|Invalid Input|country=”Switzerland”, month =3|result\_text: None(season not found for the given input)|
|Invalid Input|country=”Australia”, month=-3|<p>Result\_text: None(season not found for the given input)</p><p></p>|


The category is classified into valid inputs and invalid inputs. The valid inputs with country names and month values correspond to valid combinations of country-season mappings. The expected result is the respective season texts for each country-month combination. The invalid inputs have an unrecognized country name and an invalid month value. The expected result is None since the module is expected to handle such cases by returning None. This set of test cases using the equivalence partitioning method helps cover different scenarios and ensures that the module handles both valid and invalid inputs correctly.


Following are the test-cases we have in our program.

```sh

# EQUIVALENCE PARTITIONING
    # Here we will write VALID and INVALID cases on the basis of Month and Country

    def test_eqvp_month_invalid(self):

        # INVALID { Month below 1 }
        # Test case 1: invalid input - Country: Australia, Month: -3
        
        result_text, result_image = get_season("Australia", -3)
        expected_text = "The season in Australia is Autumn"
        self.assertNotEqual(result_text, expected_text, f"Expected: {expected_text}, Actual: {result_text}")
    
    
    def test_eqvp_country_invalid(self):
        
        # INVALID { Country outside our domain }
        # Test case 2: invalid input - Country: Switzerland, Month: 3
        
        result_text, result_image = get_season("Switzerland", 3)
        self.assertIsNone(result_text, f"Expected: None, Actual: {result_text}")


    def test_eqvp_season_image_invalid(self):
        
        # INVALID { Country outside our domain }
        # Test case 3: invalid input - Country: Pakistan, Month: 3
        
        result_text, result_image = get_season("Pakistan", 3)
        expected_image = f"ISEimages/winter.png"
        self.assertIsNone(result_image, f"Expected: {expected_image}, Actual: {result_image}")    

    def test_eqvp_month_valid(self):

        # VALID { Month between 1 - 12 }
        # Test case 4: valid input - Country: Spain, Month: 7
        
        result_text, result_image = get_season("Spain", 7)
        expected_text = "The season in Spain is Winter"
        self.assertEqual(result_text, expected_text, f"Expected: {expected_text}, Actual: {result_text}")

    def test_eqvp_month_invalid_range(self):

        # INVALID { Month above 12 }
        # Test case 5: invalid input - Country: Australia, Month: 15
        
        result_text, result_image = get_season("Australia", 15)
        expected_text = None
        self.assertIsNone(result_text, f"Expected: {expected_text}, Actual: {result_text}")

```


**Module 2: “get\_average\_temperature”**


|Category |Test Data|Expected Result|
| :- | :- | :- |
|Valid Input |City =”Perth”, day\_time=”Morning”|<p>avg\_temp: 18.2</p><p></p>|
|invalid Input |City =”Perth”, day\_time=”Morning”|<p>avg\_temp: 22.2</p><p></p>|
|invalid Input |<p>City =”Nepal”, day\_time=”Morning”,</p><p>Temperature=”14”</p>|<p>Expected\_text:  </p><p>Temperature is 5°C above average. It's significantly higher!</p>|
|invalid Input |<p>City =”Lahore”, day\_time=”Morning” </p><p><br></p>|<p>Expected\_text:  </p><p>None</p>|
|Valid Input |<p>City =”Nepal”, day\_time=”Morning”,</p><p>Temperature=8.4</p>|expected\_text = "Temperature is within the normal range."|


Here we have categories the results into Valid and Invalid outputs. The inputs to the test case include City name, day\_time, and temperature values. In the above test cases we have tried various combinations. These include; Invalid city name, Invalid temperature reading (compare to average), Invalid comparison to the expected value. On the other hand, valid combination include valid city, day\_time, temperature value etc.


```sh

    # EQUIVALENCE PARTITIONING
    # Here we will write VALID and INVALID cases on the basis of Day Time and City

    
    def test_eqvp_city_invalid(self):
        
        # INVALID { City outside our domain }
        # Test case 1: invalid input - City: Lahore, Morning
        
        result_text = get_average_temperature("Lahore", "Morning", temperature_data)
        expected_text = None
        self.assertIsNone(result_text, f"Expected: {expected_text}, Actual: {result_text}")


    def test_eqvp_city_valid(self):

        # VALID { City within the domain }
        # Test case 2: valid input - City: Perth
        
        avg_temp = get_average_temperature("Perth", "Morning", temperature_data)
        expected_text = 18.2
        self.assertEqual(avg_temp, expected_text, f"Expected: {expected_text}, Actual: {avg_temp}")

    def test_eqvp_temp_invalid(self):

        # INVALID { Average Temperature above original }
        # Test case 3:

        avg_temp = get_average_temperature("Perth", "Morning", temperature_data)
        expected_text = 22.2
        self.assertNotEqual(avg_temp, expected_text, f"Expected: {expected_text}, Actual: {avg_temp}")

```



1. **Boundary Value Analysis** 

In the case of boundary value analysis, our aim is to test our app’s module on the edges values also called boundary values. Following are the test cases we have performed to ensure boundaries are correctly incorporated in the program. 

**Module 1: ‘get\_season’**


|Category|Test Data|Expected Value|
| :- | :- | :- |
|Invalid|<p>Country=”Spain” </p><p>Month = 0</p>|None|
|Valid|<p>Country=”Spain”,</p><p>Month = 12</p>|The season in Spain is Summer|
|Invalid|<p>Country=”Spain” </p><p>Month = 13</p>|None|


``` sh

# BOUNDARY VALUE ANALYSIS
    # Here we will write VALID and INVALID cases on the basis of Month

    def test_bva_month_zero_invalid(self):

        # INVALID { Month equals 0 }
        # Test case 6: invalid input - Country: Spain, Month: 0
        
        result_text, result_image = get_season("Spain", 0)
        expected_text = None
        self.assertIsNone(result_text, f"Expected: {expected_text}, Actual: {result_text}") 

    def test_bva_month_valid(self):

        # INVALID { Month equals 12 }
        # Test case 7: invalid input - Country: Spain, Month: 12
        
        result_text, result_image = get_season("Spain", 12)
        expected_text = "The season in Spain is Summer"
        self.assertEqual(result_text,expected_text, f"Expected: {expected_text}, Actual: {result_text}") 

    def test_bva_month_thirteen_invalid(self):

        # INVALID { Month equals 13 }
        # Test case 8: invalid input - Country: Spain, Month: 13
        
        result_text, result_image = get_season("Spain", 13)
        expected_text = None
        self.assertIsNone(result_text, f"Expected: {expected_text}, Actual: {result_text}")   

```


**Module 2: “get\_average\_temperature”**


|Category|Test Data|Actual|Expected Value|
| :- | :- | :-: | :- |
|Invalid|<p>Country=”Nepal”,</p><p>Day\_time = “Morning”,</p><p>Temperature = 14</p>|Average\_temp = 8.5|"Temperature is 5.5°C above average. It's significantly higher!"|
|Valid|<p>Country=”Nepal”,</p><p>Day\_time = “Morning”,</p><p>Month = 8.4</p>|Average\_temp = 8.5|"Temperature is within the normal range."|
|Invalid|<p>Country=”Nepal”,</p><p>Day\_time = “Morning”,</p><p>Month = 3.4</p>|Average\_temp = 8.5|"Temperature is 5.1°C below average. It's significantly lower!"|


```sh

 # BOUNDARY VALUE ANALYSIS
    # Here we will write VALID and INVALID cases on the basis of Month

    def test_bva_cmp_temp_invalid(self):

        # INVALID { Temperature equals 14 }
        # Test case 4: invalid input - Temperature: 14
        
        avg_temp = get_average_temperature("Nepal", "Morning", temperature_data)
        result_text = compare_temperature(14, avg_temp)
        expected_text = f"Temperature is within the normal range."
        self.assertNotEqual(result_text, expected_text, f"Expected: {expected_text}, Actual: {avg_temp}")



    def test_bva_cmp_temp_valid(self):

        # VALID { Temperature equals 8.4 }
        # Test case 5: invalid input - Nepal average temperature: 8.4
        
        avg_temp = get_average_temperature("Nepal", "Morning", temperature_data)
        result_text = compare_temperature(8.4, avg_temp)
        expected_text = f"Temperature is within the normal range."
        self.assertEqual(result_text, expected_text, f"Expected: {expected_text}, Actual: {avg_temp}")

    
    def test_bva_cmp_temp_invalid_(self):

        # INVALID { Temperature equals 3.4 }
        # Test case 6: invalid input - Nepal average temperature: 3.4
        
        avg_temp = get_average_temperature("Nepal", "Morning", temperature_data)
        result_text = compare_temperature(3.4, avg_temp)
        expected_text = f"Temperature is 5.1°C below average. It's significantly lower!"
        self.assertEqual(result_text, expected_text, f"Expected: {expected_text}, Actual: {avg_temp}")

```


**White Box Testing**

White box testing is done to ensure quality and internal structure can both be tested. For demonstration purposes, we run a white box test to make sure the system returns the correct records. We check the size of the season and temperature data in our system i.e. it shouldn't be empty.**  

**Module 1: ‘get\_season’**


|Category|Test Data|Expected Value|
| :- | :- | :- |
|Invalid|<p>season\_definitions</p><p>length > 0</p>|True|

```sh

    # 2) WHITEL BOX TEST CASES
    # Code quality and internal structure can both be tested. For demonstration purposes, 
    # let's imagine we run a white box test to make sure the system returns the correct records. 
    # We'll check the size of the season data in our system i.e. it shouldn't be empty.

    def test_white_box_valid(self):

        # VALID { Season Records Shouldn't be empty }
        # Test case 9: 

        definition_lenth = len(season_definitions)
        self.assertGreater(definition_lenth, 0, f"Expected: Non Zero, Actual: {definition_lenth}")  


```


**Module 2: “get\_average\_temperature”**


|Category|Test Data|Expected Value|
| :- | :- | :- |
|Invalid|Temperature\_data length > 0|True|

```sh
    # 2) WHITEL BOX TEST CASES
    # Code quality and internal structure can both be tested. For demonstration purposes, 
    # let's imagine we run a white box test to make sure the system returns the correct records. 
    # We'll check the size of the season data in our system i.e. it shouldn't be empty.

    def test_white_box_valid(self):

        # VALID { Temperature Records Shouldn't be empty }
        # Test case 7: 

        definition_lenth = len(temperature_data)
        self.assertGreater(definition_lenth, 0, f"Expected: Non Zero, Actual: {definition_lenth}") 

```

**Ethical Challenges & Professionalism**

Here are some potential ethical challenges to consider:
- Data Accuracy and Bias: 
  Ensuring the accuracy and reliability of the temperature data used in the program is crucial. Biases in the data, such as underrepresentation of certain regions or inaccurate measurements, can lead to misleading or unfair results.
- Cultural Sensitivity: Consider the cultural and social implications of associating seasons with specific countries. Avoid reinforcing stereotypes or generalizations that may perpetuate cultural biases or misrepresentations.
- Transparency and Accountability: Clearly communicate the limitations, assumptions, and potential biases of the program to users. Be transparent about how decisions are made and ensure accountability for any issues or errors that may arise.

It is important to carefully address these ethical challenges by considering the impact of the program on individuals, communities, and the environment. Regularly assess and review the ethical implications of the project to ensure responsible and inclusive practices.

**Professionalism** 
In the context of your app it refers to conducting ourself and our project in a manner that upholds high standards, integrity, and ethical behavior. Here are some aspects of professionalism that we consider throughout:

- Reliability
- Communication
- User-Centric Approach
- Professional Design
- Collaborative Approach
- Continuous Learning and Improvement

**Conclusion**
With this we finally reach the conclusion about Weather Application. As discussed earlier, it serve two primary purposes i.e. Finds season of a country in the given month and the temperature difference with the average temperature of a city. In this Software Engineering project, we try to utilize the best industry practices starting from software design till the deployment phase. We started the journey with a basic design and then added features on top of it. We focuses on the principal of modularity, divide and conquer approach, and seperation of concern. It also demonstrates our commitment to utilizing best practices in software engineering. By adhering to professional standards, ethical considerations, and continuously improving our design and features, we have developed a reliable and user-friendly application that provides accurate season data and temperature differences. We are proud of the outcomes of this project and believe it will serve its intended purpose effectively.

