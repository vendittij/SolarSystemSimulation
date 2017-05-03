/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author jtd027
 */
public class TabInfoPane extends TabPane{
    
    public Scroll overScroll;
    public Split detailSplit;
    
   public TabInfoPane(){
      super();
      overScroll = new Scroll();
      detailSplit = new Split();
    } 
    
   public void setProperties() {
       
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            // Here we overwrite the usual tabPane control handlers, since these keys allow the user to navigate our Solar System.
            @Override
            public void handle(KeyEvent event) {
            }
        });
              
        this.setOpacity(0.75); //CHECK HOW TO SET FOR PROPER OPACITY
        this.setBlendMode(BlendMode.SRC_OVER);
        this.setPrefSize(1500, 250);
        this.setBorder(new Border(new BorderStroke(Color.AQUAMARINE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(5), Insets.EMPTY)));
        this.setOpaqueInsets(new Insets(3)); //CHECK IF THIS DOES ANYTHING
        this.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        //More properties set here
                
        //Then call methods to set-up the inner panes
        this.overScroll.setProperties();
        this.detailSplit.setProperties();
                
        Tab over = new Tab("Planets Overview", overScroll);
        Tab detail = new Tab("Planet Detail", detailSplit);
        
        this.getTabs().add(over);        
        //this.getTabs().add(detail);
        
    }
   
   void populateInfo(SolarSystem sys){
       this.overScroll.populate(sys);
       this.detailSplit.populate(sys);
   }
 
    private class Scroll extends ScrollPane{
        
        HBox scrollBox;
        
        void setProperties(){
            
//            this.setBorder(new Border(new BorderStroke(Color.GHOSTWHITE, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(10), Insets.EMPTY)));
            this.setPadding(new Insets(10));
            this.setBlendMode(BlendMode.SRC_OVER);
            this.setOpacity(0.9);
            
            this.scrollBox = new HBox();
            this.scrollBox.setPrefSize(3000, 170);
//            this.scrollBox.setMaxSize(1850, 180);
            this.scrollBox.setSpacing(10);
            this.scrollBox.setPadding(new Insets(5));
            this.scrollBox.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(5), Insets.EMPTY)));
            this.scrollBox.setOpacity(1.0);
            this.setBlendMode(BlendMode.SRC_OVER);
            this.setContent(scrollBox);
            
            
            for (int i = 0; i < 10; i++){
                VBox box = new VBox();
                box.setPrefSize(290, 160);
                box.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(3), Insets.EMPTY)));
                box.setOpacity(2.0);
                box.setBlendMode(BlendMode.SRC_ATOP);
                box.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(1), new Insets(1))));
                this.scrollBox.getChildren().add(box);
            }
            
        }
        
        void populate(SolarSystem sys){
            
            int i = 0;
            for(Node v : scrollBox.getChildren()){
                Planet currentPlanet = sys.planetSelector(i);
                VBox vert = (VBox)v;
                ListView list = new ListView();
                list.getItems().addAll(currentPlanet.basicStats());
                vert.getChildren().add(list);
                i++;
            }
            
        }
        
    }
    
    private class Split extends SplitPane{
        
        void setProperties(){
            //Then set the splitPane detail properties
            this.setOrientation(Orientation.HORIZONTAL);
            this.setDividerPosition(2, .5);
            this.setMinHeight(200);
            //root.setAlignment(detailSplit, Pos.BOTTOM_LEFT);
            this.setStyle("-fx-background-color: rgba(192, 192, 192, .4);");

            this.getItems().add(new Label("LABELS GO HERE"));
            Text textOut = new Text();
            textOut.setFont(Font.font(null, FontWeight.BOLD, 30));
            textOut.setText("INFORMATION GOES HERE");
            textOut.setFill(Color.YELLOW);
            this.getItems().add(textOut);
        }
        
        void populate(SolarSystem sys){
            
        }
        
    }
    
}
