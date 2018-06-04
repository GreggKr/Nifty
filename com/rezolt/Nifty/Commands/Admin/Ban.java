package com.rezolt.Nifty.Commands.Admin;

import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Utils.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.util.Arrays;
import java.util.List;

public class Ban implements Command
{
    @Override
    public String getName()
    {
        return "Ban";
    }

    @Override
    public String getDescription()
    {
        return "Bans a user";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("bann");
    }
    @Override
    public String getFormat()
    {
        return "ban (user) [reason] | [time]";
    }
    @Override
    public void execute(Message m, String[] args)
    {
        Guild g = m.getGuild();
        User author = m.getAuthor();
        MessageChannel channel = m.getChannel();
        Member user = null;
        Member a = g.getMember(author);
        if(m.getMentionedUsers().isEmpty())
            Messages.error(g,Permission.UNKNOWN,new Ban(),a,args, channel);
        else
        {
            user = g.getMember(m.getMentionedUsers().get(0));
        }
        if(user != null)
        {
            if(a.canInteract(user))
            {
                if(a.hasPermission(Permission.BAN_MEMBERS))
                {
                    if(args.length > 2)
                    {
                        if(m.getContentRaw().contains("|"))
                        {
                            String sec = m.getContentRaw().substring(m.getContentRaw().lastIndexOf("|") + 1);
                            int i = Integer.parseInt(sec);
                            String reason = "";
                            for(int l = 2; l < args.length - 2; l++)
                            {
                                reason += args[l];
                            }
                            g.getController().ban(user, i, reason);

                        }
                        else
                        {
                            String reason = "";
                            for(int i = 2; i < args.length; i++)
                            {
                                reason += args[i];
                            }
                            g.getController().ban(user, 1000, reason);

                        }
                    }
                    else
                    {
                        g.getController().ban(user, 1000);
                    }
                }
                else
                {
                    Messages.error(g,Permission.BAN_MEMBERS, new Ban(), a, args, channel);

                }
            }
            else
            {
                Messages.canInteractError(author, user.getUser(), g, m);
            }
        }
    }
}
