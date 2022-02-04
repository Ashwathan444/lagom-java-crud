package commands;

import akka.Done;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lagom.Movie;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.Jsonable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Optional;

public interface MovieCommand extends Jsonable {

    @Value
    @Builder
    @JsonDeserialize
    @AllArgsConstructor
    final class CreateMovie implements MovieCommand, PersistentEntity.ReplyType<Done> {
        Movie movie;
    }

    @Value
    @Builder
    @JsonDeserialize
    @AllArgsConstructor
    final class UpdateMovie implements MovieCommand, PersistentEntity.ReplyType<Done> {
        Movie movie;
    }

    @Value
    @Builder
    @JsonDeserialize
    @AllArgsConstructor
    final class DeleteMovie implements MovieCommand, PersistentEntity.ReplyType<Done> {
        Movie movie;
    }

    @JsonDeserialize
    final class MovieCurrentState implements MovieCommand, PersistentEntity.ReplyType<Optional<Movie>> {}
}
