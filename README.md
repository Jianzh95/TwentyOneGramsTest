# TwentyOneGramsTest

## Couple of urls to request to the API.

### All movies

http://localhost:8080/allMovies

//Response containing all movies

### Single movie by title

localhost:8080/movies/{title}

//Response containing a single movie by title.  
Example: http://localhost:8080/movies/Avatar

### Genre and language

localhost:8080/movies/{genre}/{language}

//Response containing movies filtered by genre and language  
Example: http://localhost:8080/movies/Action/English

### All movies by title

localhost:8080/allTitleMovies/{title}

//Response containing all movies filtered by title  
Example: http://localhost:8080/allTitleMovies/God 


### All movies by plot

localhost:8080/allPlotMovies/{plot}

//Response containing all movies filtered by plot  
Example: http://localhost:8080/allPlotMovies/officer

### All movies by director

localhost:8080/allDirectorMovies/{director}

//Response containing all movies filtered by director  
Example: http://localhost:8080/allDirectorMovies/Christopher Nolan

### All movies by actor

localhost:8080/allActorMovies/{actor}

//Response containing all movies filtered by actor  
Example: http://localhost:8080/allActorMovies/Sean Astin
