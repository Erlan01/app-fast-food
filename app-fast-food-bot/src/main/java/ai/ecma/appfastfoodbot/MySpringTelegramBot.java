package ai.ecma.appfastfoodbot;

import ai.ecma.appfastfoodbot.botsApi.TelegramFacade;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Slf4j
@Setter
public class MySpringTelegramBot extends SpringWebhookBot {
    @Value("${bot.token}")
    private String TOKEN;

    @Value("${bot.name}")
    private String BOT_USERNAME;

    @Value("${bot.path}")
    private String BOT_PATH;

//    @Autowired
//    private MainService mainService;
//
    @Autowired
    private TelegramFacade telegramFacade;


    public MySpringTelegramBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    public MySpringTelegramBot(DefaultBotOptions options, SetWebhook setWebhook) {
        super(options, setWebhook);
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) { //All messages coming from the grizzly server will trigger this method
//        if (update.getMessage() != null && update.getMessage().hasText()) {
//            List<PartialBotApiMethod<Message>> listOfCommands = mainService.receiveUpdate(update);
//            listOfCommands.forEach(x -> {
//                try {
//                    if (x instanceof SendMessage) {
//                        execute((SendMessage) x);
//                    }
//                    if (x instanceof SendPhoto) {
//                        execute((SendPhoto) x);
//                    }
//
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//            });
//        }

        SendMessage sendMessage = telegramFacade.handleUpdate(update);


        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getBotPath() {
        return "springbot"; //any other path here
    }
}
