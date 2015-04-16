package main.AffGraph.ButtonMod;

import main.AffGraph.GameMod.ClassicMod;

public class ClassicButton extends ButtonMod {

		public ClassicButton(){
			super("Mode Classic");
			mod = new ClassicMod();
		}
}
