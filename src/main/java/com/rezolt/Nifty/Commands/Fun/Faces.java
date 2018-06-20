package com.rezolt.Nifty.Commands.Fun;

import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Utils.Messages;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;

import java.util.Arrays;
import java.util.List;

public class Faces implements Command {
    @Override
    public String getName()
    {
        return "Faces";
    }

    @Override
    public String getDescription()
    {
        return "Shows you those dank faces!";
    }

    @Override
    public List<String> getUsage()
    {
        return Arrays.asList("troll", "pic", "face");
    }


    @Override
    public String getFormat()
    {
        return "face [face]";
    }
    @Override
    public String getCatagory(){return "fun";}
    @Override
    public void execute(Message m, String[] args)
    {
        String face = "";
        if(args.length == 2) {
            switch(args[1].toLowerCase()) {
                case ("guns"):
                    face = "̿̿ ̿̿ ̿̿ ̿'̿'\\̵͇̿̿\\з= ( ▀ ͜͞ʖ▀) =ε/̵͇̿̿/’̿’̿ ̿ ̿̿ ̿̿ ̿̿";
                    break;
                case ("sniper"):
                    face = "▄︻̷̿┻̿═━一";
                    break;
                case ("bear"):
                    face = "ʕ•ᴥ•ʔ";
                    break;
                case ("squat"):
                    face = "(ง ͠° ͟ل͜ ͡°)ง";
                    break;
                case ("sad"):
                    face = "ಠ╭╮ಠ";
                    break;
                case ("cryhug"):
                    face = "༼ つ ಥ_ಥ ༽つ";
                    break;
                case ("huh"):
                    face = "ಠ⌣ಠ";
                    break;
                case ("flipall"):
                    face = "┻━┻ ︵ヽ(`Д´)ﾉ︵ ┻━┻";
                    break;
                case ("shutup"):
                    face = "ᕙ(⇀‸↼‶)ᕗ";
                    break;
                case ("dog"):
                    face = "(ᵔᴥᵔ)";
                    break;
                case ("hiding"):
                    face = "┬┴┬┴┤ ͜ʖ ͡°) ├┬┴┬┴";
                    break;
                case ("$5"):
                    face = "[̲̅$̲̅(̲̅5̲̅)̲̅$̲̅]";
                    break;

                case ("help"):
                    face = "List of faces: hiding, $5, dog, shutup, flipall, huh, cryhug, sad, squat, bear, sniper, guns";
                    break;
                default:
                    face = "invalid face! Try face help";

            }
        }
        else
        {
            Messages.error(Permission.UNKNOWN, m, args, new Faces());
            face = "List of faces: hiding, $5, dog, shutup, flipall, huh, cryhug, sad, squat, bear, sniper, guns";
        }
        m.getChannel().sendMessage(face).queue();
    }
}
