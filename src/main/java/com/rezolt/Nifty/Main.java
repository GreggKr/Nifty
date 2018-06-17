package com.rezolt.Nifty;

import com.rezolt.Nifty.Commands.Admin.Ban;
import com.rezolt.Nifty.Commands.Fun.Kill;
import com.rezolt.Nifty.Commands.Fun.RPS;
import com.rezolt.Nifty.Commands.Handler.CommandHandler;
import com.rezolt.Nifty.Commands.Help;
import com.rezolt.Nifty.Commands.User.Report;
import com.rezolt.Nifty.Commands.User.Suggest;
import com.rezolt.Nifty.Commands.User.Support;
import com.rezolt.Nifty.Events.MessageReceived;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main
{
    private static CommandHandler ch = new CommandHandler();
    private static JDA jda;

    public static CommandHandler getCommandHandler()
    {
        return Main.ch;
    }

    public static void main(String args[]) throws LoginException, InterruptedException
    {
        registerCommands();
        jda = new JDABuilder(AccountType.BOT)
                .setToken(Config.token)
                .addEventListener(new MessageReceived())
                .buildBlocking();
    }

    protected static void registerCommands()
    {
        ch.registerCommand(new Help());
        ch.registerCommand(new Ban());
        ch.registerCommand(new Support());
        ch.registerCommand(new Report());
        ch.registerCommand(new Suggest());
        ch.registerCommand(new Kill());
        ch.registerCommand(new RPS());
    }
}
