package com.rezolt.Nifty.Commands.Handler;

import net.dv8tion.jda.core.entities.Message;

import java.util.List;

public interface Command
{
    public String getName();

    String getDescription();

    public String getFormat();

    public List<String> getUsage();

    public void execute(Message m, String[] args);
}
