package org.parasol.ai;

import jakarta.enterprise.context.SessionScoped;

import org.parasol.model.ClaimBotQuery;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.smallrye.mutiny.Multi;

@RegisterAiService
@SessionScoped
public interface ClaimService {
    @SystemMessage("""
        If a question does not make any sense, or is not factually coherent, explain why instead of answering something not correct. If you don't know the answer to a question, please don't share false information.
        """
    )
    Multi<String> chat(ClaimBotQuery query);
}
