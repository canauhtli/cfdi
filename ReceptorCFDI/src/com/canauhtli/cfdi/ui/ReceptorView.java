package com.canauhtli.cfdi.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.ui.controller.Principal;

import insidefx.undecorator.UndecoratorScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ReceptorView extends Application {

	private static Logger log = LoggerFactory.getLogger(ReceptorView.class);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
		loader.setController(new Principal());
		Region root = loader.load();

		UndecoratorScene.setClassicDecoration();
		UndecoratorScene undecoratorScene = new UndecoratorScene(primaryStage, StageStyle.TRANSPARENT, root, "/com/canauhtli/cfdi/ui/Decoration.fxml");
		undecoratorScene.removeDefaultStylesheet();
		undecoratorScene.addStylesheet("skin/mainview.css");
		
		Image image = new Image("/resources/img/nom32.png");
		primaryStage.getIcons().addAll(image);
		
		primaryStage.setScene(undecoratorScene);
		primaryStage.setTitle("Receptor de facturas CFDI");
		primaryStage.toFront();
		primaryStage.show();
	}
	

}
