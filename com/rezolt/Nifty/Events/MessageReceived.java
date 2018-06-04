package com.rezolt.Nifty.Events;

import com.rezolt.Nifty.Config;
import com.rezolt.Nifty.Main;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageReceived extends ListenerAdapter {
    private String prefix = Config.prefix;
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Main.getCommandHandler().handle(event);
    }
}
