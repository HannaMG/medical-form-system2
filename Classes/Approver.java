package Classes;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Approver implements ActionListener{
    private JFrame inbox = new JFrame("User Inbox");
    private JTextArea cTextArea = new JTextArea("Your submission has been recieved! Here is a copy of your answers: \n\n Name: \n DOB: \n Address: \n Alien Number: \n Medical Condition: \n Phone Number: \n Condition Start Date: \n", 5, 10);
    private JTextArea nTextArea = new JTextArea(10, 50);
    JPanel inboxScr = new JPanel();

    /**
     * Sets up and shows Approver Screen
     */
    public void showApproverScreen() {
        /**
         * Approver
         */
        JFrame approver = new JFrame("Approver Screen");
        approver.setVisible(true); 
        approver.setSize(1000, 700);
        approver.setLayout(new BoxLayout(approver.getContentPane(), BoxLayout.Y_AXIS));
        approver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**
         * Confirmation Panel
         */

        JPanel confirmation = new JPanel();
        BoxLayout cLayout = new BoxLayout(confirmation, BoxLayout.Y_AXIS);
        confirmation.setLayout(cLayout);
        confirmation.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmation.setPreferredSize(new Dimension(800, 450));
        confirmation.setMaximumSize(new Dimension(800, 450));
        
        //Border
        TitledBorder cBorder = new TitledBorder("Confirmation Message"); 
        confirmation.setBorder(cBorder);
        
        //Message Text
        JLabel cLabel = new JLabel("Message:");
        cLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmation.add(cLabel);
        
        //Text Area
        //JTextArea cTextArea = new JTextArea("Your submission has been recieved! Here is a copy of your answers: \n\n Name: \n DOB: \n Address: \n Alien Number: \n Medical Condition: \n Phone Number: \n Condition Start Date: \n", 5, 10);
        confirmation.add(cTextArea);
        
        //Send button
        JButton cSend = new JButton("Send");
        cSend.setAlignmentX(Component.CENTER_ALIGNMENT);
        cSend.setActionCommand("confirmation");
        cSend.addActionListener(this);
        confirmation.add(cSend);
        
        //Add to frame
        approver.getContentPane().add(confirmation);

        /**
         * Neccessary Next Steps Panel
         */

        JPanel nextSteps = new JPanel();
        BoxLayout nLayout = new BoxLayout(nextSteps, BoxLayout.Y_AXIS);
        nextSteps.setLayout(nLayout);
        nextSteps.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextSteps.setPreferredSize(new Dimension(800, 450));
        nextSteps.setMaximumSize(new Dimension(800, 450));
        
        //Border
        TitledBorder nBorder = new TitledBorder("Necessary Next Steps Message"); 
        nextSteps.setBorder(nBorder);
        
        //Message Text
        JLabel nLabel = new JLabel("Message:");
        nLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextSteps.add(nLabel);
        
        //Medical Condition Drop Down
        String[] medicalConditions = {"Tuberculosis", "HIV/AIDS", "Malaria", "Zika Virus", "Measles", "Hepatitis", "Chickenpox"};
        JComboBox conditionList = new JComboBox(medicalConditions);
        nextSteps.add(conditionList);

        //Text Area
        nextSteps.add(nTextArea);
        
        //Send button
        JButton nSend = new JButton("Send");
        nSend.setAlignmentX(Component.CENTER_ALIGNMENT);
        nSend.setActionCommand("nextSteps");
        nSend.addActionListener(this);
        nextSteps.add(nSend);
        
        //Add to frame
        approver.getContentPane().add(nextSteps);


        /**
         * User Message Inbox
         */
        inbox.setVisible(true); 
        inbox.setSize(1000, 700);
        inbox.setLayout(new BoxLayout(inbox.getContentPane(), BoxLayout.Y_AXIS));
        inbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Scrolling Inbox
        BoxLayout iLayout = new BoxLayout(inboxScr, BoxLayout.Y_AXIS);
        inboxScr.setLayout(iLayout);
        inboxScr.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Message Text
        JLabel iLabel = new JLabel("Messages:");
        iLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inboxScr.add(iLabel);

        //Scroll Bar
        JScrollPane scrBar = new JScrollPane(inboxScr, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inbox.add(scrBar);

   }

    public void actionPerformed(ActionEvent e) {
            if("nextSteps".equals(e.getActionCommand())) {
                JPanel message = new JPanel();
                BoxLayout nLayout = new BoxLayout(message, BoxLayout.Y_AXIS);
                message.setLayout(nLayout);
                message.setAlignmentX(Component.CENTER_ALIGNMENT);
                message.setPreferredSize(new Dimension(800, 450));
                message.setMaximumSize(new Dimension(800, 450));

                //Border
                TitledBorder mBorder = new TitledBorder("Next Steps Message"); 
                message.setBorder(mBorder);
        
                //Message Text
                JLabel mLabel = new JLabel("<html>" + nTextArea.getText().replaceAll("(\r\n|\n)", "<br />") + "</html>");
                mLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                message.add(mLabel);

                //Add to frame
                inboxScr.add(message);
                inboxScr.revalidate();
                inboxScr.repaint();
                
            } else if("confirmation".equals(e.getActionCommand())) {
                JPanel message = new JPanel();
                BoxLayout mLayout = new BoxLayout(message, BoxLayout.Y_AXIS);
                message.setLayout(mLayout);
                message.setAlignmentX(Component.CENTER_ALIGNMENT);
                message.setPreferredSize(new Dimension(800, 450));
                message.setMaximumSize(new Dimension(800, 450));

                //Border
                TitledBorder mBorder = new TitledBorder("Confirmation Message"); 
                message.setBorder(mBorder);
        
                //Message Text
                JLabel mLabel = new JLabel("<html>" + cTextArea.getText().replaceAll("(\r\n|\n)", "<br />") + "</html>");
                mLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                message.add(mLabel);

                //Add to frame
                inboxScr.add(message);
                inboxScr.revalidate();
                inboxScr.repaint();

            }
    }
}
