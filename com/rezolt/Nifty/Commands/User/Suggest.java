package com.rezolt.Nifty.Commands.User;

import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Config;
import com.rezolt.Nifty.Utils.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Suggest implements Command
{
    @Override
    public String getName()
    {
        return "Suggest";
    }

    @Override
    public String getDescription()
    {
        return "Suggest a bot feature";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("idea", "feature");
    }

    @Override
    public String getFormat()
    {
        return "suggest (idea) | (Description)";
    }

    @Override
    public void execute(Message m, String[] args)
    {
        Guild g = m.getGuild();
        User author = m.getAuthor();
        MessageChannel channell = m.getChannel();
        if(args.length >= 4 && m.getContentRaw().contains("|"))
        {
            Guild guild = m.getJDA().getGuildById(Config.serverID);
            String Description = m.getContentRaw().substring(m.getContentRaw().lastIndexOf("|") + 1);
            String idea = "";
            for(int i = 1; i < args.length - 2; i++)
            {
                if(args[i].contains("|"))
                {
                    break;
                }
                idea += args[i] + " ";
            }
            MessageChannel channel = guild.getTextChannelById(Config.suggestChannelID);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(idea);
            eb.setThumbnail(author.getAvatarUrl());
            eb.setFooter(author.getName(), author.getAvatarUrl());
            eb.setDescription("Description: " + Description);
            eb.setColor(Color.decode("#12CBC4"));
            channel.sendMessage(eb.build()).queue();
        }
        else
        {
            Messages.error(g, Permission.UNKNOWN, new Suggest(), g.getMember(author), args, channell);
        }
    }
}
