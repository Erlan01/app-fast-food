package ai.ecma.appfastfoodbot.cache;

import ai.ecma.lib.enums.BotStateEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataCacheImpl implements DataCache {
    private Map<Long, BotStateEnum> usersBotState = new HashMap<>();

    @Override
    public void setUserBotState(long userId, BotStateEnum botState) {
        usersBotState.put(userId, botState);
    }

    @Override
    public BotStateEnum getCurrentBotState(long userId) {
        BotStateEnum botStateEnum = usersBotState.get(userId);
        if (botStateEnum == null) {
            return BotStateEnum.CHOOSE_LANG;
        }
        return botStateEnum;
    }
}
