package com.kazula.restapp_videorental.api;

import com.kazula.restapp_videorental.dao.entity.Videotapes;
import com.kazula.restapp_videorental.manager.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
public class VideoApi {

    private VideoManager videotapes;

    @Autowired
    public VideoApi(VideoManager videotapes) {
        this.videotapes = videotapes;
    }

    @GetMapping("/all")
    public Iterable<Videotapes> getAll() {
        return videotapes.findAll();
    }

    @GetMapping
    public Optional<Videotapes> getById(@RequestParam Long index) {
        return videotapes.findById(index);
    }

    @PostMapping
    public Videotapes addVideos (@RequestBody Videotapes videotape) {
        return videotapes.save(videotape);
    }

    @PutMapping
    public Videotapes updateVideos (@RequestBody Videotapes videotape) {
        return videotapes.save(videotape);
    }

    @DeleteMapping
    public void deleteVideos (@RequestParam Long index) {
        videotapes.deleteById(index);
    }

}
