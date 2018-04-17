package sample;

import java.awt.Font;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.awt.*;
import java.io.IOException;
import java.time.LocalTime;

import java.lang.Math.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private Canvas canvas=new Canvas(800,800);
    private GraphicsContext gc=canvas.getGraphicsContext2D();
    private Stage stage;
    private double cR=0.0;
    private double cX=0.0;//-----
                          //     Wspolrzedne srodka tarczy
    private double cY=0.0;//-----



    TableView table;

    @Override
    public void start(Stage primaryStage) throws Exception{


        stage=primaryStage;
        stage.setTitle("Analog Clock");

        BorderPane borderPane=new BorderPane();
        Pane wrapperPane=new Pane();

        borderPane.setCenter(wrapperPane);//------aby menu nie wchodzilo na zegar trzeba"owinac" tarczę wokol czegos innego
        wrapperPane.getChildren().add(canvas);

        stage.setScene(new Scene(borderPane));

        stage.show();


        new AnimationTimer() {
            @Override
            public void handle(long l) {

                drawClock();

            }
        }.start();

                                            //USTAWIANIE MENU

        Label menuAboutLabel= new Label("O autorze");
Menu menuAbout=new Menu();
menuAbout.setGraphic(menuAboutLabel);
menuAboutLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {

    }
});
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("Program");
        Menu budzik = new Menu("Budzik");

        MenuItem exit=new MenuItem("Zamknij");

        MenuItem aboutAuthor =new MenuItem("O autorze");


 exit.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent actionEvent) {
         System.exit(1);
     }
 });



 budzik.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent actionEvent) {




     }

 });

menuFile.getItems().addAll(exit);
budzik.getItems().addAll(aboutAuthor);

menuBar.getMenus().addAll(menuFile, budzik);
borderPane.setTop(menuBar);

    }


    private void drawOval(double X, double Y, double R)
    {
        gc.strokeOval(X-R, Y-R,2*R, 2*R );

    }
private void fillOval(double X, double Y, double R)
{
    gc.fillOval(X-R,Y-R, 2*R,2*R);

}

    private void drawClock()
    {
        setParametersAndClear();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        drawOval(cX, cY, cR);




        //////RYSOWNIE CYFER
        gc.setFill(Color.BLACK);
        for(int i=1; i<=12; i++)
        {
            double angle=2*Math.PI*i/12;
            double x=Math.sin(angle)*cR+cX-5;
            double y=-Math.cos(angle)*cR+cY+10;

            String a=Integer.toString(i);

            gc.setFont(new javafx.scene.text.Font(40));
          gc.fillText(a,x,y);



        }

        //RYSOWANKO KROPEK SEKUNDOWYCH NA TARCZY
        for(int i=1; i<=60; i++)
    {
        gc.setFill(Color.RED);
        double angle=2*Math.PI*i/60;
        double x=Math.sin(angle)*cR+cX;
        double y=-Math.cos(angle)*cR+cY;


        fillOval(x,y,3);
    }

gc.setLineWidth(1);
        gc.setFill(Color.BLACK);
        for(int i=1; i<=12; i++)
        {
            double angle=2*Math.PI*i/12;
            double x=Math.sin(angle)*cR+cX;
            double y=-Math.cos(angle)*cR+cY;

            fillOval(x,y,3);



        }




        gc.setFill(Color.RED);
                               //RYSOWANIE SRODKA TARCZY
        fillOval(cX,cY,5);






      LocalTime atm = LocalTime.now();
        double atmHours = (atm.getHour() % 12) + (atm.getMinute() / 60.0) + (atm.getSecond() / 3600.0);
        double atmMinutes = atm.getMinute() + (atm.getSecond() / 60.0);
        double atmSeconds = atm.getSecond();




        //KOLEJNO WSKAZOWKI GODZINOWA MINUTOWA SEKUNDOWA
         double hourLength = 0.5 * cR;
         double minuteLength = 0.8 * cR;
         double secondLength = 0.9 * cR;


         gc.setLineWidth(6);
         gc.strokeLine(cX, cY, cX+Math.sin(2*Math.PI*atmHours/12)*hourLength, cY-Math.cos(2*Math.PI*atmHours/12)*hourLength);
         gc.setLineWidth(4);
         gc.strokeLine(cX,cY,cX+Math.sin(2*Math.PI*atmMinutes/60)*minuteLength, cY-Math.cos(2*Math.PI*atmMinutes/60)*minuteLength);
         gc.setLineWidth(3);
        gc.strokeLine(cX,cY,cX+Math.sin(2*Math.PI*atmSeconds/60)*secondLength, cY-Math.cos(2*Math.PI*atmSeconds/60)*secondLength);



    }


    private void setParametersAndClear() {
        canvas.setWidth(stage.getWidth());
        canvas.setHeight(stage.getHeight());
        double size = Math.min(stage.getHeight(), stage.getWidth()) - 100;
        cR = size / 2;
        cX = size / 2 +30;
        cY = size / 2 +30;
        gc.clearRect(0, 0, 10000, 10000);
    }






    public static void main(String[] args) {
        launch(args);
    }






}
