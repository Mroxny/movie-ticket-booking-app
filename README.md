# movie-ticket-booking-app
Cinema ticket booking management system

Description
----

The application is a seat reservation system for a multiplex cinema, written in Java and exposed as REST services. It allows users to select a day, time, and movie to view, and then choose from available seats and ticket types. It handles reservations, including calculation of the total amount to pay and reservation expiration time, and includes a default set of test data for multiple screening rooms, movies, and screenings.

Installation
----

You can install the project by downloading the [.zip]() file and typing `java -jar movie-ticket-booking-app-0.0.1-SNAPSHOT.jar` or clone the project and typing `mvn package`


How to use
----
The application contains test data that helps you understand how the application works. You can use the app in different ways, for example:

Example curl commands:
* `curl -X GET http://localhost:8080/allScreening` - List of all screenings
* `curl -X GET http://localhost:8080/screenings?day=YYYY-MM-DD&startTime=HH:MM&endTime=HH:MM` - List movies available for the given day and time interval
* `curl -X GET http://localhost:8080/screening?id=#` - Get information about the specific screening, where *#* is ID of the screening
* `curl -X GET http://localhost:8080/reservations?id=#` - Get information about the specific reservation, where *#* is ID of the reservation
* `curl -X POST -H "Content-Type: application/json" -d '{ "name": "Jan", "surname": "Kowalski", "screeningId": 1, "seats": [ { "row": 1, "column": 2, "ticketType": "ADULT" } ] }' http://localhost:8080/reservations` - make reservation

The whole thing can also be done in *Postman*. To make a reservation in this program you can:
1. In the "Create a new request" dialog, select "POST" as the HTTP method and enter the URL for the 'localhost:8080/reservations' endpoint in the "Enter request URL" field.
2. In the "Body" tab, select the "raw" radio button and select "JSON (application/json)" from the dropdown list.
3. In the request body, enter the reservation data as a JSON object. The JSON object should include the name and surname of the person making the reservation, the id of the screening, and a list of seats.
```
{
    "name": "Jan",
    "surname": "Kowalski",
    "screeningId": 3,
    "seats": [
        {
            "row": 1,
            "column": 2,
            "seatType": "CHILD"
        },
        {
            "row": 1,
            "column": 3,
            "seatType": "ADULT"
        }
    ]
}
```

Assumptions
----
Some basic assumptions:
* A maximum of 10 seats can be booked
* All seats must be booked in one row in one reservation
* All seats are *ADULT* by default

