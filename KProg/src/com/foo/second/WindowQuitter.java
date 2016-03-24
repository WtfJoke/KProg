package com.foo.second;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Implements closing of window, by shutting down the vm
 * 
 * @author manue
 *
 */
public class WindowQuitter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
