package feral.translate.users.controllers;

import feral.translate.users.client.TranslateClient;
import feral.translate.users.client.TranslateEngineClient;
import feral.translate.users.domain.Translate;
import feral.translate.users.domain.User;
import feral.translate.users.domain.requests.TranslateDTO;
import feral.translate.users.domain.response.TranslateResponse;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/translate")
@RequiredArgsConstructor
public class TranslateController {

    private final TranslateEngineClient translateEngineClient;
    private final TranslateClient translateClient;

    @GetMapping("/direct")
    public String direct(@RequestParam("text") String text) {
        return translateEngineClient.translateDirect(text);
    }

    @PostMapping
    public Translate translate(@RequestBody String origin, @AuthenticationPrincipal User user) {

        TranslateDTO dto = TranslateDTO.builder()
            .origin(origin)
            .userId(user.getId())
            .build();
        return translateClient.translate(dto);
    }

    @PostMapping("/search")
    public Page<TranslateResponse> search(@AuthenticationPrincipal User user, Pageable pageable) {
        return translateClient.search(user.getId(), pageable);
    }
}
