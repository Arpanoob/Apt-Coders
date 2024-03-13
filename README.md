
Assignment Submission with Spring Boot and Redis

Introduction:
For this assignment submission, we have developed a Spring Boot application with an in-memory Redis database to manage course-related information. The application provides routes to perform CRUD operations on courses and ensures proper authorization using authorities such as STUDENT, TEACHER, and COURSECREATOR.

Routes:

/course/get

Method: GET
Header:
authority: STUDENT, TEACHER, COURSECREATOR
Response:
JSON Object representing the course details.
Example:
Student =>{
    "id": -8713011235329858928,
    "subject": "Math",
    "chapters": 12,
    "noOfClasses": 0,
    "learnMode": "online",
    "role": "STUDENT"
}
/course/add

Method: POST
Body:
String name
String subject
int chapters
Enum(type): PERSONALISED (0) or GROUP (1)
String learnMode
Response:
Success (200)
/course/update/{id}

Method: PUT
Path Variable: id (Course ID)
Body:
String name
String subject
int chapters
Enum(type): PERSONALISED (0) or GROUP (1)
String learnMode
Response:
No Content (204)
/course/delete/{id}

Method: DELETE
Path Variable: id (Course ID)
Response:
No Content (204)
Authorization:

get route requires an authority header to specify the role of the user (STUDENT, TEACHER, or COURSECREATOR).
Unauthorized access results in a status code 401 (UNAUTHORIZED).
Conclusion:
This Spring Boot application provides a  API for managing course-related data with proper authorization. By utilizing an in-memory Redis database, the application ensures efficient data storage and retrieval. With these routes, users can seamlessly perform CRUD operations on courses based on their roles.






