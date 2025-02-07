package feral.translate.users.client;

import feral.translate.users.domain.Translate;
import feral.translate.users.domain.requests.TranslateDTO;
import feral.translate.users.domain.response.TranslateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${services.logic.url}", name = "TranslateClient")
public interface TranslateClient {

    @PostMapping("/api/v1/translate")
    Translate translate(@RequestBody TranslateDTO dto);

    @PostMapping("/api/v1/translate/search")
    Page<TranslateResponse> search(@RequestBody Long userId, Pageable pageable);
}

