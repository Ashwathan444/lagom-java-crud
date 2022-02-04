package com.lagom;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.Optional;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.transport.Method.*;

public interface MovieService extends Service {

    ServiceCall<NotUsed, Optional<Movie>> movie(String id);


    ServiceCall<Movie, Done> newMovie();


    ServiceCall<Movie, Done> updateMovie(String id);


    ServiceCall<NotUsed, Done> deleteMovie(String id);
    

    ServiceCall<NotUsed, Done> health();


    @Override
    default Descriptor descriptor() {

        return named("movie").withCalls(
                restCall(GET, "/api/movie/:id", this::movie),
                restCall(GET, "/api/movie/health", this::health),
                restCall(POST, "/api/new-movie", this::newMovie),
                restCall(PUT, "/api/update-movie/:id", this::updateMovie),
                restCall(DELETE, "/api/delete-movie/:id", this::deleteMovie)
        ).withAutoAcl(true);
    }
}
