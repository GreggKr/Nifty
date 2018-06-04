package com.rezolt.Nifty.Commands.Handler;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Collections;
import java.util.List;

public class Command
{
    public String getName()
    {
        return "";
    }

    public String getDescription()
    {
        return "";
    }

    public String getFormat()
    {
        return "";
    }

    public List<String> getUsage()
    {
        return Collections.emptyList();
    }

    public void execute(MessageReceivedEvent event, String[] args, User author, Message m, Guild g)
    {

    }
}
