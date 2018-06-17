package com.rezolt.Nifty.Commands.Fun;

import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Utils.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RPS implements Command {
    @Override
    public String getName() {
        return "RPS";
    }

    @Override
    public String getDescription() {
        return "Classic game of Rock, Paper, Scissors";
    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList("rock-paper-scissors", "rockpaperscissors");
    }


    @Override
    public String getFormat() {
        return "RPS [Rock/Paper/Scissors]";
    }

    @Override
    public String getCatagory() {return "fun";}

    @Override
    public void execute(Message m, String[] args) {
        if(args.length != 2) {
            Messages.error(Permission.UNKNOWN, m, args, new RPS());
        }
        else {
            Random rand = new Random();
            int i = rand.nextInt(3);
            String what = "";
            String ui = args[1].toLowerCase().substring(0, 1);
            int oc = 10;
            switch(i) {
                case 0:
                    what = "r";
                    break;
                case 1:
                    what = "p";
                    break;
                case 2:
                    what = "s";
            }


            //Handles winners and losers
            switch(ui) {
                case "r":
                    switch(what) {
                        case "r":
                            oc = 0;
                            break;
                        case "p":
                            oc = -1;
                            break;
                        case "s":
                            oc = 1;
                            break;
                    }
                    break;
                case "p":
                    switch(what) {
                        case "r":
                            oc = 1;
                            break;
                        case "p":
                            oc = 0;
                            break;
                        case "s":
                            oc = -1;
                            break;
                    }
                    break;
                case "s":
                    switch(what) {
                        case "r":
                            oc = -1;
                            break;
                        case "p":
                            oc = 1;
                            break;
                        case "s":
                            oc = 0;
                            break;
                    }
                    break;
            }

            //---------------------------------------//

            if(oc == -1)
            {
                m.getChannel().sendMessage("**[You Lost!]** | " + this.letToWord(what) + " beats " + this.letToWord(ui) + "!").queue();
            }
            else if(oc == 0)
            {
                m.getChannel().sendMessage("**[Draw]** | " + this.letToWord(what) + " doesn't beat " + this.letToWord(ui) + "!").queue();
            }
            else if(oc == 1)
            {
                m.getChannel().sendMessage("**[You Win!]** | " + this.letToWord(ui) + " beats " + this.letToWord(what) + "!").queue();
            }
        }
    }

    private String letToWord(String l)
    {
        switch(l.toLowerCase())
        {
            case "r":
                return "Rock";
            case "p":
                return "Paper";
            case "s":
                return "Scissors";

        }
        return "";
    }
    private String emoteme(String what)
    {
        switch(what.toLowerCase())
        {
            case "rock":
                return ":fist:";
            case"paper":
                return ":hand_splayed:";
            case"scissors":
                return ":v:";
        }
        return "";
    }
}
