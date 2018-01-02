package com.canauhtli.cfdi.ui;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.ui.controls.PrincipalController;
import com.canauhtli.config.ConfigManager;

import insidefx.undecorator.UndecoratorScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CfdiView extends Application {
	
//	private AnchorPane listadoPeriodo;
	
	private DBManager dbm;
	private ConfigManager cm;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Monitor de CFDI");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
		PrincipalController principalController = new PrincipalController(dbm, cm);
		loader.setController(principalController);
		Region root = loader.load();
		
		UndecoratorScene.setClassicDecoration();
		UndecoratorScene undecoratorScene = new UndecoratorScene(stage, StageStyle.TRANSPARENT, root, "/com/canauhtli/cfdi/ui/viewDecoration.fxml");
		undecoratorScene.removeDefaultStylesheet();
		undecoratorScene.addStylesheet("skin/cfdiview.css");
		
		Image image = new Image("/resources/img/nom32.png");
        stage.getIcons().addAll(image);
        
		
		stage.setScene(undecoratorScene);
		stage.toFront();
		stage.show();
	}
	
	public void init() {
		dbm = new DBManager();
		cm = new ConfigManager(dbm);

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
