package kr.java.bedrock.controller;

import jakarta.servlet.http.HttpSession;
import kr.java.bedrock.util.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AIController {

    private final ChatModel chatModel;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        List<Map<String, String>> history = SessionUtil.getChatHistory(session);
        model.addAttribute("history", history);
        return "chat";
    }

    @PostMapping("/chat")
    public String chat(@RequestParam("message") String message, HttpSession session) {
        List<Map<String, String>> history = SessionUtil.getChatHistory(session);

        // User message
        history.add(Map.of("role", "user", "content", message));

        // AI Response
        String response = ChatClient.create(chatModel)
                .prompt()
                .user(message)
                .call()
                .content();

        history.add(Map.of("role", "assistant", "content", response));

        return "redirect:/";
    }
}
