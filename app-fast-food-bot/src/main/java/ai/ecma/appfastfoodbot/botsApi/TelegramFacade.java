package ai.ecma.appfastfoodbot.botsApi;

import ai.ecma.appfastfoodbot.cache.DataCache;
import ai.ecma.lib.enums.BotStateEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TelegramFacade {
    private final DataCache dataCache;
    private final BotStateContext botStateContext;

    public SendMessage handleUpdate(Update update) {
        SendMessage replyMessage = null;

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            replyMessage = handleMessageInput(message);
        } else if (message != null && message.hasContact()) {
            replyMessage = handleMessageContact(message);
        }

        return replyMessage;
    }

    private SendMessage handleMessageContact(Message message) {
        Contact contact = message.getContact();
        Long userId = message.getFrom().getId();


        return null;
    }

    private SendMessage handleMessageInput(Message message) {
        String messageText = message.getText();
        Long userId = message.getFrom().getId();
        BotStateEnum botState;

        switch (messageText) {
            case "/start":
                botState = BotStateEnum.CHOOSE_LANG;
                break;
            default:
                botState = dataCache.getCurrentBotState(userId);
                break;
        }

        dataCache.setUserBotState(userId, botState);

        return botStateContext.processInputMessage(botState, message);
    }
}
