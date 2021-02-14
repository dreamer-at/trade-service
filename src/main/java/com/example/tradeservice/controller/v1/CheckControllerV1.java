package com.example.tradeservice.controller.v1;


import com.example.tradeservice.dto.RequestCheckDTO;
import com.example.tradeservice.service.OperationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/operation/")
public class CheckControllerV1 {

    /**
     * Responds allowed http methods in the header.
     * <p>
     * This always responds with HTTP-Code 200
     */
    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptions() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
                .build();
    }

    /**
     * Responds allowed http methods the header.
     * <p>
     * This always responds with HTTP-Code 200
     */
    @RequestMapping(value = "{id}", method = RequestMethod.OPTIONS)
    ResponseEntity<?> singularOptions(@SuppressWarnings("unused") @PathVariable(required = false) UUID id) {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.OPTIONS)
                .build();
    }

    private final OperationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String checkOperation(@RequestBody RequestCheckDTO dto) {
        return service.checkOperation(dto);
    }

    @PostMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<RequestCheckDTO> checkAllOperations(@RequestBody RequestCheckDTO dto) {
        return service.checkAllOperation(dto);
    }
}
