package ru.dorofeev.bulletin_board.controller;

import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.dorofeev.bulletin_board.model.base.Photo;
import ru.dorofeev.bulletin_board.service.interf.PhotoService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/photo")
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("file") MultipartFile file, Photo photo) throws IOException {
        String pathDirectory = "src/main/resources/static/image";
        Random random = new Random();
        String ext = Objects.requireNonNull(file.getContentType()).split("/")[1];

        String name = String.format("%s%s",System.currentTimeMillis(), random.nextInt(100000) + "." + ext);
        Path path = Paths.get(pathDirectory + File.separator + name);

        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        Photo photoCurrent = Photo.builder()
                .name(file.getOriginalFilename())
                .urn(path.toString())
                .advertisement(photo.getAdvertisement())
                .build();


        photoService.save(photoCurrent);
    }

    @GetMapping("/list")
    public List<Photo> getAll() {
        return photoService.findALl();
    }

    @GetMapping("/find/{id}")
    public Optional<Photo> getById(@PathVariable Long id) {
        return photoService.findById(id);
    }


}
