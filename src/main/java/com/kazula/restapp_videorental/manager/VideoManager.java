package com.kazula.restapp_videorental.manager;

import com.kazula.restapp_videorental.dao.VideotapeRepository;
import com.kazula.restapp_videorental.dao.entity.Videotapes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoManager {

    private VideotapeRepository videotapeRepository;

    @Autowired
    public VideoManager(VideotapeRepository videotapeRepository) {
        this.videotapeRepository= videotapeRepository;
    }

    public Optional<Videotapes> findById(Long id) {
        return videotapeRepository.findById(id);
    }

    public Iterable<Videotapes> findAll() {
        return videotapeRepository.findAll();
    }

    public Videotapes save(Videotapes videotapes) {
        return videotapeRepository.save(videotapes);
    }

    public void deleteById(Long id) {
        videotapeRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Videotapes(1L, "Matrix", LocalDate.of(1999,05,10)));
        save(new Videotapes(2L, "Obcy", LocalDate.of(1993,03,12)));
    }
}


