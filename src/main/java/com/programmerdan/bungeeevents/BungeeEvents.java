package com.programmerdan.minecraft.bungeeevents;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.nio.file.Files;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PreLoginEvent;


import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BungeeEvents extends Plugin implements Listener {

	@Override
	public void onEnable() {
		getLogger().info("Enabling BungeeEvents");

		getProxy().getPluginManager().registerListener(this, this);
	}

	private void waitAMoment() {
		try {
			Thread.sleep(500l);
		} catch(InterruptedException ie) {}
	}

	@EventHandler
	public void onPlayerPreLogin(PreLoginEvent event) {
		getLogger().info("PreLoginEvent fired");

		if (event.getName() != null) 
			getLogger().info(" -- name: " + event.getName());

		if (event.getUniqueId() != null)
			getLogger().info(" -- unid: " + event.getUniqueId());

		getLogger().info(" -- version: " + event.getVersion());

		waitAMoment();

		getLogger().info("PreLoginEvent done");
	}

	@EventHandler
	public void onPlayerLogin(LoginEvent event) {
		getLogger().info("LoginEvent fired");

		if (event.getName() != null) 
			getLogger().info(" -- name: " + event.getName());

		if (event.getUniqueId() != null)
			getLogger().info(" -- unid: " + event.getUniqueId());

		getLogger().info(" -- version: " + event.getVersion());

		waitAMoment();

		getLogger().info("LoginEvent done");
	}

	@EventHandler
	public void afterLogin(PostLoginEvent event) {
		getLogger().info("PostLoginEvent fired");

		ProxiedPlayer player = event.getPlayer();

		if (player.getName() != null) 
			getLogger().info(" -- name: " + player.getName());

		if (player.getUniqueId() != null)
			getLogger().info(" -- unid: " + player.getUniqueId());

		waitAMoment();

		getLogger().info("PostLoginEvent done");
	}

}

