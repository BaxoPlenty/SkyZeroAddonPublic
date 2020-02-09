package de.baxoplenty;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ServerData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class SkyZeroAddon extends LabyModAddon {

    private boolean enabled = true;
    private ArrayList<String> payLog = new ArrayList<String>();

    @Override
    public void onEnable() {
        System.out.println("Enabled SkyZero Addon");
        this.getApi().registerForgeListener(this);

        this.getApi().getEventManager().registerOnJoin(new Consumer<ServerData>() {
            @Override
            public void accept(ServerData serverData) {
                if(enabled == true) {
                    LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("https://media.discordapp.net/attachments/645344272815620118/675788438217162752/SkyZeroGA.png","§4§lS§c§lKY§4§lZ§c§lERO", "§7Schreibe §c--help §7in den Chat um die §cHilfe §7Seite zu sehen");
                }
            }
        });

        this.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(String s, String s1) {
                if(enabled == true) {
                    if(s.contains("§c§lSKYZERO")) {
                        if(s.contains("§7gegeben.")) {

                            if (s.contains("§7hat dir ")) {
                                String[] args = s.split(" ");
                                String prefix = args[3];
                                String name = args[4];
                                String hat = args[5];
                                String dir = args[6];
                                String geld = args[7];
                                String gegeben = args[8];

                                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                                Date date = new Date();
                                String time = dateFormat.format(date);

                                LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("https://media.discordapp.net/attachments/645344272815620118/675788438217162752/SkyZeroGA.png", "§4§lS§c§lKY§4§lZ§c§lERO", prefix + " " + name + " " + hat + " " + dir + " " + geld + " " + gegeben);
                                payLog.add("§8┃ §b§lPAYLOG §8» " + prefix + " " + name + " " + hat + " " + dir + " " + geld + " " + gegeben + " §8(§7" + time + "§8)");
                            } else if (s.contains("§7Du hast ")) {
                                String[] args = s.split(" ");
                                String prefix = args[3];
                                String name = args[4];
                                String hat = args[5];
                                String dir = args[6];
                                String geld = args[7];
                                String gegeben = args[8];

                                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                                Date date = new Date();
                                String time = dateFormat.format(date);

                                LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("https://media.discordapp.net/attachments/645344272815620118/675788438217162752/SkyZeroGA.png", "§4§lS§c§lKY§4§lZ§c§lERO", prefix + " " + name + " " + hat + " " + dir + " " + geld + " " + gegeben);
                                payLog.add("§8┃ §b§lPAYLOG §8» " + prefix + " " + name + " " + hat + " " + dir + " " + geld + " " + gegeben + " §8(§7" + time + "§8)");
                            }
                        }
                    }
                }
                return false;
            }
        });

        this.getApi().getEventManager().register(new MessageSendEvent() {
            @Override
            public boolean onSend(String s) {
                if(enabled == true) {
                    if (s.startsWith("--")) {
                        if (s.equals("--help")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8┃ §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8▸ §e§lHilfe");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--help §8┃ §7Zeigt diese Seite an");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--features §8┃ §7Zeigt alle features an");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--shop §8┃ §7Zeigt dir die Adresse für den Shop");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--credits §8┃ §7Zeigt dir die Developer§8/§7Tester");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--paylog §8┃ §7Zeigt dir deinen PayLog");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--clearpaylog §8┃ §7Cleart den PayLog");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        } else if (s.equals("--features")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8┃ §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8▸ §e§lFeatures");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Benachrichtigung wenn dir Geld gepayt wurde");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Paylog");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }  else if (s.equals("--shop")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8┃ §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8▸ §e§lShop");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7shop.skyzero.ga");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }  else if (s.equals("--credits")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8┃ §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8▸ §e§lCredits");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Developed by §cBaxoPlenty §8(§7BaxoPlenty#2761§8)");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Tested by §cMr_Kompliziert §8(§7Mr_Kompliziert#9220§8)");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }  else if (s.equals("--paylog")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8┃ §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8▸ §e§lPaylog");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            if(!payLog.isEmpty()) {
                                LabyMod.getInstance().displayMessageInChat(payLog.toString().replace("[", "").replace("]", "").replace(", ", "\n"));
                            } else {
                                LabyMod.getInstance().displayMessageInChat("§8┃ §b§lPAYLOG §8» §7Du hast derzeit keine Transaktionen");
                            }
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }  else if (s.equals("--clearpaylog")) {
                            payLog.clear();
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8┃ §b§lADDON §8» §7Der Paylog wurde gecleart");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }
                    }

                    return s.startsWith("--");
                } else {
                    return false;
                }
            }
        });
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings(final List<SettingsElement> list) {
        final BooleanElement bE = new BooleanElement("Enabled", new ControlElement.IconData(Material.LEVER), new Consumer<Boolean>() {
            @Override
            public void accept(final Boolean enabled) {
                SkyZeroAddon.this.enabled = enabled;
            }
        }, this.enabled);
        list.add(bE);
    }
}
