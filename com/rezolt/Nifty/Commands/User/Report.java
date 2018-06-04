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
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Report extends Command
{
    @Override
    public String getName()
    {
        return "Report";
    }

    @Override
    public String getDescription()
    {
        return "Reports a bot issue";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("Issue", "bug");
    }
    @Override
    public String getFormat()
    {
        return "report (Issue) | (Description)";
    }
    @Override
    public void execute(MessageReceivedEvent event, String[] args, User author, Message m, Guild g)
    {
        if(args.length >= 4 && m.getContentRaw().contains("|"))
        {
            Guild guild = event.getJDA().getGuildById(Config.serverID);
            String Description = m.getContentRaw().substring(m.getContentRaw().lastIndexOf("|") + 1);
            String issue = "";
            for(int i = 1; i < args.length - 2; i++)
            {
                if(args[i].contains("|"))
                    break;
                issue += args[i] + " ";
            }
            MessageChannel channel = guild.getTextChannelById(Config.reportChannelID);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(issue);
            eb.setThumbnail(author.getAvatarUrl());
            eb.setFooter(author.getName(), author.getAvatarUrl());
            eb.setDescription("Description: " + Description);
            eb.setColor(Color.decode("#0652DD"));
            channel.sendMessage(eb.build()).queue();
        }
        else
        {
            Messages.error(g, Permission.UNKNOWN, new Report(), g.getMember(author),args, event.getChannel());
        }
    }
}
