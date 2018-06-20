package com.rezolt.Nifty.Commands.User;

import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Utils.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Who implements Command {
    @Override
    public String getName()
    {
        return "Who";
    }

    @Override
    public String getDescription()
    {
        return "GEts user Stats!";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("user", "info");
    }


    @Override
    public String getFormat()
    {
        return "who [user]";
    }
    @Override
    public String getCatagory(){return "user";}
    @Override
    public void execute(Message m, String[] args) {
        if(!m.getMentionedUsers().isEmpty())
        {
            User who = m.getMentionedUsers().get(0);
            EmbedBuilder eb = new EmbedBuilder();
            String guilds = "";

            for(Guild g : who.getMutualGuilds())
            {
                guilds +=   g.getName() + ", ";
            }
            //➢  ➣
            String desc = " **➣** Name: **"+ who.getName() +"**#"+ who.getDiscriminator() +
                    "\n**➢** ID: " + who.getId() + "" +
                    "\n**➣** Joined: " + who.getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE) +
                    "\n**➢** Joined Guild: " + m.getGuild().getMember(who).getJoinDate().format(DateTimeFormatter.ISO_LOCAL_DATE) +
                    "\n**➣** Mutual Guilds: " + guilds;
            eb.setTitle(who.getName())
                    .setColor(Color.decode("#00cec9"))
                    .setThumbnail(who.getAvatarUrl())
                    .setFooter("Summoned By " + m.getGuild().getMember(m.getAuthor()).getEffectiveName(), m.getAuthor().getAvatarUrl())
                    .setDescription(desc);

            m.getChannel().sendMessage(eb.build()).queue();
        }
        else
        {
            Messages.error(Permission.UNKNOWN, m, args, new Who());
        }
    }
}
