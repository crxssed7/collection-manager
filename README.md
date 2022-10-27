# Collection Manager

**QA Project - Tanveer Najib**

A simple project to allow the categorisation of media (books, movies, video games, music, etc).

**What could be improved?**

In the long run, I would like to add more database tables for further categorisation. I would also like to add a nice looking frontend.

**How to run the project**

1. Clone this repository.
2. Port 8080 must be available for the project to run.
3. Install `Eclipse`, `SpringToolSuite`, and `MySQL`
4. Update your database credentials in `application.properties`
5. Run the project from within `SpringToolSuite`.
6. Send requests to the API using an API client such as `Postman` or `Insomnia`.

## Documentation

**Database Structure**

One MediaType can have many Media, however one Media can only have one MediaType. This is a Many-To-One relationship.

![erd](images/erd.png)

**Endpoints**
