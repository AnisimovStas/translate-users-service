package feral.translate.users.controllers;

import feral.translate.users.client.TranslateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/translate")
@RequiredArgsConstructor
public class TranslateController {

    private final TranslateClient translateClient;

    @GetMapping("/direct")
    public String direct(@RequestParam("text") String text) {
        return translateClient.translate(text);
    }
}
