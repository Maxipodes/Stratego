package main.AffGraph.ButtonMod;

import javax.swing.JButton;

import main.AffGraph.GameMod.GameMod;

public abstract class ButtonMod extends JButton {
	
	protected GameMod mod;
	
	protected ButtonMod(String string) {
		super(string);
	}

	public GameMod getMod(){
		return mod;
	}
}
