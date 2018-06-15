package com.rezolt.Nifty.Commands;

import com.rezolt.Nifty.Commands.Handler.Command;
import com.rezolt.Nifty.Config;
import com.rezolt.Nifty.Utils.Messages;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Changelog implements Command {
    @Override
    public String getName() {
        return "Changelog";
    }

    @Override
    public String getDescription() {
        return "New changelog!";
    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList("update");
    }

    @Override
    public String getFormat() { return "changelog, (Version), {Changes}";}

    @Override
    public void execute(Message m, String[] args) {
        String[] changes = m.getContentRaw().split(",");
        boolean owner = false;
        for(int i = 0; i < Config.owners.length; i++) {
            if(m.getAuthor().getId().equals(Config.owners[i])) {
                owner = true;
            }
        }
        if(owner) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(changes[1]); //Version
            String log = "";
            for(int l = 2; l < changes.length; l++) {
                log += "-" + changes[l] + "\n";
            }
            eb.setDescription(log);
            eb.setColor(Color.decode("#00cec9"));
            eb.setThumbnail("https://www.vextras.com/wp-content/uploads/2016/01/Coding-1.png");
            eb.setFooter(m.getCreationTime().getMonth().getValue() + "/"
                    + m.getCreationTime().getDayOfMonth() + "/" + m.getCreationTime().getYear(), m.getAuthor().getAvatarUrl());
            m.getGuild().getTextChannelById(Config.changelogChannelID).sendMessage(eb.build()).queue();
        }
        else {
            Messages.botOwnerOnly(m);
        }

    }


}
