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

Media:
- **GET** `media/read/{id}` - Reads specific media from the database with given id.
- **GET** `media/read` - Reads all media in the database.
- **POST** `media/create` - Adds a media to the database. You must include the field values in JSON format in the request body.
- **DEL** `media/delete/{id}` - Deletes media with the given id if it exists in the database.
- **PUT** `media/update/{id}` - Updates a specific media with the given id. You must include the fields in JSON format in the body.

MediaType:
- **GET** `mediatype/read/{id}` - Reads specific media type from the database with given id.
- **GET** `mediatype/read` - Reads all media types in the database.
- **POST** `mediatype/create` - Adds a media type to the database. You must include the field values in JSON format in the request body.
- **DEL** `mediatype/delete/{id}` - Deletes a media type with the given id if it exists in the database.
- **PUT** `mediatype/update/{id}` - Updates a specific media type with the given id. You must include the fields in JSON format in the body.
