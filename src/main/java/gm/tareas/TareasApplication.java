package gm.tareas;

import gm.tareas.presentation.AppSystemTaskFx;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication {

	public static void main(String[] args) {

		Application.launch(AppSystemTaskFx.class,args);
	}

}
