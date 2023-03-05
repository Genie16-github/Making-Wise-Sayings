package org.example.wiseSaying.service;

import org.example.Util;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public long write(String content, String authorName) {
        return wiseSayingRepository.write(content, authorName);
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingRepository.delete(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String modify_ws, String modify_wr) {
        wiseSayingRepository.modify(wiseSaying, modify_ws, modify_wr);
    }

    public WiseSaying findById(long id) {
        return wiseSayingRepository.findById(id);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public void build() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();

        Util.file.mkdir("prodBuild");

        String json = "[\n" + wiseSayings
                .stream()
                .map(wiseSaying -> wiseSaying.toJson())
                .collect(Collectors.joining(",\n")) + "\n]";

        Util.file.saveToFile("prodBuild/data.json", json);
    }
}
