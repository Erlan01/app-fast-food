package ai.ecma.appfastfoodbot.config;

import ai.ecma.appfastfoodbot.MySpringTelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultWebhook;

@Slf4j
@Configuration
public class BotConfig {

    @Value("${bot.token}")
    private String TOKEN;

    @Value("${bot.name}")
    private String BOT_USERNAME;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url("https://d1da-146-158-23-122.ngrok.io").build();
    } // public address, now it is ngrok, in the future it will (i think) be the server address
    // Create it as
    @Bean
    public MySpringTelegramBot mySpringTelegramBot(SetWebhook setWebhookInstance) throws TelegramApiException {

        MySpringTelegramBot mySpringTelegram = new MySpringTelegramBot(setWebhookInstance);
        mySpringTelegram.setBOT_USERNAME(BOT_USERNAME);
        mySpringTelegram.setTOKEN(TOKEN);
        mySpringTelegram.setBOT_PATH("springbot");
        DefaultWebhook defaultWebhook = new DefaultWebhook();

        defaultWebhook.setInternalUrl(
                "http://localhost:80"); // the port to start the server, on the localhost computer, on the server it
        // be the server address

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class, defaultWebhook);

        mySpringTelegram.getBotUsername();
        telegramBotsApi.registerBot(mySpringTelegram, setWebhookInstance);
        return mySpringTelegram;

    }

}
