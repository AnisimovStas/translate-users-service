package feral.translate.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${services.translate.url}", name = "TranslateEngineClient")
public interface TranslateEngineClient {

    @GetMapping("/api/v1/translate")
    String translateDirect(
        @RequestParam("text") String text
    );
}
