package com.example.demo.SSE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
public class SEE {

    @GetMapping("/sse")
    public SseEmitter sendSSE(){
        SseEmitter emitter = new SseEmitter();
        new Thread(() -> {

                try {
                    for(int i = 0; i < 5; i++){
                        emitter.send(SseEmitter.event().data("Number" + i));
                        Thread.sleep(1500);
                    }
                } catch (Exception e) {
                    emitter.completeWithError(e);
                }


        });

        return emitter;
    }
}
