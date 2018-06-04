package com.rezolt.Nifty.Commands;

import com.rezolt.Nifty.Commands.Handler.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Help extends Command
{
    @Override
    public String getName()
    {
        return "Help";
    }

    @Override
    public String getDescription()
    {
        return "Shows all of the commands!";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("?", "commands", "list");
    }
    @Override
    public void execute(MessageReceivedEvent event, String[] args, User author, Message m, Guild g)
    {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Coming Soon!");
        eb.setColor(Color.decode("#12CBC4"));
        eb.setAuthor(author.getName(), author.getAvatarUrl(), author.getAvatarUrl());

        event.getChannel().sendMessage(eb.build()).queue();

    }
}
