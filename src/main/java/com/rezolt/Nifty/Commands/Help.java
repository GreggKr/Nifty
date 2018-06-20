package com.rezolt.Nifty.Commands;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.menu.Paginator;
import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Commands.Handler.CommandHandler;
import com.rezolt.Nifty.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Help implements Command {
    private Paginator.Builder pbuilder;
    private  CommandHandler ch;
    List<Command> lis;

    @Override
    public String getName() {
        return "Help";
    }

    @Override
    public String getDescription() {
        return "Shows all of the commands!";
    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList("?", "commands", "list");
    }

    @Override
    public String getFormat() { return "help";}

    @Override
    public String getCatagory() { return "User";}

    @Override
    public void execute(Message m, String[] args) {
        m.getChannel().sendMessage("In Progress!").queue();
        List<Command> mod = new ArrayList<>();
        List<Command> user = new ArrayList<>();
        List<Command> fun = new ArrayList<>();
        //List<Command> other = new ArrayList<>();

        //Adds each command to correct catagory
        Main.getCommandHandler().getRegisteredCommands().forEach(c ->{
            if(c.getCatagory().toLowerCase().startsWith("mod"))
                mod.add(c);
            else if(c.getCatagory().toLowerCase().startsWith("user"))
                user.add(c);
            else if(c.getCatagory().toLowerCase().startsWith("fun"))
                fun.add(c);
            //else if(c.getCatagory().toLowerCase().startsWith("other"))
                //other.add(c);
        });
        List<List<Command>> cmds = new ArrayList<>();
        cmds.add(mod); cmds.add(user); cmds.add(fun); //cmds.add(other);
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Commands");
        String desc = "";
        for(List<Command> ls : cmds)
        {
            desc += "\n__**"+ls.get(0).getCatagory()+"**__\n\n";
            for(Command c : ls)
            {
                desc += c.getName() + ": `" + c.getFormat() + "`  " + c.getDescription() + "\n";
            }
        }
        eb.setDescription(desc);
        m.getChannel().sendMessage(eb.build()).queue();
    }
}
