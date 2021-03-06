package me.misoryan.wurfelt.commands;

import me.misoryan.wurfelt.WurfeltBungee;
import me.misoryan.wurfelt.libs.Lib;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class AllChatCommand extends Command {

    public AllChatCommand(String name)
    {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("§cCurrent Usage: §4/ac <Message>");
            return;
        }
        ChatCommand.ChatMode.putIfAbsent(commandSender.getName(),false);
        if (ChatCommand.ChatMode.get(commandSender.getName())) {
            ChatCommand.ChatMode.put(commandSender.getName(),false);
            WurfeltBungee.ins.getProxy().getPlayer(commandSender.getName()).chat(Lib.getCurrentArgsFormat(strings,0));
            ChatCommand.ChatMode.put(commandSender.getName(),true);
        }
        else {
            WurfeltBungee.ins.getProxy().getPlayer(commandSender.getName()).chat(Lib.getCurrentArgsFormat(strings,0));
        }
    }
}
