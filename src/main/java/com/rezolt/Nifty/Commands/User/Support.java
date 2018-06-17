package com.rezolt.Nifty.Commands.User;

import com.rezolt.Nifty.Commands.Handler.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Support implements Command
{
    @Override
    public String getName()
    {
        return "Support";
    }

    @Override
    public String getDescription()
    {
        return "Helps you get support";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("server", "join");
    }


    @Override
    public String getFormat()
    {
        return "support";
    }
    @Override
    public String getCatagory(){return "user";}
    @Override
    public void execute(Message m, String[] args)
    {
        Guild g = m.getGuild();
        User author = m.getAuthor();
        MessageChannel channel = m.getChannel();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Support!");
        eb.setAuthor("Join Here!", "https://discord.gg/etdC226", g.getSelfMember().getUser().getAvatarUrl());
        eb.setThumbnail("https://www.ptc.com/-/media/Images/Redesign/support/ReactivateGS-CTA.png");
        eb.setDescription("Need help with me? Join out support server now! Talk with our support team and get any issues resolved within minutes!");
        eb.setColor(Color.decode("#A3CB38"));
        eb.setFooter("Report bugs with n!report", g.getSelfMember().getUser().getAvatarUrl());
        channel.sendMessage(eb.build()).queue();
    }

}
