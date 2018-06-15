package com.rezolt.Nifty.Commands.Fun;

import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Utils.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Kill implements Command
{
    @Override
    public String getName()
    {
        return "Kill";
    }

    @Override
    public String getDescription()
    {
        return "Murders a specified user";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("murder", "slaughter", "stab");
    }
    @Override
    public String getFormat()
    {
        return "kill (User)";
    }
    @Override
    public void execute(Message m, String[] args)
    {
        Guild g = m.getGuild();
        User author = m.getAuthor();
        MessageChannel channel = m.getChannel();
        User mu = null;
        if(!m.getMentionedUsers().isEmpty()) {
            mu = m.getMentionedUsers().get(0);
        }
        if(mu == null)
        {
            Messages.error(g,Permission.UNKNOWN,new Kill(),g.getMember(author),args,channel);
            return;
        }
        Random rand = new Random();
        int i = rand.nextInt(21); //Exact number of death messages
        String[] deaths =
                {
                        "%k% stabbed %d% with a pitchfork!",
                        "%d% thrown under a bus by %k%",
                        "%k% blasted %d% with a raygun!",
                        "%k% threw acid in %d%'s face!",
                        "%d% was stabbed by %k% with a butter knife",
                        "%d%'s eyes were spooned out out by %k%",
                        "%k% summoned a demon on %d%...",
                        "%k% drowned %d%",
                        "%k% shoved %d% off a cliff!",
                        "%k% Strangled %d% to death",
                        "%d% fell off of a cliff",
                        "%d% slipped on a banana peel!",
                        "%k% poisoned %d%'s coffee...",
                        "%d%'s parachute failed",
                        "%d% tried to bench press too much!",
                        "%d% fell into a volcano",
                        "%d% was killed by a feral cat!",
                        "%d%'s gun back fired...",
                        "%d% was kicked by a horse",
                        "%d% dived in the shallow end of the pool",
                        "%d% fell off the space needle",
                        "%k% jumped on %d%'s head!"

                };
        channel.sendMessage(deaths[i].replaceAll("%k%", g.getMember(author).getEffectiveName()).replaceAll("%d%", g.getMember(mu).getEffectiveName())).queue();
    }
}
