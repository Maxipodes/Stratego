package test;

import main.AffGraph.Panel.ImagePanel;

import org.junit.Assert;
import org.junit.Test;

public class ImagePanelTest {
	
	@Test
	public final void testImagePanel(){
		try{
			new ImagePanel("Logo.jpg");
		}
		
		catch(Exception e){
			Assert.fail();
		}
		
		Assert.assertTrue(true);
	}

}
