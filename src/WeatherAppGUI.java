import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGUI extends JFrame {
    public WeatherAppGUI(){
        //setup our GUI and add a title
        super("Weather App");

        //configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set the size of GUI (in pixels);
        setSize(450,650);

        //load GUI at the center of the screen
        setLocationRelativeTo(null);

        //make layout manager null to manually position our components within the gui
        setLayout(null);

        //prevent resize
        setResizable(false);

        addGuiComponents();

    }

    private void addGuiComponents(){
        //search field
        JTextField searchTextField = new JTextField();

        //set the location and size components
        searchTextField.setBounds(15,15,351,45);

        //change font style and size
        searchTextField.setFont(new Font("Dialog", Font.PLAIN,24));

        add(searchTextField);

        //search button
        JButton searchButton= new JButton(loadImage("src/assets/search.png"));

        //change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375,13,47,45);
        add(searchButton);

        //weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0,125,450,217);
        add(weatherConditionImage);

        //temperature text
        JLabel temperatureText= new JLabel("10 C");
        temperatureText.setBounds(0,350,450,54);
        temperatureText.setFont((new Font("Dialog",Font.BOLD,48)));

        //center the text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        //weather conditions description
        JLabel weatherConditionDesc= new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0,405,450,36);
        weatherConditionDesc.setFont(new Font("Diaglog", Font.PLAIN,32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        //humidity Image
        JLabel humidityImage=new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15,500,74,66);
        add(humidityImage);

        //humidity Text
        JLabel humidityText= new JLabel("<html><b>Humidity</b> 100% </html>");
        humidityText.setBounds(90,500,85,55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN,16));
        add(humidityText);

        //windspeed Image
        JLabel windspeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windspeedImage.setBounds(220,500,74,66);
        add(windspeedImage);

        //windspeed Text
        JLabel windspeedText= new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(300, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog",Font.PLAIN,16));

        add(windspeedText);
    }

    //used to create images in our gui components
    private ImageIcon loadImage (String resourcePath){
        try{
            //read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));

            //returns an image icon so that our component can render it
            return new ImageIcon(image);
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }

}
