package main.AffGraph.ButtonMod;

import main.AffGraph.GameMod.EasyMod;

public class EasyButton extends ButtonMod {

		public EasyButton(){
			super("IA facile");
			mod = new EasyMod();
		}
}
