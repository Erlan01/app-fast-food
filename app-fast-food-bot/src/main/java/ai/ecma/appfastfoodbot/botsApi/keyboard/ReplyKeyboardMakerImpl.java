package ai.ecma.appfastfoodbot.botsApi.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ReplyKeyboardMakerImpl implements ReplyKeyboardMaker {

    @Override
    public InlineKeyboardMarkup makeInlineKeyboard(Map<String, String> buttons) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonList = new ArrayList<>();

        List<InlineKeyboardButton> buttonsGroup = new ArrayList<>();
        buttons.forEach((s, s2) -> {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(s);
            button.setCallbackData(s2);
            buttonsGroup.add(button);
        });


        int k = 0;
        int cycle = buttonsGroup.size() % 2 == 0 ? buttonsGroup.size() / 2 : buttonsGroup.size() / 2 + 1;

        for (int i = 0; i < cycle; i++) {
            List<InlineKeyboardButton> row = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                row.add(buttonsGroup.get(j));
                if (k == buttonsGroup.size() - 1) {
                    break;
                }
                k++;
            }
            buttonList.add(row);
        }

        inlineKeyboardMarkup.setKeyboard(buttonList);
        return null;
    }

    @Override
    public ReplyKeyboardMarkup makeReplyKeyboard(String[] buttons, boolean oneRow) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        int k = 0;
        int cycle;
        if (oneRow) {
            cycle = buttons.length;
        } else {
            cycle = (buttons.length % 2 == 0) ? buttons.length / 2 : buttons.length / 2 + 1;
        }
        for (int i = 0; i < cycle; i++) {
            KeyboardRow row = new KeyboardRow();
            if (oneRow){
                row.add(new KeyboardButton(buttons[k]));
                k++;
            }else {
                for (int j = 0; j < 2; j++) {
                    row.add(new KeyboardButton(buttons[k]));
                    if (k == buttons.length - 1) {
                        break;
                    }
                    k++;
                }
            }


            keyboardRows.add(row);
        }

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
}
