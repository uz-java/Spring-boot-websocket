package com.example.springbootwebsocket;

import com.example.springbootwebsocket.domains.Message;
import com.example.springbootwebsocket.domains.OutputMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/08/22 23:33 (Wednesday)
 * Spring-boot-websocket/IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class WebSocketController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    @GetMapping
    public String indexPage() {
        return "index";
    }

    @ResponseBody
    @GetMapping("test")
    public String test(@RequestParam(required = false, defaultValue = "Me") String name) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());

        OutputMessage message = new OutputMessage(name, "Raise message", time);
        simpMessagingTemplate.convertAndSend("/topic/messages", message);
        return name;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
