package br.com.jeduardo.reactive.webflux.controller;

import br.com.jeduardo.reactive.webflux.document.Playlist;
import br.com.jeduardo.reactive.webflux.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistService service;

    @GetMapping
    public Flux<Playlist> getPlaylist() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Playlist> getPlaylistById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Playlist> addPlaylist(@RequestBody Playlist playlist) {
        return service.save(playlist);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = service.findAll();
        System.out.println(Thread.currentThread().getName());
        return Flux.zip(interval, events);
    }

}
