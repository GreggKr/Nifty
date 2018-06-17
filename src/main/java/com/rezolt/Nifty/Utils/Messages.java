package com.rezolt.Nifty.Utils;

import com.rezolt.Nifty.Commands.Handler.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.awt.*;

public class Messages
{
    public static void error(Permission p, Message me, String[] args, Command c)
    {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.decode("#EA2027"));
        Guild g = me.getGuild();
        Member m = g.getMember(me.getAuthor());
        MessageChannel channel = me.getChannel();
        if(!m.hasPermission(p))
        {
            eb.setTitle("Insuffecient Permissions!");
            eb.setDescription("You must have the " + p.getName() + " permission to use command " + c.getName() + "!");
        }
        else
        {
            eb.setTitle("Invalid Arguments!");
            eb.setDescription("__**Usage:**__ " + c.getFormat());
            eb.setFooter("Caused by " + m.getEffectiveName(), g.getSelfMember().getUser().getAvatarUrl());
        }
        eb.setAuthor(m.getEffectiveName(), m.getUser().getAvatarUrl(), m.getUser().getAvatarUrl());
        eb.setThumbnail("https://cdn.pixabay.com/photo/2017/02/12/21/29/false-2061132_960_720.png");
        channel.sendMessage(eb.build()).queue();
    }

    public static void canInteractError(User a1, User a2, Guild guild, Message m)
    {
        if(guild.getMember(a1).canInteract(guild.getMember(a2)))
        {
            return;
        }
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.decode("#EA2027"));
        eb.setTitle("Invalid Permissions!");
        eb.setDescription(guild.getMember(a1).getEffectiveName() + " you cannot interact with " + guild.getMember(a2).getEffectiveName());
        eb.setFooter("Caused by " + guild.getMember(m.getAuthor()).getEffectiveName(), guild.getSelfMember().getUser().getAvatarUrl());
        eb.setThumbnail("https://cdn.pixabay.com/photo/2017/02/12/21/29/false-2061132_960_720.png");
        m.getChannel().sendMessage(eb.build()).queue();
    }
    public static void botOwnerOnly(Message m)
    {
        EmbedBuilder eb = new EmbedBuilder();
        Guild guild = m.getGuild();
        eb.setColor(Color.decode("#EA2027"));
        eb.setTitle("Invalid Permissions!");
        eb.setDescription(m.getAuthor().getName() + " you must be my owner to use this command!");
        eb.setFooter("Caused by " + guild.getMember(m.getAuthor()).getEffectiveName(), guild.getSelfMember().getUser().getAvatarUrl());
        eb.setThumbnail("https://cdn.pixabay.com/photo/2017/02/12/21/29/false-2061132_960_720.png");
        m.getChannel().sendMessage(eb.build()).queue();
    }
}
