import javax.swing.*;

public class UItest extends JFrame{

    private JLabel myLabel;
    private JPanel myPanel;
    private JButton myButton;
    public UItest(String title,String content){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel = new JPanel();
        myLabel = new JLabel();
        myButton = new JButton("Get Maximum air pressure");
        myLabel.setText(content);
        myPanel.add(myLabel);

        this.setContentPane(myPanel);

    }


    public static void main(String[] args) {
        DBTest rc = new DBTest();
        String response = rc.makeGETRequest("https://studev.groept.be/api/a23ib2c03/getId/℃" );
        String target_Id = rc.getid(response);

//        UItest ui= new UItest("FeiYang Zheng",target_Id);
//        ui.setVisible(true);
//        ui.pack();

        UItest ui= new UItest("FeiYang Zheng",target_Id);
        ui.setVisible(true);
        ui.pack();
    }


}
