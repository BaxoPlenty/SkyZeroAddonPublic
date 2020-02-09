// 
// Decompiled by Procyon v0.5.36
// 

package de.baxoplenty;

import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.labymod.settings.elements.SettingsElement;
import java.util.List;
import net.labymod.api.events.MessageSendEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.main.LabyMod;
import net.labymod.utils.ServerData;
import net.labymod.utils.Consumer;
import java.util.ArrayList;
import net.labymod.api.LabyModAddon;

public class SkyZeroAddon extends LabyModAddon
{
    private boolean enabled;
    private ArrayList<String> payLog;
    
    public SkyZeroAddon() {
        this.enabled = true;
        this.payLog = new ArrayList<String>();
    }
    
    public void onEnable() {
        System.out.println("Enabled SkyZero Addon");
        this.getApi().registerForgeListener((Object)this);
        this.getApi().getEventManager().registerOnJoin((Consumer)new Consumer<ServerData>() {
            public void accept(final ServerData serverData) {
                if (SkyZeroAddon.this.enabled) {
                    LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("https://media.discordapp.net/attachments/645344272815620118/675788438217162752/SkyZeroGA.png", "§4§lS§c§lKY§4§lZ§c§lERO", "§7Schreibe §c--help §7in den Chat um die §cHilfe §7Seite zu sehen");
                }
            }
        });
        this.getApi().getEventManager().register((MessageReceiveEvent)new MessageReceiveEvent() {
            public boolean onReceive(final String s, final String s1) {
                if (SkyZeroAddon.this.enabled && s.contains("§c§lSKYZERO") && s.contains("§7gegeben.")) {
                    final String[] args = s.split(" ");
                    final String prefix = args[3];
                    final String name = args[4];
                    final String hat = args[5];
                    final String dir = args[6];
                    final String geld = args[7];
                    final String gegeben = args[8];
                    if (s.contains("§7hat dir ")) {
                        final SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        final Date date = new Date();
                        final String time = dateFormat.format(date);
                        LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("https://media.discordapp.net/attachments/645344272815620118/675788438217162752/SkyZeroGA.png", "§4§lS§c§lKY§4§lZ§c§lERO", prefix + " " + name + " " + hat + " " + dir + " " + geld + " " + gegeben);
                        SkyZeroAddon.this.payLog.add("§8\u2503 §b§lPAYLOG §8» " + prefix + " " + name + " " + hat + " " + dir + " " + geld + " " + gegeben + " §8(§7" + time + "§8)");
                    }
                }
                return false;
            }
        });
        this.getApi().getEventManager().register((MessageSendEvent)new MessageSendEvent() {
            public boolean onSend(final String s) {
                if (SkyZeroAddon.this.enabled) {
                    if (s.startsWith("--")) {
                        if (s.equals("--help")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8\u2503 §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8\u25b8 §e§lHilfe");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--help §8\u2503 §7Zeigt diese Seite an");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--features §8\u2503 §7Zeigt alle features an");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--shop §8\u2503 §7Zeigt dir die Adresse f\u00fcr den Shop");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--credits §8\u2503 §7Zeigt dir die Developer§8/§7Tester");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--paylog §8\u2503 §7Zeigt dir deinen PayLog");
                            LabyMod.getInstance().displayMessageInChat("§8» §7--clearpaylog §8\u2503 §7Cleart den PayLog");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }
                        else if (s.equals("--features")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8\u2503 §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8\u25b8 §e§lFeatures");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Benachrichtigung wenn dir Geld gepayt wurde");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Paylog");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }
                        else if (s.equals("--shop")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8\u2503 §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8\u25b8 §e§lShop");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7shop.skyzero.ga");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }
                        else if (s.equals("--credits")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8\u2503 §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8\u25b8 §e§lCredits");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Developed by §cBaxoPlenty §8(§7BaxoPlenty#2761§8)");
                            LabyMod.getInstance().displayMessageInChat("§8» §7Tested by §cMr_Kompliziert §8(§7Mr_Kompliziert#9220§8)");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }
                        else if (s.equals("--paylog")) {
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8\u2503 §b§lADDON §8» §cSkyZero.GA Addon §7by §cBaxoPlenty §8\u25b8 §e§lPaylog");
                            LabyMod.getInstance().displayMessageInChat(" ");
                            if (!SkyZeroAddon.this.payLog.isEmpty()) {
                                LabyMod.getInstance().displayMessageInChat(SkyZeroAddon.this.payLog.toString().replace("[", "").replace("]", "").replace(", ", "\n"));
                            }
                            else {
                                LabyMod.getInstance().displayMessageInChat("§8\u2503 §b§lPAYLOG §8» §7Du hast derzeit keine Transaktionen");
                            }
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }
                        else if (s.equals("--clearpaylog")) {
                            SkyZeroAddon.this.payLog.clear();
                            LabyMod.getInstance().displayMessageInChat(" ");
                            LabyMod.getInstance().displayMessageInChat("§8\u2503 §b§lADDON §8» §7Der Paylog wurde gecleart");
                            LabyMod.getInstance().displayMessageInChat(" ");
                        }
                    }
                    return s.startsWith("--");
                }
                return false;
            }
        });
    }
    
    public void loadConfig() {
    }
    
    protected void fillSettings(final List<SettingsElement> list) {
        final BooleanElement bE = new BooleanElement("Enabled", new ControlElement.IconData(Material.LEVER), (Consumer)new Consumer<Boolean>() {
            public void accept(final Boolean enabled) {
                SkyZeroAddon.this.enabled = enabled;
            }
        }, this.enabled);
        list.add((SettingsElement)bE);
    }
}
