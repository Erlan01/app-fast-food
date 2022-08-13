package ai.ecma.appfastfoodbot.botsApi;

import ai.ecma.lib.enums.BotStateEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface BotStateContext {
    SendMessage processInputMessage(BotStateEnum botState, Message message);
}
