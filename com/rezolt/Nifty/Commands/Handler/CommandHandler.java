package com.rezolt.Nifty.Commands.Handler;

import com.rezolt.Nifty.Config;
import net.dv8tion.jda.core.entities.MessageType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler
{
    private List<Command> registeredCommands = new ArrayList<>();

    public List<Command> getRegisteredCommands()
    {
        return registeredCommands;
    }

    public void registerCommand(Command cmd)
    {
        registeredCommands.add(cmd);
    }

    public void handle(MessageReceivedEvent event)
    {
        if(!event.getAuthor().isBot())
        {
            if(event.getMessage().getType() != MessageType.DEFAULT) return;
            String[] args = event.getMessage().getContentRaw().split(" ");
            registeredCommands.forEach(cmd -> {
                List<String> aliases = new ArrayList<>(cmd.getUsage());
                aliases.add(cmd.getName());
                aliases.forEach(a -> {
                    if(args[0].equalsIgnoreCase(Config.prefix + a))
                    {
                        cmd.execute(event.getMessage(), args);
                        return;
                    }
                    ;
                });
            });
        }
    }
}


