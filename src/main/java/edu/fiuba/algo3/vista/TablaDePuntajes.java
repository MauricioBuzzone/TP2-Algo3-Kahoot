package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Queue;

public class TablaDePuntajes extends TableView {

    public TablaDePuntajes(String propertyValue, String nombreDeLaColumna, Queue<Jugador> jugadores){
        super();

        TableColumn<String, Integer> column1 = new TableColumn<>("Nombre de jugador");
        TableColumn<String, Integer> column2 = new TableColumn<>(nombreDeLaColumna);

        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setCellValueFactory(new PropertyValueFactory<>(propertyValue));

        column1.setStyle("    -fx-font-family: " + App.FUENTE + " ;\n" +
                         "    -fx-font-size: 15pt ;\n" +
                         "-fx-alignment: CENTER;");
        column2.setStyle("    -fx-font-family: " + App.FUENTE + " ;\n" +
                         "    -fx-font-size: 15pt ;\n " +
                         "-fx-alignment: CENTER;");

        this.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        column1.setMaxWidth( 1f * Integer.MAX_VALUE * 60 );
        column2.setMaxWidth( 1f * Integer.MAX_VALUE * 40 );


        this.getColumns().add(column1);
        this.getColumns().add(column2);

        while(!jugadores.isEmpty()){
            this.getItems().add(jugadores.poll());
        }

        column2.setSortType(TableColumn.SortType.DESCENDING);
        this.getSortOrder().setAll(column2);

    }
}
