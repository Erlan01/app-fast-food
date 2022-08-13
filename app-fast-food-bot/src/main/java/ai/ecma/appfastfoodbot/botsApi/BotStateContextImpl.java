package ai.ecma.appfastfoodbot.botsApi;

import ai.ecma.appfastfoodbot.botsApi.keyboard.ReplyKeyboardMaker;
import ai.ecma.lib.enums.BotStateEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class BotStateContextImpl implements BotStateContext {
    private final ReplyKeyboardMaker keyboardMaker;

    @Override
    public SendMessage processInputMessage(BotStateEnum botState, Message message) {
        SendMessage sendMessage = new SendMessage();

        switch (botState) {
            case CHOOSE_LANG:
                sendMessage.setReplyMarkup(keyboardMaker.makeReplyKeyboard(
                        new String[]{"O'zbekcha", "Русский", "English"},
                        true
                ));
                sendMessage.setText("Tilni tanlang!");
                break;
        }

        sendMessage.setChatId(String.valueOf(message.getChatId()));

        return sendMessage;
    }
}
