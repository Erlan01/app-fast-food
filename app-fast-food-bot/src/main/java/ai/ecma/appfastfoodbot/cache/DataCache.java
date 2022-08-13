package ai.ecma.appfastfoodbot.cache;

import ai.ecma.lib.enums.BotStateEnum;

public interface DataCache {
    void setUserBotState(long userId, BotStateEnum botState);

    BotStateEnum getCurrentBotState(long userId);


}
