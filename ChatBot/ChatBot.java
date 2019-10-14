package com.company;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBot extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Chatter: simple chatbot";
    final int START_lOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String INTELLECT = "INTELLECT";
    final String ENTER_BUTTON = "Enter";

    JTextPane dialogue; // aria for dialog
    JCheckBox intellect; // enable/disable intellect
    JTextField message; // field for entering message
    Bot bot; // bot class
    SimpleAttributeSet styleBotText; // style bot text

    public static void main(String[] args) {
	    new ChatBot();
    }

    // Constructor a window
    ChatBot() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(START_lOCATION, START_lOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);

        //dialog aria
        dialogue = new JTextPane();
        dialogue.setEditable(false);
        dialogue.setContentType("text/html");
        JScrollPane scrollBar = new JScrollPane(dialogue);

        //bot message style
        styleBotText = new SimpleAttributeSet();
        StyleConstants.setItalic(styleBotText, true);
        StyleConstants.setForeground(styleBotText, Color.green);
        StyleConstants.setAlignment(styleBotText, StyleConstants.ALIGN_RIGHT);

        //panel with check intellect, message field and Enter button
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        intellect = new JCheckBox(INTELLECT);
        intellect.doClick();
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton(ENTER_BUTTON);
        enter.addActionListener(this);

        //collect all the elements
        panel.add(intellect);
        panel.add(message);
        panel.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, panel);
        setVisible(true);
        bot = new Bot(); // create bot
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (message.getText().trim().length() > 0) {
            try {
                StyledDocument doc = dialogue.getStyledDocument();
                doc.insertString(doc.getLength(), message.getText() + "\n",
                        new SimpleAttributeSet());
                doc.insertString(doc.getLength(),TITLE_OF_PROGRAM.substring(0, 9) +
                        bot.sayinReturn(message.getText(), intellect.isSelected()) + "\n", styleBotText);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}