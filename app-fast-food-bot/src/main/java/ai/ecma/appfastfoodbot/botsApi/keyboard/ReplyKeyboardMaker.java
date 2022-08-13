package ai.ecma.appfastfoodbot.botsApi.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.Map;

public interface ReplyKeyboardMaker {
    InlineKeyboardMarkup makeInlineKeyboard(Map<String, String> buttons);

    ReplyKeyboardMarkup makeReplyKeyboard(String[] buttons, boolean oneRow);
}
