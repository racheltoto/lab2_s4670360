*NIT3213 Final Assignment: Android Application Development - s4670360 Rachel Leung*

*Project Overview*

This Android application is developed as part of the NIT3213 Final Assignment. It demonstrates proficiency in API integration, user interface design, and best practices in Android development. The app interacts with the 'vu-nit3213-api' to authenticate users and retrieve data, featuring three main screens: Login, Dashboard, and Details.

*Objective*

The objective of this project is to build an Android app that allows users to log in, view a list of entities, and navigate to a detailed view of each entity. It follows clean architecture principles, utilizes dependency injection via Hilt, and includes unit tests for critical components.

*API Details*

Base URL:
`https://nit3213-api-h2b3-latest.onrender.com`

Endpoints:

1. **Login Endpoint:**
   - URL: `https://nit3213-api-h2b3-latest.onrender.com/footscray/auth`
   - Method: POST
   - Request Body:
     ```json
{
"username": "Rachel",
"password": "s4670360"
}
     ```
   - Successful Response:
     ```json
{
    "keypass": "history"
}
     ```

2. **Dashboard Endpoint:**
   - URL: `https://nit3213-api-h2b3-latest.onrender.com/dashboard/history`
   - Method: GET
   - Successful Response:
     ```json
     {
    "entities": [
        {
            "event": "World War II",
            "startYear": 1939,
            "endYear": 1945,
            "location": "Global",
            "keyFigure": "Winston Churchill",
            "description": "A global war that involved the vast majority of the world's countries, including all of the great powers."
        },
        {
            "event": "American Revolution",
            "startYear": 1765,
            "endYear": 1783,
            "location": "North America",
            "keyFigure": "George Washington",
            "description": "A colonial revolt that resulted in the independence of the United States of America from Great Britain."
        },
        {
            "event": "French Revolution",
            "startYear": 1789,
            "endYear": 1799,
            "location": "France",
            "keyFigure": "Napoleon Bonaparte",
            "description": "A period of far-reaching social and political upheaval in France that overthrew the monarchy and established a republic."
        },
        {
            "event": "Industrial Revolution",
            "startYear": 1760,
            "endYear": 1840,
            "location": "Europe and North America",
            "keyFigure": "James Watt",
            "description": "A period of major industrialization that saw a transition from hand production methods to machines and new manufacturing processes."
        },
        {
            "event": "Cold War",
            "startYear": 1947,
            "endYear": 1991,
            "location": "Global",
            "keyFigure": "John F. Kennedy",
            "description": "A period of geopolitical tension between the United States and the Soviet Union and their respective allies."
        },
        {
            "event": "Renaissance",
            "startYear": 1300,
            "endYear": 1600,
            "location": "Europe",
            "keyFigure": "Leonardo da Vinci",
            "description": "A period of cultural, artistic, political, and economic revival following the Middle Ages."
        },
        {
            "event": "Fall of the Berlin Wall",
            "startYear": 1989,
            "endYear": 1989,
            "location": "Berlin, Germany",
            "keyFigure": "Mikhail Gorbachev",
            "description": "The fall of the Berlin Wall, a pivotal event symbolizing the end of the Cold War and the Iron Curtain's division of Europe."
        }
    ],
    "entityTotal": 7
}
     ```


*Screens*

1. Login Screen
- A form that allows the user to log in using their first name and student ID.
- Makes a POST request to the appropriate endpoint based on class location.
- Upon successful login, the app navigates to the Dashboard screen.
- Displays error messages for failed login attempts.

2. Dashboard Screen
- Displays a list of entities in a `RecyclerView`.
- Uses the `keypass`-> "history" from the login response to make a GET request.
- Each item in the `RecyclerView` shows a summary of the entity.
- Clicking on an entity navigates to the Details screen.

3. Details Screen
- Displays detailed information about the selected entity.
- Includes a user-friendly layout to present the entity description and properties.

Technology Stack

- Kotlin: Primary programming language.
- Retrofit & Moshi: For network requests and JSON parsing.
- Dagger Hilt: For dependency injection.
- JUnit: For unit testing.
- AndroidX: Modern Android components.

*Setup and Installation*

1. Clone the repository:
   ```bash
   git clone https://github.com/racheltoto/lab2_s4670360

2. Open the project in Android Studio.

3. Build the project and ensure all dependencies are resolved.

4. Run the project on an Android emulator - Pixel 8a API 35

*How to Use the App*
Login: Enter username and student ID (e.g., "Rachel", "s4670360").
Dashboard: View a list of historical events, click on the button of "Show Data" to view more detailed information.
Details: More detailed information show on this page.
Logout: Allow user return to the login page.

*Claim*
This project is part of the NIT3213 Final Assignment and is for educational purposes.
     
