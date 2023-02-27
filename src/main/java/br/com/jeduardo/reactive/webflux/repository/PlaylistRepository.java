package br.com.jeduardo.reactive.webflux.repository;

import br.com.jeduardo.reactive.webflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
