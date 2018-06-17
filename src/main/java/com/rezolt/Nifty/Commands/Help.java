package com.rezolt.Nifty.Commands;

import com.rezolt.Nifty.Commands.Handler.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Help implements Command
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
    public String getFormat() { return "help";}
    @Override
    public String getCatagory() { return "user";}
    @Override
    public void execute(Message m, String[] args)
    {
        Guild g = m.getGuild();
        User author = m.getAuthor();
        MessageChannel channel = m.getChannel();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Coming Soon!");
        eb.setColor(Color.decode("#12CBC4"));
        eb.setAuthor(author.getName(), author.getAvatarUrl(), author.getAvatarUrl());

        channel.sendMessage(eb.build()).queue();

    }
}
