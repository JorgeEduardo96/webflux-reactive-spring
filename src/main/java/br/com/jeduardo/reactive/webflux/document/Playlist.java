package br.com.jeduardo.reactive.webflux.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Playlist {

    @Id
    private String id;
    private String nome;

}
