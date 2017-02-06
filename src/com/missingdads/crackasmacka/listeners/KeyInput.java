package com.missingdads.crackasmacka.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.missingdads.crackasmacka.Core;

public class KeyInput extends KeyAdapter {

	public KeyInput() {

	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
		
		if(key == KeyEvent.VK_ENTER) {
			
			Core.ShopOpen = true;
		}

	}
}
